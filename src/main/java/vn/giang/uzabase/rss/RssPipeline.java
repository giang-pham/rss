package vn.giang.uzabase.rss;

import org.springframework.stereotype.Service;
import vn.giang.uzabase.rss.model.RssModel;
import vn.giang.uzabase.rss.pipe.RssConvertPipe;
import vn.giang.uzabase.rss.pipe.RssPrintPipe;
import vn.giang.uzabase.rss.pipe.RssReadPipe;
import vn.giang.uzabase.rss.pipe.RssSavePipe;

import java.util.function.Function;

/**
 * Created by Giang on 04-Aug-17.
 */
@Service
public class RssPipeline {
    private final Function<RssModel, RssModel> readFeed;
    private final Function<RssModel, RssModel> convertFeed;
    private final Function<RssModel, RssModel> printFeed;
    private final Function<RssModel, RssModel> saveFeed;

    public RssPipeline(RssReadPipe rssReadPipe, RssConvertPipe rssConvertPipe, RssPrintPipe rssPrintPipe, RssSavePipe rssSavePipe) {
        this.readFeed = rssModel -> rssReadPipe.process(rssModel);
        this.convertFeed = rssModel -> rssConvertPipe.process(rssModel);
        this.printFeed = rssModel -> rssPrintPipe.process(rssModel);
        this.saveFeed = rssModel -> rssSavePipe.process(rssModel);
    }

    /**
     * this pipe can be cloned to add and remove any process
     * - choose to save or not save
     * - choose to read from single or multiple source by extends RssModel and put a list of urls
     * @param rss rss model with source and entries
     * @return
     */
    public RssModel process(RssModel rss) {
        return readFeed
                .andThen(convertFeed)
                .andThen(printFeed)
                .andThen(saveFeed)
                .apply(rss);
    }
}
