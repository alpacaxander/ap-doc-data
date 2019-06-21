package alexander.paulsell.documentdata.data.entities;

import alexander.paulsell.documentdata.data.entities.Document.Section;

public class Snippet extends Section {

    private String type;
    private String data;

    public Snippet() {}

    public Snippet(String text) {
        this.type = "snippet";
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