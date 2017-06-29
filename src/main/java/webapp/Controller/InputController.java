package webapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import webapp.Data.TermEntries;
import webapp.Entity.TermEntry;
import webapp.Service.EntryService;

import java.util.ArrayList;

/**
 * Created by lns16 on 6/27/2017.
 */

@Controller
public class InputController {

    @Autowired
    EntryService entryService;

    String searchTerm;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model) {

        ArrayList<String> termNames = entryService.getEntryTermNames();
        model.addAttribute("termEntries", termNames);
        // string is the name of the html file
        return "layout";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processSearch(@RequestParam String searchTerm) {
        this.searchTerm = searchTerm;
        // string is the name of the html file
        return "redirect:search";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String processSearch2(@RequestParam String searchTerm) {
        this.searchTerm = searchTerm;
        // string is the name of the html file
        return "redirect:search";
    }

    @RequestMapping(value = "/search")
    public String displaySearchResults(Model model) {
        TermEntry result = entryService.getEntryByTerm(searchTerm);
        if (!(result == null)) {
            model.addAttribute("term", result.getTerm());
            // model.addAttribute("term", term);
            String description = result.getDescription();
            model.addAttribute("description", description);
        }
        if (!(searchTerm == null)) {
            model.addAttribute("searchTerm", searchTerm);
        } else {
            model.addAttribute("searchTerm", "...");
        }

        // string is the name of the html file
        return "search";
    }

}
