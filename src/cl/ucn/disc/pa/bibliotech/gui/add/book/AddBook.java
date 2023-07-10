package cl.ucn.disc.pa.bibliotech.gui.add.book;

import cl.ucn.disc.pa.bibliotech.book.Book;
import cl.ucn.disc.pa.bibliotech.book.BookService;
import cl.ucn.disc.pa.bibliotech.book.DefaultBook;
import cl.ucn.disc.pa.bibliotech.gui.menu.MainMenu;
import cl.ucn.disc.pa.bibliotech.helper.GuiHelper;

import javax.swing.*;

public class AddBook extends JFrame {

    private JTextField nameField;
    private JTextField authorField;
    private JTextField isbnField;
    private JTextField categoryField;
    private JTextField pagesField;
    private JTextField stockField;
    private JButton buttonAdd;
    private JButton buttonPrevious;
    private JPanel addBookMenu;

    private final BookService bookService;
    private final MainMenu mainMenu;

    public AddBook(BookService bookService, MainMenu mainMenu) {
        this.bookService = bookService;
        this.mainMenu = mainMenu;

        loadButtons();
    }

    private void loadButtons() {
        buttonAdd.addActionListener(action -> {
                    onAddBook();
                }
        );

        buttonPrevious.addActionListener(action -> {
            onBack();
        });

    }

    public void open() {
        setContentPane(addBookMenu);

        setTitle("Add Book");
        setSize(300,300);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void onAddBook() {

        String isbn = isbnField.getText();
        String name = nameField.getText();
        String author = authorField.getText();
        String category = categoryField.getText();
        int pages = Integer.parseInt(pagesField.getText());
        int stock = Integer.parseInt(stockField.getText());

        Book book = new DefaultBook(
            isbn, author, name, category, pages, stock
        );

        bookService.add(book);

        GuiHelper.showActionPerformed("Libro agregado!");
    }

    private void onBack() {
        setVisible(false);
        mainMenu.open();
    }

}
