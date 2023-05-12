import java.io.*;
import java.util.ArrayList;
import java.sql.*;

public class BookDAO {

    private Connection con;

    public BookDAO(Connection con){
        this.con = con;
    }
    public void create(Book book){
        try{
            if(con != null && !con.isClosed()) {
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO" +
                        " BOOK (ISBN, TITLE, AUTHOR, ANO, AVAILABLE)" +
                        " VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {


                    ps.setString(1,book.getIsbn());
                    ps.setString(2,book.getTitle());
                    ps.setString(3,book.getAuthor());
                    ps.setInt(4,book.getYear());
                    ps.setBoolean(5,book.isAvailable());
                    ps.executeUpdate();

                    //Esta parte asigna o ID
                    ResultSet rs = ps.getGeneratedKeys();
                    if(rs.next()){
                        int idBook = rs.getInt(1);
                        book.setIdBook(idBook);
                    }
                }
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Book get(int idBook){
       try{
           if(con != null && !con.isClosed()) {
               try (Statement st = con.createStatement();) {
                   ResultSet rs = st.executeQuery("SELECT * FROM BOOK WHERE IDBOOK = " + idBook);
                   if (rs.next()) {
                       return new Book(rs.getString("ISBN"), rs.getString("TITLE"),
                               rs.getString("AUTHOR"), rs.getInt("ANO"),
                               rs.getBoolean("AVAILABLE"), rs.getInt("IDBOOK"));
                   }
               }
           }
       }catch (SQLException ex){
           System.out.println(ex.getMessage());
       }
       return null;
    }

    public void update (Book book){
        try{
            if(con != null && !con.isClosed()) {
                try (PreparedStatement ps = con.prepareStatement("UPDATE" +
                        " BOOK SET ISBN=?, TITLE=?, AUTHOR=?, ANO=?, AVAILABLE=? WHERE" +
                        " IDBOOK=?");) {

                    ps.setString(1,book.getIsbn());
                    ps.setString(2,book.getTitle());
                    ps.setString(3,book.getAuthor());
                    ps.setInt(4,book.getYear());
                    ps.setBoolean(5,book.isAvailable());
                    ps.setInt(6,book.getIdBook());
                    ps.executeUpdate();

                    //Esta parte asigna o ID
                    ResultSet rs = ps.getGeneratedKeys();
                    if(rs.next()){
                        int idBook = rs.getInt(1);
                        book.setIdBook(idBook);
                    }
                }
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void delete (int idBook){
        try{
            if(con != null && !con.isClosed()){
                try(PreparedStatement ps = con.prepareStatement("DELETE FROM BOOK WHERE IDBOOK=?")){
                    ps.setInt(1,idBook);
                    ps.executeUpdate();
                }
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList getAll(){
        ArrayList<Book> libros = new ArrayList<Book>();
        try{
            if(con != null && !con.isClosed()){
                try(Statement st = con.createStatement()){
                    ResultSet rs = st.executeQuery("SELECT * FROM BOOK");
                    while (rs.next()){
                        libros.add(new Book(rs.getString("ISBN"), rs.getString("TITLE"),
                                rs.getString("AUTHOR"), rs.getInt("ANO"),
                                rs.getBoolean("AVAILABLE")));
                    }
                }
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return libros;
    }

    public void insertFoto(Book libro, File foto){
        try{
            if(con != null && !con.isClosed()) {
                try (PreparedStatement ps = con.prepareStatement("UPDATE BOOK SET PHOTO=? WHERE IDBOOK =?");
                     BufferedInputStream bis = new BufferedInputStream(new FileInputStream(foto));) {
                    ps.setBinaryStream(1,bis);
                    ps.setLong(2,libro.getIdBook());
                    ps.executeUpdate();
                } catch (IOException iex) {
                    System.out.println(iex.getMessage());
                }
            }
        }catch (SQLException se){
            System.out.println(se.getMessage());
        }
    }

    public void saveFoto(long idBook, File destino){
        try{
            if (con != null && !con.isClosed()){
                try(Statement st = con.createStatement(); BufferedOutputStream bo =
                        new BufferedOutputStream(new FileOutputStream(destino))){
                    ResultSet rs = st.executeQuery("SELECT PHOTO FROM BOOK WHERE IDBOOK="+idBook);
                    if(rs.next()){
                        BufferedInputStream binary = new BufferedInputStream(rs.getBinaryStream(1));
                        byte[] buffer = new byte[1024];
                        while ((binary.read(buffer)>0)){
                            bo.write(buffer);
                        }
                    }
                }catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
