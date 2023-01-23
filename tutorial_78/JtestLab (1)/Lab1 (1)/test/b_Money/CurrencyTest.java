package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	// testing getName method from Currency class. Output should be the name of the currency specified before
	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());
	}
	//testing getRate method from Currency class. Output should be the rate specified before
	@Test
	public void testGetRate() {
		assertEquals(0.15, SEK.getRate(), 0);
		assertEquals(0.20, DKK.getRate(), 0);
		assertEquals(1.5, EUR.getRate(), 0);
	}
	//testing getName method from Currency class. Should be able to set rate of the currency, checking if output is correct
	@Test
	public void testSetRate() {
		EUR.setRate(0.5);
		assertEquals(0.5, EUR.getRate(),0);;
	}

	//testing universalValue method from Currency class. Output should be amount*rate
	@Test
	public void testGlobalValue() {
		assertEquals(10 * 1.5, EUR.universalValue(10), 0);;
	}
	//testing valueInThisCurrency method from Currency class.Should be able to calculate one currency into another one
	@Test
	public void testValueInThisCurrency() {
		assertEquals((int)(100 * 1.5 / 0.20), DKK.valueInThisCurrency(100, EUR), 0);
	}
}
