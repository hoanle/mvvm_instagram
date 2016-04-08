package hoanle.mvvm_instagram.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hoanle on 4/8/16.
 */
public class User {

    @SerializedName("username")
    private String userName;

    @SerializedName("profile_picture")
    private String profilePicture;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
