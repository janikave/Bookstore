package viikko3.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class BookController {

    @GetMapping("/index")
    public String frontPage() {

        return "frontpage";
    }
}
