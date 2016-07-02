package instavans.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Job {
	
	@Id
	@GeneratedValue
	private int id;
	private Date date;
	private double lat;
	private double lang;
	private int numOfPorters;
	private String locationName;
	private int money;
	
	
	
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getNumOfPorters() {
		return numOfPorters;
	}
	public void setNumOfPorters(int numOfPorters) {
		this.numOfPorters = numOfPorters;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLang() {
		return lang;
	}
	public void setLang(double lang) {
		this.lang = lang;
	}
	public int getRequiredNumOfPorters() {
		return numOfPorters;
	}
	public void setRequiredNumOfPorters(int requiredNumOfPorters) {
		this.numOfPorters = requiredNumOfPorters;
	}
	
	
	

}
