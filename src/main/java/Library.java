import java.io.File;
import java.sql.*;

public class Library {

    public static void main(String[] args) {
        Connection con = ConnectionLibrary.getConnection();
        BookDAO BD = new BookDAO(con);
        /*Book b1984 = new Book("9788423359394", "1984", "George Orwell",
                1949, true);
        BD.create(b1984);

        Book bGatsby = new Book("9789500435260", "The Great Gatsby", "F. Scott Fitzgerald",
                1925, true);
        BD.create(bGatsby);

        Book bCatcher = new Book("9780316769488", "The Catcher in the Rye", "J.D Salinger",
                1951, false);
        BD.create(bCatcher);

        Book bCar = new Book("9780008196806", "How to build a car", "Adrian Newey", 2017, true);
        BD.create(bCar);

        Book bFarm = new Book("9780141036137", "Animal Farm", "George Orwell", 1945, false);
        BD.create(bFarm);
        Book b1984 = BD.get(6);
        Book bGatsby = BD.get(7);
        Book bCatcher = BD.get(8);
        Book bCar = BD.get(9);
        Book bFarm = BD.get(10);
        System.out.println(bFarm.toString());

        File p1984 = new File("src/main/resources/nineteeneightyfour.jpg");
        File pAnimalFarm = new File("src/main/resources/AnimalFarm.jpg");
        File pHowToBuildACar = new File("src/main/resources/HowToBuildACar.jpg");
        File pTheGreatGatsby = new File("src/main/resources/TheGreatGatsby.jpg");
        File pCatcherInTheRye = new File("src/main/resources/CatcherInTheRye.jpg");


        BD.insertFoto(b1984,p1984);
        BD.insertFoto(bGatsby,pTheGreatGatsby);
        BD.insertFoto(bCatcher,pCatcherInTheRye);
        BD.insertFoto(bCar,pHowToBuildACar);
        BD.insertFoto(bFarm,pAnimalFarm);*/

        /*Book bGaliza = new Book("9788482887296", "Sempre en Galiza", "Castelao", 1944, true, 1);
        BD.create(bGaliza);
        File pGaliza = new File("src/main/resources/galiza.jpg");
        BD.insertFoto(bGaliza,pGaliza);

        Book bWild = new Book(" 978151239582", "The Call of the Wild", "Jack London", 1903, true, 2);
        BD.create(bWild);
        File pWild = new File("src/main/resources/wild.jpg");
        BD.insertFoto(bWild,pWild);

        Book bTom = new Book("9781503215672", "Tom Sawyer", "Mark Twain", 1876, true, 3);
        BD.create(bTom);
        File pTom = new File("src/main/resources/sawyer.jpg");
        BD.insertFoto(bTom,pTom);*/
        BD.delete(8);
        BD.delete(14);
        BD.delete(16);






    }
}
