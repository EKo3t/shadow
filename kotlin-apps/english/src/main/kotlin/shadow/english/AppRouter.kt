package shadow.english

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import shadow.english.model.AddWordRequest


@Configuration(proxyBeanMethods = false)
open class AppRouter {

    @Bean
    open fun route(wordHandler: WordHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .path("/words/") { builder: RouterFunctions.Builder ->
                builder
                    .POST("/add", accept(MediaType.APPLICATION_JSON), addWord(wordHandler))
            }
            .build()
    }

    private fun addWord(wordHandler: WordHandler) = HandlerFunction<ServerResponse> { request ->
        request
            .bodyToMono<AddWordRequest>()
            .flatMap { addWordRequest -> wordHandler.processRequest(addWordRequest) }
            .flatMap { response -> ServerResponse.ok().build() }
    }
}