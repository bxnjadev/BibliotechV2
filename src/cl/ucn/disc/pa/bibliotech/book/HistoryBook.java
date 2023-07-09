package cl.ucn.disc.pa.bibliotech.book;

import cl.ucn.disc.pa.bibliotech.user.User;

import java.util.List;

public class HistoryBook {

    private List<BorrowedBook> history;

    public HistoryBook(List<BorrowedBook> history) {
        this.history = history;
    }

    public void rentBook(User seller, Book book) {

    }

    public void lendBook(User user, Book book) {

    }

    public static HistoryBook empty() {
        return new HistoryBook(null);
    }

}
