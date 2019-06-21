package alexander.paulsell.documentdata.data.entities;

import org.springframework.data.annotation.Id;

import alexander.paulsell.documentdata.data.entities.Document.Section;

public class Image extends Section {

    private String type = "image";
    private byte[] data;

    public Image() {}

    public Image(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public boolean equals(Object obj) {
        if (this.getClass().equals(obj.getClass())) {
            return false;
        }
        return getData().equals(((Image) obj).getData());
    }

    @Override
    public String toString() {
        return new String(data);
    }
}