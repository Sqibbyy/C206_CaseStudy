import java.util.ArrayList;

public class ResourceCentre {

	public static void main(String[] args) {

		ArrayList<Stall> stallList = new ArrayList<Stall>();
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();

		stallList.add(new Stall("Stall1", "Malay STall", 35));
		stallList.add(new Stall("Stall2", "Chinese STall", 35));
		stallList.add(new Stall("Stall3", "Indian STall", 35));
		orderList.add(new Order("CSO1", "Rice", 10));
		orderList.add(new Order("CSO2", "Noodle", 10));
		orderList.add(new Order("CSO3", "Porriage", 10));

		ingredientList.add(new Ingredient("CSI01", "Rice"));
		ingredientList.add(new Ingredient("CSI01", "Noodle"));
		ingredientList.add(new Ingredient("CSI01", "Tomato"));
		
		promotionList.add(new Promotion("CSP01", "One"));
		promotionList.add(new Promotion("CSP02", "One"));
		promotionList.add(new Promotion("CSP03", "One"));

		int option = 0;

		while (option != 5) {

			ResourceCentre.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				ResourceCentre.viewAllStall(stallList);
				ResourceCentre.viewAllOrder(orderList);
				ResourceCentre.viewAllIngredient(ingredientList);
				ResourceCentre.viewAllPromotion(promotionList);

			} else if (option == 2) {
				// Add a new item
				ResourceCentre.setHeader("ADD");
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Stall");
				System.out.println("2. Order");
				System.out.println("3. Ingredient");
				System.out.println("4. Promotion");

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a Stall
					Stall ss = inputStall();
					ResourceCentre.addStall1(stallList, ss);
					System.out.println("Stall added");

				} else if (itemType == 2) {
					// Add a Order
					Order oo = inputOrder();
					ResourceCentre.addOrder(orderList, oo);
					System.out.println("Order added");

				} else if (itemType == 3) {
					// Add Ingredient
					Ingredient ii = inputIngredient();
					ResourceCentre.addIngredient(ingredientList, ii);
					System.out.println("Ingredient added");

				}
				//test

				else if (itemType == 4) {
					// Add Promotion
					Promotion pp = inputPromotion();
					ResourceCentre.addPromotion(promotionList, pp);
					System.out.println("Promotion added");

				}

				else if (option == 5) {
					System.out.println("Bye!");
				} else {
					System.out.println("Invalid option");
				}

			}

		}
	}

	public static void menu() {
		ResourceCentre.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Inventory");
		System.out.println("2. Add item");
		System.out.println("3. Delete");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	// ================================= Option 1 View items (CRUD- Read)
	// =================================
	public static String retrieveAllStall(ArrayList<Stall> stallList) {
		String output = "";

		for (int i = 0; i < stallList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", stallList.get(i).getAssetTag(),
					stallList.get(i).getDescription(),
					ResourceCentre.showAvailability(stallList.get(i).getIsAvailable()), stallList.get(i).getDueDate(),
					stallList.get(i).getOpticalZoom());
		}
		return output;
	}

	public static void viewAllStall(ArrayList<Stall> stallList) {
		ResourceCentre.setHeader("Stall LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION", "AVAILABLE",
				"DUE DATE", "OPTICAL ZOOM");
		output += retrieveAllStall(stallList);
		System.out.println(output);
	}

	public static String retrieveAllOrder(ArrayList<Order> orderList) {
		String output = "";

		for (int i = 0; i < orderList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", orderList.get(i).getAssetTag(),
					orderList.get(i).getDescription(),
					ResourceCentre.showAvailability(orderList.get(i).getIsAvailable()), orderList.get(i).getDueDate(),
					orderList.get(i).getOpticalZoom());
		}
		return output;
	}

	public static void viewAllOrder(ArrayList<Order> orderList) {
		ResourceCentre.setHeader("Order LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION", "AVAILABLE",
				"DUE DATE", "OPTICAL ZOOM");
		output += retrieveAllOrder(orderList);
		System.out.println(output);
	}

	public static String retrieveAllIngredient(ArrayList<Ingredient> ingredientList) {
		String output = "";

		for (int i = 0; i < ingredientList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", ingredientList.get(i).getAssetTag(),
					ingredientList.get(i).getDescription(),
					ResourceCentre.showAvailability(ingredientList.get(i).getIsAvailable()),
					ingredientList.get(i).getDueDate(), ingredientList.get(i).getId());
		}
		return output;
	}

	public static void viewAllIngredient(ArrayList<Ingredient> ingredientList) {
		ResourceCentre.setHeader("Stall LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION", "AVAILABLE",
				"DUE DATE", "OPTICAL ZOOM");
		output += retrieveAllIngredient(ingredientList);
		System.out.println(output);
	}

	public static String retrieveAllPromotion(ArrayList<Promotion> promotionList) {
		String output = "";

		for (int i = 0; i < promotionList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", promotionList.get(i).getAssetTag(),
					promotionList.get(i).getDescription(),
					ResourceCentre.showAvailability(promotionList.get(i).getIsAvailable()),
					promotionList.get(i).getDueDate(), promotionList.get(i).getAssetTag());
		}
		return output;
	}

	public static void viewAllPromotion(ArrayList<Promotion> promotionList) {
		ResourceCentre.setHeader("Stall LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION", "AVAILABLE",
				"DUE DATE", "OPTICAL ZOOM");
		output += retrieveAllPromotion(promotionList);
		System.out.println(output);
	}

	// ================================= Option 2 Add an item (CRUD - Create)
	// =================================

	public static void addStall1(ArrayList<Stall> stallList, Stall ss) {

		stallList.add(ss);

	}

	public static void addOrder(ArrayList<Order> orderList, Order oo) {

		orderList.add(oo);

	}

	public static void addIngredient(ArrayList<Ingredient> ingredientList, Ingredient ii) {

		ingredientList.add(ii);

	}

	public static void addPromotion(ArrayList<Promotion> promotionList, Promotion pp) {

		promotionList.add(pp);

	}

	public static Stall inputStall() {
		Stall ss = null;
		// write your code here

		return ss;

	}

	public static Order inputOrder() {
		Order oo = null;
		// write your code here

		return oo;

	}

	public static Ingredient inputIngredient() {
		Ingredient ii = null;
		// write your code here

		return ii;

	}

	public static Promotion inputPromotion() {
		Promotion pp = null;
		// write your code here

		return pp;

	}

	// ================================= Option 3 Delete (CRUD - Update)
	// =================================
	public static boolean doDeleteStall(ArrayList<Stall> stallList, String id) {
		boolean isDeleted = false;

		for (int i = 0; i < stallList.size(); i++) {
			if (id.equalsIgnoreCase(stallList.get(i).getAssetTag())) {

				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static boolean doDeleteOrder(ArrayList<Order> orderList, String id) {
		boolean isDeleted = false;

		for (int i = 0; i < orderList.size(); i++) {
			if (id.equalsIgnoreCase(orderList.get(i).getAssetTag())) {

				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static boolean doDeleteIngredient(ArrayList<Ingredient> ingredientList, String id) {
		boolean isDeleted = false;

		for (int i = 0; i < ingredientList.size(); i++) {
			if (id.equalsIgnoreCase(ingredientList.get(i).getAssetTag())) {

				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static boolean doDeletePromotion(ArrayList<Promotion> promotionList, String id) {
		boolean isDeleted = false;

		for (int i = 0; i < promotionList.size(); i++) {
			if (id.equalsIgnoreCase(promotionList.get(i).getAssetTag())) {

				isDeleted = true;
			}
		}
		return isDeleted;
	}
}
//
