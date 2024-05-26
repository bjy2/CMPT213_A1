import ca.cmpt213_a1.bike.Bike;

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
            System.out.println("1. List bikes");
            System.out.println("2. Add a new bike");
            System.out.println("3. Remove a bike");
            System.out.println("4. Change bike attributes");
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
        System.out.printf("%-5s %-15s %-10s %-15s %-10s %-5s%n", "ID", "Owner", "Type", "Serial", "Brake", "Wheel Size");

        for (Bike bike : bikes) {
            System.out.printf("%-5s %-15s %-10s %-15s %-10s %-5s%n",
                    bike.getBikeID(), bike.getOwnerName(), bike.getType(), bike.getSerialNumber(), bike.getBrakeType(), bike.getWheelSize());
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

        System.out.println("Bike added successfully!");
    }

    public static void deleteBike() {
        displayAllBikes();
        System.out.print("Enter the bike ID to delete (or 0 to cancel): ");
        int bikeID = scanner.nextInt();
        scanner.nextLine();  // Consume newline

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
            System.out.println("Bike deleted successfully!");
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
            scanner.nextLine();  // Consume newline

            switch (attributeChoice) {
                case 1:
                    System.out.print("Enter new owner's name: ");
                    String newOwner = scanner.nextLine();
                    bikeToChange.setOwnerName(newOwner);
                    break;
                case 2:
                    System.out.print("Enter new bike type: ");
                    String newType = scanner.nextLine();
                    bikeToChange.setType(newType);
                    break;
                case 3:
                    System.out.print("Enter new serial number: ");
                    String newSerialNumber = scanner.nextLine();
                    bikeToChange.setSerialNumber(newSerialNumber);
                    break;
                case 4:
                    System.out.print("Enter new brake type: ");
                    String newBrakeType = scanner.nextLine();
                    bikeToChange.setBrakeType(newBrakeType);
                    break;
                case 5:
                    System.out.print("Enter new wheel size in inches: ");
                    int newWheelSize = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    bikeToChange.setWheelSize(newWheelSize);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Bike attributes updated successfully!");
        } else {
            System.out.println("Invalid bike ID. Please try again.");
        }
    }

    public static void displayBikeToString() {
        System.out.println("Bikes toString():");
        for (Bike bike : bikes) {
            System.out.println(bike);
        }
    }
}

