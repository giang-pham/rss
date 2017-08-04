package vn.giang.uzabase.rss.model;

/**
 * Created by Giang on 04-Aug-17.
 */
public class UzbRssFeed {
    private String title;
    private String body;
    private String link;

    private UzbRssFeed(Builder builder) {
        setTitle(builder.title);
        setBody(builder.body);
        setLink(builder.link);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static final class Builder {
        private String title;
        private String body;
        private String link;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder body(String val) {
            body = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public UzbRssFeed build() {
            return new UzbRssFeed(this);
        }
    }
}
