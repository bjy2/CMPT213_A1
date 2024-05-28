import ca.sfu.cmpt213.as1.Bike;

import java.util.ArrayList;
import java.util.Scanner;

public class BikeSystem {
    private static ArrayList<Bike> bikes = new ArrayList<>();
    private static int nextBikeID = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("**********************************************\n" +
                           "* Bike Registry by Brandon Yang sn 301558726 *\n" +
                           "**********************************************");
        displayMainMenu();
    }

    public static void displayMainMenu() {
        while (true) {
            System.out.println("*************\n" +
                               "* Main Menu *\n" +
                               "*************");
            System.out.println("1. List Bikes");
            System.out.println("2. Add a new Bike");
            System.out.println("3. Remove a Bike");
            System.out.println("4. Change Bike attribute");
            System.out.println("5. DEBUG: Dump objects (toString)");
            System.out.println("6. Exit");
            System.out.print("> ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    displayAllBikes();
                    break;
                case 2:
                    addNewBike();
                    break;
                case 3:
                    deleteBike();
                    break;
                case 4:
                    alterBike();
                    break;
                case 5:
                    displayBikeToString();
                    break;
                case 6:
                    System.out.println("BYE!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void displayAllBikes() {
        System.out.println("******************");
        System.out.println("* List of Bikes: *");
        System.out.println("******************");
        System.out.printf("%-5s %-15s %-10s %-15s %-10s %-5s %n", "ID", "Owner,", "Type,", "Serial,", "Brake,", "Wheel Size");

        for (Bike bike : bikes) {
            System.out.printf("%-5s %-15s %-10s %-15s %-10s %-5s%n",
                    bike.getBikeID(), bike.getOwnerName()+",", bike.getType()+",", bike.getSerialNumber()+",", bike.getBrakeType()+",", bike.getWheelSize());
        }
    }

    public static void addNewBike() {
        System.out.print("Enter Bike owner name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Enter Bike type: ");
        String type = scanner.nextLine();

        System.out.print("Enter Bike's serial number: ");
        String serialNumber = scanner.nextLine();

        System.out.print("Enter Bike's brake type: ");
        String brakeType = scanner.nextLine();

        System.out.print("Enter Bike's wheel size: ");
        int wheelSize = scanner.nextInt();
        scanner.nextLine();

        int bikeID = nextBikeID++;
        bikes.add(new Bike(bikeID, ownerName, type, serialNumber, brakeType, wheelSize));

    }

    public static void deleteBike() {
        displayAllBikes();
        System.out.println("Enter ID to remove (0 to cancel)");
        System.out.print("> ");
        int bikeID = scanner.nextInt();
        scanner.nextLine();

        if (bikeID == 0) {
            return;
        }

        Bike bikeToDelete = null;
        for (Bike bike : bikes) {
            if (bike.getBikeID() == bikeID) {
                bikeToDelete = bike;
                break;
            }
        }

        if (bikeToDelete != null) {
            bikes.remove(bikeToDelete);
            System.out.println("Bike removed successfully!");
        } else {
            System.out.println("Invalid bike ID. Please try again.");
        }
    }

    public static void alterBike() {
        displayAllBikes();
        System.out.println("Enter ID (0 to cancel)");
        System.out.print("> ");
        int bikeID = scanner.nextInt();
        scanner.nextLine();

        Bike bikeToChange = null;
        for (Bike bike : bikes) {
            if (bike.getBikeID() == bikeID) {
                bikeToChange = bike;
                break;
            }
        }
        // Ask Attribute Name then ask for new Value
        if (bikeToChange != null) {
            System.out.println("Which Attribute?");
            System.out.print("> ");

            String attributeChoice = scanner.nextLine();

            switch (attributeChoice) {
                case "Owner":
                    System.out.println("New Value: ");
                    System.out.print("> ");
                    String newOwner = scanner.nextLine();
                    bikeToChange.setOwnerName(newOwner);
                    break;
                case "Type":
                    System.out.println("New Value: ");
                    System.out.print("> ");
                    String newType = scanner.nextLine();
                    bikeToChange.setType(newType);
                    break;
                case "Serial":
                    System.out.println("New Value: ");
                    System.out.print("> ");
                    String newSerial = scanner.nextLine();
                    bikeToChange.setSerialNumber(newSerial);
                    break;
                case "Brake":
                    System.out.println("New Value: ");
                    System.out.print("> ");
                    String newBrake = scanner.nextLine();
                    bikeToChange.setBrakeType(newBrake);
                    break;
                case "Wheel Size":
                    System.out.println("New Value: ");
                    System.out.print("> ");
                    int newWheelSize = scanner.nextInt();
                    bikeToChange.setWheelSize(newWheelSize);
                    break;
                default:
                    System.out.print("Invalid input. Please try again.");
                }
            }
            else {
                System.out.println("Invalid bike ID. Please try again.");
            }
        }

    public static void displayBikeToString() {
        System.out.println("All Bike objects:");
        for (int i = 0; i < bikes.size(); i++) {
            Bike bike = bikes.get(i);
            System.out.println((i + 1) + ". " + bike);
        }
    }
}

