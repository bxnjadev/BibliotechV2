package cl.ucn.disc.pa.bibliotech.reader;

/**
 * A adapter for serialization
 * @param <T> the type
 */

public interface AdapterReader<T> {

    /**
     * write any element
     * @param object the object element
     * @return the serialization String
     */

    String write(T object);

    /**
     * Read and convert to object
     * @param value the value
     * @return the value
     */

    T read(String value);

}
