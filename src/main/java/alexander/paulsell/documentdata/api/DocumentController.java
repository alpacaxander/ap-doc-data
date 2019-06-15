package alexander.paulsell.documentdata.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import alexander.paulsell.documentdata.business.Manager;
import alexander.paulsell.documentdata.data.entities.Document;;

@RestController
public class DocumentController {

    @Autowired
    Manager manager;

    @CrossOrigin
    @GetMapping("/hello") 
    public Document getHello() {
        return new Document("Hello, World");
    }

    @CrossOrigin
    @PostMapping("/create")
	public void createDocument(Document testDocument) {
        throw new UnsupportedOperationException();
    }
    
    @CrossOrigin
    @GetMapping("/get")
	public Document getDocument(String title) {
		return manager.getDocument(title);
    }
    
    @CrossOrigin
    @GetMapping("/getall")
	public List<Document> getAllDocuments() {
        return manager.getAllDocuments();
	}

} 