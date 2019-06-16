package alexander.paulsell.documentdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import alexander.paulsell.documentdata.data.DocumentDbClient;
import alexander.paulsell.documentdata.data.entities.Document;
import alexander.paulsell.documentdata.data.entities.Section;
import alexander.paulsell.documentdata.data.entities.Text;

@SpringBootApplication
public class DocumentdataApplication implements CommandLineRunner {

	@Autowired
	DocumentDbClient documentDbClient;

	public static void main(String[] args) {
		SpringApplication.run(DocumentdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		documentDbClient.deleteAll();
		documentDbClient.save(readDocument("Document Title", new File[] {new ClassPathResource("static//DocumentTitle//Testph.txt").getFile()}));
	}

	public Document readDocument(String title, File[] sectionFiles) {
		Section[] sections = new Section[sectionFiles.length];
		for (int i = 0; i < sectionFiles.length; i++){
			sections[i] = readFileToSection(sectionFiles[i]);
		}
		return new Document(title, sections);
	}

    private static Section readFileToSection(File file) {
        FileInputStream fis = null;
        byte[] bArray = new byte[(int) file.length()];
        try {
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();
        } catch (IOException ioExp) {
            ioExp.printStackTrace();
        }
        return new Text(new String(bArray));
    }

}
