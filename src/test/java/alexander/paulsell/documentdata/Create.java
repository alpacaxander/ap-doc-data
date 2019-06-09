package alexander.paulsell.documentdata;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import alexander.paulsell.documentdata.api.DocumentController;
import alexander.paulsell.documentdata.data.entities.Document;
import alexander.paulsell.documentdata.data.entities.Section;
import alexander.paulsell.documentdata.data.entities.Text;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Create {

	@Test
	public void createOneDocumentWithNoSections() {
		long id = 123456789;
		String title = "test title 1";
		Document testDocument = new Document(id, title);
		DocumentController.createDocument(testDocument);
		Document retrievedDocument = DocumentController.getDocument(id);
		String retrievedTitle = retrievedDocument.getTitle();
		assertTrue(title.equals(retrievedTitle));
	}

	@Test
	public void createOneDocumentWithOneTextSection() {
		long id = 123456789;
		String title = "test title 1";
		Text section = new Text(987654321, "Test text");
		Section[] sections = {section};
		Document testDocument = new Document(id, title, sections);
		DocumentController.createDocument(testDocument);
		Document retrievedDocument = DocumentController.getDocument(id);
		assertTrue(testDocument.equals(retrievedDocument));
	}
	
	@Test
	public void createOneDocumentWithManyTextSections() {
		long id = 123456789;
		String title = "test title 1";
		Text section1 = new Text(987654321, "Test text1");
		Text section2 = new Text(98761234, "Test text2");
		Section[] sections = {section1, section2};
		Document testDocument = new Document(id, title, sections);
		DocumentController.createDocument(testDocument);
		Document retrievedDocument = DocumentController.getDocument(id);
		assertTrue(testDocument.equals(retrievedDocument));
	}

	@Test
	public void createManyDocumentsWithZeroOneManySections() {
		ArrayList<Document> testDocuments = new ArrayList<Document>();
		Text section1 = new Text(321, "Test text1");
		Text section2 = new Text(4321, "Test text2");
		Text section3 = new Text(12345, "Test text3");
		Section[] sections1 = {section1};
		Section[] sections2 = {section2, section3};
		testDocuments.add(new Document(123, "Test title 1"));
		testDocuments.add(new Document(1234, "Test title 2", sections1));
		testDocuments.add(new Document(12345, "Test title 3", sections2));
		for (Document doc: testDocuments) { DocumentController.createDocument(doc); }
		
		ArrayList<Document> retrievedDocuments = new ArrayList<Document>();
		for (Document doc: DocumentController.getAll()) { retrievedDocuments.add(doc); }
		assertTrue(testDocuments.size() == retrievedDocuments.size());
		assertTrue(retrievedDocuments.containsAll(testDocuments));
	}

}
