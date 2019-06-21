package alexander.paulsell.documentdata.data.entities;

import org.springframework.data.annotation.Id;

import alexander.paulsell.documentdata.data.entities.Document.Section;

public class Text extends Section {

    private String type;
    private String data;

    public Text() {}

    public Text(String text) {
        this.type = "text";
        this.data = text;
    }

    public String getData() {
        return data;
    }

    public String getType() {
        return type;
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