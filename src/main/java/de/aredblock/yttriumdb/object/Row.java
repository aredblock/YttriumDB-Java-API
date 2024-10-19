package de.aredblock.yttriumdb.object;

public class Row {

    private String Key;
    private String Value;

    public static Row of(String key, String value) {
        final var instance = new Row();
        instance.Key = key;
        instance.Value = value;
        return instance;
    }

    public String getKey() {
        return Key;
    }

    public String getValue() {
        return Value;
    }

}
