package com.mainaction;

import java.util.ArrayList;

import android.graphics.Bitmap;

public class Gun {

	float winH, winW, gunperenos=0;
	
	Bitmap AKf = Pictures.AKShootf;
	Bitmap AKb = Pictures.AKShootb;
	Bitmap bulletr = Pictures.Bullet;
	Bitmap bulletl = Pictures.Bulletback;
	Bitmap plit = Pictures.Ground;
	Bitmap wall = Pictures.Wall;
	
	 AnimatePerson Bullet = new AnimatePerson(bulletr, 4); 
	 AnimatePerson gun = new AnimatePerson(AKf, 5);
	 
	 int plasei, plasej;
	 
	 
	 public float[] wallsy, wallsx, bulletsx, bulletsy, bulletsDirect, lastbulletx, lastbullety;
	 public int kolplat, kolwall, freebullet = 0,k=0;
	 protected float xhero = 0, directhero = 1, yhero= 0, V = 20, width = gun.Pers.getWidth()/5, height = gun.Pers.getHeight();
	
	 
	 public Gun() {
		 bulletsx = new float[50];
		 bulletsy = new float[50];
		 lastbulletx =new float[50];
		 lastbullety = new float[50];
		 bulletsDirect = new float[50];
		 
		 for(int i = 0; i<49; i++) {
				bulletsx[i] += -1000;
				bulletsy[i] += -1000;
			} 
		 
	}
	 
	
	 void inv () {
			
			for(int i = 0; i<49; i++) {
				bulletsx[i] += bulletsDirect[i]*70;
			}
			

			checkwall();
			
			
			for(int i = 0; i<49; i++) {
				lastbulletx[i] = bulletsx[i];
				
			}
		} 
	 
	 
	 void CreateBullet(float xhero, float yhero ) {
			bulletsDirect[freebullet] = directhero;
			bulletsx[freebullet] = xhero;
			bulletsy[freebullet] = yhero+Pictures.AK.getHeight()/8f;
			lastbulletx[freebullet] = bulletsx[freebullet];
			freebullet += 1;
			if (freebullet>49) {
			freebullet = 0;	
			}
			
		} 
	 
	 
	 
	 
	 void checkwall() {
	    
		 for (int j = 0; j < 49; j++) {
		 
		 plasei = (int)(bulletsx[j]/Map.klet);
	     plasej = (int)((-bulletsy[j]-Hero.height/2.3f)/Map.klet);
	     
	     if (plasei-2<0) {
	    	    bulletsDirect[j] = 0;
	    		bulletsx[j] = -1000;
	    		bulletsy[j] = -1000; 
	     }
	     else {	
		 for (int i = plasei-2; i < plasei+1; i++) { 
			
			 if (!Map.mapget[i][plasej][1].equals("0")) {
				 
	
			 
			 if((lastbulletx[j] <= (i)*Map.klet)&(bulletsx[j] > (i)*Map.klet)) {
				 if (!Map.mapget[i][plasej][1].equals("Zombie")) {
				    	bulletsDirect[j] = 0;
			    		bulletsx[j] = -1000;
			    		bulletsy[j] = -1000;
					 }
				 else{
		    		if (Map.mapget[i][plasej][1].equals("Zombie")) {
		    			k = new Integer(Map.mapget[i][plasej][3]);
		    			if (Map.zomb[k].active != 0) {
		    				
		    				bulletsDirect[j] = 0;
				    		bulletsx[j] = -1000;
				    		bulletsy[j] = -1000;
		 	
		    			if (Hero.gunnumb == 1) {
				    		Map.zomb[k].health-=20;
				    		}
				    		
				    		
				    		if (Hero.gunnumb == 2) {
					    	Map.zomb[k].ill-=20;
					    	}
				    		
				    		
				    		if (Map.zomb[k].health == 0) {
				    		Map.zomb[k].active=0;
				    		Hero.alive -= 1;
				    		Hero.ill -= 1;
				    		Hero.killed += 1;
				    		Map.zomb[k].zomb.animate=0;
				    		if  (Map.zomb[k].move == 1) {
				    			Map.zomb[k].zomb.Pers = Map.zomb[k].zombdf;
				    		}
				    		else
				    		{
				    			Map.zomb[k].zomb.Pers = Map.zomb[k].zombdb;
				    		}
				    		Map.zomb[k].zomb.col = 1;
				    		}
				    		
				    		
				    		if (Map.zomb[k].ill == 0) {
					    		Map.zomb[k].noneill = 1;
					    		Hero.ill -= 1;
					    		NewDraw.rec+=10;
					    		Map.zomb[k].angry = false;
					    		Map.zomb[k].zombf = Pictures.Zombnonillf;
					    		Map.zomb[k].zombb = Pictures.Zombnonillb;
					    		if (Map.zomb[k].move == 1) {
					    			Map.zomb[k].zomb.Pers = Pictures.Zombnonillf;
					    		}
					    		else {
					    			Map.zomb[k].zomb.Pers =Pictures.Zombnonillb;
					    		}
					    		}	
		    		}
			      }
			 }
	    	  }
	    	  
	    	  if((lastbulletx[j] >= (i+1)*Map.klet)&(bulletsx[j] < (i+1)*Map.klet)) {
	    		  if (!Map.mapget[i][plasej][1].equals("Zombie")) {
				    	bulletsDirect[j] = 0;
			    		bulletsx[j] = -1000;
			    		bulletsy[j] = -1000;
					 }
			    		if (Map.mapget[i][plasej][1].equals("Zombie")) {
			    			k = new Integer(Map.mapget[i][plasej][3]);
			    			if (Map.zomb[k].active != 0) {
			    				
			    				bulletsDirect[j] = 0;
					    		bulletsx[j] = -1000;
					    		bulletsy[j] = -1000;
			    				
			    			if (Hero.gunnumb == 1) {
					    		Map.zomb[k].health-=20;
					    		}
					    		
					    		
					    		if (Hero.gunnumb == 2) {
						    	Map.zomb[k].ill-=20;
						    	}
					    		
					    		
					    		if (Map.zomb[k].health == 0) {
					    		Map.zomb[k].active=0;
					    		Hero.alive -= 1;
					    		Hero.ill -= 1;
					    		Hero.killed += 1;
					    		Map.zomb[k].zomb.animate=0;
					    		if  (Map.zomb[k].move == 1) {
					    			Map.zomb[k].zomb.Pers = Map.zomb[k].zombdf;
					    		}
					    		if  (Map.zomb[k].move == -1) {
					    			Map.zomb[k].zomb.Pers = Map.zomb[k].zombdb;
					    		}
					    		Map.zomb[k].zomb.col = 1;
					    		}
					    		
					    		
					    		if (Map.zomb[k].ill == 0) {
					    			Hero.ill -=1;
					    			NewDraw.rec+=10;
					    			Map.zomb[k].noneill = 1;
					    			Map.zomb[k].angry = false;
						    		Map.zomb[k].zombf = Pictures.Zombnonillf;
						    		Map.zomb[k].zombb = Pictures.Zombnonillb;
						    		if (Map.zomb[k].move == 1) {
						    			Map.zomb[k].zomb.Pers = Pictures.Zombnonillf;
						    		}
						    		else {
						    			Map.zomb[k].zomb.Pers =Pictures.Zombnonillb;
						    		}
						    		}	
			    		}
				      }
	    	  }
			 }
			 
	
		 }
	     }
			 

		
		    	
		    }
		 
		 
		 
		 
		 
	 
	 
	 }
	 
	 
	 void turn(boolean direction) {
			
			if (direction) {
				gun.Pers = AKf;
				gunperenos = 0;
				Bullet.Pers = bulletr;
				directhero = 1;
			}
			
			if (!direction) {
				gun.Pers = AKb;
				if (Hero.gunnumb == 2) {
					gunperenos = -Pictures.Vacpistolf.getWidth()/2.3f;	
				}
				Bullet.Pers = bulletl;
				directhero = -1;
			}
				
			
		} 
	 
	 
	 
	 
	 
	
}
