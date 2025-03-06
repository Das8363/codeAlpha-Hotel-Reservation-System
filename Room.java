package Hotel;
public class Room {
	private int roomNumber;
	private String category;
	private boolean isAvailable;
	private double pricePerNight;

	public Room(int roomNumber, String category, double pricePerNight) {
		this.roomNumber = roomNumber;
		this.category = category;
		this.isAvailable = true; // Assume all rooms are available initially
		this.pricePerNight = pricePerNight;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getCategory() {
		return category;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public String toString() {
		return "Room #" + roomNumber + " - " + category + " - $" + pricePerNight + " per night";
	}
}
