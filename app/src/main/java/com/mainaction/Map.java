package com.mainaction;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Map {
	
	Bitmap wall =Pictures.Wall, ground = Pictures.Ground, hero = Pictures.HeroForvard;
	
	static Edtboun[] bouns;
	
	public static String[][][] mapget;
	
	NotAnimatePers gr[] = { 
			new NotAnimatePers(Pictures.gr1),
	        new NotAnimatePers(Pictures.gr2),
	        new NotAnimatePers(Pictures.gr3),
	        new NotAnimatePers(Pictures.gr4),
	        new NotAnimatePers(Pictures.gr5)
	};
	
	NotAnimatePers livedt = new NotAnimatePers(Pictures.edtlive);
	NotAnimatePers buledt = new NotAnimatePers(Pictures.edtbullet);
	NotAnimatePers wlt = new NotAnimatePers(Pictures.wlt);
	NotAnimatePers wlb = new NotAnimatePers(Pictures.wlb);
	NotAnimatePers wl = new NotAnimatePers(Pictures.wl);
	NotAnimatePers pl = new NotAnimatePers(Pictures.pl);
	NotAnimatePers pll = new NotAnimatePers(Pictures.pll);
	NotAnimatePers plr = new NotAnimatePers(Pictures.plr);
	NotAnimatePers vacpistol = new NotAnimatePers(Pictures.Vacpistolf);
	
	AnimatePerson vac = new AnimatePerson(Pictures.vaci, 7);
	
	int kolz=0, grow;
	
	float xhero, yhero, vacup=0, xh, yh;
	static int klet = Pictures.gr1.getWidth(), length, leftgran, rightgran, topgran, botomgran;
	
	float winH,winW;
	
	static float vacpistolx,vacpistoly,vacx,vacy;
	
	static Zombie[] zomb ;
	ArrayList<Zombie> zombi = new ArrayList<Zombie>(); 
	ArrayList<Edtboun> bon = new  ArrayList<Edtboun>();
	
public Map(String[] s) {
	 
	for (int i=0; i<5; i++) {
		gr[i].Ground = true;
	}
	
	vac.animate=1;
	
	length = s.length;
	
	mapget = new String[s.length][s.length][4];
	
	for(int j = 0; j < s.length-1; j++) {
		for(int i = 0; i < s.length; i++) {
			mapget[i][j][1] = s[j].substring((i*5) + 1, (i*5) + 2);
			mapget[i][j][2] = s[j].substring((i*5) + 3, (i*5) + 4);
		}
	}
	
	for(int i = 0; i < s.length-1; i++) {
		for(int j = 0; j < s.length-1; j++) {
			
			if (mapget[i][j][1].equals("1")) {
				mapget[i][j][3] = fillArrayRandom(1,5)+"";
				}
			
			if (mapget[i][j][1].equals("2")) {
			
		          mapget[i][j][3] = "1";
				
			if (j != 0) {
				if(mapget[i][j-1][1].equals("0")) {
				  mapget[i][j][3] = "2";
 				}
			}
			
			if (j != s.length) {
				if(mapget[i][j+1][1].equals("0")) {
				  mapget[i][j][3] = "3";
				} 	
			}
			
			}
			
			
			if (mapget[i][j][1].equals("3")) {
				
		          mapget[i][j][3] = "1";
				
			if (i != s.length) {
				if(mapget[i+1][j][1].equals("0")) {
				  mapget[i][j][3] = "3";
				} 	
			}
			
			if (i != 0) {
				if(mapget[i-1][j][1].equals("0")) {
				  mapget[i][j][3] = "2";
				} 	
			}
			
			}
            
			if (mapget[i][j][2].equals("1")) {
			xh = i*klet;
			yh = j*(-klet);
			}
			
			if (mapget[i][j][2].equals("2")) {
				Zombie z = new Zombie( (j+2)*(-klet), i*klet, (i+1)*klet);
				zombi.add(z);
			}
			
			if (mapget[i][j][2].equals("6")) {
				vacx = i*klet- klet/2;
				vacy = j*(-klet);
				}
			
			if (mapget[i][j][2].equals("5")) {
				vacpistolx = i*klet - klet/2;
				vacpistoly = j*(-klet);
				}
			
			if (mapget[i][j][2].equals("3")) {
				bon.add(new Edtboun(0, 1, i*klet, j*(-klet)));
				mapget[i][j][0] = (bon.size()-1)+"";
				}
			
			if (mapget[i][j][2].equals("4")) {
				bon.add(new Edtboun(40, 2, i*klet, j*(-klet)));
				mapget[i][j][0] = (bon.size()-1)+"";
				}
			
		}
	}
	
	zomb = new Zombie[zombi.size()];
	
	for (int k = 0; k< zomb.length; k++) {
	zomb[k] = zombi.get(k);
	}
	
	bouns = new Edtboun[bon.size()];
	
   for(int i = 0; i<bon.size(); i++) {
		bouns[i] = bon.get(i);
	}
	
	kolz = zomb.length;
}



public int fillArrayRandom(int min, int max) {
	
	return (int) (Math.random() * (max - min + 1)) + min;
}


void Draw(Canvas gra, float w, float h) {
	
	if (vacup <= 0) {
		grow = 1;
	}

	if (vacup >= 20) {
		grow =-1;
	}
	
	vacup += grow*0.5;
	
	vac.Draw(gra, vacx  - xhero + winW/2f, h- vacy-vacup + yhero - winH/2f, 0);
	
	vacpistol.Draw(gra, vacpistolx  - xhero + winW/2f, h- vacpistoly-vacup + yhero - winH/2f);
	
	leftgran = (int)((xhero - w/2)/klet - 2);
	if (leftgran < 0) {
		leftgran = 0;
	}
	if (leftgran > length -2) {
		leftgran = length-2;
	}
	
	rightgran = (int)((xhero + w/2)/klet + 2);
	if (rightgran < 0) {
		rightgran = 0;
	}
	if (rightgran > length -2) {
		rightgran = length-2;
	}
	
	topgran = (int)((yhero + h/2)/(-klet) - 2);
	if (topgran < 0) {
		topgran = 0;
	}
	if (topgran > length -2) {
		topgran = length-2;
	}
	

	botomgran = (int)((yhero - h/2)/(-klet) + 2);
	if (botomgran < 0) {
		botomgran = 0;
	}
	if (botomgran > length -2) {
		botomgran = length-2;
	}
	

	for (int i=0; i< bouns.length; i++) {
		
		bouns[i].inv();
		
		if (bouns[i].vers == 1) {
			livedt.p.setAlpha(bouns[i].vis);
			livedt.Draw(gra, bouns[i].x- xhero + winW/2f,h- bouns[i].y- bouns[i].pos  + yhero - winH/2f);
		}
		if (bouns[i].vers == 2) {
			buledt.p.setAlpha(bouns[i].vis);
			buledt.Draw(gra, bouns[i].x- xhero + winW/2f,h- bouns[i].y - bouns[i].pos + yhero - winH/2f);
		}
	}
	
	for(int i = 0; i<zomb.length; i++) {
			
		zomb[i].setHeroCoord(xhero, yhero);
		
		zomb[i].inv(i);
		
		zomb[i].draw(gra, winW, winH);
		
	}
	
	

	
	
	for(int i = leftgran; i<rightgran; i++) {
		
	
		for(int j = topgran; j<botomgran; j++) {
			
			if (mapget[i][j][1].equals("1")) {
				gr[new Integer(mapget[i][j][3])-1].Draw(gra, i*klet - xhero + winW/2f,h-  j*(-klet)  + yhero - winH/2f);
			}
			
			if (mapget[i][j][2].equals("3")) {
				
			}
			
			if (mapget[i][j][1].equals("2")) {
				
				if (mapget[i][j][3].equals("1")) {
					wl.Draw(gra, i*klet - xhero + winW/2f,h-  j*(-klet)  + yhero - winH/2f);
				}
				if (mapget[i][j][3].equals("2")) {
					wlt.Draw(gra, i*klet - xhero + winW/2f,h-  j*(-klet)  + yhero - winH/2f);
				}
				if (mapget[i][j][3].equals("3")) {
					wlb.Draw(gra, i*klet - xhero + winW/2f,h-  j*(-klet)  + yhero - winH/2f);
				}
			}
			
            if (mapget[i][j][1].equals("3")) {
				
				if (mapget[i][j][3].equals("1")) {
					pl.Draw(gra, i*klet - xhero + winW/2f,h-  j*(-klet) + yhero - winH/2f);
				}
				if (mapget[i][j][3].equals("2")) {
					pll.Draw(gra, i*klet - xhero + winW/2f,h-  j*(-klet) + yhero - winH/2f);
				}
				if (mapget[i][j][3].equals("3")) {
					plr.Draw(gra, i*klet - xhero + winW/2f,h-  j*(-klet) + yhero - winH/2f);
				}
			}
			
		}
		
	}
	
	
	
}

	


void gethero(float x, float y, float WinH, float WinW) {
	xhero = x;
	yhero = y;
	winW = WinW;
	winH = WinH;
}


}
