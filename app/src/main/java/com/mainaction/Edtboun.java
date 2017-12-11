package com.mainaction;

public class Edtboun {

	int power, vers, x, grow = 1, y;
	boolean activated;
	int pos, vis=200;
	
	public Edtboun(int pow, int ver, int X, int Y) {
		power = pow;
		vers = ver;
		x = X;
		y = Y;
		activated = false;
		pos = Randomik(0, 100);
	}
	
	void inv() {
		if (activated&(vis > 0)) {
			vis -= 4;
		}
		
		if (pos<=0) {
			grow=1;
		}
		
		if (pos>=Pictures.edtbullet.getHeight()/3) {
			grow=-1;
		}
		pos+=grow;
		
	}
	
	void activate () {
		if (!activated) {
		if (vers == 1) {
			Hero.health = 100;
		}
		
		if (vers == 2) {
			Glob.hasbulletinbox += power;
		}
		}
		
		activated = true;
	}
	
	
	public int Randomik(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	
}
