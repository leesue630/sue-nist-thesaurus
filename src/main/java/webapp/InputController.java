package webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lns16 on 6/27/2017.
 */

@Controller
public class InputController {

    @RequestMapping("/")
    public String greeting(Model model) {
        // string is the name of the html file
        return "layout";
    }

}
