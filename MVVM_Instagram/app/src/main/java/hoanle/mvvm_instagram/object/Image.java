package hoanle.mvvm_instagram.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hoanle on 4/8/16.
 */
public class Image {

    @SerializedName("standard_resolution")
    private Resolution standardResolution;

    public Resolution getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(Resolution standardResolution) {
        this.standardResolution = standardResolution;
    }

    public class Resolution{

        @SerializedName("url")
        private String url;

        @SerializedName("width")
        private int width;

        @SerializedName("height")
        private int height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
