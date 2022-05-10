package ModelClasses;

import com.google.gson.annotations.SerializedName;

public class ThumbnailModel {

    @SerializedName("path")
    private String path;
    @SerializedName("extension")
    private String extension;

    public ThumbnailModel(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
