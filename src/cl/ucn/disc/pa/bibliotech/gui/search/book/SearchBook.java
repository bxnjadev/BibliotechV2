package cl.ucn.disc.pa.bibliotech.gui.search.book;

import cl.ucn.disc.pa.bibliotech.book.Book;
import cl.ucn.disc.pa.bibliotech.book.BookService;
import cl.ucn.disc.pa.bibliotech.helper.GuiHelper;

import javax.swing.*;

public class SearchBook {

    private JButton searchButton;
    private JLabel isbn;

    private JLabel bookName;
    private JLabel bookAuthor;
    private JLabel bookCategory;
    private JLabel bookPages;

    private final BookService bookService;

    public SearchBook(BookService bookService) {
        this.bookService = bookService;
    }

    private void loadButtons() {
        searchButton.addActionListener(action -> {
                    onSearchBook();
                }
        );
    }

    private void onSearchBook() {
        String isbnValue = isbn.getText();

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
        bookPages.setText("Paginas "+  book.getPages());

    }

}
