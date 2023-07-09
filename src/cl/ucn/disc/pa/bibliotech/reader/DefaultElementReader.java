package cl.ucn.disc.pa.bibliotech.reader;

import ucn.In;

import java.io.IOException;

/**
 * This class implement a way for read using cvs files
 */

public class DefaultElementReader<T> implements ElementReader<T> {

    private boolean hasNext = true;
    private static final String SEPARATOR_CHARACTER = ",";
    private static final String EMPTY_STRING = "";
    private final In in;

    private final AdapterReader<T> reader;

    /**
     * The main constructor
     * @param fileName the file name
     * @throws IOException throw exception if this error with the cvs file
     */

    public DefaultElementReader(String fileName, AdapterReader<T> adapterReader) throws IOException {
        in = new In(fileName);
        reader = adapterReader;
    }

    @Override
    public T read() {

        //Get a new line
        String line = in.readLine();

        //if the line is null no read more
        if (line == null) {
            hasNext = false;
            return null;
        }

        //If the line is empty return a pokemom null
        if (line.equals(EMPTY_STRING)) {
            return null;
        }

        //serialize a pokemon and return it
        return reader.read(line);
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public void close() throws Exception {
        in.close();
    }

}
