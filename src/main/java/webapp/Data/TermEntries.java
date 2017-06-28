package webapp.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import webapp.Entity.TermEntry;

/**
 * Created by lns16 on 6/27/2017.
 */

@Repository
public class TermEntries {

    private static Map<String, TermEntry> termEntries;

    static {

        termEntries = new HashMap<String, TermEntry>(){

            {
                put("dog", new TermEntry("dog", 1, "animal that barks", new ArrayList<String>() {
                    {
                        add("doggy");
                        add("puppy");}
                }));
                put("cat", new TermEntry("cat", 2, "animal that meows", new ArrayList<String>() {
                    {
                        add("kitty");
                        add("kitten");}
                }));
                put("kitty", new TermEntry("kitty", 3, "small animal that meows", new ArrayList<String>() {
                    {
                        add("cat");
                        add("kitty");}
                }));
            }
        };


    }

    public Collection<TermEntry> getAllEntries(){
        return this.termEntries.values();
    }

    public TermEntry getEntryByTerm(String term){
        return this.termEntries.get(term);
    }

    public ArrayList<String> getEntryTermNames(){
        return new ArrayList<String>(this.termEntries.keySet());
    }

    // TODO
    public void getEntrySynonyms(){}
}
