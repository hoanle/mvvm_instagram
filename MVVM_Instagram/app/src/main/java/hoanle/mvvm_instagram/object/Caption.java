package hoanle.mvvm_instagram.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hoanle on 4/8/16.
 */
public class Caption {

    @SerializedName("text")
    private String text;

    @SerializedName("created_time")
    private String createdAt;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
