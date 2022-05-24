import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[]args){

        Scanner input = new Scanner(System.in);

        String databaseUsers = " ";
        String databasePassword = " ";
        String databaseRole = " ";

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem",
                    "root", "Nhl-2512197627092002");
            System.out.println("Enter username: ");
            String username = input.next();
            System.out.println("Enter password: ");
            String password = input.next();
            System.out.println("Enter role: ");
            String role = input.next();

            String select = "select * from users where username = ? and password = ? and role = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(select);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

            }

        }catch(SQLException sqlException){
            System.err.println(sqlException.getMessage());
        }


        //GeneralUsers generalUsers = new GeneralUsers();
           Operations operations = new Operations();
           System.out.println("Enter username: ");
           String username = input.next();
           System.out.println("Enter password: ");
           String password = input.next();
           System.out.println("Enter role: ");
           String role = input.next();

           if (password.equals("1234") && username.equals("Harriet") && role.equals("librarian")) {
               System.out.println("Main menu");
               System.out.println("1.Books operations" +
                       "\n2.Fines operations" +
                       "\n3.Borrower operations" +
                       "\n4.Staff operations");
               System.out.println("Enter number of operation you would like to do");
               String operation = input.next();

               if (operation.equals("1")) {
                   operations.booksOperations();
               } else if (operation.equals("2")) {
                   operations.finesOperation();
               } else if (operation.equals("3")) {
                   operations.borrowerOperations();
               } else if (operation.equals("4")) {
                   operations.staffOperations();
               } else {
                   System.out.println("Operation does not exist");
               }
           } else if (password.equals("12345") && username.equals("Nalufu") && role.equals("borrower")) {
               System.out.println("borrowers menu");
               operations.borrower();
           } else {
               System.out.println("incorrect username/password/role");
           }

         //Books books = new Books();




        //books.add();
        //books.displayRecords();
       // books.updateRecord();
       // books.deleteRecord();

    }
}
