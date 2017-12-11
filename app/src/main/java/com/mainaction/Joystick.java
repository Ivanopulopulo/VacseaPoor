package com.mainaction;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class Joystick  {
	
	
	button left, right, shoot, jump;
	
	int k = 0;
	
	float xtap,ytap;
	
	boolean lefttap; boolean righttap; boolean jumptap; boolean shoottap; 
	

	public Joystick(Bitmap Left, Bitmap Right, Bitmap Jump, Bitmap Shoot, Bitmap Leftt, Bitmap Rightt, Bitmap Jumpt, Bitmap Shoott ) {
		
		left = new button(Left,Leftt);
		
		right = new button(Right,Rightt);
		
		jump = new button(Jump,Jumpt);
		
		shoot = new button(Shoot,Shoott);
		
	}
	
	void Check (MotionEvent event, int f) {
		
		k = f;
		
		left.taped = false;
		right.taped = false;
		shoot.taped = false;
		jump.taped = false;
		
		
		for (int i = 0; i<k ; i++) {
			xtap = event.getX(i);
			ytap = event.getY(i);
			
			
			left.check(xtap,ytap,event,i);
			
			if ((left.taped)) {
				break;
			}
			
			}
			

			for (int j = 0; j<k ; j++) {
				xtap = event.getX(j);
				ytap = event.getY(j);
		
				
				right.check(xtap, ytap, event, j);
				
				if (right.taped) {
					break;
				}
				
				
			} 

				for (int i1 = 0; i1<k ; i1++) {
					xtap = event.getX(i1);
					ytap = event.getY(i1);
					
				
					
					jump.check(xtap, ytap, event, i1);
					
					if (jump.taped) {
						break;
					}
				
					
				
				}

					for (int i2 = 0; i2<k ; i2++) {
						xtap = event.getX(i2);
						ytap = event.getY(i2);
						
						
						shoot.check(xtap, ytap, event, i2);
						
						if (shoot.taped) {
							break;
						}
					}
			
		
			
		}
		
	
	
	
	

	protected void Draw(Canvas graphics, float h, float w) {	

		
		left.Draw(graphics, 0, 4*(h/6f));
		right.Draw(graphics, left.tap.Pers.getWidth(), 4*(h/6f));
		shoot.Draw(graphics, w-shoot.tap.Pers.getWidth(), 4*(h/6f));
		jump.Draw(graphics,  w-shoot.tap.Pers.getWidth()-jump.tap.Pers.getWidth(), 5*(h/6f));
		
		
		
		}
	
	
}
