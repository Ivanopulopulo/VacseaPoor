package com.mainaction;



import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Box {

	
	boolean Moveble = false;
	NotAnimatePers boxPicture;
	float x=-100, y=-100, Vx=0, M = 0.1f, winH, winW;
	int i;
	
public Box(Bitmap BoxPicture, float Xg, float Yg) {
	
	boxPicture = new NotAnimatePers (BoxPicture);
	x = Xg;
	y = Yg;
	
}


public int check(float distx, float disty, int shir, int vis) {
	i=3;
	
	
	if ((distx+shir>x)&(distx<x)&!((disty-y-boxPicture.Pers.getHeight()>-1))) {
		i = -1;
		
	}
	
	if ((distx<x+boxPicture.Pers.getWidth())&(distx+shir>x + boxPicture.Pers.getWidth())&!((disty-y-boxPicture.Pers.getHeight()>-1))) {
		i =  1;
	}
	
	
	if ((disty-y-boxPicture.Pers.getHeight()>-1)&((distx+shir>x)&(distx<x+boxPicture.Pers.getWidth()))) {
		i = 0;
	}
	
	if (!(distx+shir>x)||!(distx<x+boxPicture.Pers.getWidth())) {
		i = 5;
	}
	
	
	
	return i;
}



public boolean isMoveble() {
	return Moveble;
}


public void setMoveble(boolean moveble) {
	Moveble = moveble;
}


void Move(float actingV, float actingm) {
	if (Moveble) 
	{
		Vx = actingV;
		x+=Vx;
	}
}

void slow() {
	if (Vx>0.01) {
	Vx-=0.01;
	}
	if (Vx<-0.01) {
		Vx+=0.01;
    }
	if ( (Vx == 0.01) || (Vx == -0.01)) {
		Vx = 0;
	}
}


void Draw(Canvas gra) {
	boxPicture.Draw(gra, x, winH - boxPicture.Pers.getHeight() - y);
}




}
