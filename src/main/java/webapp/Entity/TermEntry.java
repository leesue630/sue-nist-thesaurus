package webapp.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lns16 on 6/27/2017.
 */
public class TermEntry {

    //private List<String> synonyms = new ArrayList<String>();
    private String term;
    private int id;
    private String description;

    public TermEntry(String term, int id, String description) {
        this.term = term;
        this.id = id;
        this.description = description;
    }

    public TermEntry(){}

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
