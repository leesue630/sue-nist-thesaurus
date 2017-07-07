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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lns16 on 6/27/2017.
 */

@Controller
public class InputController {

    @Autowired
    EntryService entryService;

    String searchTerm;
    String showInfoTerm;

    // first home get
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model) {
        ArrayList<String> termNames = entryService.getEntryTermNames();
        model.addAttribute("termEntries", termNames);
        // string is the name of the html file
        TermEntry result = entryService.getEntryByTerm(showInfoTerm);
        if (result != null) {
            model.addAttribute("showTerm", result.getTerm());
            model.addAttribute("showDescription", result.getDescription());
            model.addAttribute("showSynonyms", result.getSynonyms().toString().replaceAll("[\\[\\]]", ""));
        }
        // string is the name of the html file
        return "layout";
    }

    // from home search post
    @RequestMapping(value = "", method = RequestMethod.POST, params = {"searchTerm"})
    public String processSearch(@RequestParam String searchTerm) {
        this.searchTerm = searchTerm;
        // string is the name of the html file
        return "redirect:search";
    }

    // from home show info post
    @RequestMapping(value = "", method = RequestMethod.POST, params = {"showInfoTerm"})
    public String processShowInfo(@RequestParam String showInfoTerm) {
        this.showInfoTerm = showInfoTerm;
        // string is the name of the html file
        return "redirect: ";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST, params = {"showInfoTerm"})
    public String processShowInfo2(@RequestParam String showInfoTerm) {
        this.showInfoTerm = showInfoTerm;
        // string is the name of the html file
        return "redirect: ";
    }

//    // home display info get
//    @RequestMapping(value = "")
//    public String displayShowInfo(Model model) {
//        TermEntry result = entryService.getEntryByTerm(showInfoTerm);
//        model.addAttribute("showTerm", result.getTerm());
//        // model.addAttribute("term", term);
//        String description = result.getDescription();
//        model.addAttribute("showDescription", description);
//        // string is the name of the html file
//        return "layout";
//    }

    // search post
    @RequestMapping(value = "search", method = RequestMethod.POST, params = {"searchTerm"})
    public String processSearch2(@RequestParam String searchTerm) {
        this.searchTerm = searchTerm;
        // string is the name of the html file
        return "redirect:search";
    }

    // search get
    @RequestMapping(value = "/search")
    public String displaySearchResults(Model model) {
        HashMap<String, String> resultList = new HashMap<>();
        TermEntry result = entryService.getEntryByTerm(searchTerm);
        if (result != null) {
            resultList.put(result.getTerm(), result.getDescription());
        }
        Collection<TermEntry> allEntries = entryService.getAllEntries();
        for (TermEntry term : allEntries) {
            if (term.getSynonyms().contains(searchTerm)) {
                resultList.put(term.getTerm(), term.getDescription());
            }
        }
        if (searchTerm != null) {
            model.addAttribute("searchTerm", searchTerm);
        } else {
            model.addAttribute("searchTerm", "...");
        }
        model.addAttribute("resultEntrySet", resultList.entrySet());
        // string is the name of the html file
        return "search";
    }

}
