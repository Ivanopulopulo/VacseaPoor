package menuparts;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class BackGround {

	Bitmap picture ;
	Rect onpicturesrc;
	Rect onscreensrc;
	
	  float k;
	
	public BackGround(Bitmap p) {
	  picture = p;	
	}
	
	void draw(Canvas c, int Width, int Height) {
	//Paint p = new Paint();

		k = picture.getWidth()/(c.getWidth());
		
	    onpicturesrc = new Rect(0,0,picture.getWidth(),picture.getHeight());
		onscreensrc = new Rect(-2,-2,Width+2,Height+2);
		
		c.drawBitmap(picture , onpicturesrc, onscreensrc, null);
	}
	
	
}
