package com.example.app;

import org.junit.Assert;
import org.junit.*;

import com.example.app.*;

import junit.framework.TestCase;



/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	@Test
	public void testEmployeeList() {
	HR obj = new HR();
	Assert.assertArrayEquals(new String[] {"Arun", "Kuldeep", "Monti", "Shalini", "Varun"}, obj.employeeList(App.listOfEmployees));

	}
	
	@Test
	public void testTopPerformers() {
		HR obj = new HR();
		Assert.assertArrayEquals(new String[] { "Varun", "Monti", "Kuldeep"}, obj.topPerformers(App.listOfEmployees, App.parameters));
	}
	
	@Test
	public void testParameterTopper() {
		HR obj = new HR();
		Assert.assertEquals("Monti", obj.parameterTopper(App.listOfEmployees, App.parameters, App.performanceParameters[0]));
	}
	
	@Test
	public void testLazyEmployees() {
		HR obj = new HR();
		Assert.assertArrayEquals(new String[] {"Monti", "Kuldeep", "Shalini"}, obj.lazyEmployees(App.listOfEmployees, App.attendenceList));
	}
    

}
