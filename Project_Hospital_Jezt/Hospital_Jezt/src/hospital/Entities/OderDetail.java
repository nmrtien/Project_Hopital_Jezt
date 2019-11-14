package hospital.Entities;



public class OderDetail {
	
	private int oddId;
	private String oddMeName;
	private int oddMeQuantity;
	private float oddMePrice;
	private float oddAmount;
	private int odId;
	
	public OderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OderDetail(int oddId, String oddMeName, int oddMeQuantity, float oddMePrice, float oddAmount, int odId) {
		super();
		this.oddId = oddId;
		this.oddMeName = oddMeName;
		this.oddMeQuantity = oddMeQuantity;
		this.oddMePrice = oddMePrice;
		this.oddAmount = oddAmount;
		this.odId = odId;
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

	public float getOddAmount() {
		return oddAmount;
	}

	public void setOddAmount(float oddAmount) {
		this.oddAmount = oddAmount;
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	
	
}
