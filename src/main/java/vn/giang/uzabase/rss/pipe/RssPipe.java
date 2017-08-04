package vn.giang.uzabase.rss.pipe;

import com.rometools.rome.io.FeedException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

/**
 * Created by Giang on 04-Aug-17.
 */
public interface RssPipe<T> {
    public T process(T t) throws IOException, FeedException;
}
