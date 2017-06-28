package webapp.Data;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
                put("dog", new TermEntry("dog", 1, "animal that barks"));
                put("cat", new TermEntry("cat", 2, "animal that meows"));
                put("kitty", new TermEntry("kitty", 3, "animal that meows"));
            }
        };
    }

    public Collection<TermEntry> getAllEntries(){
        return this.termEntries.values();
    }

    public TermEntry getEntryByTerm(String term){
        return this.termEntries.get(term);
    }
}
