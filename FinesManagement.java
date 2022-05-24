import java.util.*;
import java.sql.*;

public class FinesManagement implements MainOperations {

    private int fineID;
    private String firstName;
    private String lastName;
    private int ID;
    private int age;
    private String offence;
    private double fineAmount;

    Scanner input = new Scanner(System.in);

    public void add() {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem",
                    "root", "Nhl-2512197627092002");

            System.out.println("Enter fine ID: ");
            fineID = input.nextInt();
            System.out.println("Enter first name of offender: ");
            input.next();
            firstName = input.nextLine();
            System.out.println("Enter last name of offender: ");
            input.next();
            lastName = input.nextLine();
            System.out.println("Enter borrower ID: ");
            ID = input.nextInt();
            System.out.println("Enter age of offender: ");
            age = input.nextInt();
            System.out.println("Enter offence: ");
            input.nextLine();
            offence = input.next();
            System.out.println("Enter fine amount:");
            fineAmount = input.nextDouble();

            String insert = "insert into finesmanagement values (?,?,?,?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setInt(1, fineID);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,lastName);
            preparedStatement.setInt(4,ID);
            preparedStatement.setInt(5,age);
            preparedStatement.setString(6, offence);
            preparedStatement.setDouble(7,fineAmount);
            preparedStatement.execute();

            System.out.println("Insertion was successful!!");
        }catch(SQLException sqlE){
            System.err.println("Something went wrong when connecting to the database, or when querying from it");
            System.err.println(sqlE.getMessage());
            System.err.println("Error code = " + sqlE.getErrorCode());
            System.err.println("SQL state = " + sqlE.getSQLState());
        }catch(InputMismatchException in){
            System.out.println("You might have entered a string, where an int was expected. So please try again");
        }catch(ArithmeticException arithmeticException){
            System.err.println("The math you are trying to do cannot go through");
        }catch(NoSuchElementException noSuchElementException){
            System.err.println("You didn't enter any valid data");
        }
    }

    public void displayRecords() {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem",
                    "root", "Nhl-2512197627092002");

            System.out.println("This is the data in the fines management table");
            String select = "select * from finesmanagement;";
            PreparedStatement preparedStatement = connection.prepareStatement(select);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println("fine ID: " + resultSet.getString(1) + " " +
                        "first name: " + resultSet.getString(2) + " " +
                        "last name: " + resultSet.getString(3) + " " +
                        "borrower ID: " + resultSet.getString(4) + " " +
                        "age: " + resultSet.getString(5) + " " +
                        "offence: " + resultSet.getString(6) + " " +
                        "fineAmount: " + resultSet.getString(7));
            }
        }catch(SQLException sqlException){
            System.err.println("Something went wrong when connecting to the database, or when querying from it");
            System.err.println(sqlException.getMessage());
            System.err.println("Error code = " + sqlException.getErrorCode());
            System.err.println("SQL state = " + sqlException.getSQLState());
        }catch(InputMismatchException exception){
            System.err.println("You might have entered a string, where an int was expected. So please try again");
        }catch(NoSuchElementException noSuchElementException){
            System.err.println("You didn't enter any valid data");
        }catch(ArithmeticException arithmeticException){
            System.err.println("The math you are trying to do cannot go through");
        }
    }

    public void searchRecords() {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem",
                    "root", "Nhl-2512197627092002");

            System.out.println("Enter the ID of the fine you would like to search for");
            fineID = input.nextInt();

            String select = "select * from finemanagement where fineID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.execute();
            preparedStatement.setInt(1,fineID);
            ResultSet resultSet  = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println("fine ID: " + resultSet.getString(1) + " " +
                        "first name: " + resultSet.getString(2) + " " +
                        "last name: " + resultSet.getString(3) + " " +
                        "borrower ID: " + resultSet.getString(4) + " " +
                        "age: " + resultSet.getString(5) + " " +
                        "offence: " + resultSet.getString(6) + " " +
                        "fineAmount: " + resultSet.getString(7));
            }

        }catch(SQLException sqlException){
            System.err.println("Something went wrong when connecting to the database, or when querying from it");
            System.err.println(sqlException.getMessage());
            System.err.println("Error code = " + sqlException.getErrorCode());
            System.err.println("SQL state = " + sqlException.getSQLState());
        }catch(InputMismatchException exception){
            System.err.println("You might have entered a string, where an int was expected. So please try again");
        }catch(NoSuchElementException noSuchElementException){
            System.err.println("You didn't enter any valid data");
        }catch(ArithmeticException arithmeticException){
            System.err.println("The math you are trying to do cannot go through");
        }
    }

    public void updateRecord() {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem",
                    "root", "Nhl-2512197627092002");

            System.out.println("Enter fine ID: ");
            int newFineID = input.nextInt();
            System.out.println("Enter first name: ");
            input.next();
            firstName = input.nextLine();
            System.out.println("Enter last name: ");
            input.next();
            lastName = input.nextLine();
            System.out.println("Enter borrower ID: ");
            ID = input.nextInt();
            System.out.println("Enter age: ");
            input.next();
            age = input.nextInt();
            System.out.println("Enter offence: ");
            input.next();
            offence = input.nextLine();
            System.out.println("Enter fine amount N$: ");
            fineAmount = input.nextDouble();
            System.out.println("Enter fine ID of fine record you would like to update: ");
            ID = input.nextInt();

            String update = "update finesmanagement set fineID = ?, firstName = ?, lastName = ?, ID = ?," +
                    " age = ?, offence = ?, fineAmount = ? where fineID = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setInt(1,newFineID);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,lastName);
            preparedStatement.setInt(4,ID);
            preparedStatement.setInt(5,age);
            preparedStatement.setString(6,offence);
            preparedStatement.setDouble(7,fineAmount);
            preparedStatement.setInt(8,ID);

            preparedStatement.executeUpdate();
            System.out.println("Update is successful");

        }catch(SQLException sqlException){
            System.err.println("Something went wrong when connecting to the database, or when querying from it");
            System.err.println(sqlException.getMessage());
            System.err.println("Error code = " + sqlException.getErrorCode());
            System.err.println("SQL state = " + sqlException.getSQLState());
        }catch(InputMismatchException exception){
            System.err.println("You might have entered a string, where an int was expected. So please try again");
        }catch(NoSuchElementException noSuchElementException){
            System.err.println("You didn't enter any valid data");
        }catch(ArithmeticException arithmeticException){
            System.err.println("The math you are trying to do cannot go through");
        }
    }

    public void deleteRecord() {
        try{

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem",
                    "root", "Nhl-2512197627092002");
            System.out.println("Enter the ID of the fine record you would like to delete");
            fineID = input.nextInt();
            String delete = "delete from finemanagement where fineID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1,fineID);
            preparedStatement.execute();
            System.out.println("Delete is successful!!");

        }catch(SQLException sqlException){
            System.err.println("Something went wrong when connecting to the database, or when querying from it");
            System.err.println(sqlException.getMessage());
            System.err.println("Error code = " + sqlException.getErrorCode());
            System.err.println("SQL state = " + sqlException.getSQLState());
        }catch(InputMismatchException exception){
            System.err.println("You might have entered a string, where an int was expected. So please try again");
        }catch(NoSuchElementException noSuchElementException){
            System.err.println("You didn't enter any valid data");
        }catch(ArithmeticException arithmeticException){
            System.err.println("The math you are trying to do cannot go through");
        }
    }
}
