package main.java.applogic;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;

import java.util.Properties;

public class StandData {
    @Property("url")
    private String url;

    private Properties properties;

    public String getUrl() {
        return url;
    }

    public StandData(Properties properties) {
        this.properties = properties;
        PropertyLoader.populate(this, properties);
    }
}
