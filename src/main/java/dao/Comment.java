package dao;

import java.io.Serializable;
import java.util.List;

public class Comment implements Serializable {
    private String url;
    private String comment;

    public Comment() {
    }

    public Comment(String url, String comment) {
        this.url = url;
        this.comment = comment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
