package viikko3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import viikko3.bookstore.domain.BookRepository;
import viikko3.bookstore.domain.Book;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository brepository;

    @GetMapping("/books")
    public @ResponseBody List<Book> getBooksRest() {
        return (List<Book>) brepository.findAll();
    }

    @GetMapping("/books/{bookid}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("bookid") Long bookid) {
        return brepository.findById(bookid);
    }

}
