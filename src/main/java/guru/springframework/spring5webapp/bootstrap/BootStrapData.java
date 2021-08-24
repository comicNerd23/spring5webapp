package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    /*public BootStrapData(AuthorRepository ar, BookRepository br) {
        this.authorRepository = ar;
        this.bookRepository = br;
    }*/
    @Autowired
    public BootStrapData(AuthorRepository ar, BookRepository br, PublisherRepository pr) {
        this.authorRepository = ar;
        this.bookRepository = br;
        this.publisherRepository = pr;
    }

    @Override
    public void run(String... args) {

        Author a1 = new Author("J.K.","Rowling");
        Book b1 = new Book("Harry Potter and the Philosopher's Stone","142313412");
        Book b2 = new Book("Harry Potter and the Chamber Of Secrets","242313412");
        a1.getBookSet().add(b1);
        b1.getAuthorSet().add(a1);
        b2.getAuthorSet().add(a1);

        Author a2 = new Author("Chetan","Bhagat");
        Book b3 = new Book("Five Point Someone","345342352");
        a2.getBookSet().add(b3);
        b3.getAuthorSet().add(a2);

        authorRepository.save(a1);
        bookRepository.save(b1);
        bookRepository.save(b2);
        authorRepository.save(a2);
        bookRepository.save(b3);

        Publisher p1 = new Publisher("Bloomberg", "Big House 5","London","Unknown","620122");

        publisherRepository.save(p1);

        System.out.println("Started in bootstrap");
        System.out.println(authorRepository.count());
        System.out.println(bookRepository.count());

        System.out.println(publisherRepository.count());

    }
}
