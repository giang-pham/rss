package vn.giang.uzabase.rss.model;

import java.util.List;

/**
 * Created by Giang on 04-Aug-17.
 */
public class RssModel {
    private String url;
    private List<UzbRssFeed> uzbRssFeeds;

    public RssModel(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<UzbRssFeed> getUzbRssFeeds() {
        return uzbRssFeeds;
    }

    public void setUzbRssFeeds(List<UzbRssFeed> uzbRssFeeds) {
        this.uzbRssFeeds = uzbRssFeeds;
    }


}
