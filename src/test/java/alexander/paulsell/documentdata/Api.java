package alexander.paulsell.documentdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import alexander.paulsell.documentdata.api.DocumentController;
import alexander.paulsell.documentdata.data.entities.Document;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Api {

    @Autowired
    DocumentController controller;

    // Create

    // Read
    @Test
    public void getAll() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void getByTitle() {
        throw new UnsupportedOperationException();
    }

    // Update

    // Delete
}