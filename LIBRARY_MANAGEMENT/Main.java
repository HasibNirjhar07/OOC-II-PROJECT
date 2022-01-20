package Projects.Library;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    //Admin Block variables
    static Admin admin = new Admin();

    //User Block variables
    static ArrayList<User> users = new ArrayList<>(List.of(new User("A", "1111", 1000), new User("B", "2222", 1500)));
    static User currentUser;
    static int categoryInd;
    static int exchangeCount = 0;

    //Default books List
    static ArrayList<Book> books = new ArrayList<>(List.of(
    new Book("Science", new ArrayList<>(List.of("Cosmos", "The Elegant Universe", "Beyond Infinity")), new ArrayList<>(List.of("Brian Greene", "Jared Diamond", "Angela Saini")), new ArrayList<>(List.of("2008", "2012", "2002")), new ArrayList<>(List.of(3, 1, 3))),
    new Book("Novel", new ArrayList<>(List.of("Shadow Of Love", "The Guest List", "In Five Years")), new ArrayList<>(List.of("Matthew", "Lucy Fole", "T.J.Klune")), new ArrayList<>(List.of("2015", "1992", "2005")), new ArrayList<>(List.of(4, 2, 1))),
    new Book("Fantasy", new ArrayList<>(List.of("The Atlas Six", "The Empire's Ruin")), new ArrayList<>(List.of(" A. K.Larkwood", " Jenny Lyons")), new ArrayList<>(List.of("2019", "2016")), new ArrayList<>(List.of(3, 5))), 
    new Book("Mystery", new ArrayList<>(List.of("A Time for Mercy", "Titans", "Deadly Cross", "The Sentinel")), new ArrayList<>(List.of("Anthony Horowitz", "John Grisham", "Andrew Lee", "Tana French")), new ArrayList<>(List.of("2013", "2001", "2018", "2014")), new ArrayList<>(List.of(2, 5, 4, 6)))));

    //***************************************Home Menu********************************************
    private static void Home() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n<************ Welcome To KPR Library ************>");
            System.out.println("""
                    1 - Admin
                    2 - User
                    3 - Exit""");
            System.out.print("Choose Your Option : ");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    admin();
                    break;
                case 2:
                    user();
                    break;
                case 3:
                    flag = false;
                    System.out.println("\tThank You For Using KPR Library");
                    break;
                default:
                    System.out.println("\tInvalid input");
                    Home();
            }
        }
    }

    //****************************************** Admin Block *****************************************

    private static void admin() {
        System.out.println("\n<****** Admin Login ******>");
        System.out.print("User name : ");
        String userName = sc.nextLine();
        System.out.print("\nPassword : ");
        String password = sc.nextLine();

        if (!admin.name.equals(userName) || !admin.password.equals(password)) {
            System.out.println("\tWrong credentials, try again");
            admin();
        }

        boolean flag = true;
        while (flag) {
            System.out.println("\n******** Welcome, Admin *******");
            System.out.println("""
                    1 - View books
                    2 - Add book
                    3 - Remove book
                    4 - Update book
                    5 - View borrowed books
                    6 - Reports
                    7 - Back""");
            System.out.print("Choose Your Option : ");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    viewBooks("Admin");
                    break;
                case 2:
                    addBooks();
                    break;
                case 3:
                    removeBooks();
                    break;
                case 4:
                    updateBooks();
                    break;
                case 5:
                    viewBorrowedBooks();
                    break;
                case 6:
                    reports();
                    break;
                case 7:
                    flag =false;
                    break;
                default:
                    System.out.println("\tInvalid Input");
            }
        }
    }

    // View books block
    private static void viewBooks(String userType) {
        boolean flag = true;
        while (flag) {
            System.out.println("\n********* " + userType + " *************");
            System.out.println("""
                    1 - Category
                    2 - Search By Name
                    3 - Back""");
            System.out.print("Choose Your Option : ");
            Integer option = sc.nextInt();
            switch (option) {
                case 1:
                    bookCategory();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid input");
            }
        }
    }

    // Book_Category
    private static void bookCategory() {
        //show category
        System.out.println("\nList Of Category :");
        for (int i = 0; i < books.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + books.get(i).categoryName);
        }
        System.out.print("Select Category : ");
        int ctry = (sc.nextInt() - 1);
        sc.nextLine();
        if (ctry >= books.size()) {
            System.out.println("\tInvalid input");
            bookCategory();
            return;
        }

        //show Books In The category
        System.out.println("********************************************************************************************************");
        System.out.printf("%7s %24s %28s %19s %17s", "S.NO", "BOOK NAME", "AUTHOR", "YEAR", "QUANTITY");
        System.out.println();
        System.out.println("********************************************************************************************************");

        for (int i = 0; i < books.get(ctry).bookName.size(); i++) {
            System.out.format("%5s %31s %25s %17s %13s", (i + 1), books.get(ctry).bookName.get(i), books.get(ctry).author.get(i), books.get(ctry).year.get(i), books.get(ctry).quantity.get(i));
            System.out.println();
        }

        System.out.println("********************************************************************************************************");
        categoryInd = ctry;
    }

    // Search By Name
    private static void searchByName() {
        System.out.print("\nName of the book : ");
        String searchBookName = sc.nextLine();
        for (Book book : books) {
            for (int j = 0; j < book.bookName.size(); j++) {
                if (book.bookName.get(j).equals(searchBookName)) {
                    System.out.println("********************************************************************************************************");
                    System.out.printf("%18s %25s %19s %17s %15s", "BOOK NAME", "AUTHOR", "YEAR", "QUANTITY", "CATEGORY");
                    System.out.println();
                    System.out.println("********************************************************************************************************");
                    System.out.format("%23s %24s %15s %14s %18s", book.bookName.get(j), book.author.get(j), book.year.get(j), book.quantity.get(j), book.categoryName);
                    System.out.println();
                    System.out.println("********************************************************************************************************");
                    return;
                }
            }
        }
        System.out.println("\t" + searchBookName + " book not found!");
    }

    // Add Book Block
    private static void addBooks() {
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("""
                    1 - Existing Category
                    2 - New Category
                    3 - Back""");
            System.out.print("Choose Your Option : ");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    inExistingCatry();
                    break;
                case 2:
                    inNewCatry();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid Input");
            }
        }
    }

    // Add Books In Existing Category
    private static void inExistingCatry() {
        //Show Category
        System.out.println("\nList Of Category :");
        for (int i = 0; i < books.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + books.get(i).categoryName);
        }
        System.out.print("Select Category : ");
        int catry = (sc.nextInt() - 1);
        sc.nextLine();
        if (catry >= books.size()) {
            System.out.println("\tInvalid Input");
            inExistingCatry();
            return;
        }

        //add Book
        System.out.print("\nBook name : ");
        String newBookName = sc.nextLine();
        System.out.print("Author name : ");
        String newBookAuthor = sc.nextLine();
        System.out.print("Year : ");
        String newBookYear = sc.nextLine();
        System.out.print("Quantity : ");
        int newBookQuantity = sc.nextInt();
        sc.nextLine();

        books.get(catry).bookName.add(newBookName);
        books.get(catry).author.add(newBookAuthor);
        books.get(catry).year.add(newBookYear);
        books.get(catry).quantity.add(newBookQuantity);

        System.out.println("\t" + newBookName + " Successfully Added In " + books.get(catry).categoryName);
    }

    // Add books in new category
    private static void inNewCatry() {
        System.out.print("\nCategory Name : ");
        String newCategoryName = sc.nextLine();
        System.out.print("Book Name : ");
        String newCategoryBookName = sc.nextLine();
        System.out.print("Author Name : ");
        String newCategoryBookAuthor = sc.nextLine();
        System.out.print("Year : ");
        String newCategoryBookYear = sc.nextLine();
        System.out.print("Quantity : ");
        int newCategoryBookQuantity = sc.nextInt();
        sc.nextLine();

        books.add(new Book(newCategoryName, new ArrayList<>(List.of(newCategoryBookName)),
            new ArrayList<>(List.of(newCategoryBookAuthor)),
            new ArrayList<>(List.of(newCategoryBookYear)),
            new ArrayList<>(List.of(newCategoryBookQuantity))));

        System.out.println("\t" + newCategoryBookName + " Successfully Added");
    }

    // Remove Books
    private static void removeBooks() {
        //show books
        bookCategory();
        if (categoryInd != -1) {
            System.out.print("\n(0)Entire category (OR) Select book : ");
            int ind = (sc.nextInt() - 1);
            sc.nextLine();
            if (ind >= books.get(categoryInd).bookName.size()) {
                System.out.println("\tInvalid input");
                removeBooks();
                return;
            }

            //Remove Categorys
            if (ind == -1) {
                System.out.println("\t" + books.get(categoryInd).categoryName + " Category Successfully Removed");
                books.remove(categoryInd);
                return;
            }

            //Remove Books
            System.out.println("\t" + books.get(categoryInd).bookName.get(ind) + " Successfully Removed");
            books.get(categoryInd).bookName.remove(ind);
            books.get(categoryInd).author.remove(ind);
            books.get(categoryInd).year.remove(ind);
            books.get(categoryInd).quantity.remove(ind);
        }
    }

    // Update The Book Details
    private static void updateBooks() {
        bookCategory();
        if (categoryInd != -1) {
            System.out.print("\nSelect The Book : ");
            int bookToUpdate = (sc.nextInt() - 1);
            sc.nextLine();
            if (bookToUpdate >= books.get(categoryInd).bookName.size()) {
                System.out.println("\tInvalid Input");
                removeBooks();
                return;
            }

            System.out.println("Update : (1)Book name / (2)Author name / (3)Year / (4)Quantity");
            System.out.print("Select : ");
            int updateOption = sc.nextInt();
            sc.nextLine();

            switch (updateOption) {
                case 1:
                    System.out.print("\nEnter The Book Name : ");
                    String updateBookName = sc.nextLine();
                    books.get(categoryInd).bookName.set(bookToUpdate, updateBookName);
                    System.out.println("\tBook Name Successfully Updated");
                    break;
                case 2:
                    System.out.print("\nEnter Author Name : ");
                    String updateAuthorName = sc.nextLine();
                    books.get(categoryInd).author.set(bookToUpdate, updateAuthorName);
                    System.out.println("\tAuthor Name Successfully Updated");
                    break;
                case 3:
                    System.out.print("\nEnter The Year : ");
                    String updateYear = sc.nextLine();
                    books.get(categoryInd).year.set(bookToUpdate, updateYear);
                    System.out.println("\tYear Successfully Updated");
                    break;
                case 4:
                    System.out.print("\nEnter Quantity : ");
                    int updateQuantity = sc.nextInt();
                    sc.nextLine();
                    books.get(categoryInd).quantity.set(bookToUpdate, updateQuantity);
                    System.out.println("\tQuantity Successfully Updated");
                    break;
                default:
                    System.out.println("\tInvalid Input");
                    updateBooks();
                    break;
            }
        }
    }

    // View Borrowed Books Details
    private static void viewBorrowedBooks() {
        System.out.print("\nName of the book : ");
        String searchBookName = sc.nextLine();
        System.out.println("***************************************************************************");
        System.out.printf("%7s %18s %22s %21s ", "S.NO", "USER NAME", "BORROWED DATE", "RETURNING DATE\n");
        System.out.println("***************************************************************************");
        int i = 1;
        for (User user : users)
            for (int j = 0; j < user.borrowedBooks.size(); j++)
                if (user.borrowedBooks.get(j).get(0).equals(searchBookName)) {
                    System.out.format("%7s %16s %22s %19s", (i), user.name, user.borrowedBooks.get(j).get(3), user.borrowedBooks.get(j).get(4) + "\n");
                    i++;
                }
            System.out.println("***************************************************************************");
    }

    // Report About Book
    private static void reports() {
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("""
                    1 - Low quantity
                    2 - Outstanding
                    3 - Back""");
            System.out.print("Choose your option : ");
            Integer option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    lowQuantity();
                    break;
                case 2:
                    outstanding();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid input");
                    reports();
                    break;
            }
        }
    }

    // List of low quantity books
    private static void lowQuantity() {
        if (!admin.lowQuantity.isEmpty()) {
            for (int i = 0; i < admin.lowQuantity.size(); i++) {
                for (Book book : books)
                    for (int k = 0; k < book.bookName.size(); k++)
                        if (admin.lowQuantity.get(i).get(0).equals(book.bookName.get(k)))
                            if (book.quantity.get(k) >= 2) {
                                admin.lowQuantity.remove(i);
                                lowQuantity();
                                return;
                            }
            }
            System.out.println("***********************************************************************************************");
            System.out.printf("%7s %24s %23s %17s %18s ", "S.NO", "BOOK NAME", "AUTHOR", "CATEGORY", "QUANTITY\n");
            System.out.println("***********************************************************************************************");
            for (int i = 0; i < admin.lowQuantity.size(); i++)
                System.out.format("%5s %28s %22s %16s %15s ", (i + 1), admin.lowQuantity.get(i).get(0), admin.lowQuantity.get(i).get(1), admin.lowQuantity.get(i).get(2), admin.lowQuantity.get(i).get(3) + "\n");
                System.out.println("***********************************************************************************************");
        } else System.out.println("\tN/A");
    }

    // Outstanding books
    private static void outstanding() {
        return;
    }


    //************************************** User ********************************
    // User Home
    private static void user() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n******** User ********");
            System.out.println("""
                    1 - Login
                    2 - Create Account
                    3 - Back""");
            System.out.print("Choose your option : ");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    userCreateAccount();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid Input");
                    user();
                    break;
            }
        }
    }


    // User Sign Up Page For New User
    private static void userCreateAccount() {
        System.out.println("\n****** User Sign up ********");
        System.out.print("User name : ");
        String newUserName = sc.nextLine();
        System.out.print("Password : ");
        String newUserPassword = sc.nextLine();
        System.out.print("Conform password : ");
        String newUserConformPassword = sc.nextLine();

        //Check If User Exist
        for (User user : users) {
            if (user.name.equals(newUserName)) {
                System.out.println("Account Already Exist, Login");
                userLogin();
                return;
            }
        }

        //check password
        if (!newUserPassword.equals(newUserConformPassword)) {
            System.out.println("\tPassword Mismatch, Try Again");
            userCreateAccount();
            return;
        }
        System.out.print("Initial Deposit Amount :");
        int depositAmount = sc.nextInt();
        sc.nextLine();

        //add user
        users.add(new User(newUserName, newUserConformPassword, depositAmount));
        System.out.println("\tAccount Created Successfully");
        userLogin();
    }

    // User Login For Existing User
    private static void userLogin() {
        System.out.println("\n******* User Login *********");
        System.out.print("User name : ");
        String userName = sc.nextLine();

        //check If User Exist Or Not
        for (User user : users) {
            if (user.name.equals(userName)) {
                System.out.print("Password : ");
                String password = sc.nextLine();
                if (user.password.equals(password)) currentUser = user;
                else {
                    System.out.println("\tWrong Password");
                    userLogin();
                    break;
                }
            }
        }
        if (currentUser == null) {
            System.out.println("\tYou don't have an account, please Sign up");
            userCreateAccount();
            return;
        }


        //User Personal Menu
        boolean flag = true;
        while (flag) {
            System.out.println("\n******* Welcome, Mr." + currentUser.name + " *******");
            System.out.println("""
                    1 - View Books
                    2 - Borrow Books
                    3 - Return Book
                    4 - Borrowed History
                    5 - Penalty
                    6 - Manage Funds
                    7 - Others
                    8 - Back""");
            System.out.print("Choose your option : ");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    viewBooks("Mr." + currentUser.name);
                    break;
                case 2:
                    if (currentUser.borrowedBooks.size() < 3) borrowBooks();
                    else System.out.println("\tYou Have Three Books, Please Return One  Of Them To Borrow Next Book");
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    borrowedHistory();
                    break;
                case 5:
                    penalty();
                    break;
                case 6:
                    manageFund();
                    break;
                case 7:
                    others();
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid Input");
            }
        }
    }


    // Borrow Books Block
    private static void borrowBooks() {
        if (currentUser.amount >= 500) {
            //Show The Books
            bookCategory();
            if (categoryInd != -1) {
                System.out.print("Select Book : ");
                int ind = (sc.nextInt() - 1);
                sc.nextLine();
                if (ind >= books.get(categoryInd).bookName.size()) {
                    System.out.println("\tInvalid Input");
                    removeBooks();
                    return;
                }

                //check if already borrowed or not
                if (!currentUser.borrowedBooks.isEmpty()) for (int i = 0; i < currentUser.borrowedBooks.size(); i++)
                    if (currentUser.borrowedBooks.get(i).contains(books.get(categoryInd).bookName.get(ind))) {
                        System.out.println("\tYou Already Borrowed This Book");
                        return;
                    }

                //Reduce Book Count
                int bookQuantity = books.get(categoryInd).quantity.get(ind);
                if (bookQuantity < 1)
                    System.out.println("\t" + books.get(categoryInd).bookName.get(ind) + " Book Is Not Available, Please Contact The Admin");
                else {
                    books.get(categoryInd).quantity.set(ind, --bookQuantity);
                    //Add The Book
                    String borrowDate = BorrowDate();
                    String returnDate = ReturnDate(borrowDate);
                    currentUser.borrowedBooks.add(new ArrayList<>(List.of(books.get(categoryInd).bookName.get(ind), books.get(categoryInd).author.get(ind), books.get(categoryInd).year.get(ind), borrowDate, returnDate)));
                    currentUser.borrowedHistory.add(new ArrayList<>(List.of(books.get(categoryInd).bookName.get(ind), books.get(categoryInd).author.get(ind), books.get(categoryInd).year.get(ind), borrowDate, returnDate, "Not returned")));
                    System.out.println("\t" + books.get(categoryInd).bookName.get(ind) + " Book Successfully Borrowed");
                }
                if (bookQuantity <= 1) {
                    if (!admin.lowQuantity.isEmpty()) {
                        admin.lowQuantity.add(new ArrayList<>(List.of(books.get(categoryInd).bookName.get(ind), books.get(categoryInd).author.get(ind), books.get(categoryInd).categoryName, (bookQuantity + ""))));
                    }
                }
            } else System.out.println("\tYour Minimum Deposit Is Less Than 500, Please Add Fund");
        }

    }


    // Return The Borrowed Books
    private static void returnBooks() {
        if (!currentUser.borrowedBooks.isEmpty()) {
            //Show Borrowed Books
            System.out.println("***********************************************************************************************************************************");
            System.out.printf("%7s %24s %28s %17s %22s %23s", "S.NO", "BOOK NAME", "AUTHOR", "YEAR", "BORROWED DATE", "RETURNING DATE\n");
            System.out.println("***********************************************************************************************************************************");
            for (int i = 0; i < currentUser.borrowedBooks.size(); i++) {
                ArrayList<String> book = currentUser.borrowedBooks.get(i);
                System.out.format("%5s %31s %25s %15s %20s %22s", (i + 1), book.get(0), book.get(1), book.get(2), book.get(3), book.get(4) + "\n");
            }
            System.out.println("***********************************************************************************************************************************");

            System.out.print("Select The Book : ");
            int bookIndex = (sc.nextInt() - 1);
            sc.nextLine();

            if (bookIndex >= currentUser.borrowedBooks.size()) {
                System.out.println("\tInvalid Input");
                returnBooks();
                return;
            }

            //check returning date
            System.out.print("Enter Current Date : ");
            String dateOfReturn = sc.nextLine();
            int returnDay = Integer.parseInt(dateOfReturn.split("/")[0]);
            int borrowDay = Integer.parseInt(currentUser.borrowedBooks.get(bookIndex).get(3).split("/")[0]);
            int numOfDays = 0;

            while (true) if (returnDay == borrowDay) break;
            else {
                borrowDay++;
                numOfDays++;
                if (borrowDay > 31) borrowDay = 1;
            }

            if (numOfDays > 16) {
                numOfDays -= 15;
                int fine = numOfDays * admin.penaltyPerDay;
                currentUser.amount -= fine;
                currentUser.penaltyList.add(new ArrayList<>(List.of("Overdue", "₹" + fine, dateOfReturn)));
                System.out.println("\t" + fine + "Rs Deducted For Overdue Of " + numOfDays + " Days");
            }

            String currentBookToDelete = currentUser.borrowedBooks.get(bookIndex).get(0);
            System.out.println("\t" + currentBookToDelete + " Successfully Returned");

            //Increase Book Count In Library
            for (Book book : books) {
                for (int j = 0; j < book.bookName.size(); j++) {
                    if (book.bookName.get(j).equals(currentBookToDelete)) {
                        book.quantity.set(j, (book.quantity.get(j) + 1));
                        break;
                    }
                }
            }

            //Mark The Book As Returned
            for (int i = 0; i < currentUser.borrowedHistory.size(); i++)
                if (currentUser.borrowedHistory.get(i).get(0).equals(currentBookToDelete)) {
                    currentUser.borrowedHistory.get(i).set(5, "Returned");
                    break;
                }

            //remove from borrowed list
            Iterator<ArrayList<String>> it = currentUser.borrowedBooks.iterator();
            while (it.hasNext()) {
                if (it.next().get(0).equals(currentBookToDelete)) {
                    it.remove();
                    return;
                }
            }
        } else System.out.println("\tYou don't have books to return");
    }


    // History Of Borrowed Books For The User
    private static void borrowedHistory() {
        if (!currentUser.borrowedHistory.isEmpty()) {
            System.out.println("********************************************************************************************************************************************************");
            System.out.printf("%7s %24s %28s %17s %22s %23s %18s", "S.NO", "BOOK NAME", "AUTHOR", "YEAR", "BORROWED DATE", "RETURNING DATE", "STATUS\n");
            System.out.println("********************************************************************************************************************************************************");
            for (int i = 0; i < currentUser.borrowedHistory.size(); i++) {
                ArrayList<String> book = currentUser.borrowedHistory.get(i);
                System.out.format("%5s %31s %25s %15s %20s %22s %24s", (i + 1), book.get(0), book.get(1), book.get(2), book.get(3), book.get(4), book.get(5) + "\n");
            }
            System.out.println("********************************************************************************************************************************************************");
        } else System.out.println("\tHistory Not Available");
    }


    // List Of Penalty
    private static void penalty() {
        if (!currentUser.penaltyList.isEmpty()) {
            System.out.println("**************************************************************");
            System.out.printf("%7s %17s %16s %15s", "S.NO", "REASON", "AMOUNT", "DATE\n");
            System.out.println("**************************************************************");
            for (int i = 0; i < currentUser.penaltyList.size(); i++)
                System.out.format("%5s %20s %14s %17s", (i + 1), currentUser.penaltyList.get(i).get(0), currentUser.penaltyList.get(i).get(1), currentUser.penaltyList.get(i).get(2) + "\n");
            System.out.println("**************************************************************");
        } 
        else System.out.println("\tYou Don't Have Any Penalties");
    }


    //Other Options
    private static void others() {
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("""
                    1 - Report Book Lost
                    2 - Extend Returning Period
                    3 - Exchange Book
                    4 - Back""");
            System.out.print("Choose Your Option : ");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    reportBookLost();
                    break;
                case 2:
                    extendReturningTime();
                    break;
                case 3:
                    if (exchangeCount <= 3)
                        exchangeBook();
                    else
                        System.out.println("\tYour Exchanging Limit Is Exceeded");
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid Input");
                    others();
                    break;
            }
        }
    }


    // Report For Book Lost
    private static void reportBookLost() {

        //Show The Borrowed Books
        System.out.println("***********************************************************************************************************************************");
        System.out.printf("%7s %24s %28s %17s %22s %23s", "S.NO", "BOOK NAME", "AUTHOR", "YEAR", "BORROWED DATE", "RETURNING DATE\n");
        System.out.println("***********************************************************************************************************************************");
        for (int i = 0; i < currentUser.borrowedBooks.size(); i++) {
            ArrayList<String> book = currentUser.borrowedBooks.get(i);
            System.out.format("%5s %31s %25s %15s %20s %22s", (i + 1), book.get(0), book.get(1), book.get(2), book.get(3), book.get(4) + "\n");
        }
        System.out.println("***********************************************************************************************************************************");

        System.out.print("Select The Book : ");
        int bookIndex = (sc.nextInt() - 1);
        sc.nextLine();

        if (bookIndex >= currentUser.borrowedBooks.size()) {
            System.out.println("\tInvalid Input");
            reportBookLost();
            return;
        }

        String currentBook = currentUser.borrowedBooks.get(bookIndex).get(0);

        //Deduct Amount
        currentUser.amount -= admin.penaltyForLost;
        currentUser.penaltyList.add(new ArrayList<>(List.of("Book Lost", "₹250", "N/A")));
        System.out.println("\t250Rs Deducted For Book Lost");

        //Mark As Lost
        for (int i = 0; i < currentUser.borrowedHistory.size(); i++)
            if (currentUser.borrowedHistory.get(i).get(0).equals(currentBook)) {
                currentUser.borrowedHistory.get(i).set(5, "Lost");
                break;
            }

        //Remove From Borrowed List
        Iterator<ArrayList<String>> it = currentUser.borrowedBooks.iterator();
        while (it.hasNext()) {
            if (it.next().get(0).equals(currentBook)) {
                it.remove();
                return;
            }
        }
    }


    // Extend The Returning Time
    private static void extendReturningTime() {

        //Show The Borrowed Books
        System.out.println("\n************************************************************************************************************************************");
        System.out.printf("%7s %24s %28s %17s %22s %23s", "S.NO", "BOOK NAME", "AUTHOR", "YEAR", "BORROWED DATE", "RETURNING DATE\n");
        System.out.println("***********************************************************************************************************************************");
        for (int i = 0; i < currentUser.borrowedBooks.size(); i++) {
            ArrayList<String> book = currentUser.borrowedBooks.get(i);
            System.out.format("%5s %31s %25s %15s %20s %22s", (i + 1), book.get(0), book.get(1), book.get(2), book.get(3), book.get(4) + "\n");
        }
        System.out.println("***********************************************************************************************************************************");

        System.out.print("Select Book : ");
        int bookIndex = (sc.nextInt() - 1);
        sc.nextLine();

        if (bookIndex >= currentUser.borrowedBooks.size()) {
            System.out.println("\tInvalid Input");
            extendReturningTime();
            return;
        }
        ArrayList<String> currentBook = currentUser.borrowedBooks.get(bookIndex);

        System.out.print("New Date : ");
        String newDate = sc.nextLine();
        int oldDay = Integer.parseInt(currentBook.get(4).split("/")[0]);
        int newDay = Integer.parseInt(newDate.split("/")[0]);
        int dayCount = 0;

        while (true) if (oldDay == newDay) break;
        else {
            oldDay++;
            dayCount++;
            if (oldDay > 31) oldDay = 1;
        }

        if (dayCount > 9) {
            System.out.println("Date Can't Extend Above 10days");
            extendReturningTime();
            return;
        }

        //update New Date
        currentBook.set(4, newDate);

        int historyInd = 0;
        for (int i = 0; i < currentUser.borrowedHistory.size(); i++)
            if (currentUser.borrowedHistory.get(i).get(0).equals(currentBook.get(0))) historyInd = i;

        currentUser.borrowedHistory.get(historyInd).set(4, newDate + "(Ext)");
        System.out.println("\tNew Date Successfully Updated");
    }


    // Exchanging Book
    private static void exchangeBook() {

        //Show  The Borrowed Books
        System.out.println("***********************************************************************************************************************************");
        System.out.printf("%7s %24s %28s %17s %22s %23s", "S.NO", "BOOK NAME", "AUTHOR", "YEAR", "BORROWED DATE", "RETURNING DATE\n");
        System.out.println("***********************************************************************************************************************************");
        for (int i = 0; i < currentUser.borrowedBooks.size(); i++) {
            ArrayList<String> book = currentUser.borrowedBooks.get(i);
            System.out.format("%5s %31s %25s %15s %20s %22s", (i + 1), book.get(0), book.get(1), book.get(2), book.get(3), book.get(4) + "\n");
        }
        System.out.println("***********************************************************************************************************************************");

        System.out.print("Select The Book : ");
        int exchangeBookIndex = (sc.nextInt() - 1);
        sc.nextLine();

        if (exchangeBookIndex >= currentUser.borrowedBooks.size()) {
            System.out.println("\tInvalid Input");
            exchangeBook();
            return;
        }


        //Show All Books To Exchange
        bookCategory();
        if (categoryInd != -1) {
            System.out.print("Select Book : ");
            int newBookIndex = (sc.nextInt() - 1);
            sc.nextLine();
            if (newBookIndex >= books.get(categoryInd).bookName.size()) {
                System.out.println("\tInvalid Input");
                bookCategory();
                return;
            }
            ArrayList<String> exchangeBook = currentUser.borrowedBooks.get(exchangeBookIndex);

            //Update In History Of List
            int historyInd = 0;
            for (int i = 0; i < currentUser.borrowedHistory.size(); i++)
                if (currentUser.borrowedHistory.get(i).get(0).equals(exchangeBook.get(0))) historyInd = i;

            //Replace Books
            exchangeBook.set(0, books.get(categoryInd).bookName.get(newBookIndex));
            exchangeBook.set(1, books.get(categoryInd).author.get(newBookIndex));
            exchangeBook.set(2, books.get(categoryInd).year.get(newBookIndex));

            currentUser.borrowedHistory.set(historyInd, exchangeBook);
            currentUser.borrowedHistory.get(historyInd).set(0, currentUser.borrowedHistory.get(historyInd).get(0) + "(Exg)");
            currentUser.borrowedHistory.get(historyInd).add("Not Returned");
            exchangeCount++;
            System.out.println("\tBook Exchanged Successfully");
        }
    }

    // Managing Funds
    private static void manageFund() {
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("""
                    1 - Show balance
                    2 - Add fund
                    3 - Back""");
            System.out.print("Choose your option : ");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    showFund();
                    break;
                case 2:
                    addFund();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid  Input");
                    manageFund();
                    break;
            }
        }
    }

    // Show The Available Funds
    private static void showFund() {
        System.out.println("\nCurrent Balance Is : " + currentUser.amount);
    }

    // Add Funds
       private static void addFund() {
        System.out.print("\nEnter Amount : ");
        int amt = sc.nextInt();
        sc.nextLine();
        currentUser.amount += amt;
        System.out.println("\t Amount Successfully Added");
    }

    // Random Date (For Borrow)
    private static String BorrowDate() {
        int day = (int) (Math.random() * 31) + 1;
        int month = (int) (Math.random() * 12) + 1;
        int year = 2022;
        return day + "/" + month + "/" + year;
    }

    // Random Date (For Return)
    private static String ReturnDate(String date) {
        String[] dateArr = date.split("/");
        int newDay = Integer.parseInt(dateArr[0]);
        int newMonth = Integer.parseInt(dateArr[1]);
        int newYear = Integer.parseInt(dateArr[2]);
        for (int i = 1; i <= 15; i++) {
            if (newDay < 31) newDay++;
            else {
                newDay = 1;
                newMonth++;
                if (newMonth > 12) {
                    newMonth = 1;
                    newYear++;
                }
                --i;
            }
        }
        return newDay + "/" + newMonth + "/" + newYear;
    }

    //? Main
    public static void main(String[] args) {
        Home();
    }
}
