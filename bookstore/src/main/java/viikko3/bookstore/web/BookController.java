package viikko3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import viikko3.bookstore.domain.BookRepository;

import org.springframework.ui.Model;

@Controller
public class BookController {
    @Autowired

    private BookRepository repository;

    @GetMapping("/index")
    public String frontPage() {

        return "frontpage";
    }
}
