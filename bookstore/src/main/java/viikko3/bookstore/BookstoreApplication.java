package viikko3.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import viikko3.bookstore.domain.Book;
import viikko3.bookstore.domain.BookRepository;
import viikko3.bookstore.domain.CategoryRepository;
import viikko3.bookstore.domain.Category;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {

		return (args) -> {
			log.info("save some sample categories");

			Category c1 = new Category("Seikkailu");
			Category c2 = new Category("Mysteeri");
			Category c3 = new Category("Draama");

			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);

			log.info("save some sample books");

			Book b4 = new Book("Parry Hotteri", "RK Jowling", 2004, "1700-0432-046", 31.50, c1);
			Book b5 = new Book("Harri Putteri", "WJ Rokling", 2005, "1700-0432-047", 32.50, c2);
			Book b6 = new Book("Harri Patteri", "JW Korling", 2006, "1700-0432-048", 33.50, c3);

			brepository.save(b4);
			brepository.save(b5);
			brepository.save(b6);

			log.info("fetching all the categories");
			for (Category name : crepository.findAll()) {
				log.info(name.toString());
			}

			log.info("fetching all the books");
			for (Book book : brepository.findAll()) {

				log.info(book.toString());
			}

		};
	}
}
