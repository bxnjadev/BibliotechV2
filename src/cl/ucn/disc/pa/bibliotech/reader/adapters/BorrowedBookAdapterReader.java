package cl.ucn.disc.pa.bibliotech.reader.adapters;

import cl.ucn.disc.pa.bibliotech.book.BorrowedBook;
import cl.ucn.disc.pa.bibliotech.reader.AdapterReader;

public class BorrowedBookAdapterReader implements AdapterReader<BorrowedBook> {

    private static final String CHARACTER_SEPARATOR = ",";

    @Override
    public String write(BorrowedBook object) {
        return object.toString();
    }

    @Override
    public BorrowedBook read(String value) {



        return null;
    }

}
