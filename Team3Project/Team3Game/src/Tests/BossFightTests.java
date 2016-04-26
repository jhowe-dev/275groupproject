package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.BossFight1Controller;
import Controller.BossFight2Controller;
import Model.Boss;
import Model.CaptainEstuary;
import Model.EmployeeHero;
import Model.Hero;
import view.BossFight1View;
import view.BossFight2View;
import view.Caption;

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
//	@Test
//	public void testCaption(){
//		Caption c = new Caption(0, 0, 0, 0);
//		c.setText("hi");
//		assertEquals();
//	}
	@Test
	public void testViews(){
		BossFight1View bf1 = new BossFight1View();
		BossFight2View bf2 = new BossFight2View();
		bf1.displayMessage("");bf2.displayMessage("");
		bf1.HeroPunches(75);bf2.HeroPunches(75);
		bf1.BossAttacks(34);bf2.BossAttacks(56);
		//fail("Views failed");
	}
	@Test
	public void testBossFightControllers(){
		BossFight1Controller bf1 = new BossFight1Controller();
		BossFight2Controller bf2 = new BossFight2Controller();
		//fail("controllers failed");
	}

}
