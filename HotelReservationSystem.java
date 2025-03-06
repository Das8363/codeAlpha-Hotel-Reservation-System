package Hotel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HotelReservationSystem {
	private static Hotel hotel = new Hotel();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n--- Hotel Reservation System ---");
			System.out.println("1. Search Available Rooms");
			System.out.println("2. Make Reservation");
			System.out.println("3. View Reservations");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				searchAvailableRooms();
				break;
			case 2:
				makeReservation();
				break;
			case 3:
				hotel.viewReservations();
				break;
			case 4:
				System.out.println("Thank you for using the Hotel Reservation System!");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void searchAvailableRooms() {
		System.out.print("Enter check-in date (YYYY-MM-DD): ");
		String checkInDateStr = scanner.nextLine();
		System.out.print("Enter check-out date (YYYY-MM-DD): ");
		String checkOutDateStr = scanner.nextLine();

		// Convert the date strings to Date objects (You can use a better date parsing
		// method)
		Date checkInDate = new Date(checkInDateStr);
		Date checkOutDate = new Date(checkOutDateStr);

		ArrayList<Room> availableRooms = hotel.searchAvailableRooms(checkInDate, checkOutDate);
		if (availableRooms.isEmpty()) {
			System.out.println("No rooms available for the selected dates.");
		} else {
			System.out.println("Available Rooms:");
			for (Room room : availableRooms) {
				System.out.println(room);
			}
		}
	}

	private static void makeReservation() {
		System.out.print("Enter your name: ");
		String guestName = scanner.nextLine();

		System.out.print("Enter room number you want to book: ");
		int roomNumber = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.print("Enter check-in date (YYYY-MM-DD): ");
		String checkInDateStr = scanner.nextLine();
		System.out.print("Enter check-out date (YYYY-MM-DD): ");
		String checkOutDateStr = scanner.nextLine();

		// Convert the date strings to Date objects (You can use a better date parsing
		// method)
		Date checkInDate = new Date(checkInDateStr);
		Date checkOutDate = new Date(checkOutDateStr);

		if (hotel.makeReservation(roomNumber, guestName, checkInDate, checkOutDate)) {
			System.out.println("Reservation successful!");
		} else {
			System.out.println("Sorry, the room is not available.");
		}
	}
}
