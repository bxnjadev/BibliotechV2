package cl.ucn.disc.pa.bibliotech.gui.search.book;

import cl.ucn.disc.pa.bibliotech.book.Book;
import cl.ucn.disc.pa.bibliotech.book.BookService;
import cl.ucn.disc.pa.bibliotech.gui.menu.MainMenu;
import cl.ucn.disc.pa.bibliotech.helper.GuiHelper;

import javax.swing.*;

public class SearchBook extends JFrame {

    private JButton searchButton;
    private JLabel isbn;

    private JLabel bookName;
    private JLabel bookAuthor;
    private JLabel bookCategory;
    private JLabel bookPages;
    private JPanel searchBookPanel;
    private JButton retryButton;
    private JTextField textFieldSearch;

    private MainMenu mainMenu;

    private final BookService bookService;

    public SearchBook(BookService bookService) {
        this.bookService = bookService;
        loadButtons();
    }

    private void loadButtons() {
        searchButton.addActionListener(action -> {
                    onSearchBook();
                }
        );

        retryButton.addActionListener(action -> {
            setVisible(false);
            mainMenu.open();
        });
    }

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void open() {
        setContentPane(searchBookPanel);

        setTitle("Search Book Menu");
        setSize(300, 300);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void onSearchBook() {
        String isbnValue = textFieldSearch.getText();

        if (isbnValue.isEmpty()) {
            GuiHelper.showMessageError("El ISBN es vacio");
            return;
        }

        Book book = bookService.searchByIsbn(isbnValue);

        if (book == null) {
            GuiHelper.showMessageError("Libro no encontrado");
            return;
        }

        updateData(book);
    }

    private void updateData(Book book) {

        bookName.setText("Nombre: " + book.getName());
        bookAuthor.setText("Autor: " + book.getAuthor());
        bookCategory.setText("Categoría: " + book.getCategory());
        bookPages.setText("Paginas " + book.getPages());

    }

}
