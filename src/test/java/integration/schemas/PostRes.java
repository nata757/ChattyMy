package integration.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRes {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private  String title;

    @JsonProperty("description")
    private  String description;

    @JsonProperty("body")
    private String body;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("publishDate")
    private String publishDate;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("draft")
    private boolean draft;

    @JsonProperty("userId")
    private String userId;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
