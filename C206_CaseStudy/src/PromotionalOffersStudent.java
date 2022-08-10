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
import java.util.ArrayList;
public class PromotionalOffersStudent {
	
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;
	
	public static void main(String[] args) {
		ArrayList<PromotionalOffers> promotionalofferList = new ArrayList<PromotionalOffers>();
		
		promotionalofferList.add (new PromotionalOffers("Malay Stall","5", "Roti Jala"));
		promotionalofferList.add (new PromotionalOffers("Chinese Stall","6", "Fishball Noodle"));
		promotionalofferList.add (new PromotionalOffers("Indian Stall","4", "Nasi Briyani"));

		int option1 = 0;
		
		while (option1 != OPTION_QUIT) {
			menu();
			
			option1 = Helper.readInt("Enter an option > ");
			
			if (option1 == OPTION_VIEW) {
				
				PromotionalOffersStudent.viewAllPromotionalOffers(promotionalofferList);
				//option1 = Helper.readInt("Enter option > ");
				
			}else if (option1 == OPTION_ADD) {
				
				PromotionalOffersStudent.setHeader("ADD");
				
				addPromotionalOffers(promotionalofferList);
				
				option1 = Helper.readInt("Enter option > ");
		
		    }else if (option1 == OPTION_DELETE) {
		    	PromotionalOffersStudent.setHeader("DELETE");
		    	
		    	PromotionalOffersStudent.deletePromotionalOffers(promotionalofferList);
		    	
		    	option1 = Helper.readInt("Enter option > ");
			}
		} System.out.println("Program end");
	}

	public static void menu() {
		System.out.println("Promotional Offer");
		System.out.println("1. Display all Promotional Offers");
		System.out.println("2. Add a Promotional Offers");
		System.out.println("3. Delete existing Promotional Offers");
		System.out.println("4. Quit");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//================================= Option 1 View (CRUD - Read) =================================
	public static String retrieveAllPromotionalOffers(ArrayList<PromotionalOffers> promotionaloffersList) { 
		String output = "";

		for (int i = 0; i < promotionaloffersList.size(); i++) {

			output += String.format("%-84s", promotionaloffersList.get(i).toString());
		}
		return output;
	}
	
	public static void viewAllPromotionalOffers(ArrayList<PromotionalOffers> promotionaloffersList) {
		Helper.line(80, "-");
		System.out.println("PROMOTIONAL OFFERS LIST");
		Helper.line(80, "-");
	
		String output = String.format("%-20s %-20s %-20s \n", "STALL NAME", "PRICE", "ITEMS");
		 output += retrieveAllPromotionalOffers(promotionaloffersList);	
		System.out.println(output);
	}
	
	//================================= Option 2 Add =================================
		public static void addPromotionalOffers(ArrayList<PromotionalOffers> promotionalofferList) {
			String stall = Helper.readString("Enter Stall Name> ");
			String price = Helper.readString("Enter Price > ");
			String item = Helper.readString("Enter Item Name> ");
			
			promotionalofferList.add(new PromotionalOffers(stall, price, item));
			
			System.out.println("Item has been added.");
			
		}
		
		public static void addPromotionalOffer(ArrayList<PromotionalOffers> promotionalofferList, PromotionalOffers po) {
			
			promotionalofferList.add(po);
		}
			
		
		//================================= Option 3 Delete  =================================
		public static Boolean deletePromotionalOffers (ArrayList<PromotionalOffers> promotionaloffersList) {
			String name1 = Helper.readString("Enter Stall Name: ");

			for (int i = 0; i < promotionaloffersList.size(); i++) {
				
				String name2 = promotionaloffersList.get(i).getStall();
				
				if (name1.equalsIgnoreCase(name2)) {
					promotionaloffersList.remove(i);
				}
			}
			return null;
		}
}
// fiqaa