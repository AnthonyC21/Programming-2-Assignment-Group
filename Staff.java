import java.util.*;
import java.sql.*;

public class Staff extends GeneralUsers implements MainOperations{

    Scanner input = new Scanner(System.in);

    public void add() {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem",
                    "root", "12345");

            System.out.println("Enter staff ID: ");
            ID = input.nextInt();
            System.out.println("Enter first name: ");
            input.next();
            firstName = input.nextLine();
            System.out.println("Enter last name: ");
            input.next();
            lastName = input.nextLine();
            System.out.println("Enter role: ");
            role = input.next();
            System.out.println("Enter age: ");
            age = input.nextInt();

            String insert = "insert into staff values (?,?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,lastName);
            preparedStatement.setString(4,role);
            preparedStatement.setInt(5,age);
            preparedStatement.execute();

            System.out.println("Insertion was successful!!");
        }
        catch(SQLException sqlE){
            System.err.println("something went wrong when inserting the data");
            System.err.println(sqlE.getMessage());
            System.err.println("Error code = " + sqlE.getErrorCode());
            System.err.println("SQL state = " + sqlE.getSQLState());
        }
        catch(InputMismatchException in){
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
                    "root", "12345");

            System.out.println("This is the data in the staff table");
            String select = "select * from staff;";
            PreparedStatement preparedStatement = connection.prepareStatement(select);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println("staff ID: " + resultSet.getString(1) + " " +
                        "first name: " + resultSet.getString(2) + " " +
                        "last name: " + resultSet.getString(3) + " " +
                        "role: " + resultSet.getString(4) + " " +
                        "age: " + resultSet.getString(5));
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
                    "root", "12345");

            System.out.println("Enter the ID of the staff member you would like to search for: ");
            ID = input.nextInt();

            String select = "select * from staff where ID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.execute();
            preparedStatement.setInt(1,ID);
            ResultSet resultSet  = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println("staff ID: " + resultSet.getString(1) + " " +
                        "first name: " + resultSet.getString(2) + " " +
                        "last name: " + resultSet.getString(3) + " " +
                        "role: " + resultSet.getString(4) + " " +
                        "age: " + resultSet.getString(5));
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
                    "root", "12345");

            System.out.println("Enter staff ID: ");
            int newID = input.nextInt();
            System.out.println("Enter first name: ");
            firstName = input.next();
            System.out.println("Enter last name: ");
            lastName = input.next();
            System.out.println("Enter role: ");
            role = input.next();
            System.out.println("Enter age: ");
            age = input.nextInt();

            System.out.println("Enter ID of staff record you would like to update: ");
            ID = input.nextInt();

            String update = "update staff set ID = ?, firstName = ?, lastName = ?, role = ?," +
                    " age = ? where ID = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setInt(1,newID);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,lastName);
            preparedStatement.setString(4,role);
            preparedStatement.setInt(5,age);
            preparedStatement.setInt(6,ID);

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
                    "root", "12345");
            System.out.println("Enter ID of staff record you would like to delete?");
            ID = input.nextInt();
            String delete = "delete from staff where ID = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1,ID);
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
