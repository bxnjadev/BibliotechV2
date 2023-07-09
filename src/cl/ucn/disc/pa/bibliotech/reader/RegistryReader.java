package cl.ucn.disc.pa.bibliotech.reader;

public interface RegistryReader {

    <T> void addAdapter(Class<T> clazz, AdapterReader<T> adapter);

    <T> AdapterReader<T> getAdapter(Class<T> clazz);

}
