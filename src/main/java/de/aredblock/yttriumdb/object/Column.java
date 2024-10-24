package de.aredblock.yttriumdb.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Column {

    private List<Row> Rows;

    public static Column of(Row... rows) {
        final var instance = new Column();
        instance.Rows = new ArrayList<>(Arrays.asList(rows));
        return instance;
    }

    public List<Row> getRows() {
        return Rows;
    }

}
