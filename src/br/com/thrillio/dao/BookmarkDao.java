package br.com.thrillio.dao;

import br.com.thrillio.DataStore;
import br.com.thrillio.entities.Bookmark;
import br.com.thrillio.entities.UserBookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks() {
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
