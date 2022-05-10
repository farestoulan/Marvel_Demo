package ModelClasses;

import com.google.gson.annotations.SerializedName;

public class ListModelClass {

    @SerializedName("description")
private String description;

    @SerializedName("thumbnail")
    ThumbnailModel thumbnail;

    public ListModelClass(String description, ThumbnailModel thumbnail) {
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ThumbnailModel getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailModel thumbnail) {
        this.thumbnail = thumbnail;
    }
}
