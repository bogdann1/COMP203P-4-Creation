package ucl.cs.catalogues;

import ucl.cs.Book;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BritishLibraryCatalogue implements Catalogue {

  private static Catalogue INSTANCE = new BritishLibraryCatalogue();

  private BritishLibraryCatalogue() {
    catalogue = allTheBooks();
  }

  private final Collection<Book> catalogue;

  public static Catalogue getInstance() {
    return INSTANCE;
  }

  @Override
  public List<Book> searchFor(String query) {
    return catalogue.stream()
        .filter(book -> book.matchesAuthor(QueryParser.lastNameFrom(query)))
        .filter(book -> book.matchesAuthor(QueryParser.firstNameFrom(query)))
        .filter(book -> book.matchesTitle(QueryParser.titleFrom(query)))
        .filter(book -> book.publishedSince(QueryParser.publishedAfterFrom(query)))
        .filter(book -> book.publishedBefore(QueryParser.publishedBeforeFrom(query)))
        .collect(Collectors.toList());
  }


  private Collection<Book> allTheBooks() {

    System.out.println("Memory Usage: 500MB...");

    return Arrays.asList(
        new Book("A Tale of Two Cities", "Charles Dickens", 1859),
        new Book("Pride and Prejudice", "Jane Austen", 1813),
        new Book("Pride and Prejudice", "Jane Austen", 1813),
        new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890),
        new Book("Oliver Twist", "Charles Dickens", 1838),
        new Book("Frankenstein", "Mary Shelley", 1817),
        new Book("Brave New World", "Aldous Huxley", 1932),
        new Book("Lord of the Flies", "William Golding", 1954),
        new Book("Hamlet", "William Shakespeare", 1603),
        new Book("The Life and Opinions of Tristram Shandy, Gentleman", "Laurence Sterne", 1759));

    // and so on... Imagine that this list is very large and therefore uses a lot of memory.

  }

}
