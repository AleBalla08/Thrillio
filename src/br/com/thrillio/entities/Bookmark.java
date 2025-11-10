package br.com.thrillio.entities;

public abstract class Bookmark {
    private long id;
    private String title;
    private String profileUrl;
    private String KidFriendlyStatus = br.com.thrillio.constants.KidFriendlyStatus.UNKNOWN;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public abstract boolean isKidFriendlyEligible();

    public String getKidFriendlyStatus() {
        return KidFriendlyStatus;
    }

    public void setKidFriendlyStatus(String kidFriendlyStatus) {
        KidFriendlyStatus = kidFriendlyStatus;
    }
}
