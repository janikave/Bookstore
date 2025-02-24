package viikko3.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import viikko3.bookstore.domain.BookRepository;
import viikko3.bookstore.domain.CategoryRepository;
import viikko3.bookstore.domain.Book;

import org.springframework.ui.Model;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository crepository;

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());

        return "addbook";
    }

    @PostMapping("/savebook")
    public String saveBook(Book book) {
        bookRepository.save(book);

        return "redirect:/booklist";
    }

    @GetMapping("/booklist")
    public String getBooks(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }

    @GetMapping("/deletebook/{bookid}")
    public String deleteBook(@PathVariable("bookid") Long bookid) {
        bookRepository.deleteById(bookid);

        return "redirect:/booklist";
    }
}
