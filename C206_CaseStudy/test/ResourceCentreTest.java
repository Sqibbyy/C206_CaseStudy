import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ResourceCenterTest {

	private Order cc1;
	private Order cc2;


	private Promotion pc1;
	private Promotion pc2;
	

	private Stall st1;
	private Stall st2;
	

	private Ingredient In1;
	private Ingredient In2;


	private ArrayList<Order> orderList;


	private ArrayList<Promotion> promotionList;


	private ArrayList<Ingredient> ingredientList;

	private ArrayList<Stall> stallList; 
	
	public ResourceCenterTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		cc1 = new Order("CC001", "Prata", 4);
		cc2 = new Order("CC002", "Western Food", 4);


		pc1 = new Promotion("PC001", "breakfast happy hour");
		pc2 = new Promotion("PC002", "Coffee break time");
		
	
		st1 = new Stall("ST001" , "Ah Huat Chicken Rice");
		st2 = new Stall("ST002" , "Muhd Nasi Briyani");
		
	
		In1 = new Ingredient("ST001","Ah Huat Chicken Rice","Chilli paddi", "22/10/22", 40, 22.50, true);
		In2 = new Ingredient("ST002","Muhd Nasi Briyani", "Kampong Chicken", "24/9/22", 50, 82.50, true);
		
		orderList = new ArrayList<Order>();
		promotionList = new ArrayList<Promotion>();
		stallList = new ArrayList<Stall>();
		ingredientList = new ArrayList<Ingredient>();

	}

	@Test
	public void testAddOrder1() {
		
		assertNotNull("Test if there is valid order arraylist to add to", orderList);

		ResourceCenterTest.addOrder(orderList, cc1);
		assertEquals("Test if that order arraylist size is 1?", 1, orderList.size());

		assertSame("Test that order is added same as 1st item of the list?", cc1, orderList.get(0));

	}

	private static void addOrder(ArrayList<Ingredient> orderList2, Order cc12) {
		
	}

	@Test
	public void testAddFoodPromotion() {
		assertNotNull("Test if there is valid Foodcorder arraylist to add to", promotionList);

		ResourceCenterTest.addPromotion(promotionList, pc1);
		assertEquals("Test if that Foodcorder arraylist size is 1?", 1, promotionList.size());

		assertSame("Test that Foodcorder is added same as 1st item of the list?", pc1, promotionList.get(0));

	}

	private static void addPromotion(ArrayList<Promotion> promotionList2, Promotion pc12) {
		
	}

	@Test
	public void testRetrieveAllorder() {
		assertNotNull("Test if there is valid order arraylist to add to", orderList);

		String allOrder = ResourceCenterTest.retrieveAllOrder(orderList);
		String testOutput = "";
		assertEquals("Check that ViewAllorderlist", testOutput, allOrder);

		ResourceCenterTest.addOrder(orderList, cc1);
		ResourceCenterTest.addOrder(orderList, cc2);
		assertEquals("Test if that order arraylist size is 2?", 2, orderList.size());

		// from the SourceCentre
		allOrder = ResourceCenterTest.retrieveAllOrder(orderList);

		testOutput = String.format("%-10s %-30s %-10s\n", "CC001", "Prata", 4);
		testOutput += String.format("%-10s %-30s %-10s\n", "CC002", "Western Food", 4);

		assertEquals("Check that ViewAllorderlist", testOutput, allOrder);

	}

	private static String retrieveAllOrder(ArrayList<Order> orderList2) {
		return null;
	}

	@Test
	public void testDoReturnorder() {
		// boundary
		assertNotNull("Test if there is valid order arraylist to add to", orderList);
		ResourceCenterTest.addOrder(orderList, cc1);
		// error
		Boolean isReturned = ResourceCenterTest.doReturnOrder(orderList, "CC001");
		assertTrue("Test if available Foodcorder CC001 is returned -false?", isReturned);
		// normal
//		
		isReturned = ResourceCenterTest.doReturnOrder(orderList, "CC0013");
		assertFalse("Test if non-existing amcorder CC0013 is returned - false?", isReturned);

	}

	private static Boolean doReturnOrder(ArrayList<Ingredient> orderList2, String string) {
		return null;
	}

	@Test
	public void testRetrieveAllPromotions() {
		assertNotNull("Test if there is a valid promotioncorder array to add to", promotionList);
		String allPromotioncorder = ResourceCenterTest.retrieveAllPromotion(promotionList);
		String testOutput = "";
		assertEquals("Check that ViewAllPromotionslist", testOutput, allPromotioncorder);

		ResourceCenterTest.addPromotion(promotionList, pc1);
		ResourceCenterTest.addPromotion(promotionList, pc2);
		assertEquals("Test if that promotion arraylist size is 2?", 2, promotionList.size());

		
		allPromotioncorder = ResourceCenterTest.retrieveAllPromotion(promotionList);

		testOutput = String.format("%-10s %-30s %-10s\n", "PC001", "breakfast happy hour", 3);
		testOutput += String.format("%-10s %-30s %-10s\n", "PC002", "Coffee break time", 3);

		assertEquals("Check that ViewAllPromotionlist", testOutput, allPromotioncorder);

	}
	
	private static String retrieveAllPromotion(ArrayList<Promotion> promotionList2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testDoReturnPromotion() {
		assertNotNull("Test if there is valid Promotion arraylist to add to", promotionList);
		ResourceCenterTest.addPromotion(promotionList, pc1);
		Boolean isReturned = ResourceCenterTest.doReturnPromotion(promotionList, "PC001");
		assertTrue("Test if available Promotion PC001 is returned -false?", isReturned);
		
		isReturned = ResourceCenterTest.doReturnPromotion(promotionList, "PC0013");
		assertFalse("Test if non-existing amcorder PC0013 is returned - false?", isReturned);

	}
	
	private static Boolean doReturnPromotion(ArrayList<Promotion> promotionList2, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testRetrieveAllStall() {
		assertNotNull("Test if there is a valid stallcorder array to add to", stallList);
		String allStallcorder = ResourceCenterTest.retrieveAllStall(stallList);
		String testOutput = "";
		assertEquals("Check that ViewAllStalllist", testOutput, allStallcorder);

		ResourceCenterTest.addStall(stallList, st1);
		ResourceCenterTest.addStall(stallList, st2);
		assertEquals("Test if that stall arraylist size is 2?", 2, stallList.size());

		
		allStallcorder = ResourceCenterTest.retrieveAllStall(stallList);

		testOutput = String.format("%-10s %-30s\n", "ST001", "Ah Huat Chicken Rice");
		testOutput += String.format("%-10s %-30s\n", "ST002", "Muhd Nasi Briyani");

		assertEquals("Check that ViewAllStalllist", testOutput, allStallcorder);

	}
	
	private static String retrieveAllStall(ArrayList<Stall> stallList2) {
		return null;
	}

	private static void addStall(ArrayList<Stall> stallList2, Stall st12) {
		
	}

	@Test
	public void testAddStall() {
		assertNotNull("Test if there is valid stall arraylist to add to", stallList);

		ResourceCenterTest.addStall(stallList, st1);
		assertEquals("Test if that stall arraylist size is 1?", 1, stallList.size());

		assertSame("Test that stall is added same as 1st item of the list?", st1, stallList.get(0));

	}
	
	@Test
	public void testDoReturnStall() {
		assertNotNull("Test if there is valid Stall arraylist to add to", stallList);
		ResourceCenterTest.addStall(stallList, st1);
		Boolean isReturned = ResourceCenterTest.doDeleteStall(stallList, "ST001");
		assertTrue("Test if available Stall ST001 is returned -false?", isReturned);
		
		isReturned = ResourceCenterTest.doDeleteStall(stallList, "ST0013");
		assertFalse("Test if non-existing stall ST0013 is returned - false?", isReturned);

	}
	private static Boolean doDeleteStall(ArrayList<Stall> stallList2, String string) {
		return null;
	}

	@Test
	public void testAddOrder() {
		assertNotNull("Test if there is valid order arraylist to add to", orderList);

		ResourceCenterTest.addStall(stallList, st1);
		
		ResourceCenterTest.addOrder(stallList,orderList,In1);
		assertEquals("Test if that order arraylist size is 1?", 1, orderList.size());

		assertSame("Test that stall is added same as 1st item of the list?", In1, orderList.get(0));

	}
	private static void addOrder(ArrayList<Stall> stallList2, ArrayList<Ingredient> orderList2, Ingredient in12) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testDeleteOrder() {
		assertNotNull("Test if there is valid order arraylist to add to", orderList);
		ResourceCenterTest.addStall(stallList, st1);
		
		ResourceCenterTest.addOrder(stallList,orderList, In1);
		assertEquals("Test if that stall arraylist size is 1?", 1, orderList.size());
		
		Boolean Isdelete = ResourceCenterTest.doDeleteOrder(orderList, "ST001", "Chilli paddi");
		assertTrue("Test that stall is added same as 1st item of the list?", Isdelete);
		Isdelete = ResourceCenterTest.doDeleteOrder(orderList, "ST001", "In1");
		assertFalse("Test if non-existing stall ST0013 is returned - false?", Isdelete);
	
	}
	private static Boolean doDeleteOrder(ArrayList<Ingredient> orderList2, String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testRetrieveAllOrder() {
		assertNotNull("Test if there is a valid order array to add to", orderList);
		String allorder = ResourceCenterTest.retrieveAllOrder(orderList);
		String testOutput = "";
		assertEquals("Check that ViewAllorderlist", testOutput, allorder);

		ResourceCenterTest.addStall(stallList, st1); 
		ResourceCenterTest.addStall(stallList, st2);
		
		ResourceCenterTest.addOrder(stallList,orderList, In1);
		ResourceCenterTest.addOrder(stallList,orderList, In2);
		assertEquals("Test if that stall arraylist size is 2?", 2, orderList.size());

		
		allorder = ResourceCenterTest.retrieveAllOrder(orderList);

		testOutput = String.format("%-10s %-25s %-25s %-20s %-10s %-10s %-10s\n", "ST001", "Ah Huat Chicken Rice","Chilli paddi", "22/10/22", 40, 22.50, "Yes");
		testOutput += String.format("%-10s %-25s %-25s %-20s %-10s %-10s %-10s\n", "ST002", "Muhd Nasi Briyani","Kampong Chicken", "24/9/22", 50, 82.50, "Yes"); 

		assertEquals("Check that ViewAllorderlist", testOutput, allorder);

	}

	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		pc1 = null;
		pc2 = null;
		st1 = null;
		st2 = null;
		In1 = null;
		In2 = null;
		

		promotionList = null;
		stallList = null;
		orderList = null;

	}

}
