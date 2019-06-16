package alexander.paulsell.documentdata.data.entities;

import java.util.Arrays;

import org.springframework.data.annotation.Id;

public class Text extends Section{

    @Id
    private String id;

    private String data;

    public Text() {}

    public Text(String text) {
        this.data = text;
    }

    public String getId() {
        return null;
    }

    public String getData() {
        return data;
    }

    public boolean equals(Object obj) {
        if (this.getClass().equals(obj.getClass())) {
            return false;
        }
        return getData().equals(((Text) obj).getData());
    }

    @Override
    public String toString() {
        return new String(data);
    }
}