package alexander.paulsell.documentdata.data.entities;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Document {

    @Id
    private String title;
    private Section[] sections;

    public Document() {}

    public Document(String title) {
        this.title = title;
        this.sections = new Section[0];
    }
    
    public Document(String title, Section[] sections) {
        this.title = title;
        this.sections = sections;
    }

    public String getTitle() {
        return title;
    }

    public Section[] getSections(){
        return sections;
    }

    public boolean equals(Object obj) {
        return getTitle().equals(((Document) obj).getTitle());
    }

    @Override
    public String toString() {
        String sectionString = "";
        for (Section s: getSections()) {
            sectionString += s.toString() + ", ";
        }

        return String.format(
                "Document[title='%s', sections='%s']",
                title, sectionString);
    }

}