package hospital.Entities;

import java.util.Date;

public class Medicine {
	
	private int meId;
	private String meName;
	private float mePrice;
	private String meProducer;
	private String meTitle;
	private String meContent;
	private Date meDateOfManufacture;
	private Date meExpirationDate;
	private String meImage;
	private boolean meStatus;
	private int caId;
	
	public Medicine() {
		// TODO Auto-generated constructor stub
	}

	public Medicine(int meId, String meName, float mePrice, String meProducer, String meTitle, String meContent,
			Date meDateOfManufacture, Date meExpirationDate, String meImage, boolean meStatus, int caId) {
		
		this.meId = meId;
		this.meName = meName;
		this.mePrice = mePrice;
		this.meProducer = meProducer;
		this.meTitle = meTitle;
		this.meContent = meContent;
		this.meDateOfManufacture = meDateOfManufacture;
		this.meExpirationDate = meExpirationDate;
		this.meImage = meImage;
		this.meStatus = meStatus;
		this.caId = caId;
	}

	public int getMeId() {
		return meId;
	}

	public void setMeId(int meId) {
		this.meId = meId;
	}

	public String getMeName() {
		return meName;
	}

	public void setMeName(String meName) {
		this.meName = meName;
	}

	public float getMePrice() {
		return mePrice;
	}

	public void setMePrice(float mePrice) {
		this.mePrice = mePrice;
	}

	public String getMeProducer() {
		return meProducer;
	}

	public void setMeProducer(String meProducer) {
		this.meProducer = meProducer;
	}

	public String getMeTitle() {
		return meTitle;
	}

	public void setMeTitle(String meTitle) {
		this.meTitle = meTitle;
	}

	public String getMeContent() {
		return meContent;
	}

	public void setMeContent(String meContent) {
		this.meContent = meContent;
	}

	public Date getMeDateOfManufacture() {
		return meDateOfManufacture;
	}

	public void setMeDateOfManufacture(Date meDateOfManufacture) {
		this.meDateOfManufacture = meDateOfManufacture;
	}

	public Date getMeExpirationDate() {
		return meExpirationDate;
	}

	public void setMeExpirationDate(Date meExpirationDate) {
		this.meExpirationDate = meExpirationDate;
	}

	public String getMeImage() {
		return meImage;
	}

	public void setMeImage(String meImage) {
		this.meImage = meImage;
	}

	public boolean isMeStatus() {
		return meStatus;
	}

	public void setMeStatus(boolean meStatus) {
		this.meStatus = meStatus;
	}
	
	public int getCaId() {
		return caId;
	}
	
	public void setCaId(int caId) {
		this.caId = caId;
	}
}
