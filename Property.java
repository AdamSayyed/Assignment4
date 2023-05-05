
/**
 * Represents a Property object
 * 
 * @author khandan
 *
 */
public class Property {

	private String propertyName; // Property name
	private String city; // property location
	private double rentAmount; // Amount of rent
	private String owner; // Owner's name
	private Plot plot; // area covered by this property
	private static int count = 0;

	public Property() {

		propertyName = "";
		city = "";
		rentAmount = 0;
		owner = "";
		plot = new Plot(0, 0, 1, 1);
		count++;
	}

	public Property(Property p) {

		propertyName = p.propertyName;
		city = p.city;
		rentAmount = p.rentAmount;
		owner = p.owner;
		plot = p.getPlot();
		count++;
	}

	public Property(String propertyName, String city, double rentAmount, String owner) {

		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
		count++;
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = setPlot(x, y, width, depth);
		count++;
	}

	public Plot getPlot() {
		return this.plot;
	}

	public Plot setPlot(int x, int y, int width, int depth) {
		return new Plot(x, y, width, depth);
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public void setLoc(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String toString() {
		return "Property Name: " + propertyName + "\n Located in " + city + "\n Belonging to: " + owner
				+ "\n Rent Amount: " + rentAmount;
	}
}
