package com.mainaction;


import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Hero {

	float winH, winW, armperenos, gunperenos;
	
	
	Bitmap herof = Pictures.HeroForvard;
	Bitmap armf = Pictures.HeroArmF;
	Bitmap herob = Pictures.HeroBack;
	Bitmap armb = Pictures.HeroArmB;
	Bitmap plit = Pictures.Ground;
	Bitmap wall = Pictures.Wall;
	
	
	
	 AnimatePerson hero = new AnimatePerson(herof, 16);
	 NotAnimatePers  arm = new NotAnimatePers(armf);
	 
	 Gun gun = new Gun();
	 
	static float health = 100,height,xhero,yhero; 
	
	static String[][][] mapget;
	
	static int alive,killed,gunnumb;
	
	static int plasei, plasej, ill;
	
	static Boolean hasvac = false, hasvacpistol= false;
	
	protected float movehero = 0, directhero = 1, Vx = 20, Vy = 0, width = hero.Pers.getWidth()/17,  lasty=0, lastx = 0;
	protected boolean injump = false, hasground = true;	
	public int kolplat, kolwall, freebullet = 0, leftgran, rightgran, topgran, botomgran;
	public float[] platformsy, platformsx, wallsy, wallsx, bulletsx, bulletsy, bulletsDirect;//*
	public float vacx,vacy,vacpistoly,vacpistolx;
	
public Hero(float x, float y, int Kolzomb, 	String[] s) {
	health = 100;
	alive = Kolzomb;
	ill = Kolzomb;
	killed = 0;
	gunnumb = 1;
	xhero = x; 
	lastx = x;
	yhero = y;
	lasty = y;
	Glob.hasbulletinbox=120;
	hasvac = false;
	hasvacpistol= false;
	bulletsx = new float[50];
	bulletsy = new float[50];
	bulletsDirect = new float[50];
	
	
    mapget = new String[s.length][s.length][4];
	
	for(int j = 0; j < s.length-1; j++) {
		for(int i = 0; i < s.length; i++) {
			mapget[i][j][1] = s[j].substring((i*5) + 1, (i*5) + 2);
		}
	}
	
	height = hero.Pers.getHeight();	
	
}
	
    
    void checkklet() {
    	plasei = (int)(xhero/Map.klet);
    	plasej = (int)(-yhero/Map.klet);
    	
    	hasground = false;
    	
    	leftgran = plasei -3;
    	if (leftgran < 0) {
    		leftgran = 0;
    	}
    	
    	if (leftgran > Map.length -2) {
    		leftgran = Map.length -2;
    	}
    	
    	rightgran = plasei +3;
    	if (rightgran < 0) {
    		rightgran = 0;
    	}
    	
    	if (rightgran > Map.length -2) {
    		rightgran = Map.length-2;
    	}
    	
    	topgran = plasej - 3;
    	if (topgran < 0) {
    		topgran = 0;
    	}
    	
    	if (topgran > Map.length -2) {
    		topgran = Map.length-2;
    	}

    	botomgran = plasej +3;
    	if (botomgran < 0) {
    		botomgran = 0;
    	}
    	
    	if (botomgran > Map.length -2) {
    		botomgran = Map.length-2;
    	}
    	
    	
    	for (int i = leftgran; i< rightgran; i++) {
    		for (int j = topgran; j< botomgran; j++) {
    			
    	    	if ((!Map.mapget[i][j][1].equals("0"))&(!Map.mapget[i][j][1].equals("Zombie"))) {
    	    		    	    		
    	    	  if(((lasty >= -j*Map.klet)&(yhero < -j*Map.klet)||(yhero == -j*Map.klet))&(xhero < (i+1)*Map.klet)&(xhero+width > (i)*Map.klet)) { //
    	    		  yhero = -j*Map.klet;
    	     		  Vy = 0;
    	     		  hasground = true;
    	    	  }	
    	    		
    	    	  if((lasty + height <= -(j+1)*Map.klet)&(yhero +height > -(j+1)*Map.klet)&(xhero < (i+1)*Map.klet)&(xhero+width > (i)*Map.klet)) {
    	    		  yhero = -(j+1)*Map.klet - height;
    	     		  Vy = 0;
    	    	  }
    	    	  
    	    	  if((lastx + width <= (i)*Map.klet)&(xhero + width > (i)*Map.klet)&(yhero < -(j)*Map.klet)&(yhero + height > -(j+1)*Map.klet)) {
    	    		  xhero = (i)*Map.klet - width;
    	     		  movehero = 0;
    	    	  }
    	    	  
    	    	  if((lastx >= (i+1)*Map.klet)&(xhero < (i+1)*Map.klet)&(yhero < -(j)*Map.klet)&(yhero + height > -(j+1)*Map.klet)) {
    	    		  xhero = (i+1)*Map.klet ;
    	     		  movehero = 0;
    	    	  }
    	    	  
    	    	  
    		    }
    	    	
    	    	if ((j==plasej||j==plasej-1)&i==plasei) {
    	    	if (Map.mapget[i][j][2].equals("5")) {
    	    		hasvacpistol = true;
    	    		
    	    		Map.vacpistolx = -2000;
    	    		
    	    		if (hasvac) {
    	    			changegun();
    	    		}
    	    	}
    	    	
    	    	if (Map.mapget[i][j][2].equals("6")) {
    	    		hasvac = true;
    	    		
    	    		Map.vacx = -2000;
    	    		
    	    		if (hasvacpistol) {
    	    			changegun();
    	    		}
    	    	}
    	    	
    	    	if (Map.mapget[i][j][2].equals("3")||Map.mapget[i][j][2].equals("4")) {
    	    		Map.bouns[new Integer(Map.mapget[i][j][0])].activate();
    	    	}
    	    	}
    	    	
    		}
    	}
    	
    	if (hasground == false) {
    		Vy -= Pictures.Wall.getHeight()/222f;
    	}
    	
    	
    }
    
    
    
    void changegun() {
    	gunnumb = 2;
		gun.bulletl = Pictures.Ukolb;
		gun.bulletr = Pictures.Ukolf;
		if (directhero == 1)
		{
			gun.gun.Pers = Pictures.Vacpistolf;
		}
			else {
				gun.gun.Pers = Pictures.Vacpistolb;
		}
		gun.gun.Pers = Pictures.Vacpistolf;
		gun.Bullet.col = 1;

		gun.AKf = Pictures.Vacpistolf;
		gun.AKb = Pictures.Vacpistolb;
		gun.gun.col = 1;
    }
    
    
void checkvacp() {
    	
    	if ((Math.abs(yhero-Map.vacpistoly)<100)&(Math.abs(xhero -Map.vacpistolx)<100)) {
    		
    		hasvacpistol = true;
    		
    		if (hasvac) {
    			changegun();
    		}
    		
    		
    	}
    	
    	
    }
    
    
	void Draw (Canvas gra) {
		
   	    hero.Draw(gra,  winW/2f , winH - (winH/2f + height), 0);
    	
    	 for(int i = 0; i<49; i++) {
			gun.Bullet.Draw(gra, gun.bulletsx[i]- xhero + winW/2f , winH - gun.bulletsy[i]+ yhero - winH/2f  -height/2.3f, 0);
		}
  	
    	 if (directhero == 1) {
		   gun.gun.Draw(gra, winW/2f -Pictures.AK.getHeight()*0.2f , winH - (winH/2f + height)+Pictures.AK.getHeight()*1.4f, 0);
    	 }
    	 else
    	 {
    	 gun.gun.Draw(gra, winW/2f -Pictures.AK.getHeight()*1.1f + gun.gunperenos , winH - (winH/2f + height)+Pictures.AK.getHeight()*1.4f, 0); 
    	 }
   	    
   	    
     	arm.Draw(gra,  winW/2f , winH - (winH/2f + height));
     	
     
	}
	
	
	
	
	void Jump () {
		yhero += 0.1f;
		Vy += Pictures.Wall.getHeight()/6.5f;
	}
	
	
	
	
	void inv () {
	
	
	 	gun.inv();
		
		xhero += Vx*movehero;	
		yhero += Vy;
        checkklet();
        
		lasty = yhero;
		lastx = xhero;
	}
	
	
	
	void setcontrol(Joystick controler) {
		
		movehero = 0;
		if (controler.right.taped) {
		 if (movehero!=1)	{
	     turn(true);
		 movehero = 1;
		 directhero = 1;
		 gun.turn(true);	
		 }
		}
		if (controler.left.taped) {
			 if (movehero!=-1)	{
			     turn(false);
				 movehero = -1;
				 directhero = -1;
				 gun.turn(false);		
				 }
	    }
		
		if ((!controler.left.taped)&(!controler.right.taped)) {
				 movehero = 0;
				 hero.animate = 0;		 
	    }
		
		if (controler.shoot.taped) {
			 if ((Glob.hasbulletinbox != 0)&(Glob.coldgun))	{
				 gun.gun.animate = 1;
				 Glob.hasbulletinbox -= 1;
				 
				 gun.CreateBullet(xhero, yhero);
				 
				 }
	    }
		else {
			 gun.gun.animate = 0;
		}
		
		if (controler.jump.taped) {
			 if (hasground)	{
			     Jump();
				 }
	    }
		
		
	}
	
	
	
	
	void turn(boolean direction) {
		
		if (direction) {
			hero.Pers = herof;
			arm.Pers = armf;
			hero.animate = 1;
		}
		
		if (!direction) {
			hero.Pers = herob;
			arm.Pers = armb;
			hero.animate = 1;

		}
			
		
	}
		
	
}
