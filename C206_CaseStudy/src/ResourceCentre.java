import java.util.ArrayList;

public class ResourceCentre {

	public static void main(String[] args) {

		ArrayList<Stall> stallList = new ArrayList<Stall>();
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Ingridients> ingridientsList = new ArrayList<Ingridients>();
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();

		stallList.add(new Stall("Stall1", "Malay STall", 35));
		stallList.add(new Stall("Stall2", "Chinese STall", 35));
		stallList.add(new Stall("Stall3", "Indian STall", 35));
		orderList.add(new Order("CSO1", "Rice", 10));
		orderList.add(new Order("CSO2", "Noodle", 10));
		orderList.add(new Order("CSO3", "Porriage", 10));
		ingredientList.add(new Ingredient("CSI01", "Rice", "1"));
		ingredientList.add(new Ingredient("CSI01", "Noodle", "1"));
		ingredientList.add(new Ingredient("CSI01", "Tomato", "1"));
		promotionList.add(new Promotion("CSP01", "", "1"));
		promotionList.add(new Promotion("CSP02", "", "1"));
		promotionList.add(new Promotion("CSP03", "", "1"));

		int option = 0;

		while (option != 5) {

			ResourceCentre.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				ResourceCentre.viewAllStall(stallList);
				ResourceCentre.viewAllOrder(orderList);
				ResourceCentre.viewAllIngredient(orderList);
				ResourceCentre.viewAllPromotion(orderList);

			} else if (option == 2) {
				// Add a new item
				ResourceCentre.setHeader("ADD");
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a camcorder
					Camcorder cc = inputCamcorder();
					ResourceCentre.addCamcorder(camcorderList, cc);
					System.out.println("Camcorder added");

				} else if (itemType == 2) {
					// Add a Chromebook
					Chromebook cb = inputChromebook();
					ResourceCentre.addChromebook(chromebookList, cb);
					System.out.println("Chromebook added");

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				// Loan item
				ResourceCentre.setHeader("LOAN");
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Loan camcorder
					ResourceCentre.loanCamcorder(camcorderList);
				} else if (itemType == 2) {
					// Loan Chromebook
					ResourceCentre.loanChromebook(chromebookList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 4) {
				// Return item
				ResourceCentre.setHeader("RETURN");
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");

				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					// Return camcorder
					ResourceCentre.returnCamcorder(camcorderList);
				} else if (itemType == 2) {
					// Return Chromebook
					ResourceCentre.returnChromebook(chromebookList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
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
					ResourceCentre.showAvailability(stallList.get(i).getIsAvailable()),
					stallList.get(i).getDueDate(), stallList.get(i).getOpticalZoom());
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
					ResourceCentre.showAvailability(orderList.get(i).getIsAvailable()),
					orderList.get(i).getDueDate(), orderList.get(i).getOpticalZoom());
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
					ingredientList.get(i).getDueDate(), ingredientList.get(i).getOpticalZoom());
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


	// ================================= Option 2 Add an item (CRUD - Create)
	// =================================
	public static Camcorder inputCamcorder() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");

		Camcorder cc = new Camcorder(tag, description, zoom);
		return cc;

	}

	public static void addCamcorder(ArrayList<Camcorder> camcorderList, Camcorder cc) {

		camcorderList.add(cc);

	}

	public static Chromebook inputChromebook() {
		Chromebook cb = null;
		// write your code here

		return cb;

	}

	public static void addChromebook(ArrayList<Chromebook> chromebookList, Chromebook cb) {
		// write your code here
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
}
