import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    public Connection getConnection(){
        try
        {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/emp_manager", "root", "ORA123");
            //System.out.println("Conexiune cu succes!");
            return connection;

        } catch(SQLException ex){
            System.out.println("Eroare de conexiune: "+ex.getMessage());
            return null;
        }
    }

    //- Insert(creez) noi angajati
    public void create(Employee emp)
    {
        //met1 (mai putin high-tech)!
        //String sql = "INSERT into employee2(name, surname, email) values('"+ emp.getName() + "', '"
        //+emp.getSurname() + "', '"+emp.getEmail() + "')";

        //met 2 (high tech)
        String sql = "INSERT into employee2(name, surname, email, birthdate) values(?,?,?,?)";
        try //with resources
                (
                        Connection connection = getConnection(); //cream o conexiune
                        PreparedStatement statement = connection.prepareStatement(sql); //pregatim statementul.
                        // partea dreapta a expresiei returneaza un obiect de tip PreparedStatement
                        //noi inscriem aceasta informatie din partea dr a expresiei in variabila statement
                )
        {
            if (connection != null) //adica daca conexiunea e stabilita cu succes
            {
                statement.setString(1, emp.getName()); //nu scriem 0 pt ca aici numaratoarea incepe de la 1;
                //adica numararea pozitiei in acest caz nu e ca la indecsi.
                //pe poz 1 adica in locul la primul '?', inscriem emp.getName()
                statement.setString(2, emp.getSurname());
                statement.setString(3, emp.getEmail());
                statement.setString(4, emp.getBirthdate());
                int rows = statement.executeUpdate(); //returneaza nr de rinduri afectate de cererea noastra;

                //Eliberam memoria folosita!
                statement.close();//inchidem pt a curati inf
                //de dorit de inchis si obiectul de tip Connection si resultset daca ele exista.
                connection.close();
            }
        } catch(SQLException ex){
            System.out.println("Nu am putut face insertul!"+ex.getMessage());
        }


    }
    //- Update(modific/editez)
    public void update(Employee emp)
    {
        String sql = "UPDATE employee2 set name=?, surname=?, email=?, birthdate=? where id = ?";
        try //with resources
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql);
                )
        {
            if (connection != null)
            {
                statement.setString(1, emp.getName());
                statement.setString(2, emp.getSurname());
                statement.setString(3, emp.getEmail());
                statement.setString(4, emp.getBirthdate());
                statement.setInt(5, emp.getId());
                int rows = statement.executeUpdate();

                System.out.println("Update-ul s-a facut!");
            }
            connection.close();
        } catch(SQLException ex){
            System.out.println("Nu am putut face update-ul"+ex.getMessage());
        }
    }

    //- Delete(sterg)
    public void delete(int id)
    {
        String sql = "delete from employee2 where id = "+id;
        try  //with resources
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql);
                )
        {
            if (connection != null)
            {
                int rows = statement.executeUpdate();
                System.out.println("Angajatul cu id-ul "+ id +" a fost sters cu succes!");

            }
        } catch(SQLException ex){
            System.out.println("Nu am putut face delete-ul");
        }
    }

    // - Select(afisez)
    public List<Employee> selectAll()
    {
        List<Employee> employees = new ArrayList<>();
        //1.SQL - select
        String sql = "SELECT id, name, surname, email, birthdate from employee2 order by id asc"; //se poate si select * from employee
        try //with resources
                (   //2.getConnection
                    Connection connection = getConnection();
                    //3.statement
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    //ResultSet result = e un obiect ce salveaza in el informatia in forma de tablitsa bidimensionala
                    //adica un fel de matrice

                    //Nota: Declarind acest doc in interiorul la try-with-resources,
                    //java automat o sa inchida la final toate conexiunile.
                    //deci nu v-a fi nevoie de blocul finally si try catchul din el cu .close().
                )
        {
            //dupa cum observi prepare statement nu e necesar!
            //4. Acum, afisam datele noastre cu ajutorul functiei  resultSet.next(); Aceasta functie
            //muta cursorul pe urm rind din tabelul sau, cind ajunge pe ultimu rind, returneaza false
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                String birthdate1= resultSet.getString("birthdate");
                employees.add(new Employee(id, name, surname, email, birthdate1));
            }

        } catch(SQLException ex) {
            System.out.println("Nu am putut face selectul!");
        }


        // System.out.println("ID   NUME & PRENUME       EMAIL        BIRTHDATE");
        System.out.printf("%1s", "ID");
        System.out.printf("%15s", "NUME");
        System.out.printf("%20s", "PRENUME");
        System.out.printf("%25s", "EMAIL");
        System.out.printf("%30s", "BIRTHDATE");
        System.out.println("");

        for (int i=0; i<employees.size(); i++)
        {
            System.out.print(employees.get(i).getId());
            System.out.printf("%15s", employees.get(i).getName());
            System.out.printf("%20s", employees.get(i).getSurname());
            System.out.printf("%25s", employees.get(i).getEmail());
            System.out.printf("%30s", employees.get(i).getBirthdate());
            System.out.println("");
        }
        return employees;
    }
}