package lib_Managemet_HashMap;

import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return a.getTitle().compareToIgnoreCase(b.getTitle());
    }
}
