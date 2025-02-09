package viikko3.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import viikko3.bookstore.domain.Book;
import viikko3.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Harri Potteri", "kiihkoilija", 2001, "1700-0432-043", 30.50);
			Book b2 = new Book("Harri Putteri", "kiihkoilija", 2002, "1700-0432-044", 30.50);
			Book b3 = new Book("Harri Patteri", "kiihkoilija", 2002, "1700-0432-045", 30.50);

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}
}
