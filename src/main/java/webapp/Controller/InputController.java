package webapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webapp.Data.TermEntries;
import webapp.Service.EntryService;

import java.util.ArrayList;

/**
 * Created by lns16 on 6/27/2017.
 */

@Controller
public class InputController {

    @Autowired
    EntryService entryService;

    @RequestMapping("")
    public String home(Model model) {

        ArrayList<String> termNames = entryService.getEntryTermNames();
        model.addAttribute("termEntries", termNames);
        // string is the name of the html file
        return "layout";
    }

    @RequestMapping("/search")
    public String greeting(Model model, @RequestParam(value="term", required=true) String term) {
        // string is the name of the html file
        model.addAttribute("term", term);
        return "search";
    }

}
