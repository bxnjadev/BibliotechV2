package cl.ucn.disc.pa.bibliotech.reader;

import java.util.Collection;

public interface ElementSaver<T> {

    void save(Collection<T> collection);

}
