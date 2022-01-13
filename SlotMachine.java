// Slots by Patrick Celedio

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
class SlotMachine {

    // main function
    public static void main(String[] args){
        // Display menu
        menu();
    }

    static void pressAnyButtonToContinue() {
        System.out.print("Press enter to continue..");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Please press enter to continue.");
        }
    }

    // the spinning of the slots function
    // 1. Randomly generate three symbols
    // 2. Calculate prize according to the generation of the symbols
    static int playSlots() {
        // Create a random object to create random values
        Random rand = new Random();

        // Contain the symbols in an array--
        String[] symbols=new String[8];
        symbols[0]= "DD";
        symbols[1]= "7";
        symbols[2]= "BBB";
        symbols[3]= "BB";
        symbols[4]= "B";
        symbols[5]= "C";
        symbols[6]= "AB";
        symbols[7]= "0";

        // Generate symbols
        String[] slots=new String[3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){

                // Generate a random int to determine the symbol
                int chance = rand.nextInt(symbols.length);

                // Fill slots array with random symbol
                slots[i]=symbols[chance];
            }
        }

        // Print out symbols
        for (int i=0; i<slots.length; i++){
            System.out.print("|" +  slots[i] + "|");
        }

        // Calculate pay-out

        // if all three symbols match
        if (slots[0] == slots[1] && slots[1] == slots[2]){
            switch(slots[0]){
                case "DD":
                    return 1;
                case "7":
                    return 2;
                case "BBB":
                    return 3;
                case "BB":
                    return 4;
                case "B":
                    return 5;
                case "C":
                    return 6;
                case "AB":
                    return 7;
                case "0":
                    return 8;
            }
        } else if (slots[0]==slots[1] && slots[2]=="0") {
            switch (slots[0]) {
                case "C":
                    return 6;
                case "0":
                    return 8;
            }
        } else if (slots[0]==slots[2] && slots[1]=="0") {
            switch (slots[0]) {
                case "C":
                    return 6;
                case "0":
                    return 8;
            }
        } else if (slots[1]==slots[2] && slots[0]=="0"){
            switch (slots[0]) {
                case "C":
                    return 6;
                case "0":
                    return 8;
            }
        } else if (slots[0]=="C" && slots[1]==slots[2]){
            switch (slots[1]) {
                case "C":
                case "DD":
                case "7":
                case "BBB":
                case "BB":
                case "B":
                case "AB":
                    return 5;
                case "0":
                    return 6;
            }
        }else if (slots[1]=="C" && slots[0]==slots[2]){
            switch (slots[0]) {
                case "C":
                case "DD":
                case "7":
                case "BBB":
                case "BB":
                case "B":
                case "AB":
                    return 5;
                case "0":
                    return 6;
            }
        }else if (slots[2]=="C" && slots[0]==slots[1]){
            switch (slots[0]) {
                case "C":
                case "DD":
                case "7":
                case "BBB":
                case "BB":
                case "B":
                case "AB":
                    return 5;
                case "0":
                    return 6;
            }
        }else if(slots[0]=="C"){
            return 5;
        }else if(slots[1]=="C"){
            return 5;
        }else if(slots[2]=="C"){
            return 5;
        }

        return 0;
    }

    static void menu(){
        // Create a scanner object to take in user input
        Scanner sc = new Scanner(System.in);

        // Create variable to hold user's total capital and user's bet denomination
        double money = 100.00;
        double denomination = 0;

        // Initialize userWins as int inorder to have numerous outcomes instead of boolean
        int userWins = 0;

        // Print menu
        System.out.println("\n****************\n" + "Welcome to Slots" + "\n****************"
                + "\n1. Play\n2. Rules\n3. Exit\nEnter either 1-3 to navigate. \n");

        // Capture user input-- user must enter an integer
        int menuChoice = sc.nextInt();

        switch(menuChoice){
            case 1:
                // Game loop
                while(true){
                    do {
                        // Prompt user current money value
                        System.out.println("\nYou currently have " + money + " dollars.");

                        if (money >= 25.00){
                            System.out.println(
                                    // Prompt user which betting denomination they want to choose
                                    "\n1. $0.50\n2. $1.00\n3. $5.00\n4. $25.00\n5. Exit" +
                                    "\nEnter either 1-4 to choose your denomination or enter 5 to return to the menu.\n");
                        } else if (money >= 5.00){
                            System.out.println(
                                    // Prompt user which betting denomination they want to choose
                                    "\n1. $0.50\n2. $1.00\n3. $5.00\n5. Exit" +
                                    "\nEnter either 1-3 to choose your denomination or enter 5 to return to the menu.\n");
                        } else if (money >= 1.00){
                            System.out.println(
                                    // Prompt user which betting denomination they want to choose
                                    "\n1. $0.50\n2. $1.00\n5. Exit" +
                                    "\nEnter either 1 or 2 to choose your denomination or enter 5 to return to the menu.\n");
                        }else if (money >= 0.50){
                            System.out.println(
                                    // Prompt user which betting denomination they want to choose
                                    "\n1. $0.50\n5. Exit" +
                                            "\nEnter 1 to choose your denomination " +
                                            "or enter 5 to return to the menu.\n");
                        }else {
                            System.out.println("\nLooks like you spent all of your virtual money! Uh-oh.");
                            pressAnyButtonToContinue();
                            System.out.println("...You were kicked out of the casino!"
                                    + "\nYou leave with $" + money + "!\n");
                            menu();
                        }

                        // Try-catch only accept int values
                        try {
                            switch(sc.nextInt()){
                                case 1:
                                    if (money >= 0.50){
                                        denomination=0.50;
                                        break;
                                    } else {
                                        System.out.println("You do not have enough money to put in this much!" +
                                                "\nYou were kicked out of the casino.");
                                    }
                                case 2:
                                    if (money >= 1.00){
                                        denomination=1.00;
                                        break;
                                    } else {
                                        System.out.println("You do not have enough money to put in this much!" +
                                                "\nYou were kicked out of the casino.");
                                    }
                                case 3:
                                        if (money >= 5.00) {
                                            denomination = 5.00;
                                            break;
                                        } else {
                                            System.out.println("You do not have enough money to put in this much!" +
                                                    "\nYou were kicked out of the casino.");
                                        }
                                case 4:
                                    if (money >= 25.00) {
                                        denomination = 25.00;
                                        break;
                                    } else {
                                        System.out.println("You do not have enough money to put in this much!" +
                                                "\nYou were kicked out of the casino.");
                                    }
                                case 5:
                                    menu();
                                    break;

                            }
                        } catch (InputMismatchException e) {
                            sc.next();
                            System.out.println("Please enter either 1-5 to choose your denomination. \n");
                        }
                    } while (!(denomination>0)); // Checks if user put in a bet that is below integer 0

                    // Captures the output of playSlots which is the func that beings the slot machine process
                    userWins = playSlots();

                    switch (userWins) {
                        case 0:
                            money -= denomination;
                            System.out.println("\nWin!\n0pts");
                            break;
                        case 1:
                            money -= denomination;
                            money += 800*denomination;
                            System.out.println("\nBig win!\n" + 800*denomination + " pts");
                            break;
                        case 2:
                            money -= denomination;
                            money += 8*denomination;
                            System.out.println("\nWin!\n" + 80*denomination + " pts");
                            break;
                        case 3:
                            money -= denomination;
                            money += 2.2*denomination;
                            System.out.println("\nWin!\n" + 2.2*denomination + " pts");
                            break;
                        case 4:
                            money -= denomination;
                            money += 2*denomination;
                            System.out.println("\nWin!\n" + 2*denomination + " pts");
                            break;
                        case 5:
                            money -= denomination;
                            money += 1.5*denomination;
                            System.out.println("\nWin!\n" + 1.5*denomination + " pts");
                            break;
                        case 6:
                            money -= denomination;
                            money += 1*denomination;
                            System.out.println("\nWin!\n" + 1*denomination + " pts");
                            break;
                        case 7:
                            money -= denomination;
                            money += .5*denomination;
                            System.out.println("\nWin!\n" + .5*denomination + " pts");
                            break;
                        case 8:
                            money -= denomination;
                            money += 0*denomination;
                            System.out.println("\nWin!\n" + 0*denomination + " pts");
                            break;
                    }

                    if (money <= .49){
                        System.out.println("\nLooks like you spent all of your virtual money! Uh-oh.");
                        pressAnyButtonToContinue();
                        System.out.println("...You were kicked out of the casino!"
                                + "\nYou leave with $" + money + "!\n");
                        menu();
                    }
                }
            case 2:
                System.out.println("*********************************");
                System.out.println("Slots by Patrick Celedio" +
                        "\nThe rule is to just spin to win!");
                System.out.println("*********************************\n");

                pressAnyButtonToContinue();
                menu();
            case 3:
                System.out.println("Thanks for playing!");
                // Exit game
                System.exit(0);
        }
    }
}
