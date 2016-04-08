package hoanle.mvvm_instagram.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import hoanle.mvvm_instagram.object.InstagramPhoto;

/**
 * Created by hoanle on 4/8/16.
 */
public class PhotoResponse {

    @SerializedName("data")
    private List<InstagramPhoto> list;

    public List<InstagramPhoto> getList() {
        return list;
    }

    public void setList(List<InstagramPhoto> list) {
        this.list = list;
    }
}
