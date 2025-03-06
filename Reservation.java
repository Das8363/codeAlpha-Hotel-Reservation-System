package Hotel;

import java.util.Date;

public class Reservation {
	private int roomNumber;
	private String guestName;
	private Date checkInDate;
	private Date checkOutDate;
	private double totalAmount;

	public Reservation(int roomNumber, String guestName, Date checkInDate, Date checkOutDate, double totalAmount) {
		this.roomNumber = roomNumber;
		this.guestName = guestName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalAmount = totalAmount;
	}

	public void displayBookingDetails() {
		System.out.println("Booking Details:");
		System.out.println("Room Number: " + roomNumber);
		System.out.println("Guest Name: " + guestName);
		System.out.println("Check-in Date: " + checkInDate);
		System.out.println("Check-out Date: " + checkOutDate);
		System.out.println("Total Amount: $" + totalAmount);
	}
}
