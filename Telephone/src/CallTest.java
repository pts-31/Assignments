import static org.junit.Assert.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CallTest {

	String s="Piyusha";
	long phNo=97027816107L;
	Date d1 = new Date(97, 10, 27); 
    Date d2 = new Date(97, 6, 12); 
    long d=d2.getTime()-d1.getTime();
    
	short type=0;
	Call call;
	cellPhone cell;
	
	@Before
	public void setUp() throws Exception{
		call=new Call(s,phNo,d1,d2,type);
		cell=new cellPhone();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	public void test() {
		assertEquals("-3312:0:0", call.getDuration(d1, d2));
	}

	@Test
	public void checkSearch() {
		cellPhone.addToTheList(9702786106L, "Anusha");
		assertEquals(9702786106L, cell.searchContact("Anusha"));
	}
	
}
