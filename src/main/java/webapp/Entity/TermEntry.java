package webapp.Entity;

import java.util.ArrayList;

/**
 * Created by lns16 on 6/27/2017.
 */
public class TermEntry {

    private ArrayList<String> synonyms = new ArrayList<String>();
    private String term;
    private int id;
    private String description;

    public TermEntry(String term, int id, String description, ArrayList<String> synonyms) {
        this.term = term;
        this.id = id;
        this.description = description;
        this.synonyms = synonyms;
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

    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    public void addSynonym(String synonym){
        this.synonyms.add(synonym);
    }
}
