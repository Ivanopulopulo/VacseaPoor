package com.mainaction;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Zombie{

	float  x=0, y=0, Vx=5, Vy=0, health = 100, ill = 100, noneill = 0, move = 1, xhero = 0, yhero = 0, damage = 0, x1,x2; 
	
	int active = 1, plasei, plasej, lasti, lastj, time=0;
	
	Bitmap zombf, zombb, zombdb, zombdf;
	
	Paint p = new Paint();
	
	Boolean angry=false;
	
	AnimatePerson zomb;
	
	public Zombie(float y, float x1,float x2) {
		// TODO Auto-generated constructor stub
		plasei = (int)(x1/Map.klet);
    	plasej = (int)(-y/Map.klet);
    	
    	lasti = plasei;
    	lastj = plasej;
    	
		zombf = Pictures.Zombief;
		zombb = Pictures.Zombieb;
		zombdf = Pictures.Zombiedf;
		zombdb = Pictures.Zombiedb;
		
		this.x1 = x1;
		this.x = x1;
		this.x2 = x2;
		this.y = y;
		
		p.setColor(Color.GREEN);
		
		zomb = new AnimatePerson(zombf, 16);
		zomb.animate = 1;
	}
	
	void draw(Canvas gra, float w, float h) {
		zomb.Draw(gra, x - xhero + w/2f, h - y - zomb.Pers.getHeight() + yhero - h/2f, 0);
		
		gra.drawLine(x - xhero + w/2f,  h - y - zomb.Pers.getHeight() + yhero - h/2f, x - xhero + w/2f + health,  h - y - zomb.Pers.getHeight() + yhero - h/2f, p);
		
	}
	
	
	void setHeroCoord(float xh, float yh) {
		
		xhero = xh;
		yhero = yh;
		
		if (Math.abs(yhero - y) <50) {
			
			if (active == 1) {
		if (xhero<x) {
			move = -1;
			zomb.Pers = zombb;
		}
		if (xhero>x) {
		    move = 1;	
		    zomb.Pers = zombf;
		}
			}
	
		
		if (Math.abs(xhero - x) < 20) {
			
			if (noneill == 0) {
			Hero.health -= 3*active;	
			}
			 move = 0;
		}
		
		}
		
		
	}
	
	
	
	void inv(int i){
		
		if (health <= 0) {
			Map.mapget[plasei][plasej-1][1] = "0";
			Map.mapget[plasei][plasej-2][1] = "0";
			Map.mapget[plasei][plasej-1][3] = i+"";
			Map.mapget[plasei][plasej-2][3] = i+"";
		}
		
		if ((active!=0)) {
    	plasei = (int)(x/Map.klet);
    	plasej = (int)(-y/Map.klet);
    	
    	if (plasei <= 1) {
    		plasei = 1;
    	}
    	
    
		Map.mapget[plasei][plasej-1][1] = "Zombie";
		Map.mapget[plasei][plasej-2][1] = "Zombie";
		Map.mapget[plasei][plasej-1][3] = i+"";
		Map.mapget[plasei][plasej-2][3] = i+"";

    	
    	if ((lasti!=plasei)||(active == 0)) {
    		Map.mapget[lasti][lastj-1][1] = "0";
    		Map.mapget[lasti][lastj-2][1] = "0";
    		Map.mapget[lasti][lastj-1][3] = "";
    		Map.mapget[lasti][lastj-2][3] = "";	
    	}
    	
    
		lasti = plasei;
    	lastj = plasej;
		
		if ((!Map.mapget[plasei+1][plasej][1].equals("0")&Map.mapget[plasei+1][plasej-1][1].equals("0")&((Map.mapget[plasei+1][plasej-2][1].equals("0")||Map.mapget[plasei+1][plasej-1][1].equals("Zombie")))&(move==1))||((!Map.mapget[plasei][plasej][1].equals("0"))&Map.mapget[plasei-1][plasej-1][1].equals("0")&(Map.mapget[plasei-1][plasej-2][1].equals("0")||Map.mapget[plasei-1][plasej-1][1].equals("Zombie"))&(move==-1))) {
		x+=move*Vx*(active+noneill);
		}
		else
		{
			if (!angry){
			time =0;
			}
		}
		
		if (noneill == 0) {
		if ((Math.abs(Hero.plasej-plasej)<2)&(Math.abs(Hero.plasei-plasei)<10)&!angry) {
			angry = true;
			zombf = Pictures.Zombiedangf;
			zombb = Pictures.Zombiedangb;
			
		}
		else
		{
			if ((!(Math.abs(Hero.plasej-plasej)<2)||!(Math.abs(Hero.plasei-plasei)<10))&angry) {			
			angry = false;	
			zombf = Pictures.Zombief;
			zombb = Pictures.Zombieb;
			}
		}
		}
		
		if ((time <=0)&(!angry)) {
			time = Randomik(100,300); 
			move = Randomik(-1, 1);
			if (move == -1) {
				if (health>0) {
				zomb.Pers = zombb;
				}
			}
			if (move == 1) {
				if (health>0) {
				zomb.Pers = zombf;
				}
			}
		}
		
		time -= 1;
		
		}
		
	}
	
	
	public int Randomik(int min, int max) {
		
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	
}
