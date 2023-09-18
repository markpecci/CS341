package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import pecci.Fraction;

public class FractionTest {

	@Test
	public void testFraction() {
		
		//declare 4 fraction objects
		Fraction fr1 = new Fraction("1/8");
		Fraction fr2 = new Fraction("3/8");
		Fraction fr3 = new Fraction("2/8");
		Fraction fr4 = new Fraction("2/8");

		//display each fraction	
		System.out.println(fr1);
		System.out.println(fr2);
		System.out.println(fr3);
		System.out.println(fr4);

		// add all and display
		Fraction sum = new Fraction("0/1");
		sum.add(fr1);
		sum.add(fr2);
		sum.add(fr3);
		sum.add(fr4);
		
		System.out.println("Sum of all fractions: " + sum);
		
		fail("Not yet implemented");
	}

}
