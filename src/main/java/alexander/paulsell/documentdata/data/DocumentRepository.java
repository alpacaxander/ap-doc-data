package alexander.paulsell.documentdata.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import alexander.paulsell.documentdata.data.entities.Document;

public interface DocumentRepository extends MongoRepository<Document, String> {

    public Optional<Document> findById(String id);
    public Optional<Document> findOneByTitle(String Title);
    public List<Document> findAll();
    
}