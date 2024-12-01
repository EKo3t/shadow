package shadow.english

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import shadow.english.model.AddWordRequest
import shadow.english.model.Word
import shadow.english.persistence.WordRepository

@Component
class WordHandler @Autowired constructor(private val wordRepository: WordRepository) {

    fun processRequest(request: AddWordRequest): Mono<Word> {
        return Mono.just<AddWordRequest>(request)
            .map { request -> Word(request.word, request.language) }
            .flatMap { word -> wordRepository.save(word) }
    }
}