package SingletonPattern;
public class CentralizedQueuingSystem { private static CentralizedQueuingSystem inst;
    private int currentlyQueueNumbers; private int[] helpingStations; // Number of people at each support desk station[4].
    private boolean resettingQueue;
    private CentralizedQueuingSystem() {
        currentlyQueueNumbers = 1;
        helpingStations = new int[4]; // For four Help Desk Stations.
        resettingQueue = false;
    }
    //Queuing system instance.
    public static synchronized CentralizedQueuingSystem getInst() {
        if (inst == null)
            inst = new CentralizedQueuingSystem();
        return inst;
    }
    //Current queue number.
    public synchronized int getcurrentqueuenumbers() {
        return currentlyQueueNumbers;
    }
    // To assign a new queue number to each every visit to the Help Desk Station.
    public synchronized void issuenumber(int helpingStation) {
        if (!resettingQueue) {
            System.out.println("Help Desk Station " + helpingStation + " has an Individual Visit! New Queue Number: " + currentlyQueueNumbers);
            currentlyQueueNumbers++;
            helpingStations[helpingStation - 1]++;
        } else {
            System.out.println("Reset in progress. Cannot issue new queue number.");
        }
    }
    // Display the number of people at each Help Desk Station.
    public synchronized void displayPersonalVisits() {
        System.out.println("\n      CURRENTLY PERSON VISIT");
        for (int i = 0; i < helpingStations.length; i++) {
            System.out.println("    Helping Desk Station " + (i + 1) + ": " + helpingStations[i] + " Personal");
        }
    }
    // To reset the queueing number based on a number entered.
    public synchronized void resetqueuingsystem(int helpingStationDesk, int newsqueuenumbers) {
        resettingQueue = true;
        currentlyQueueNumbers = newsqueuenumbers;
        helpingStations[helpingStationDesk - 1] = 0;
        System.out.println("\n        NEW STATUS OF QUEUING NUMBERS");
        System.out.println("Help Desk Station Queuing System Reset " + helpingStationDesk + "!");
        System.out.println("Queuing Number: " + newsqueuenumbers);
        System.out.println();
        resettingQueue = false;
    }
}

