package modern.challenge;

import modern.challenge.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nAdd author with books  ...");
            bookstoreService.addAuthorWithBooks();

            System.out.println("\nRemove a book of an author...");
            bookstoreService.removeBookOfAuthor();
            
            System.out.println("\nRemove all book of an author...");
            bookstoreService.removeAllBooksOfAuthor();
        };
    }
}
