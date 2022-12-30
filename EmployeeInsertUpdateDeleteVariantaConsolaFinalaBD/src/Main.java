import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.util.*;
//import java.util.Objects;

public class Main {
    public static void main(String[] args) {


        boolean flag1 = true;
        while(flag1)
        {
            System.out.println("***MENU***");
            System.out.println("1.Inregistreaza angajat!");
            System.out.println("2.Vizualizeaza angajati!");
            System.out.println("3.Editeaza angajat!");
            System.out.println("4.Stergere angajat!");
            System.out.println("0. Exit!");

            Scanner sc = new Scanner(System.in); //nu pot folosi resursele, de ce?)
            ///ctrl+aLt+L

            String a = sc.nextLine();
            switch(a)
            {
                case ("0"):
                    flag1=false;
                    break;
                case ("1"):
                    System.out.println("Ai introdus 1. Inregistram un nou angajat!");
                    System.out.println("Introdu numele: ");
                    String nume = sc.nextLine();

                    System.out.println("Introdu prenumele: ");
                    String prenume = sc.nextLine();

                    System.out.println("Introdu email: ");
                    String email = sc.nextLine();

                    System.out.println("Introdu zi de nastere(aaaa-ll-zi): ");
                    String birthdate = sc.nextLine();

                    System.out.println("Angajatul \""+nume+" "+prenume+", "+email+", "+ birthdate + "\" a fost inregistrat!");
                    Employee emp = new Employee(nume, prenume, email, birthdate);
                    DbManager manager = new DbManager();
                    manager.create(emp);
                    break;

                case ("2"):
                    System.out.println("Ai introdus 2. Vizualizam angajatii inregistrati!");
                    DbManager manager1 = new DbManager();
                    manager1.selectAll();
                    break;

                case ("3"):
                    System.out.println("Ai introdus 3. Editare angajat!");

                    DbManager manager4 = new DbManager();
                    manager4.selectAll();

                    System.out.println("Introdu id-ul angajatului: ");
                    int new_id = sc.nextInt();
                    String rest = sc.nextLine();

                    System.out.println("Introdu noul nume al angajatului: ");
                    String nume1 = sc.nextLine();

                    System.out.println("Introdu noul prenumele al angajatului: ");
                    String prenume1 = sc.nextLine();

                    System.out.println("Introdu noul email al angajatului: ");
                    String email1 = sc.nextLine();

                    System.out.println("Introdu noua zi de nastere al angajatului(aaaa-ll-zi): ");
                    String ziNast1 = sc.nextLine();


                    Employee emp2 = new Employee( nume1, prenume1, email1, ziNast1, new_id);
                    DbManager manager2 = new DbManager();
                    manager2.update(emp2);

                    break;

                case ("4"):
                    System.out.println("Ai introdus 4. Stergere angajat!");

                    DbManager manager5 = new DbManager();
                    manager5.selectAll();


                    //fac afisare cu idurile +numele,prenumele
                    System.out.println("Introdu id-ul: ");
                    int new_id1 = sc.nextInt();

                    DbManager manager3 = new DbManager();
                    manager3.delete(new_id1);
            }
        }//finisul la while
    }
}

