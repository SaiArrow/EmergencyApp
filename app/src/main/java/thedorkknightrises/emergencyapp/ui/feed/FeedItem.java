package thedorkknightrises.emergencyapp.ui.feed;

/**
 * Created by ysr on 1/28/2017.
 */

public class FeedItem {

    String title;
    String excerpt;
    int imageId;        //TODO: to be changed

    public FeedItem(String title, String excerpt, int imageId) {
        this.title = title;
        this.excerpt = excerpt;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
