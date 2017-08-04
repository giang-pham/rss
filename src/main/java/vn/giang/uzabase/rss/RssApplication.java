package vn.giang.uzabase.rss;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.giang.uzabase.rss.model.RssModel;
import vn.giang.uzabase.rss.pipe.RssPrintPipe;

import java.net.URL;

@SpringBootApplication
public class RssApplication implements CommandLineRunner{

	private static final String UZABASE_FEED = "http://tech.uzabase.com/rss";

	@Autowired
	private RssPipeline rssPipeline;

	public static void main(String[] args) {
		SpringApplication.run(RssApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		RssModel rssModel = new RssModel(UZABASE_FEED);

		rssPipeline.process(rssModel);

	}
}
