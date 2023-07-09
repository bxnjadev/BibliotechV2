package cl.ucn.disc.pa.bibliotech.gui.add.book;

import cl.ucn.disc.pa.bibliotech.book.Book;
import cl.ucn.disc.pa.bibliotech.book.BookService;
import cl.ucn.disc.pa.bibliotech.book.DefaultBook;
import cl.ucn.disc.pa.bibliotech.helper.GuiHelper;
import ucn.In;

import javax.swing.*;

public class AddBook {

    private JTextField nameField;
    private JTextField authorField;
    private JTextField isbnField;
    private JTextField categoryField;
    private JTextField pagesField;
    private JTextField stockField;
    private JButton buttonAdd;
    private JButton buttonPrevious;

    private final BookService bookService;

    public AddBook(BookService bookService) {
        this.bookService = bookService;

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

    }

}
