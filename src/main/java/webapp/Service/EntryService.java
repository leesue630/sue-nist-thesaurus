package webapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.Data.TermEntries;
import webapp.Entity.TermEntry;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lns16 on 6/28/2017.
 */

@Service
public class EntryService {

    @Autowired
    private TermEntries termEntries;

    public Collection<TermEntry> getAllEntries(){
        return this.termEntries.getAllEntries();
    }

    public TermEntry getEntryByTerm(String term){
        return this.termEntries.getEntryByTerm(term);
    }

    public ArrayList<String> getEntryTermNames(){
        return this.termEntries.getEntryTermNames();
    }
}
