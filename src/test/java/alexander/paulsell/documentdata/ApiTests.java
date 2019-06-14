package alexander.paulsell.documentdata;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import alexander.paulsell.documentdata.api.DocumentController;
import alexander.paulsell.documentdata.data.DocumentDbClient;
import alexander.paulsell.documentdata.data.entities.Document;
import alexander.paulsell.documentdata.data.entities.Section;
import alexander.paulsell.documentdata.data.entities.Text;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTests {

    @Autowired
    DocumentController documentController;

    @Autowired
    DocumentDbClient documentDbClient;

    @Before
    public void setup() {
        documentDbClient.deleteAll();
        Document document1 = new Document("title 1");
        Section[] sections1 = {new Text("test text")};
        Document document2 = new Document("title 2", sections1);
        Section[] sections2 = {new Text("test text 1"),
            new Text("test text 2"),
            new Text("test text 3"),
            new Text("test text 4")};
        Document document3 = new Document("title 3", sections2);
        assertTrue(documentDbClient.save(document1));
        assertTrue(documentDbClient.save(document2));
        assertTrue(documentDbClient.save(document3));
    }

    // Create

    // Read
    @Test
    public void getAll() {
        assertTrue(documentController.getAllDocuments().size() == 3);
    }

    @Test
    public void getByTitle() {
        String title = "Test Title";
        Section[] sections = {new Text("tt 1"),
            new Text("tt 2"),
            new Text("tt 3"),
            new Text("tt 4")};
        Document document = new Document(title, sections);
        documentDbClient.save(document);
        Document gotDocument = documentController.getDocument(title);
        assertTrue(document.equals(gotDocument));
    }

    @Test
    public void getByTitleFail() {
        assertNull(documentController.getDocument("Fake Title"));
    }

    // Update

    // Delete
}