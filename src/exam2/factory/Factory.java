package exam2.factory;


import exam2.enums.RepoType;
import exam2.impls.BookRepository;
import exam2.interfaces.IRepository;



public class Factory {
    public static IRepository createRepository(RepoType type) {
        switch (type) {
            case Book:
                return (IRepository) new BookRepository();
            default:
                throw new IllegalArgumentException("Class not fount");

        }
    }
}
