package shadow.nfsu;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class App {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        ConfigLoader.getConfig(vertx).andThen(
            config -> vertx.deployVerticle(new ServerVerticle(), new DeploymentOptions().setConfig(config.result()), res -> {
                if (res.succeeded()) {
                    System.out.println("Deployment id is: " + res.result());
                } else {
                    System.out.println("Deployment failed!");
                    res.cause().printStackTrace();
                }
            })
        );
    }
}
