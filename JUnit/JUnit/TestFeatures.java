import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFeatures {

	RandomFeatures feature;
	
	@BeforeEach
	void setUp() throws Exception {
		feature=new RandomFeatures();
	}

	@AfterEach
	void tearDown() throws Exception {
		feature=null;
	}

	@Test
	void testFindMax() {
		int[] arr= new int[] {4,7,3,9,1,5};
		assertEquals(9, feature.findMax(arr));
	}
	
	@Test
	void testSearchContact() {
		feature.addContact(9702786106L, "Anusha");
		assertEquals(9702786106L, feature.searchContact("Anusha"));
	}

	@Test
	void testGetFrequency() {
		ArrayList<String> arr=new ArrayList<String>(Arrays.asList("abc","pqr","abc","xyz","lmn","abc"));
		assertEquals(3, feature.getFrequency(arr, "abc"));
	}
}
