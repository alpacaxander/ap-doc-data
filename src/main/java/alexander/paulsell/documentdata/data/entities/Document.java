package alexander.paulsell.documentdata.data.entities;

import java.util.ArrayList;

public class Document {

    private final long id;
    private final String title;
    private Section[] sections;

    public Document(long id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public Document(long id, String title, Section[] sections) {
        this.id = id;
        this.title = title;
        this.sections = sections;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Section[] getSections(){
        return sections;
    }

    public boolean equals(Object obj) {
        if (this.getClass().equals(obj.getClass()) ||
            getId() != ((Document) obj).getId() ||
            !getTitle().equals(((Document) obj).getTitle()) ||
            getSections().length != ((Document) obj).getSections().length) {
            return false;
        } 
        ArrayList<Section> a1 = new ArrayList<Section>();
        for (Section section: getSections()) { a1.add(section); }
        ArrayList<Section> a2 = new ArrayList<Section>();
        for (Section section: ((Document) obj).getSections()) { a2.add(section); }
        if (!a1.containsAll(a2)) {
            return false;
        }
        return true;
    }

}