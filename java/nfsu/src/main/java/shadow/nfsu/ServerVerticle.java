package shadow.nfsu;

import io.vertx.core.AbstractVerticle;

public class ServerVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer()
             .requestHandler(request -> request.response().end("Hello world"))
             .listen(context.config().getJsonObject("server").getInteger("port"))
             .onSuccess(server -> System.out.println(
                 "HTTP server started on port " + server.actualPort()
             ));
    }
}
