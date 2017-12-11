package menuparts;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class AnimatePersonmenu {

	Bitmap Pers;
	int pos = 0, col;
	
	public AnimatePersonmenu(Bitmap frames, int coll) {
		// TODO Auto-generated constructor stub
		
		Pers = frames;
		col = coll;
		
	}
	
	
	
	void Draw(Canvas gra, float x, float y) {
		
		Paint p;
		p = new Paint();
		
		//gra.drawColor(Color.YELLOW);
		
		p.setAntiAlias(true);
		 
		
		Rect src = new Rect(Pers.getWidth()*pos/col, 0, Pers.getWidth()*(pos+1)/col, Pers.getHeight());
		
		pos += 1;
		
		if (pos >= col) {
			pos = 0;
		}
		
		float x2, y2;
		
		
		x2 = x + Pers.getWidth()/col;
		y2 = y + Pers.getHeight();
		
		
		Rect dst = new Rect( (int)x, (int)y, (int)x2, (int)y2);
		
		gra.drawBitmap(Pers, src, dst, p);
		
	}
	
	
	
}
