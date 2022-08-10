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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
/**
 * @author 21034676
 *
 */
public class testPromotionalOffers {
	private PromotionalOffers s1;
	private PromotionalOffers s2;
	private PromotionalOffers s3;
	
	private ArrayList<PromotionalOffers> promotionalofferList;
	@Before
	public void setUp() throws Exception {
		//prepare test data
		s1 = new PromotionalOffers("Malay Stall","5", "Roti Jala");
		s2 = new PromotionalOffers("Chinese Stall","6", "Fishball Noodle");
		s3 = new PromotionalOffers("Indian Stall","4", "Nasi Briyani");
		
		
		promotionalofferList = new ArrayList<PromotionalOffers>();
	}
	@Test
	public void testAddPromotionalOffers() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid promotional offer arraylist to add to", promotionalofferList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		PromotionalOffersStudent.addPromotionalOffers(promotionalofferList);
		assertEquals("Test that promotional offer arraylist size is 1", 1, promotionalofferList.size());
		assertSame("Test that promotional offer is added", s1, promotionalofferList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		PromotionalOffersStudent.addPromotionalOffers(promotionalofferList);
		assertEquals("Test that promotional offer arraylist size is 2", 2, promotionalofferList.size());
		assertSame("Test that promotional offer is added", s2, promotionalofferList.get(1));
	}
	@Test
	public void testRetrieveAllPromotionalOffers() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid  promotional offer arraylist to retrieve item", promotionalofferList);
		
		//test if the list of register retrieved from the SourceCentre is empty - boundary
		String allPromotionalOffers= PromotionalOffersStudent.retrieveAllPromotionalOffers(promotionalofferList);
		String testOutput = "";
		assertEquals("Test that ViewAllPromotionalOffersList", testOutput, promotionalofferList);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		PromotionalOffersStudent.addPromotionalOffers(promotionalofferList);
		PromotionalOffersStudent.addPromotionalOffers(promotionalofferList);
		assertEquals("Test that promotional offer arraylist size is 2?", 2, promotionalofferList.size());
		
		//test if the expected output string same as the list of registers retrieved from the SourceCentre	
		allPromotionalOffers= PromotionalOffersStudent.retrieveAllPromotionalOffers(promotionalofferList);
		testOutput = String.format("001","15.00", "2022-09-13", "Apple");
		testOutput += String.format("002","20.00", "2022-07-19", "Pear");
	
		assertEquals("Test that ViewAllPromotionalOffersList", testOutput, allPromotionalOffers);
		
	}
	@Test
	public void testDeletePromotionalOffers() {
		//boundary
		assertNotNull("test if there is valid promotional offer arraylist to delete from", promotionalofferList);
		
		PromotionalOffersStudent.addPromotionalOffers(promotionalofferList);
	
		// normal
		Boolean ok = PromotionalOffersStudent.deletePromotionalOffers(promotionalofferList);
		assertTrue("Test if an available item is ok to delete?", ok);
		//error condition
		ok = PromotionalOffersStudent.deletePromotionalOffers(promotionalofferList );
		assertFalse("Test if the same item is NOT ok to delete again?", ok);	
		//error condition
		PromotionalOffersStudent.deletePromotionalOffers(promotionalofferList);	
		promotionalofferList.remove(s2);
		ok = PromotionalOffersStudent.deletePromotionalOffers(promotionalofferList);
		assertFalse("Test that un-available item is NOT ok to retrieve?", ok);
		//error condition
		ok = PromotionalOffersStudent.deletePromotionalOffers(promotionalofferList );
		assertFalse("Test that non-exsiting item is NOT ok to retrieve?", ok);
		
	}
	

}
//fiqaa


