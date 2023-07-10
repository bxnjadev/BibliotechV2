package cl.ucn.disc.pa.bibliotech.reader;

import java.io.IOException;

public interface ElementReader<T> extends AutoCloseable {

    /**
     * Create a new instance the elemtn reader
     * @return the new instance
     */

    T read();



    /**
     * Check if has next line
     * @return true if has a next line
     */

    boolean hasNext();

    static <T> ElementReader<T> newReader(String fileName, AdapterReader<T> adapterReader) throws IOException {
        return new DefaultElementReader<>(fileName, adapterReader);
    }

}
