/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: ${Wafiqah Huda}
 * Student ID: {21034676}
 * Class: {W64F}
 * Date/Time created: 10 Aug 2022
 */

/**
 * @author 21034676
 *
 */
public class PromotionalOffers {
	private String stall;
	private String price;
	private String item;

public PromotionalOffers(String stall, String price, String item) {
	this.stall = stall;
	this.price = price;
	this.item = item;
	}

/**
 * @return the stall
 */
public String getStall() {
	return stall;
}

/**
 * @param stall the stall to set
 */
public void setStall(String stall) {
	this.stall = stall;
}

/**
 * @return the price
 */
public String getPrice() {
	return price;
}

/**
 * @param price the price to set
 */
public void setPrice(String price) {
	this.price = price;
	
//	fiqa
}

/**
 * @return the item
 */
public String getItem() {
	return item;
}

/**
 * @param item the item to set
 */
public void setItem(String item) {
	this.item = item;
}

@Override
public String toString() {
	String output = String.format("%-20s %-20s %-20s \n", getStall(), getPrice(), getItem());
	return output;
}
}
//fiqa
