package book;

import book.edit.EditController;
import book.listB.ListControllerB;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Objects;

public class Book {
    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String code;
    public String name;
    public String author;
    public String nxb;
    public String type;
    public Integer price;
    public Integer qty;
    private Button edit;
    private Button remove;




    public Book() {
    }

    public Book(String code, String name, String author, String nxb, String type, Integer price, Integer qty) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.nxb = nxb;
        this.type = type;
        this.price = price;
        this.qty = qty;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            try {
                EditController.editedBook = this;
                Parent editBook = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("../book/edit/EditBook.fxml"))));
                Scene se = new Scene(editBook, 800, 600);
                Main.rootStages.setScene(se);

            }catch (Exception e){

            }
        });
        this.remove =new Button("Remove");
        this.remove.setOnAction(event -> {
            ListControllerB.ls2.remove(this);


        });

    }




    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getRemove() {
        return remove;
    }

    public void setRemove(Button remove) {
        this.remove = remove;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "code='" +this.getCode() + '\'' +
                ", name='" +this.getName() + '\'' +
                ", author='" +this.getAuthor() + '\'' +
                ", nxb='" +this.nxb + '\'' +
                ", type='" +this.type + '\'' +
                ", price=" +this.getPrice() +
                ", qty=" +this.getQty() +
                '}';
    }
}
