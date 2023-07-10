package cl.ucn.disc.pa.bibliotech.helper;

import cl.ucn.disc.pa.bibliotech.reader.ElementReader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReaderHelper {

    public static <T> List<T> readElements(ElementReader<T> elementReader) {

        List<T> list = new ArrayList<>();

        while (elementReader.hasNext()) {
            list.add(elementReader.read());
        }

        return list;
    }

}
