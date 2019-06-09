package alexander.paulsell.documentdata.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import alexander.paulsell.documentdata.data.entities.Document;;

@RestController
public class DocumentController {

    @CrossOrigin
    @GetMapping("/hello") 
    public Document getHello() {
        return new Document(1, "Hello, World");
    }

    @CrossOrigin
    @PostMapping("/create")
	public static void createDocument(Document testDocument) {

    }
    
    @CrossOrigin
    @GetMapping("/get")
	public static Document getDocument(long id) {
		return null;
    }
    
    @CrossOrigin
    @GetMapping("/getall")
	public static ArrayList<Document> getAll() {
		return null;
	}

} 