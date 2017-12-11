package menuparts;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Smallable{
    	static NotAnimatePersmenu mainy;
    	
    	public Smallable(Bitmap Mainy) {
    		mainy = new NotAnimatePersmenu(Mainy);
    	}
    	
    		

    	static void draw(Canvas gra, int num, float x, float y) {
    		int n = num;
    	    int now,kol=0,s=0;
    	    
    	    Paint p;
    		p = new Paint();
    		p.setAntiAlias(true);
    		
    	      while(n!=0) {
    	      	now = n%10;
    	    	n = n/(10);

    	    	Rect src,dst;
    	    	
    	    	src = new Rect( now*mainy.Pers.getWidth()/10 + 1, 0, (now+1)*mainy.Pers.getWidth()/10, mainy.Pers.getHeight());
    	    	dst = new Rect( ((s-kol-1)*mainy.Pers.getWidth()/10)+(int)(x), (int)(y),  ((s-kol-1)*mainy.Pers.getWidth()/10)+(int)(x)+mainy.Pers.getWidth()/10, (int)(y)+mainy.Pers.getHeight());
    	    	gra.drawBitmap(mainy.Pers, src, dst, p);
    	    	kol+=1;
    	      }
    	}
}
    	

