package br.com.thrillio;

import br.com.thrillio.constants.KidFriendlyStatus;
import br.com.thrillio.constants.UserType;
import br.com.thrillio.controllers.BookmarkController;
import br.com.thrillio.entities.Bookmark;
import br.com.thrillio.entities.User;

public class View {
    public static void browse(User user, Bookmark[][] bookmarks) {
        System.out.println("\n" + user.getFirstName() + " Is Browsing items");
        int bookmarkCount = 0;

        for (Bookmark[] bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                // Bookmarking!!
                if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
                    boolean isBookmarked = getBookmarkDecision(bookmark);
                    if (isBookmarked) {
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                        System.out.println("New item bookmarked -- " + bookmark);
                    }
                }
                // mark aS kidFriendly
                if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
                    if (bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                        if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
                            bookmark.setKidFriendlyStatus(kidFriendlyStatus);
                            System.out.println("Kid Friendly Status: " + kidFriendlyStatus + ", " + bookmark);
                        }

                    }
                }
            }

        }
    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        double randomVal = Math.random();
        return randomVal < 0.4 ? KidFriendlyStatus.APPROVED :
                (randomVal >= 0.5 && randomVal < 0.8) ? KidFriendlyStatus.REJECTED
                        : KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5;
    }
//    public static void bookmark(User user, Bookmark[][] bookmarks) {
//        System.out.println("\n" + user.getFirstName() + " Is Bookmarking");
//        for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
//            int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
//            int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
//
//            Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
//
//            BookmarkController.getInstance().saveUserBookmark(user, bookmark);
//
//            System.out.println(bookmark);
//        }
//    }
}
