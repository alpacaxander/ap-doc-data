package alexander.paulsell.documentdata.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alexander.paulsell.documentdata.data.DocumentDbClient;
import alexander.paulsell.documentdata.data.entities.Document;

@Service
public class Manager{
    @Autowired
    DocumentDbClient documentDbClient;
    
    public List<Document> getAllDocuments(){
        return documentDbClient.findAll();
    }

	public Document getDocument(String title) {
		return documentDbClient.getOneByTitle(title);
	}
}