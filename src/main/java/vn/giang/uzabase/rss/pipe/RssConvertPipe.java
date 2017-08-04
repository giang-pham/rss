package vn.giang.uzabase.rss.pipe;

import org.springframework.stereotype.Service;
import vn.giang.uzabase.rss.model.RssModel;

/**
 * Created by Giang on 04-Aug-17.
 */
@Service
public class RssConvertPipe implements RssPipe<RssModel> {
    @Override
    public RssModel process(RssModel rss) {
        rss.getUzbRssFeeds().forEach(uzbRssFeed -> {
            uzbRssFeed.setBody(uzbRssFeed.getBody().replaceAll("NewsPicks", ""));
        });
        return rss;
    }
}
