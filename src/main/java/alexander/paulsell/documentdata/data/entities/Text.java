package alexander.paulsell.documentdata.data.entities;

import java.util.Arrays;

public class Text extends Section{
    private final long id;
    private final byte[] data;
    public Text(long id, String text) {
        this.id = id;
        this.data = text.getBytes();
    }

    public Text(long id, byte[] data) {
        this.id = id;
        this.data = data;
    }

    public long getId() {
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
}