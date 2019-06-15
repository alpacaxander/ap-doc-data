package alexander.paulsell.documentdata.data.entities;

public abstract class Section {
    public abstract String getId();
    public abstract byte[] getData();
    public abstract boolean equals(Object obj);
}