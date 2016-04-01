package hoanle.mvvm_instagram;

/**
 * Created by hoanle on 4/1/16.
 */
public class InstagramPhoto {
    private String username;
    private String profileUrl;
    private String caption;
    private String imageUrl;
    private long createdTime;
    private int imageHeight;
    private int likesCount;

    public InstagramPhoto(){

    }

    public InstagramPhoto(String username, String profileUrl, String caption, String imageUrl, long createdTime, int imageHeight, int likesCount){
        this.username = username;
        this.profileUrl = profileUrl;
        this.caption = caption;
        this.imageUrl = imageUrl;
        this.createdTime = createdTime;
        this.imageHeight = imageHeight;
        this.likesCount = likesCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }
}
