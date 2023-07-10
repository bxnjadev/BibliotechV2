package cl.ucn.disc.pa.bibliotech.reader;

import ucn.In;
import ucn.Out;

import java.util.Collection;

public class DefaultElementSaver<T> implements ElementSaver<T> {

    private final AdapterReader<T> adapterReader;
    private final Out out;

    public DefaultElementSaver(String fileName, AdapterReader<T> adapterReader) {
        this.adapterReader = adapterReader;

        out = new Out(fileName);
    }

    @Override
    public void save(Collection<T> collection) {

        for (T t : collection) {
            out.println(
                    adapterReader.write(t)
            );
        }

    }

}
