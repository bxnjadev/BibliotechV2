package cl.ucn.disc.pa.bibliotech.reader;

public interface AdapterReader<T> {

    String write(T object);

    T read(String value);

}
