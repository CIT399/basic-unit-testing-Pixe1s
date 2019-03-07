import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class teleTest {
	private static StringBuilder print = new StringBuilder();
	private String phoneUNF = "5701234567";
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		print.append("--- Setup Class ---\n");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		print.replace(print.length() - 1, print.length(), "");
		print.append("--- Teardown Class ---");
		System.out.println(print);
		print.setLength(0);
	}

	@BeforeEach
	void setUp() throws Exception {
		print.append("  -- Setup Test --\n");
	}

	@AfterEach
	void tearDown() throws Exception {
		print.append("  -- Teardown Test --\n\n");
	}

	@Test
	void testUnformat1() {
		print.append("    - Test 1 -\n");
		assertEquals(phoneUNF, Telephone.unformat("(570)123-4567"));
	}

	@Test
	void testUnformat2() {
		print.append("    - Test 2 -\n");
		assertEquals(phoneUNF, Telephone.unformat("5701234567"));
	}
	
	@Test
	void testUnformat3() {
		print.append("    - Test 3 -\n");
		assertEquals(phoneUNF, Telephone.unformat("570-123-4567"));
	}
	
	@Test
	void testUnformat4() {
		print.append("    - Test 4 -\n");
		assertEquals("18001234567", Telephone.unformat("1-800-1234567"));
	}
}
