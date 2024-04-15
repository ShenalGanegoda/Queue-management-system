import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class foodiesFaveQueueManagementSystem {



//    User difined Methods
    public static void viewAllQueues100 () {
        //Method to View all Queues
        System.out.println("\n***********");
        System.out.println("*" + " " + "Cashier" + " " + "*");
        System.out.println("***********");

        //Iterating through Cashiers and checking for the Final print
        for (int i = 0; i < 5; i++) {

            String value01;
            if (i < cashier01.length) {
                if (cashier01[i].equals("X")) {
                    value01 = "X";
                }else {
                    value01 = "O";
                }
            }else {
                value01 = " ";
            }

            String value02;
            if (i < cashier02.length) {
                if (cashier02[i].equals("X")) {
                    value02 = "X";
                } else {
                    value02 = "O";
                }
            } else {
                value02 = " ";
            }

            String value03;
            if (i < cashier03.length) {
                if (cashier03[i].equals("X")) {
                    value03 = "X";
                } else {
                    value03 = "O";
                }
            } else {
                value03 = " ";
            }
            System.out.println("\n" + value01 + " " + value02 + " " +  value03);

        }
    }

//    Method to View all empty Queues
    public static void viewAllEmptyQueues101 () {

        System.out.println("\n***********");
        System.out.println("*" + " " + "Cashier" + " " + "*");
        System.out.println("***********");

        //Iterating through Cashiers and checking for the Final print
        for (int i = 1; i <= 5; i++) {

            String value01;
            if (i < cashier01.length) { //Checking to see if Cashier Length is less than index
                if (cashier01[i].equals("X")) { //Checking to see if the Cashier is Available or not for the print
                    value01 = "X";
                }else {
                    value01 = "O";
                }
            }else {
                value01 = " ";
            }

            String value02;
            if (i < cashier02.length) {
                if (cashier02[i].equals("X")) {
                    value02 = "X";
                } else {
                    value02 = "O";
                }
            } else {
                value02 = " ";
            }

            String value03;
            if (i < cashier03.length) {
                if (cashier03[i].equals("X")) {
                    value03 = "X";
                } else {
                    value03 = "O";
                }
            } else {
                value03 = " ";
            }
            System.out.println("\n" + value01 + " " + value02 + " " +  value03);

        }
    }

//    Method to Add customers to the Queues
    public static void addCustomerToTheQueues102 (){
        String customerName;
        System.out.print("\nEnter name here: ");
        customerName = scannerObject.next();

        System.out.print("Enter queue here: ");
        String cashierSelected = scannerObject.next();

        if (cashierSelected.equals("1")) {
            for (int i = 0; i < cashier01.length; i++) {
                if (cashier01[i].equals("X")) {
                    cashier01[i] = customerName;
                    break;
                }
            }
        } else if (cashierSelected.equals("2")) {
            for (int i = 0; i < cashier02.length; i++) {
                if (cashier02[i].equals("X")) {
                    cashier02[i] = customerName;
                    break;
                }
            }
        } else if (cashierSelected.equals("3")) {
            for (int i = 0; i < cashier03.length; i++) {
                if (cashier03[i].equals("X")){
                    cashier03[i] = customerName;
                    break;
                }
            }
        }


    }

//    Method to remove Customers from Queues
    public static void removeCustomerFromQueue103 (){
        String[] cashierTemp;

        System.out.println("Enter Queue here: ");
        int enteredRemoveQueue = scannerObject.nextInt();

        if (enteredRemoveQueue == 1) {
            cashierTemp = cashier01;
        } else if (enteredRemoveQueue == 2) {
            cashierTemp = cashier02;
        } else {
            cashierTemp = cashier03;
        }


        System.out.println("Enter line number here: ");
        int removeIndex = scannerObject.nextInt();
        for (int i = 0; i < cashierTemp.length; i++) {
            cashierTemp[removeIndex] = "X";
        }
    }

//    Method to remove served Customers
    public static void removeAServedCustomer104 () {
        System.out.println("Enter Queue here: ");
        int removeCustomerQueue = scannerObject.nextInt();

        while (true) {
            if (removeCustomerQueue == 1) {
                cashier01[0] = "X";
            } else if (removeCustomerQueue == 2) {
                cashier02[0] = "X";
            } else if (removeCustomerQueue == 3) {
                cashier03[0] = "X";
            } else
                System.out.println("Invalid Input");
        }
    }

//    Method to Sort Customer names
    public static void customerSortedInAlphabeticalOrder105 (){}

//    Method to Store Program Data into text File
    public static void storeProgramDataIntoFile106 () {
        try {
            FileWriter writerFile = new FileWriter("BurgerProgramData.txt");
            writerFile.write("Queue 1: "+Arrays.toString(cashier01)+"\n");
            writerFile.write("Queue 2: "+Arrays.toString(cashier02)+"\n");
            writerFile.write("Queue 3: "+Arrays.toString(cashier03)+"\n");
            writerFile.write("Remaining Burger stock: " + remainingBurgerStock);
            writerFile.close();
        }catch (IOException e){
            System.out.println("Error!");
        }

    }

//    Method to Load Data from the file
    public static void loadProgramData107 () {
        try {
            FileReader readerFile = new FileReader("BurgerProgramData.txt");
            Scanner readfile = new Scanner(readerFile);
            while (readfile.hasNextLine()) {
                String data = readfile.nextLine();
                System.out.println(data);
            }

        } catch (IOException e){
            System.out.println("Error!");
        }
    }

    //Method to print the remaining Burger Stock
    public static void viewRemainingBurgerStock108 () {
        System.out.println(remainingBurgerStock);
    }

    //Method to Manipulate Burger Stock
    public static void addBurgersToStock109 () {
        if(remainingBurgerStock < 50) {
            System.out.print("Enter Value to add to the stock: ");
            int addToTheStock = scannerObject.nextInt();

            int newStock = remainingBurgerStock + addToTheStock;
            if (newStock > 50) {
                remainingBurgerStock = 50;
            } else {
                remainingBurgerStock = newStock;
            }

        }else {
            System.out.println("Burger stock is full");

        }

    }

    //Defining the Global Variables.
    public static String[] cashier01 = {"X" , "X"};
    public static String[] cashier02 = {"X" , "X" , "X"};
    public static String[] cashier03 = {"X" , "X" , "X"  , "X"  , "X"};
    public static int remainingBurgerStock = 50;
    public static Scanner scannerObject = new Scanner(System.in);




    public static void main(String[] args) {

        int burgerStock = 50;
        String optionInput = "";



        //Printing out the Menu
        System.out.println("\n------------------------------------");
        System.out.println("Welcome to Foodies Fave Food Center");
        System.out.println("------------------------------------");
        System.out.println("\n100 or VFQ: View all Queues\n101 or VEQ: View all Empty Queues.\n102 or ACQ: Add customer to a Queue.\n103 or RCQ: Remove a customer from a Queue.\n104 or PCQ: Remove a served customer.\n105 or VCS: View Customers Sorted in alphabetical order\n106 or SPD: Store Program Data into file.\n107 or LPD: Load Program Data from file.\n108 or STK: View Remaining burgers Stock.\n109 or AFS: Add burgers to Stock.\n999 or EXT: Exit the Program.");


        System.out.println(optionInput);

        //Getting in multiple Inputs using a While Loop
        while (true ){
            System.out.print("\nSelect option here: ");
            optionInput = scannerObject.next().toUpperCase() ;

            if (optionInput.equals("100") || optionInput.equals("VFQ")) {
                System.out.println("\nView all Queues selected");
                viewAllQueues100();

            } else if (optionInput.equals("101") || optionInput.equals("AEQ")) {
                System.out.println("\nView all empty selected");
                viewAllEmptyQueues101();

            } else if (optionInput.equals("102") || optionInput.equals("ACQ")) {
                System.out.println("\nAdd customer to a Queue selected");
                addCustomerToTheQueues102();

            } else if (optionInput.equals("103") || optionInput.equals("RCQ")) {
                System.out.println("\nRemove a customer from a Queue selected");
                 removeCustomerFromQueue103();

            }else if (optionInput.equals("104") || optionInput.equals("PCQ")) {
                System.out.println("\nRemove a served customer selected");
                removeAServedCustomer104();

            } else if (optionInput.equals("105") || optionInput.equals("VCS")) {
                System.out.println("\nView Customers Sorted in alphabetical order selected");


            } else if (optionInput.equals("106") || optionInput.equals("SPD")) {
                System.out.println("\nStore Program Data into file selected");
                storeProgramDataIntoFile106();

            } else if (optionInput.equals("107") || optionInput.equals("LPD")) {
                System.out.println("\nLoad Program Data from file selected");
                loadProgramData107();

            } else if (optionInput.equals("108") || optionInput.equals("STK")) {
                System.out.println("\nView Remaining burgers Stock selected");
                viewRemainingBurgerStock108();
                
            } else if (optionInput.equals("109") || optionInput.equals("AFS")) {
                System.out.println("\nAdd burgers to Stock selected");
                addBurgersToStock109();
                
            } else if (optionInput.equals("999") || optionInput.equals("EXT")) {
                System.out.println("Exiting Foodies Favourite Queue Management System");
                break;

            } else
                System.out.println("Invalid Input!\nEnter again.");
        }
    }
}