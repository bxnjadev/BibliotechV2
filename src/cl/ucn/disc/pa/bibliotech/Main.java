package cl.ucn.disc.pa.bibliotech;

import cl.ucn.disc.pa.bibliotech.auth.AuthService;
import cl.ucn.disc.pa.bibliotech.auth.DefaultAuthService;
import cl.ucn.disc.pa.bibliotech.book.*;
import cl.ucn.disc.pa.bibliotech.gui.add.book.AddBook;
import cl.ucn.disc.pa.bibliotech.gui.login.Login;
import cl.ucn.disc.pa.bibliotech.gui.menu.MainMenu;
import cl.ucn.disc.pa.bibliotech.gui.search.book.SearchBook;
import cl.ucn.disc.pa.bibliotech.helper.ReaderHelper;
import cl.ucn.disc.pa.bibliotech.reader.AdapterReader;
import cl.ucn.disc.pa.bibliotech.reader.DefaultElementSaver;
import cl.ucn.disc.pa.bibliotech.reader.ElementReader;
import cl.ucn.disc.pa.bibliotech.reader.ElementSaver;
import cl.ucn.disc.pa.bibliotech.reader.adapters.BookAdapterReader;
import cl.ucn.disc.pa.bibliotech.reader.adapters.BorrowedBookAdapterReader;
import cl.ucn.disc.pa.bibliotech.reader.adapters.UserAdapterReader;
import cl.ucn.disc.pa.bibliotech.user.User;

import java.io.IOException;

public class Main {

    private static ElementReader<Book> bookElementReader;
    private static ElementReader<User> userElementReader;
    private static ElementReader<BorrowedBook> borrowedBookElementReader;

    private static AdapterReader<Book> bookAdapterReader;
    private static AdapterReader<User> userAdapterReader;
    private static AdapterReader<BorrowedBook> borrowedBookAdapterReader;

    private static AuthService authService;
    private static BookService bookService;
    private static HistoryBook historyBook;

    public static void main(String[] args) throws IOException {

        loadReader();

        authService = new DefaultAuthService(
                ReaderHelper.readElements(userElementReader)
        );

        bookService = new DefaultBookService(
                ReaderHelper.readElements(bookElementReader)
        );

        historyBook = new HistoryBook(
                ReaderHelper.readElements(borrowedBookElementReader)
        );

        MainMenu mainMenu = new MainMenu(
                bookAdapterReader, borrowedBookAdapterReader, bookService, historyBook
        );

        AddBook addBook = new AddBook(bookService, mainMenu);
        SearchBook searchBook = new SearchBook(bookService);

        mainMenu.setBookMenu(addBook, searchBook);
        searchBook.setMainMenu(mainMenu);

        Login login = new Login(authService, mainMenu);
        login.showGui();

    }


    private static void loadReader() throws IOException {

        bookAdapterReader = new BookAdapterReader();
        userAdapterReader = new UserAdapterReader();
        borrowedBookAdapterReader = new BorrowedBookAdapterReader();

        bookElementReader = ElementReader.newReader(
                "books.txt", bookAdapterReader
        );

        userElementReader = ElementReader.newReader(
                "users.txt", userAdapterReader
        );

        borrowedBookElementReader = ElementReader.newReader(
                "reserves.txt", borrowedBookAdapterReader
        );

    }

}
