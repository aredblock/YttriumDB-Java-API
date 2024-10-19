package de.aredblock.yttriumdb;

import de.aredblock.yttriumdb.object.Column;
import de.aredblock.yttriumdb.object.Row;

public final class TestMain {

    public static void main(String[] args) throws Exception {
        final var columnUser = "demo";
        final var yttriumClient = YttriumClient.builder()
                .key("2cc735e5")
                .build();

        final var demoColumn = Column.of(
                Row.of("User1", "user1@example.com")
        );

        System.out.println("Pushing to YttriumDB");
        yttriumClient.push(columnUser, demoColumn);

        Thread.sleep(1000);

        final var loadedColumn = yttriumClient.pop(columnUser);

        System.out.println("Loaded rows: ");

        loadedColumn.getColumn().getRows().forEach(row -> {
            System.out.println(row.getKey() + "=" + row.getValue());
        });
    }

}
