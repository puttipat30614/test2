package blacksmith;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SwordTest {
	Sword Test1;
	Sword Test2;
	Sword Test3;

	@BeforeEach
	void setUp() throws Exception {
		Test1=new Sword(-3,-7);
		Test2=new Sword(4,6);
		Test3=new Sword(3,-1);
	}

	// TODO Test Sword constructor
	@Test
	void testSword() {
		assertEquals(1,Test1.getAttack());
		assertEquals(1,Test1.getDurability());
		assertEquals(4,Test2.getAttack());
		assertEquals(6,Test2.getDurability());
		assertEquals(3,Test3.getAttack());
		assertEquals(1,Test3.getDurability());
	}

	// TODO Test Sword constructor with negative attack
	@Test
	void testSwordNegativeAttack() {
		assertEquals(1,Test1.getAttack());
		assertEquals(4,Test2.getAttack());
		assertEquals(3,Test3.getAttack());
	}
	
	// TODO Test Sword constructor with negative durability
	@Test
	void testSwordNegativeDurability() {
		assertEquals(1,Test1.getDurability());
		assertEquals(6,Test2.getDurability());
		assertEquals(1,Test3.getDurability());
	}

	// TODO Test upgrade()
	@Test
	void testUpgrade() {
		Test1.upgrade(3);
		Test2.upgrade(2);
		Test3.upgrade(10);
		assertEquals(4,Test1.getAttack());
		assertEquals(2,Test1.getDurability());
		assertEquals(6,Test2.getAttack());
		assertEquals(7,Test2.getDurability());
		assertEquals(13,Test3.getAttack());
		assertEquals(2, Test3.getDurability());
	}

	// TODO Test upgrade() with negative value
	@Test
	void testUpgradeNegative() {
		Test1.upgrade(-3);
		Test2.upgrade(-2);
		Test3.upgrade(-10);
		assertEquals(1,Test1.getAttack());
		assertEquals(2,Test1.getDurability());
		assertEquals(4,Test2.getAttack());
		assertEquals(7,Test2.getDurability());
		assertEquals(3,Test3.getAttack());
		assertEquals(2, Test3.getDurability());
	}

	// TODO Test doParry()
	@Test
	void testDoParry() {
		assertEquals(9,Test1.doParry(10));
		assertEquals(10,Test2.doParry(14));
		assertEquals(9,Test3.doParry(12));
		assertEquals(0,Test1.getDurability());
		assertEquals(5,Test2.getDurability());
		assertEquals(0,Test3.getDurability());
	}

	// TODO Test doParry() with non positive attack
	@Test
	void testDoParryNonPositiveAttack() {
		assertEquals(0,Test1.doParry(-3));
		assertEquals(0,Test2.doParry(-5));
		assertEquals(0,Test3.doParry(-10));
		assertEquals(0,Test1.getDurability());
		assertEquals(5,Test2.getDurability());
		assertEquals(0,Test3.getDurability());
	}

	// TODO Test doParry() with attack <= Sword's attack ( fully parried )
	@Test
	void testDoParryFullyParried() {
		assertEquals(0,Test1.doParry(1));
		assertEquals(0,Test2.doParry(2));
		assertEquals(0,Test3.doParry(1));
		assertEquals(0,Test1.getDurability());
		assertEquals(5,Test2.getDurability());
		assertEquals(0,Test3.getDurability());
	}

	// TODO Test isBroken()
	@Test
	void testIsBroken() {
		Test1.doParry(1);Test1.doParry(1);
		Test3.doParry(1);
		assertTrue(Test1.isBroken());
		assertFalse(Test2.isBroken());
		assertTrue(Test3.isBroken());
	}

}
