package ucl.cs.catalogues;

import ucl.cs.Book;

import java.util.List;

/**
 * Created by bogdannitescu on 25/11/2017.
 */
public interface Catalogue {
    List<Book> searchFor(String query);
}
