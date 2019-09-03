package com.globant.training.app;

import org.testng.Assert;
import org.testng.annotations.*;

public class AppTest{

   private Calculator calc;

   public AppTest() {
     this.calc = new Calculator();
   }

  
   @Test
   public void additionTest() {
       System.out.print("Test: Addition Result -> ");
       try {
    	   Assert.assertEquals(calc.add(2,3),5);
    	} catch (AssertionError e) {
    	    System.out.println("Not equal");
    	    throw e;
    	}
       System.out.println("Equal");
   }

}