package cl.ucn.disc.pa.bibliotech.reader;

import java.util.Collection;

public interface ElementSaver<T> {

    /**
     * Save a collection in the system
     * @param collection the collection
     */

    void save(Collection<T> collection);

}
