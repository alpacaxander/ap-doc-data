package alexander.paulsell.documentdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import alexander.paulsell.documentdata.data.DocumentDbClient;
import alexander.paulsell.documentdata.data.entities.Document;
import alexander.paulsell.documentdata.data.entities.Snippet;
import alexander.paulsell.documentdata.data.entities.Document.Section;
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
		System.out.println(new ClassPathResource("static").getFile().toPath());
		return;/*
		try (Stream<Path> walk = Files.walk(new ClassPathResource("static").getFile().toPath(), 1)) {
			List<Document> documents = walk.filter(Files::isDirectory).skip(1)
				.map(DocumentdataApplication::pathToDocument)
				.collect(Collectors.toList());
				
			for (Document document: documents) {
				documentDbClient.save(document);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	public static Document pathToDocument(Path path) {
		try (Stream<Path> walk = Files.walk(path, 1)) {
			List<Section> sections = walk.filter(Files::isRegularFile)
				.map( v -> {return fileToSection(v);})
				.collect(Collectors.toList());
			return new Document(path.toFile().getName(), sections.toArray(new Section[] {}));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

    private static Section fileToSection(Path path) {
		File file = path.toFile();
        FileInputStream fis = null;
        byte[] bArray = new byte[(int) file.length()];
        try {
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();
        } catch (IOException ioExp) {
            ioExp.printStackTrace();
		}
		Section result = null;
		if (path.toString().endsWith(".snip")) {
			result = new Snippet(new String(bArray));
		} else {
			result = new Text(new String(bArray));
		}
        return result;
    }

}
