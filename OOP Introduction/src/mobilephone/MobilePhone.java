package mobilephone;

import java.text.Format;

public class MobilePhone {
	//e.g. make=Apple iPhone, model=11, rating=4    make=Samsung Galaxy, model=S10, rating=2
	private String make, model;
	private int rating;
	
	public MobilePhone() {
		
	}
	
	public MobilePhone(String make, String model, int rating) {
		setMake(make);
		setModel(model);
		setRating(rating);
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setRating(int rating) {
		if(rating>=0 && rating<=5) {
		this.rating = rating;
		} else {
			System.out.println("Enter a valid rating between 0-5");
		}
	}
	
	public int getRating() {
		return rating;
	}
	
	public String toString() {
		return String.format("Make: %s, Model: %s, Rating %d",getMake(),getModel(),getRating());
	}

}
