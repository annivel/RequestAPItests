package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties"
})
public interface APIConfig extends Config {
    @Key("api.base.url")
    String baseURL();

    @Key("api.base.path")
    String basePath();
}


