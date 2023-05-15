import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.util.Scanner;

public class VentanaLibrary{
    public static void main(String[] args) {
        Connection con =  ConnectionLibrary.getConnection();
        BookDAO DB = new BookDAO(con);
        Scanner sc = new Scanner(System.in);

        int exit = 1;

        while (exit == 1){
            System.out.println("Press 1 to continue");
            exit = sc.nextInt();
            if(exit == 1){
                System.out.println("Selecciona o ID do libro do que queiras ver a portada: ");
                int seleccion = sc.nextInt();
                Book libro = DB.get(seleccion);
                JFrame jf = new JFrame();
                JPanel jp = new JPanel();
                JLabel jl = new JLabel(new ImageIcon(libro.getImage()));
                jp.add(jl);
                jf.add(jp);
                jf.setVisible(true);
                jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        }


    }
}
