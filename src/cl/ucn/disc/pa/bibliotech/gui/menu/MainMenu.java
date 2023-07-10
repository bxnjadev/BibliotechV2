package cl.ucn.disc.pa.bibliotech.gui.menu;

import cl.ucn.disc.pa.bibliotech.book.Book;
import cl.ucn.disc.pa.bibliotech.book.BookService;
import cl.ucn.disc.pa.bibliotech.book.BorrowedBook;
import cl.ucn.disc.pa.bibliotech.book.HistoryBook;
import cl.ucn.disc.pa.bibliotech.gui.add.book.AddBook;
import cl.ucn.disc.pa.bibliotech.gui.search.book.SearchBook;
import cl.ucn.disc.pa.bibliotech.reader.AdapterReader;
import cl.ucn.disc.pa.bibliotech.reader.DefaultElementSaver;
import cl.ucn.disc.pa.bibliotech.reader.ElementSaver;

import javax.swing.*;

public class MainMenu extends JFrame {

    private JButton reservesButton;
    private JButton addBookButton;
    private JButton returnBookButton;
    private JButton searchBookButton;
    private JPanel mainMenu;
    private JPanel mainMenu2;
    private JButton retryField;

    private AddBook addBook;
    private SearchBook searchBook;

    private final AdapterReader<Book> bookAdapterReader;
    private final AdapterReader<BorrowedBook> borrowedBookAdapterReader;

    private final BookService bookService;
    private final HistoryBook historyBook;

    public MainMenu(AdapterReader<Book> bookAdapterReader, AdapterReader<BorrowedBook> borrowedBookAdapterReader,
                    BookService bookService, HistoryBook historyBook) {
        loadButtons();
        this.bookService = bookService;
        this.historyBook = historyBook;
        this.borrowedBookAdapterReader = borrowedBookAdapterReader;
        this.bookAdapterReader = bookAdapterReader;
    }

    public void setBookMenu(AddBook addBook, SearchBook searchBook) {
        this.addBook = addBook;
        this.searchBook = searchBook;

        loadButtons();
    }

    public void open() {
        setContentPane(mainMenu2);

        setTitle("Main Menu");
        setSize(300, 300);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadButtons() {
        setVisible(false);

        addBookButton.addActionListener(action -> {
            addBook.open();
        });

        searchBookButton.addActionListener(action -> {
            searchBook.open();
        });

        retryField.addActionListener(action -> {
            saveAll();
        });

    }

    private void saveAll() {

        ElementSaver<Book> bookElementSaver = new DefaultElementSaver<>("books.txt",
                bookAdapterReader);

        ElementSaver<BorrowedBook> borrowedBookElementSaver = new DefaultElementSaver<>("reserves.txt",
                borrowedBookAdapterReader
                );

        bookElementSaver.save(
                bookService.getBooks()
        );

        borrowedBookElementSaver.save(
                historyBook.getHistory()
        );

    }


}
