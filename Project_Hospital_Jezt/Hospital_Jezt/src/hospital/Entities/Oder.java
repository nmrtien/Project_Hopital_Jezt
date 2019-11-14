package hospital.Entities;

public class Oder {
	
	private int odId;
	private String odName;
	private String odAddress;
	private String odPhone;
	
	public Oder() {
		// TODO Auto-generated constructor stub
	}

	public Oder(int odId, String odName, String odAddress, String odPhone) {
		super();
		this.odId = odId;
		this.odName = odName;
		this.odAddress = odAddress;
		this.odPhone = odPhone;
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public String getOdName() {
		return odName;
	}

	public void setOdName(String odName) {
		this.odName = odName;
	}

	public String getOdAddress() {
		return odAddress;
	}

	public void setOdAddress(String odAddress) {
		this.odAddress = odAddress;
	}

	public String getOdPhone() {
		return odPhone;
	}

	public void setOdPhone(String odPhone) {
		this.odPhone = odPhone;
	}

}
