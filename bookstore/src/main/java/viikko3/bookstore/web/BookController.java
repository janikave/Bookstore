package viikko3.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import viikko3.bookstore.domain.BookRepository;
import viikko3.bookstore.domain.Book;

import org.springframework.ui.Model;

@Controller
public class BookController {
    @Autowired

    private BookRepository bookRepository;

    @GetMapping("/index")
    public String frontPage() {

        return "frontpage";
    }

    @GetMapping("/booklist")
    public String getBooks(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }
}
