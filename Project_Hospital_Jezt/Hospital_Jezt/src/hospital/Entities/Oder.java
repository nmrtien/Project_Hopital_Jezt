package hospital.Entities;

public class Oder {
	
	private int odId;
	private String odName;
	private String odCode;
	private float odTotalPrice;
	private int odQuantity;
	private boolean odStatus;
	private int paId;
	
	public Oder() {
		// TODO Auto-generated constructor stub
	}

	public Oder(int odId, String odName, String odCode, float odTotalPrice, int odQuantity, boolean odStatus,
			int paId) {
		
		this.odId = odId;
		this.odName = odName;
		this.odCode = odCode;
		this.odTotalPrice = odTotalPrice;
		this.odQuantity = odQuantity;
		this.odStatus = odStatus;
		this.paId = paId;
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

	public String getOdCode() {
		return odCode;
	}

	public void setOdCode(String odCode) {
		this.odCode = odCode;
	}

	public float getOdTotalPrice() {
		return odTotalPrice;
	}

	public void setOdTotalPrice(float odTotalPrice) {
		this.odTotalPrice = odTotalPrice;
	}

	public int getOdQuantity() {
		return odQuantity;
	}

	public void setOdQuantity(int odQuantity) {
		this.odQuantity = odQuantity;
	}

	public boolean isOdStatus() {
		return odStatus;
	}

	public void setOdStatus(boolean odStatus) {
		this.odStatus = odStatus;
	}

	public int getPaId() {
		return paId;
	}

	public void setPaId(int paId) {
		this.paId = paId;
	}
	
	
	
}
