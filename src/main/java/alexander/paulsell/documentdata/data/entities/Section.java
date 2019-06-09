package alexander.paulsell.documentdata.data.entities;

public abstract class Section {
    public abstract long getId();
    public abstract byte[] getData();
    public abstract boolean equals(Object obj);
}