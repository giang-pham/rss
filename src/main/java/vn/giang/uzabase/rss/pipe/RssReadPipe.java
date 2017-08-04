package vn.giang.uzabase.rss.pipe;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;
import vn.giang.uzabase.rss.model.RssModel;
import vn.giang.uzabase.rss.model.UzbRssFeed;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Giang on 04-Aug-17.
 */
@Service
public class RssReadPipe implements RssPipe<RssModel> {
    @Override
    public RssModel process(RssModel rss)  {

        SyndFeed feed = null;
        try {
            feed = new SyndFeedInput().build(new XmlReader(new URL(rss.getUrl())));
        } catch (FeedException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }

        if(feed == null) {
            System.err.println(rss.getUrl() + " is not available");
        }

        if(feed.getEntries() == null || feed.getEntries().isEmpty()) {
            System.err.println(rss.getUrl() + " has no entries");
        }

        List<UzbRssFeed> uzbFeeds = feed.getEntries().stream().map(
                syndEntry -> new UzbRssFeed.Builder()
                        .title(syndEntry.getTitle())
                        .link(syndEntry.getLink())
                        .body(syndEntry.getDescription().getValue())
                        .build()).collect(Collectors.toList());

        rss.setUzbRssFeeds(uzbFeeds);

        return rss;
    }
}
