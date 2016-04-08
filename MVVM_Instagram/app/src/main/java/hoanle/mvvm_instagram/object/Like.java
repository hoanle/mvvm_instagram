package hoanle.mvvm_instagram.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hoanle on 4/8/16.
 */
public class Like {

    @SerializedName("count")
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
