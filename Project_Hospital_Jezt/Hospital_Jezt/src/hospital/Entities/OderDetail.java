package hospital.Entities;

import java.util.Date;

public class OderDetail {
	
	private int oddId;
	private String oddMeName;
	private Date oddCreated;
	private int oddMeQuantity;
	private float oddMePrice;
	private int odId;
	private int meId;
	
	public OderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OderDetail(int oddId, String oddMeName, Date oddCreated, int oddMeQuantity, float oddMePrice, int odId,
			int meId) {
		super();
		this.oddId = oddId;
		this.oddMeName = oddMeName;
		this.oddCreated = oddCreated;
		this.oddMeQuantity = oddMeQuantity;
		this.oddMePrice = oddMePrice;
		this.odId = odId;
		this.meId = meId;
	}

	public int getOddId() {
		return oddId;
	}

	public void setOddId(int oddId) {
		this.oddId = oddId;
	}

	public String getOddMeName() {
		return oddMeName;
	}

	public void setOddMeName(String oddMeName) {
		this.oddMeName = oddMeName;
	}

	public Date getOddCreated() {
		return oddCreated;
	}

	public void setOddCreated(Date oddCreated) {
		this.oddCreated = oddCreated;
	}

	public int getOddMeQuantity() {
		return oddMeQuantity;
	}

	public void setOddMeQuantity(int oddMeQuantity) {
		this.oddMeQuantity = oddMeQuantity;
	}

	public float getOddMePrice() {
		return oddMePrice;
	}

	public void setOddMePrice(float oddMePrice) {
		this.oddMePrice = oddMePrice;
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public int getMeId() {
		return meId;
	}

	public void setMeId(int meId) {
		this.meId = meId;
	}
	
	
	
}
