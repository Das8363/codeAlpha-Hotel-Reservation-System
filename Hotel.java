package Hotel;


import java.util.ArrayList;
import java.util.Date;

public class Hotel {
	private ArrayList<Room> rooms;
	private ArrayList<Reservation> reservations;

	public Hotel() {
		rooms = new ArrayList<>();
		reservations = new ArrayList<>();

		// Adding some rooms to the hotel
		rooms.add(new Room(101, "Standard", 100));
		rooms.add(new Room(102, "Deluxe", 150));
		rooms.add(new Room(103, "Suite", 250));
		rooms.add(new Room(104, "Standard", 100));
	}

	public ArrayList<Room> searchAvailableRooms(Date checkInDate, Date checkOutDate) {
		ArrayList<Room> availableRooms = new ArrayList<>();
		for (Room room : rooms) {
			if (room.isAvailable()) {
				availableRooms.add(room);
			}
		}
		return availableRooms;
	}

	public boolean makeReservation(int roomNumber, String guestName, Date checkInDate, Date checkOutDate) {
		Room room = null;
		for (Room r : rooms) {
			if (r.getRoomNumber() == roomNumber) {
				room = r;
				break;
			}
		}

		if (room != null && room.isAvailable()) {
			double totalAmount = room.getPricePerNight() * (checkOutDate.getTime() - checkInDate.getTime())
					/ (1000 * 60 * 60 * 24); // Calculate total amount based on days
			Reservation reservation = new Reservation(roomNumber, guestName, checkInDate, checkOutDate, totalAmount);
			reservations.add(reservation);
			room.setAvailable(false); // Mark the room as unavailable
			return true;
		}
		return false;
	}

	public void viewReservations() {
		if (reservations.isEmpty()) {
			System.out.println("No reservations found.");
		} else {
			for (Reservation reservation : reservations) {
				reservation.displayBookingDetails();
			}
		}
	}
}
