
public class ManagementCompany {

	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	public final int maxproperty = 5;
	private final int mgmtwidth = 10;
	private final int mgmtdepth = 10;
	private Plot plot;

	public ManagementCompany() {

		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		properties = new Property[maxproperty];
		this.plot = new Plot(0, 0, mgmtwidth, mgmtdepth);
	}

	public ManagementCompany(String name, String taxID, double mgmFee) {

		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		properties = new Property[maxproperty];
		this.plot = new Plot(0, 0, mgmtwidth, mgmtdepth);
	}

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {

		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		properties = new Property[maxproperty];
		this.plot = new Plot(x, y, width, depth);
	}

	public ManagementCompany(ManagementCompany otherCompany) {

		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		properties = new Property[maxproperty];
		this.plot = otherCompany.plot;
	}

	public int getMAX_PROPERTY() {
		return maxproperty;
	}

	public Plot getPlot() {
		return plot;
	}

	public String getName() {
		return name;
	}

	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner);
		return addProperty(property);
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(property);
	}

	public int addProperty(Property property) {
		int rtnValue = -1;
		if (property == null)
			rtnValue = -2;
		else if (!plot.encompasses(property.getPlot()))
			rtnValue = -3;
		else
			for (int i = 0; i < properties.length; i++) {
				if (properties[i] == null) {

					Property p = new Property(property);
					properties[i] = p;
					rtnValue = i;
					break;
				} else if (properties[i].getPlot().overlaps(property.getPlot())) {
					rtnValue = -4;
					break;
				}
			}
		return rtnValue;
	}

	public double totalRent() {
		double totalRent = 0;
		for (int i = 0; i < properties.length && properties[i] != null; i++) {

			totalRent += properties[i].getRentAmount();
		}

		return totalRent;
	}

	public double maxRentProp() {
		return (properties[maxRentPropertyIndex()].getRentAmount());
	}

	private int maxRentPropertyIndex()

	{
		double maxRent = properties[0].getRentAmount();
		int maxIndex = 0;

		for (int i = 0; i < properties.length && properties[i] != null; i++) {
			if (properties[i].getRentAmount() > maxRent) {
				maxRent = properties[i].getRentAmount();
				maxIndex = i;

			}
		}
		return maxIndex;

	}

	public String toString() {

		String pStr = "List of the properties for " + name + ", " + "taxID: " + taxID + "\n";
		pStr += "______________________________________________________\n";

		for (int i = 0; i < properties.length && properties[i] != null; i++) {
			pStr += properties[i] + "\n";

		}
		pStr += "______________________________________________________\n";
		pStr += "\n total management Fee: " + (totalRent() * mgmFeePer) / 100;
		return pStr;
	}

//	public String maxPropertyRent() {
//		// TODO Auto-generated method stub
//		return maxRentProp();
//	}
	public Property getHighestRentPropperty() {
		// TODO Auto-generated method stub
		return properties[maxRentPropertyIndex()];
	}

	public Object getPropertiesCount() {
		// TODO Auto-generated method stub
		return properties.length;
	}

	public double getMgmFeePer() {
		// TODO Auto-generated method stub
		return mgmFeePer;
	}

	public String getTaxID() {
		// TODO Auto-generated method stub
		return taxID;
	}

}
