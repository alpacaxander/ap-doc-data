package alexander.paulsell.documentdata.data.entities;

public class Document {

    private final long id;
    private final String content;

    public Document(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}