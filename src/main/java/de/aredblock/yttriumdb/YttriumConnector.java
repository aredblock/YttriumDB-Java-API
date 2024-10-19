package de.aredblock.yttriumdb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.aredblock.yttriumdb.object.Column;
import de.aredblock.yttriumdb.object.LoadedColumn;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

final class YttriumConnector {

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static void push(String key, String name, String url, Column column) throws IOException, InterruptedException {
        final var columnJson = gson.toJson(column);
        final var updatedURL = url + "/push?name=" + name;

        final var client = HttpClient.newHttpClient();

        final var body = HttpRequest.BodyPublishers.ofString(columnJson);

        final var request = HttpRequest.newBuilder()
                .uri(URI.create(updatedURL))
                .header("key",key)
                .POST(body)
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static LoadedColumn pop(String key, String name, String url) throws IOException, InterruptedException {
        final var updatedURL = url + "/pop?name=" + name;

        final var client = HttpClient.newHttpClient();

        final var request = HttpRequest.newBuilder()
                .uri(URI.create(updatedURL))
                .header("key",key)
                .GET()
                .build();

        final var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), LoadedColumn.class);
    }

}
