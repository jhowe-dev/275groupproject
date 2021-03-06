package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Controller.FlyGameController;
import Model.RedKnot;
import Model.Trash;
import Model.TrashCan;

public class RedKnotTests {

	@Test
	public void testRedMove() {
		RedKnot r=new RedKnot(0,300);
		r.randstart=1;
		r.move();
		assertEquals(r.start,true);
		r=new RedKnot(0,300);
		r.randstart=0;
		r.move();
		assertEquals(r.start,true);
		r.y=0;
		r.move();
		assertEquals(r.up,false);
		assertEquals(r.gety(),5);
		r.y=2000;
		r.move();
		assertEquals(r.up,true);
		assertEquals(r.gety(),1995);
	}
	@Test
	public void testRedTouch() {
		RedKnot r=new RedKnot(0,0);
		Trash t=new Trash(0,0);
		assertEquals(r.isTouching(t),true);
		r=new RedKnot(0,0);
		t=new Trash(300,300);
		assertEquals(r.isTouching(t),false);
	}
	@Test
	public void testSetTrashcoor() {
		Trash t=new Trash(0,0);
		t.setcoor(200, 300);
		assertEquals(t.getx(),200);
		assertEquals(t.gety(),300);
	}
	@Test
	public void testTrashMove() {
		Trash t=new Trash(0,0);
		t.setcoor(200, 300);
		t.move();
		assertEquals(t.getx(),190);
	}
	@Test
	public void testTrashGrabbed() {
		Trash t=new Trash(0,0);
		assertEquals(t.isGrabbed(0, 30),true);
		t=new Trash(500,500);
		assertEquals(t.isGrabbed(0, 30),false);
	}
	@Test
	public void testFlyGameControllerAddTrash() {
		FlyGameController f=new FlyGameController();
		f.addTrash(1);
		assertEquals(f.getLength(),4);
	}
	@Test
	public void testFlyGameControllerRemoveTrash() {
		FlyGameController f=new FlyGameController();
		f.removeTrash(0);
		assertEquals(f.getLength(),2);
	}
	@Test
	public void testEatTrash() {
		Trash t=new Trash(50,50);
		TrashCan can=new TrashCan(0,0);
		assertEquals(can.isEatingTrash(t),true);
		t=new Trash(500,500);
		can=new TrashCan(0,0);
		assertEquals(can.isEatingTrash(t),false);
		t=new Trash(-50,-50);
		can=new TrashCan(0,0);
		assertEquals(can.isEatingTrash(t),true);
	}
}

