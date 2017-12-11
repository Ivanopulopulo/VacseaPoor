package com.mainaction;



import android.graphics.Bitmap;

public class Enemy {
    
	AnimatePerson enenmy ;
	
	Bitmap forv,back;
	
	float x,y, Vx,Vy, shir,vis, heropos;
	
	int derect = 0;
	
	Ground[] ground; 
	
	
	public Enemy(Bitmap Forvard, Bitmap Back, float X, float Y, float VX, float VY) {
		
        forv = Forvard;
        back = Back;
        
        x = X;
        y = Y;
        
        Vx = VX;
        Vy = VY;
        
       
		
	}
	
	void mind(float Xhero, float Yhero) {
		
		if (x>Xhero) {derect = -1;}
		
		if (x<Xhero) {derect = 1;}
		
	}
	
	
	void move() {
		
	//	mind(conf.herox, conf.heroy);
		
		
	}
	
	
	
	
	
	
}
