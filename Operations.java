import java.util.Scanner;

public class Operations {

    Books books = new Books();
    Staff staff = new Staff();
    Borrower borrower = new Borrower();
    FinesManagement fine = new FinesManagement();

    Scanner input = new Scanner(System.in);

    public void booksOperations(){
        System.out.println("Books: ");
        System.out.println("1.Add book" +
                "\n2.Display all books" +
                "\n3.Search for book" +
                "\n4.Update books" +
                "\n5.Delete book record");
        System.out.println("enter the number of the operation you would like to do");
        String operation = input.next();

        if(operation.equals("1")){
            books.add();
        }else if(operation.equals("2")){
            books.displayRecords();
        }else if(operation.equals("3")){
            books.searchRecords();
        }else if(operation.equals("4")){
            books.updateRecord();
        }else if(operation.equals("5")){
            books.deleteRecord();
        }else{
            System.out.println("Operation does not exist");
        }
        input.close();
    }

    public void finesOperation(){
        System.out.println("Fines management: ");
        System.out.println("1.Add fine" +
                "\n2.Display all fines" +
                "\n3.Search for fine" +
                "\n4.Update fines" +
                "\n5.Delete fine record");
        System.out.println("enter the number of the operation you would like to do");
        String operation = input.next();

        if(operation.equals("1")){
            fine.add();
        }else if(operation.equals("2")){
            fine.displayRecords();
        }else if(operation.equals("3")){
            fine.searchRecords();
        }else if(operation.equals("4")){
            fine.updateRecord();
        }else if(operation.equals("5")){
            fine.deleteRecord();
        }else{
            System.out.println("Operation does not exist");
        }
        input.close();
    }

    public void borrowerOperations(){
        System.out.println("Borrower: ");
        System.out.println("1.Add borrower" +
                "\n2.Display all borrowers" +
                "\n3.Search for borrower" +
                "\n4.Update borrower" +
                "\n5.Delete borrower record");
        System.out.println("enter the number of the operation you would like to do");
        String operation = input.next();

        if(operation.equals("1")){
            borrower.add();
        }else if(operation.equals("2")){
            borrower.displayRecords();
        }else if(operation.equals("3")){
            borrower.searchRecords();
        }else if(operation.equals("4")){
            borrower.updateRecord();
        }else if(operation.equals("5")){
            borrower.deleteRecord();
        }else{
            System.out.println("Operation does not exist");
        }
        input.close();
    }

    public void staffOperations(){
        System.out.println("Staff: ");
        System.out.println("1.Add staff members" +
                "\n2.Display all staff members" +
                "\n3.Search for staff member" +
                "\n4.Update staff" +
                "\n5.Delete staff record");
        System.out.println("enter the number of the operation you would like to do");
        String operation = input.next();

        if(operation.equals("1")){
            staff.add();
        }else if(operation.equals("2")){
            staff.displayRecords();
        }else if(operation.equals("3")){
            staff.searchRecords();
        }else if(operation.equals("4")){
            staff.updateRecord();
        }else if(operation.equals("5")){
            staff.deleteRecord();
        }else{
            System.out.println("Operation does not exist");
        }
        input.close();
    }
    public void borrower(){
        System.out.println("would you like to borrow a book, Yes or No?");
        String choice = input.next();
        if(choice.equalsIgnoreCase("No")){
            System.exit(0);
        }else if(choice.equalsIgnoreCase("Yes")){
            System.out.println("Main menu");
            System.out.println("1.Search records" +
                    "\n2.Display books available" +
                    "\n3.Borrow book");
            System.out.println("Enter the number of the operation you would like to do");
            String operation = input.next();
            if(operation.equals("1")){
                books.searchRecords();
            }else if(operation.equals("2")){
                books.displayRecords();
            }else if(operation.equals("3")){
                borrower.add();
            }
        }
    }
}