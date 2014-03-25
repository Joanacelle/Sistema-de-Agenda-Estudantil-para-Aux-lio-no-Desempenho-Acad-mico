
package infra;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Joanacelle
 */
public class Iteration<T> implements Iterator<T> {

    private LinkedList<T> list;
    private static int indexcorrente = 0;

    public Iteration(LinkedList<T> list) {
        this.list = list;
        indexcorrente = 0;
    }

    public boolean hasNext() {
        if (indexcorrente < list.size()) {
            return true;
        }
        return false;
    }

    public T next() {
        T n = list.get(indexcorrente);
        ++indexcorrente;
        return n;
    }

    public void remove() {
        list.remove(indexcorrente);

    }
}
