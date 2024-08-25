package shadow.nfsu;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.config.yaml.YamlProcessor;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Singleton load of config
 */
final class ConfigLoader {

    private static final YamlProcessor CONFIG_PROCESSOR = new YamlProcessor();
    private static final String CONFIG_NAME = "application.yaml";
    private static Future<JsonObject> config = null;

    synchronized static Future<JsonObject> getConfig(Vertx vertx) {
        if (config != null) {
            return config;
        }

        ConfigRetrieverOptions options = getVerticleOptions();
        ConfigRetriever retriever = ConfigRetriever.create(vertx, options);
        config = retriever.getConfig();
        return config;
    }

    private static ConfigRetrieverOptions getVerticleOptions() {
        ConfigStoreOptions fileStore = new ConfigStoreOptions()
            .setType("file")
            .setFormat("yaml")
            .setConfig(new JsonObject().put("path", CONFIG_NAME));
        return new ConfigRetrieverOptions().addStore(fileStore);
    }
}
