package vn.giang.uzabase.rss.pipe;

import org.springframework.stereotype.Service;
import vn.giang.uzabase.rss.model.RssModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Giang on 04-Aug-17.
 */
@Service
public class RssSavePipe implements RssPipe<RssModel> {
    @Override
    public RssModel process(RssModel rss) {
        rss.getUzbRssFeeds().forEach(
                uzbRssFeed -> {
                    try {
                        Files.write(Paths.get("output.txt"), uzbRssFeed.getBody().getBytes());
                    } catch (IOException e) {
                        System.err.println(e);
                    }
                });
        return rss;
    }
}
