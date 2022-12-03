package exam2;

public class Book {
    public String code;
    public String name;
    public String author;
    public Integer price;

    public Book() {
    }

    public Book(String code, String name, String author, Integer price) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.price = price;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
