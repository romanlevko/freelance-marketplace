package roman.levko.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlPageController {

    @RequestMapping("/category")
    public String category() {
        return "category.html";
    }

    @RequestMapping("/assignment")
    public String assignment() {
        return "assignment.html";
    }

    @RequestMapping("/client")
    public String client() {
        return "client.html";
    }

    @RequestMapping("/translator")
    public String translator() {
        return "translator.html";
    }

    @RequestMapping("/job")
    public String job() {
        return "job.html";
    }


}
