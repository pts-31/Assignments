package Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class MockitoTest {
	
	RandomMethods methods;
	List<String> list;
	
	@BeforeEach
	void setUp() throws Exception {
		methods=new RandomMethods();
	}

	@AfterEach
	void tearDown() throws Exception {
		methods=null;
	}
	
	@Test
	public void test1()  {
	        //  create mock
	        Employee emp = mock(Employee.class);

	        // define return value for method getUniqueId()
	        when(emp.getId()).thenReturn(43);

	        // use mock in test....
	        assertEquals(emp.getId(), 43);
	}
	
	@Test
	public void test2()  {
	        Comparable<String> c= mock(Comparable.class);
	        when(c.compareTo("Piyusha")).thenReturn(1);
	        when(c.compareTo("Anusha")).thenReturn(2);
	        //assert
	        assertEquals(1, c.compareTo("Anusha"));
	}
	
	@Test
	public void test3() {
		
		when(methods.getProperties("RedMi")).thenReturn(1);

	}
	
	@Test
	public void test4() {
		list=new LinkedList<String>();
		
		when(methods.getSizeOfTheList(list)).thenReturn(5);
	    assertEquals(5, methods.getSizeOfTheList(list));
	}

}
