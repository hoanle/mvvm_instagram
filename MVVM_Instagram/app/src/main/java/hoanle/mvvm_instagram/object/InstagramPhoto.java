package hoanle.mvvm_instagram.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hoanle on 4/1/16.
 */
public class InstagramPhoto {

    @SerializedName("caption")
    private Caption caption;

    @SerializedName("user")
    private User user;

    @SerializedName("images")
    private Image image;

    @SerializedName("created_time")
    private String createdTime;

    @SerializedName("id")
    private String id;

    @SerializedName("likes")
    private Like likes;


    public Caption getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Like getLikes() {
        return likes;
    }

    public void setLikes(Like likes) {
        this.likes = likes;
    }
}
