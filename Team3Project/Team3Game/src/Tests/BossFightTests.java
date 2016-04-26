package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Boss;
import Model.CaptainEstuary;
import Model.EmployeeHero;
import Model.Hero;

public class BossFightTests {
	
	@Test
	public void main(){
		BossFightTests test = new BossFightTests();
		test.testHeroes();
		test.testBoss();
		test.testViews();
		test.testBossFightControllers();
	}

	@Test
	public void testHeroes() {
		Hero eh = new EmployeeHero(0,0,100);
		Hero ce = new CaptainEstuary(0,0,100);
		eh.decrementHealth(25);ce.decrementHealth(10);
		assertEquals(eh.getHealth(),75);assertEquals(ce.getHealth(),90);
		//fail("Heroes failed");
	}
	public void testBoss(){
		Boss b = new Boss(4,5);
		b.decrementHealth(20);
		assertEquals(b.getHealth(), 80);
		//fail("boss failed");
	}
	@Test
	public void testViews(){
		//fail("Views failed");
	}
	@Test
	public void testBossFightControllers(){
		//fail("controllers failed");
	}

}
