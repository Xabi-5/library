import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Book implements Serializable {

    //Atributos
    private int idBook;
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;
    private File photo;
    private byte[] portada;

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

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public void setPortada(File f) {
        try (BufferedInputStream bi = new BufferedInputStream(new FileInputStream(f));
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int readBytes;
            while ((readBytes = bi.read(buffer)) > 0) {
                outputStream.write(buffer, 0, readBytes);
            }
            portada = outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPortada(String file) {
        try {
            Path path = Paths.get(file);
            portada = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Image getImage() {
        if (portada != null) {
            try (ByteArrayInputStream bis = new ByteArrayInputStream(portada)) {
                return ImageIO.read(bis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    //Metodos
    public boolean equals(Book book) {
        return isbn.equals(book.getIsbn());
    }


    //hashcode ?
    public int hashCode(){
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.isbn);
        return hash;
    }
    public String toString() {
        String str = new String();

        str += title != null ? title + " - " : "* - ";
        str += author != null ? author + ", " : "* - ";
        str += year;
        return str;
    }

    //Constructores
    public Book() {

    }

    public Book(String title, String author, int year, boolean available) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public Book(String isbn, String title, String author, int year, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public Book(String isbn, String title, String author, int year, boolean available, int idBook) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
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
