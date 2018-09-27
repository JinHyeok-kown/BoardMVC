package kr.itedu.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kr.itedu.junit.calc;

class CalcTest {
	@BeforeAll static void start() {
		System.out.println("테스트시작");
	}
	@AfterAll static void end() {
		System.out.println("테스트종료");
	}
	@BeforeEach
	void testBefore() {
		System.out.println("시작");
	}
	@AfterEach
	void testAfter() {
		System.out.println("종료");
	}
	@Test
	void testA() {

		assertEquals(12, calc.sum(5, 7));
		assertEquals(7, calc.sum(3, 4));
		assertEquals(2000, calc.sum(1500, 500));

		
	}
	
	@Test
	void testB() {
	
		assertEquals(45, calc.multi(15, 3));
		assertEquals(2, calc.div(10, 5));
		assertEquals(2000, calc.sum(1500, 500));

	}

}