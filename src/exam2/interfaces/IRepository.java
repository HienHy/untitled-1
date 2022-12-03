package exam2.interfaces;

import java.util.ArrayList;

public interface IRepository<E> {
    ArrayList<E> all();
    boolean create(E s);


}
