import java.util.Scanner;

class Passenger {
    private String name;
    private int seatNumber;

    public Passenger(String name, int seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}

public class AirlineReservationSystem {
    private static final int NUM_SEATS = 10;
    private Passenger[] seats;
    private Scanner scanner;

    public AirlineReservationSystem() {
        seats = new Passenger[NUM_SEATS];
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the Airline Reservation System");
        System.out.println("1. Reserve Seat");
        System.out.println("2. Cancel Reservation");
        System.out.println("3. View Available Seats");
        System.out.println("4. Exit");
    }

    public void reserveSeat() {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        int seatNumber = findAvailableSeat();
        if (seatNumber != -1) {
            seats[seatNumber] = new Passenger(name, seatNumber);
            System.out.println("Seat reserved successfully. Your seat number is " + seatNumber);
        } else {
            System.out.println("Sorry, all seats are occupied.");
        }
    }

    private int findAvailableSeat() {
        for (int i = 0; i < NUM_SEATS; i++) {
            if (seats[i] == null) {
                return i;
            }
        }
        return -1; // No available seats
    }

    public void cancelReservation() {
        System.out.print("Enter seat number to cancel reservation: ");
        int seatNumber = scanner.nextInt();
        if (seatNumber >= 0 && seatNumber < NUM_SEATS && seats[seatNumber] != null) {
            seats[seatNumber] = null;
            System.out.println("Reservation cancelled successfully.");
        } else {
            System.out.println("Invalid seat number or no reservation found for that seat.");
        }
    }

    public void viewAvailableSeats() {
        System.out.println("Available seats:");
        for (int i = 0; i < NUM_SEATS; i++) {
            if (seats[i] == null) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AirlineReservationSystem reservationSystem = new AirlineReservationSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            reservationSystem.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    reservationSystem.reserveSeat();
                    break;
                case 2:
                    reservationSystem.cancelReservation();
                    break;
                case 3:
                    reservationSystem.viewAvailableSeats();
                    break;
                case 4:
                    System.out.println("Thank you for using the Airline Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
