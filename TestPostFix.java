import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPostFix {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEvaluate1() {
		Postfix pf = new Postfix();
		assertEquals(5, pf.evaluate("1 2 * 3 +"));
	}
	
	@Test
	void testEvaluate2() {
		Postfix pf = new Postfix();
		assertEquals(7, pf.evaluate("1 2 3 * +"));
	}
	
	@Test
	void testEvaluate3() {
		Postfix pf = new Postfix();
		assertEquals(-78, pf.evaluate("1 2 + 3 4 ^ -"));
	}
	
	@Test
	void testEvaluate4() {
		Postfix pf = new Postfix();
		assertEquals(-11, pf.evaluate("1  2 ^ 3 4 * -"));
	}
	
	@Test
	void testEvaluate5() {
		Postfix pf = new Postfix();
		assertEquals(-1011, pf.evaluate("1 2 3 * + 4 5 ^ - 6 +"));
	}
	
	@Test
	void testEvaluate6() {
		Postfix pf = new Postfix();
		assertEquals(9.25, pf.evaluate("1 2 + 3 * 4 5 6 - ^ +"));
	}
	
	
	@Test
	void testEvaluate7() {
		Postfix pf = new Postfix();
		assertEquals(98.75, pf.evaluate("1 2 + 3 4 / + 5 + 6 7 8 + * +"));
	}
	
	@Test
	void testEvaluate8() {
		Postfix pf = new Postfix();
		assertEquals(-1, pf.evaluate("9 1 - 2 - 3 2 * - 1 -"));
	}
	
	@Test
	void testConversion() {
		Postfix pf = new Postfix();
		assertEquals("1 2 3 * + 4 5 ^ - 6 +", pf.infixToPostfix("1 + 2 * 3 - 4 ^ 5 + 6"));
	}
	
	@Test
	void testConversion2() {
		Postfix pf = new Postfix();
		assertEquals("a b c ^ d e f ^ ^ * + g - h i j + / -", pf.infixToPostfix("a + b ^ c * d ^ e ^ f - g - h / ( i + j )"));
	}

}
