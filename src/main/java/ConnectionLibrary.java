import java.sql.*;

public class ConnectionLibrary {

    public static final String URL = "jdbc:h2:L:\\Programacion\\2023\\LibraryDB\\src\\main\\resources\\DB\\library"
            + ";DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";

    public static final String DRIVER = "org.h2.Driver";

    private static Connection conexion;


    public static Connection getConnection(){
        try {
            if(conexion==null || conexion.isClosed()){
                Class.forName(DRIVER);
                conexion = DriverManager.getConnection(URL);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Drivers non atopados.");
        } catch (SQLException ex) {
            System.out.println("Erro ó establecer a conexión: "
                    + ex.getMessage());
        }
        return conexion;
    }


}
