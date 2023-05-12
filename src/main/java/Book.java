import java.io.File;
import java.io.Serializable;

public class Book implements Serializable {

    //Atributos
    private int idBook;
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;

    private File photo;

    //Getters and Setters
    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    //Metodos
    public boolean equals(Book book){
        return isbn.equals(book.getIsbn());
    }
    //hashcode ?
    public String toString(){
        String str = new String();

        str += title!=null ? title + " - " : "* - ";
        str += author!=null ? author + ", " : "* - ";
        str+= year;
        return str;
    }


    //Constructores
    public Book(){

    }
    public Book(String title, String author, int year, boolean available){
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public Book(String isbn, String title, String author, int year, boolean available){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available =available;
    }
    public Book(String isbn, String title, String author, int year, boolean available, int idBook){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available =available;
        this.idBook = idBook;
    }

    public Book(int idBook, String isbn, String title, String author, int year, boolean available, File photo) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
        this.photo = photo;
    }
}
