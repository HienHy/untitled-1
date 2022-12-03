package exam2.impls;


import exam2.Book;
import exam2.helper.Connector;
import exam2.interfaces.IRepository;
import javafx.scene.control.Alert;


import java.sql.ResultSet;
import java.util.ArrayList;



public class BookRepository implements IRepository<Book> {
    @Override
    public ArrayList<Book> all() {
        ArrayList<Book> ls=new ArrayList<>();
        try {
            Connector connector = Connector.getInstance();
            String sql = "select * from book";
            ResultSet rs = connector.query(sql);
            while (rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int price = rs.getInt("price");



                Book s = new Book(code,name,author,price);
                ls.add(s);
            }

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
        return ls;


    }

    @Override
    public boolean create(Book s) {
        try {
            Connector connector = Connector.getInstance();
            String sql_txt = "insert into book(code,name,author,price) values(?,?,?,?)";
            ArrayList parameters = new ArrayList();
            parameters.add(s.getCode());
            parameters.add(s.getName());
            parameters.add(s.getAuthor());
            parameters.add(s.getPrice());






            return connector.execute(sql_txt, parameters);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return false;
    }




}
