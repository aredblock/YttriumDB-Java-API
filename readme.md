# YttriumDB Java API

The YttriumDB Java API is the official Java API for the [YttriumDB](https://github.com/aredblock/YttriumDB) database.

### Installation

You can import the API via the [JitPack repository](https://jitpack.io/#aredblock/YttriumDB-Java-API).

```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.aredblock:YttriumDB:Tag'
}
```

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.aredblock</groupId>
        <artifactId>YttriumDB</artifactId>
        <version>Tag</version>
    </dependency>
</dependencies>
```

### Usage

With the YttriumClient you can enter or load columns into the database using the push() and pop() methods.

Upload to the database:
```java
//[...]
final var client = YttriumClient.builder()
                .key("<your_key>")
                .build();

final var column = Column.of(
        Row.of("User1", "user1@example.com")
);

client.push(columnUser, demoColumn);
//[...]
```

Loading columns from the database:
```java
//[...]
final var client = YttriumClient.builder()
                .key("<your_key>")
                .build();

final var loadedColumn = yttriumClient.pop(columnUser);

loadedColumn.getColumn().getRows().forEach(row -> {
        System.out.println(row.getKey() + "=" + row.getValue());
});
//[...]
```