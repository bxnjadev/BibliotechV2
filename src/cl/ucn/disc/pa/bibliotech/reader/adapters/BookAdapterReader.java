package cl.ucn.disc.pa.bibliotech.reader.adapters;

import cl.ucn.disc.pa.bibliotech.book.Book;
import cl.ucn.disc.pa.bibliotech.reader.AdapterReader;
import ucn.In;

public class BookAdapterReader implements AdapterReader<Book> {

    private static final String CHARACTER_SEPARATOR = ",";

    @Override
    public String write(Book object) {
        return object.toString();
    }

    @Override
    public Book read(String value) {

        String[] fields = value.split(CHARACTER_SEPARATOR);

        String isbn = fields[0];
        String name = fields[1];
        String author = fields[2];
        int pages = Integer.parseInt(fields[3]);
        int stock = Integer.parseInt(fields[4]);


        return null;
    }

}
