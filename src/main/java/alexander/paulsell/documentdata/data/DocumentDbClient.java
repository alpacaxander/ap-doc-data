package alexander.paulsell.documentdata.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import alexander.paulsell.documentdata.data.entities.Document;

@Repository
public class DocumentDbClient {

    @Autowired
    DocumentRepository repository;

    public Document getById(String id) {
        Optional<Document> result =  repository.findById(id);
        return result.get();
    }

    public List<Document> findAll() {
        return repository.findAll();
    }

    public boolean save(Document newDocument) {
        repository.save(newDocument);
        return true;
    }

	public void deleteAll() {
        repository.deleteAll();
    }
    
    public Document getOneByTitle(String title) {
        Optional<Document> result = repository.findOneByTitle(title);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
}