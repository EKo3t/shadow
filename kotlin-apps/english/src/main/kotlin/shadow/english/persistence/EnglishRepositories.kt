package shadow.english.persistence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import shadow.english.model.Word

@Repository
interface WordRepository : ReactiveMongoRepository<Word, String> {
    
}