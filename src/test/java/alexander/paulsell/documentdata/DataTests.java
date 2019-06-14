package alexander.paulsell.documentdata;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import alexander.paulsell.documentdata.data.DocumentDbClient;
import alexander.paulsell.documentdata.data.entities.Document;
import alexander.paulsell.documentdata.data.entities.Section;
import alexander.paulsell.documentdata.data.entities.Text;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTests {

    @Autowired
    DocumentDbClient documentDbClient;

    @Before
    public void setupEach() {
        documentDbClient.deleteAll();
    }

    // Create
    @Test
    public void addEmptyDocument() {
        Document singleEmptyDocument = new Document("title");
        assertTrue(documentDbClient.save(singleEmptyDocument));
    }
    
    @Test
    public void addDocumentWithSingleTextSection() {
        Section[] sections = {new Text("test text")};
        Document singleDocumentWithSingleTextSection = new Document("title", sections);
        assertTrue(documentDbClient.save(singleDocumentWithSingleTextSection));
    }

    @Test
    public void addDocumentWithManyTextSections() {
        Section[] sections = {new Text("test text 1"),
            new Text("test text 2"),
            new Text("test text 3"),
            new Text("test text 4")};
        Document singleDocumentWithManyTextSections = new Document("title", sections);
        assertTrue(documentDbClient.save(singleDocumentWithManyTextSections));
    }

    @Test
    public void addManyDocumentsDifferentTextSections() {
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
    // Read
    @Test
    public void getByTitle() {
        Document gotDocument;
        String title = "title 1";
        Document singleEmptyDocument = new Document(title);
        documentDbClient.save(singleEmptyDocument);
        gotDocument = documentDbClient.getOneByTitle(title);
        assertTrue(singleEmptyDocument.equals(gotDocument));
    }

    @Test
    public void getByTitleFail() {
        documentDbClient.save(new Document("realTitle"));
        assertTrue(documentDbClient.getOneByTitle("fakeTitle") == null);
    }

    // Update
    @Test
    public void updateTitle() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void updateSections() {
        throw new UnsupportedOperationException();
    }

    // Delete
    @Test
    public void deleteById() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void deleteByTitle() {
        throw new UnsupportedOperationException();
    }
}