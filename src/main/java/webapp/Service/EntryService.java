package webapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.Data.TermEntries;
import webapp.Entity.TermEntry;

import java.util.Collection;

/**
 * Created by lns16 on 6/28/2017.
 */

@Service
public class EntryService {

    @Autowired
    private TermEntries entries;

    public Collection<TermEntry> getAllStudents(){
        return this.entries.getAllEntries();
    }

    public TermEntry getEntryByTerm(String term){
        return this.entries.getEntryByTerm(term);
    }
}
