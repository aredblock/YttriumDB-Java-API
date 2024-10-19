package de.aredblock.yttriumdb;

import de.aredblock.yttriumdb.object.Column;
import de.aredblock.yttriumdb.object.LoadedColumn;

import java.io.IOException;

public final class YttriumClient {

    private final YttriumClientBuilder builder;
    private final String url;

    private YttriumClient(YttriumClientBuilder builder) {
        this.builder = builder;
        this.url = "http://localhost:" + builder.port + "/api/v1";
    }

    public void push(String name, Column column) throws IOException, InterruptedException {
        YttriumConnector.push(builder.key, name, url, column);
    }

    public LoadedColumn pop(String name) throws IOException, InterruptedException {
        return YttriumConnector.pop(builder.key, name, url);
    }

    public static YttriumClientBuilder builder() {
        return new YttriumClientBuilder();
    }

    public static class YttriumClientBuilder {

        private int port = 46676;
        private String key = "";

        private YttriumClientBuilder() {
        }

        public YttriumClientBuilder port(int port) {
            this.port = port;
            return this;
        }

        public  YttriumClientBuilder key(String key) {
            this.key = key;
            return this;
        }

        public YttriumClient build() {
            return new YttriumClient(this);
        }

    }

}
