package alexander.paulsell.documentdata.data.entities;

import java.util.Arrays;

import org.springframework.data.annotation.Id;

public class Text extends Section{

    @Id
    private String id;

    private byte[] data;

    public Text() {}

    public Text(String text) {
        this.data = text.getBytes();
    }

    public Text(long id, byte[] data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public boolean equals(Object obj) {
        if (this.getClass().equals(obj.getClass())) {
            return false;
        }
        return Arrays.equals(getData(), ((Text) obj).getData());
    }

    @Override
    public String toString() {
        return id;
    }
}