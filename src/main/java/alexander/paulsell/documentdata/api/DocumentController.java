package alexander.paulsell.documentdata.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import alexander.paulsell.documentdata.data.entities.Document;;

@RestController
public class DocumentController {

    @CrossOrigin
    @GetMapping("/hello") 
    public Document getHello() {
        return new Document(1, "Hello, World");
    }
} 