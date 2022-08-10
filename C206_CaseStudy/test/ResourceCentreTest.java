import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// C206 AY2022 SEM1 - Eclipse 21-09 JDK16
public class ResourceCentreTest {
	// prepare test data
	public static void main(String[] args) {


		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		ArrayList<Stall> stallList = new ArrayList<Stall>();
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();


		Order cc1 = new Order("CC001", "Roti prata", 4);
		Order cc2 = new Order("CC002", "Fish and Chips", 4);

		Promotion pc1 = new Promotion("PC001", "breakfast time");
		Promotion pc2 = new Promotion("PC002", "Break time");

		Stall st1 = new Stall("ST001","Raju Roti");
		Stall st2 = new Stall("ST002","western sedap");

		Ingredient ig1 = new Ingredient("ST001","Raju Roti ", "Egg", "05/05/2022", 10, 1.5, false);
		Ingredient ig2 = new Ingredient("ST002","western sedap", "Fish", "06/06/2022", 20, 2.0, false);


	    orderList.add(cc1);
		orderList.add(cc2);
		promotionList.add(pc1);
		promotionList.add(pc2);
		stallList.add(st1);
		stallList.add(st2);
		ingredientList.add(ig1);
		ingredientList.add(ig2);

		// Promotion

		int option = 0;

		while (option != 5) {

			ResourceCentre.menu();
			option = Helper.readInt("Enter an option > ");


			// PROMOTION OPTION
			if (option == 1) {

				while (option != 5) {

					ResourceCentre.promotion();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all items
						Promotion.viewAllPromotion(promotionList);


					} else if (option == 2) {
						// Add a new item
						Promotion.setHeader("ADD");			

						Promotion cc = inputPromotion();
						Promotion.addPromotion(promotionList, cc);
						System.out.println("Promotion added");

					} 


					else if (option == 3) {
						// Return item
						Promotion.setHeader("RETURN");				

						String tag = Helper.readString("Enter promo tag > ");
						Promotion.returnPromotion(promotionList, tag);
						

					} else if (option == 5) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}	
				option = 0;
				
			} 

			// FOOD OPTION
			else if (option == 2) {

				while (option != 5) {

					ResourceCentre.food();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all items
						ResourceCentre.viewAllOrder(orderList);


					} else if (option == 2) {
						// Add a new item
						ResourceCentre.setHeader("ADD");      

						Order cc = inputFood();
						ResourceCentre.addOrder(orderList, cc);
						System.out.println("Food added");

					} 

					else if (option == 3) {
						// Return item
						ResourceCentre.setHeader("RETURN");        

						String tag = Helper.readString("Enter food tag > ");
						ResourceCentre.returnOrder(orderList, tag);
					}

					 else if (option == 5) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}

				}
				option = 0;


			} 
			//STALL OPTION
			else if (option == 3) {
				while (option != 5) {
					ResourceCentre.stallMenu();
					option = Helper.readInt("Enter an option > ");
					if (option == 1) {
						ResourceCentre.viewAllStall(stallList);

					} else if (option == 2){
						ResourceCentre.setHeader("ADD STALL");      

						Stall st = inputStall();
						ResourceCentre.addStall(stallList, st);
						System.out.println("Stall added");

					} else if (option == 3){
						ResourceCentre.setHeader("DELETE STALL");        

						String id = Helper.readString("Enter Stall ID > ");
						ResourceCentre.doDeleteStall(stallList, id);

					} else if (option == 5) {
						System.out.println("Good bye!");
						
					} else {
						System.out.println("Invalid Option");

					}
				}
				option = 0;
				
				//ORDER OPTION
			} else if (option == 4) {

				while (option != 5) {
					ResourceCentre.ingredientMenu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						ResourceCentre.viewAllOrder(orderList);

					}else if (option == 2){
						ResourceCentre.setHeader("ADD ORDER of INGREDIENT");      

						
						ResourceCentre.addIngredient(ingredientList);

					}else if (option == 3){
						ResourceCentre.setHeader("DELETE ORDER");        

						String stallId = Helper.readString("Enter Stall ID > ");
						String ingrName = Helper.readString("Enter Ingredient Name > ");
						ResourceCentre.deleteOrder(orderList, stallId, ingrName);

					} else if (option == 5) {
						System.out.println("Good bye!");

					} else {
						System.out.println("Invalid Option");

					}
				}
				option = 0;
						
			} else if (option == 5) {
				System.out.println("Bye!");
			} else {

				System.out.println("Invalid option");
			}


		}

	}

	public static void menu() {
		ResourceCentre.setHeader("CANTEEN APP");
		System.out.println("1. Promotions");
		System.out.println("2. Food");
		System.out.println("3. Stalls");
		System.out.println("4. Request Order");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

	public static void promotions() {
		Promotion.setHeader("FOOD PROMOTION APP");
		System.out.println("1. Display promotions");
		System.out.println("2. Add promotion");
		System.out.println("3. Delete promotion");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

	public static void food() {
		Promotion.setHeader("FOOD MENU APP");
		System.out.println("1. Display food");
		System.out.println("2. Add food");
		System.out.println("3. Delete food");
//		System.out.println("4. Ingredients");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}


	//================================= Option 1 View items (CRUD- Read) =================================
	public static String retrieveAllFood(ArrayList<Order> foodList) {
		String output = "";

		for (int i = 0; i < foodList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", foodList.get(i).getAssetTag(),
					foodList.get(i).getName(), 
					foodList.get(i).getOpticalZoom());
		}
		return output;
	}
	public static void viewAllFood(ArrayList<Order> foodList) {
		ResourceCentre.setHeader("FOOD LIST");
		String output = String.format("%-10s %-30s %-10s\n", "FOOD TAG", "FOOD",
				"PRICE");
		output += retrieveAllFood(foodList);	
		System.out.println(output);
	}

	//================================= Option 1 View Promotions (CRUD- Read) =================================
	public static String retrieveAllPromotion(ArrayList<Promotion> promotionList) {
		String output = "";

		for (int i = 0; i < promotionList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", promotionList.get(i).getAssetTag(),
					promotionList.get(i).getName(), 
					promotionList.get(i).getpromotionalOffers());
		}
		return output;
	}
	public static void viewAllPromotion(ArrayList<Promotion> promotionList) {
		Promotion.setHeader("PROMOTION LIST");
		String output = String.format("%-10s %-30s %-10s\n", "PROMO TAG", "PROMOTION",
				"PRICE");
		output += retrieveAllPromotion(promotionList);	
		System.out.println(output);
	}



	//================================= Option 2 Add an item (CRUD - Create) =================================
	public static Order inputFood() {
		String tag = Helper.readString("Enter food tag > ");
		String name = Helper.readString("Enter food > ");
		int price = Helper.readInt("Enter food price > ");

		Order cc= new Order(tag, name, price);
		return cc;

	}
	public static void addFoodcorder(ArrayList<Order> foodList, Order cc) {

		foodList.add(cc);

	}


	//================================= Option 2 Add promotion (CRUD - Create) =================================
	public static Promotion inputPromotion() {
		String tag = Helper.readString("Enter promo tag > ");
		String name = Helper.readString("Enter promotion > ");
		int price = Helper.readInt("Enter promotion price > ");

		Promotion cc= new Promotion(tag, name);
		return cc;

	}
	public static void addPromotion(ArrayList<Promotion> promotionList, Promotion cc) {

		promotionList.add(cc);

	}

	//================================= Option 2 Return an item (CRUD - Update)=================================
	public static boolean doReturnFoodcorder(ArrayList<Order> foodList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < foodList.size(); i++) {
			if (tag.equalsIgnoreCase(foodList.get(i).getAssetTag())
					) {
				foodList.get(i).setIsAvailable(true);
				isReturned = true;
			}
		}
		return isReturned;

	}

	public static void returnFoodcorder(ArrayList<Order> foodList, String tag) {
		Boolean isReturned = doReturnFoodcorder(foodList, tag);

		if (isReturned == false) {
			System.out.println("Invalid food tag");

		} else {
			for (int i = 0; i < foodList.size(); i++) {
				if (tag.equalsIgnoreCase(foodList.get(i).getAssetTag())
						) {
					foodList.remove(foodList.get(i));
				}
			}
			System.out.println("food " + tag + " deleted");
		}

	}


	//================================= Option 2 Delete Promotion (CRUD - Update)=================================
	public static boolean doReturnPromotion(ArrayList<Promotion> promotionList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < promotionList.size(); i++) {
			if (tag.equalsIgnoreCase(promotionList.get(i).getAssetTag())
					) {
				promotionList.get(i).setIsAvailable(true);
				isReturned = true;
			}
		}
		return isReturned;
	}

	public static void returnPromotion(ArrayList<Promotion> promotionList, String tag) {
		Boolean isReturned = doReturnPromotion(promotionList, tag);

		if (isReturned == false) {
			System.out.println("Invalid promo tag");

		} else {
			for (int i = 0; i < promotionList.size(); i++) {
				if (tag.equalsIgnoreCase(promotionList.get(i).getAssetTag())
						) {
					promotionList.remove(promotionList.get(i));
				}
			}
			System.out.println("promotion " + tag + " deleted");
		}

	}

	//================================= Option 3 Stall (CRUD - Update)=================================
	public static void stallMenu() {
		ResourceCentre.setHeader("Stall Menu");
		System.out.println("1. View Stall List");
		System.out.println("2. Add Stall");
		System.out.println("3. Delete Stall");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	public static String retrieveAllStall(ArrayList<Stall> stallList) {
		String output = "";

		for (int i = 0; i < stallList.size(); i++) {
			output += String.format("%-10s %-30s\n", stallList.get(i).getStallId(),
					stallList.get(i).getName());
		}
		return output;
	}

	public static void viewAllStall(ArrayList<Stall> stallList) {
		ResourceCentre.setHeader("STALL LIST");
		String output = String.format("%-10s %-10s\n", "STALL ID", "STALL NAME");
		output += retrieveAllStall(stallList);	
		System.out.println(output);
	}

	public static Stall inputStall() {
		String stId = Helper.readString("Enter stall ID > ");
		String name = Helper.readString("Enter Stall Name> ");

		Stall st = new Stall(stId, name);
		return st;

	}

	public static void addStall(ArrayList<Stall> stallList, Stall st) {

		stallList.add(st);

	}

	public static boolean doDeleteStall(ArrayList<Stall> stallList,String id) {
		boolean isDeleted = false;

		for (int i = 0; i < stallList.size(); i++) {
			if (id.equalsIgnoreCase(stallList.get(i).getStallId())) {

				isDeleted = true;

			}
		}
		return isDeleted;
	}

	public static void deleteStall(ArrayList<Stall> stallList, String id) {
		Boolean isDeleted = doDeleteStall(stallList, id);

		if (isDeleted== false) {
			System.out.println("Stall ID not found.");

		} else {
			for (int i = 0; i < stallList.size(); i++) {
				if (id.equalsIgnoreCase(stallList.get(i).getStallId())) {
					stallList.remove(stallList.get(i));
				}
			}
			System.out.println("Stall " + id + " deleted");
		}

	}

	//================================= Option 4 Ingredient (CRUD - Update)=================================
	public static void ingredientMenu() {
		ResourceCentre.setHeader("Order Menu");
		System.out.println("1. View Order List");
		System.out.println("2. Add Order");
		System.out.println("3. Delete Order");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	public static String retrieveAllOrder(ArrayList<Ingredient> orderList) {
		String output = "";

		for (int i = 0; i < orderList.size(); i++) {

			output += String.format("%-110s\n", orderList.get(i).toString());
		}
		return output;
	}

	public static void viewAllOrder(ArrayList<Ingredient> orderList) {
		ResourceCentre.setHeader("INGREDIENT LIST");
		String output = String.format("%-10s %-25s %-25s %-20s %-10s %-10s %-10s\n", "STALL ID","STALL NAME", "INGREDIENT NAME",
				"ORDER DATE", "QUATITY","PRICE","DELIVERED");
		output += retrieveAllOrder(orderList);	
		System.out.println(output);
	}

	public static Ingredient inputOrder(ArrayList<Stall> stallList) {
		String stId = Helper.readString("Enter stall ID > ");
		String stName = "";
		for (int i = 0; i < stallList.size(); i++) {
			if (stId.equalsIgnoreCase(stallList.get(i).getStallId())) {
				stName = stallList.get(i).getName();
			}
		}

		String name = Helper.readString("Enter Ingredient Name > ");
		String orderDate = Helper.readString("Enter Date of Order > ");
		int quantity = Helper.readInt("Enter Quantity > ");
		double price = Helper.readDouble("Enter Ingredient Price > ");
		boolean isDelivered = Helper.readBoolean("Enter Delivered Status > ");

		Ingredient or = new Ingredient(stId, stName, name, orderDate, quantity, price, isDelivered);
		return or;

	}

	public static void addOrder(ArrayList<Stall> stallList, ArrayList<Ingredient> orderList, Ingredient or) {
		boolean able = false;

		for (int i = 0; i < stallList.size(); i++) {
			if (or.getStallId().equalsIgnoreCase(stallList.get(i).getStallId())) {
				able = true;
			}
		}
		if (able) {
			orderList.add(or);
			System.out.println("Order Successfully Added");
		
		} else {
			System.out.println("Order Cannot be Added as Stall does not exist");
		}

	}

	public static boolean doDeleteOrder(ArrayList<Ingredient> orderList, String stallId, String ingrName) {
		boolean isDeleted = false;
		//check for ingredient name and stall
		for (int i = 0; i < orderList.size(); i++) {
			if (stallId.equalsIgnoreCase(orderList.get(i).getStallId()) && ingrName.equalsIgnoreCase(orderList.get(i).getName())) {

				isDeleted = true;

			}
		}
		return isDeleted;
	}

	public static void deleteOrder(ArrayList<Ingredient> orderList, String stallId, String ingrName) {
		Boolean isDeleted = doDeleteOrder(orderList, stallId, ingrName);
		String igName = "";
		int igAmt = 0;
		String stName = "";

		if (isDeleted == false) {
			System.out.println("Stall and/or Order Name not found.");

		} else {

			for (int i = 0; i < orderList.size(); i++) {
				if (stallId.equalsIgnoreCase(orderList.get(i).getStallId()) && ingrName.equalsIgnoreCase(orderList.get(i).getName())) {
					igName = orderList.get(i).getName();
					igAmt = orderList.get(i).getQuantity();
					stName = orderList.get(i).getName();
					orderList.remove(orderList.get(i));

				}

			}
			System.out.println("Order of " + igAmt + " " + igName + " from" + stName + " deleted");
		}

	}

}
