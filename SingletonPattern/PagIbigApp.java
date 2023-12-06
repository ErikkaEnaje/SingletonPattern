package SingletonPattern;
import java.util.*;

public class PagIbigApp {public static void main(String[] args) {

    // Instantiate the queuing system.
    CentralizedQueuingSystem queuingsSystems = CentralizedQueuingSystem.getInst(); Scanner input = new Scanner(System.in); Random stand = new Random();

    System.out.println("\n\n\n\t\t\t¸,ø¤º°`°º¤ø,¸WELCOME TO THE PAG-IBIG OFFICE'S CENTRALISED QUEUING SYSTEM¸,ø¤º°`°º¤ø,¸");

    while (true) {
        boolean problem;
        do { // If there are no issues with the queuing mechanism at any Help Desk station.
            problem = true;
            System.out.println("\n\n\n\t\t\t Current Status of the Help Desk Station");

            Integer personalVisits = 6;
            for (int i = 0; i < personalVisits; i++) {
                Integer personal = stand.nextInt(2) + 1;
                queuingsSystems.issuenumber(personal);
            }
            System.out.println();

            // Show the current queue number as well as the number of individuals present at each help desk station.
            System.out.println("            CURRENTLY QUEUED NUMBER ");
            System.out.println("            Current Queue Number: " + queuingsSystems.getcurrentqueuenumbers());
            queuingsSystems.displayPersonalVisits();
            System.out.println();
            System.out.print("Is there something wrong? [Y or N]: ");
            String userChoices = input.nextLine().toLowerCase();
            if (userChoices.equals("yes")) {
                problem = false;
            }
        } while (problem);

        /* If there is a problem. */
        System.out.print("\n            What type of Help Desk Station are you? [1, 2]: ");
        Integer helpingStation = input.nextInt();
        System.out.println("\n            Help Desk Station " + helpingStation + "! You are resetting the queueing system.... ");
        System.out.print("                Enter a new queue number.: ");
        Integer newsqueuingnumbers = input.nextInt();
        input.nextLine();

        queuingsSystems.resetqueuingsystem(helpingStation, newsqueuingnumbers); // To the reset queuing system.
        System.out.println("\n\n\n\n\t\t\t New Help Desk Station Status ");
        Integer personalVisits = 4;
        for (int i = 0; i < personalVisits; i++) {
            Integer personal = stand.nextInt(2) + 1;
            queuingsSystems.issuenumber(personal);
        }
        System.out.println();

        // After a reset, each help desk station should display the current queue number and the number of people in it.
        System.out.println("            NEW QUEUED NUMBER ");
        System.out.println("          Current Queue Number: " + queuingsSystems.getcurrentqueuenumbers());
        queuingsSystems.displayPersonalVisits();
        System.out.println();

        //the user if he/she wants to run again the program.
        System.out.print("\n            Do you want to continue with the programme? [Y or N]: ");
        String nextLine = input.nextLine();
        System.out.println();

        if (!nextLine.toLowerCase().equals("y")) {
            System.out.println("Thank you for choosing us. Your health is our priority.!");
            break;
        }
    }
    input.close();
     }
}

