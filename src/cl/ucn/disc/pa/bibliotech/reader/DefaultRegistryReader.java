package cl.ucn.disc.pa.bibliotech.reader;

import java.util.HashMap;
import java.util.Map;

public class DefaultRegistryReader implements RegistryReader {

    private final Map<Class<?>, AdapterReader<?>> adapters;

    public DefaultRegistryReader(){
        adapters = new HashMap<>();
    }

    @Override
    public <T> void addAdapter(Class<T> clazz, AdapterReader<T> adapter) {
        adapters.put(clazz, adapter);
    }

    @Override
    public <T> AdapterReader<T> getAdapter(Class<T> clazz) {
        return (AdapterReader<T>) adapters.get(clazz);
    }

}
