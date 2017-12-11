package menuparts;




import android.graphics.Bitmap;
import android.graphics.Canvas;

public class menubutton  {
	
	boolean taped = false;
	
	float posx, posy;
	
	int level;

	NotAnimatePersmenu pict;
	
	
	
	public menubutton(Bitmap Pict, int Level, float x, float y) {
		
		pict = new NotAnimatePersmenu( Pict );		
		
		level = Level;
		
		posx = x;
		posy = y;
	}
	
	
	public boolean check (float x, float y) {
		if ((x>posx)&(x<posx+pict.Pers.getWidth())&(y>posy)&(y<posy+pict.Pers.getHeight()))
		{
		    return true;	
		}
		
		else
		{ 
			return false;
		}
	}
	
	
	
	void Draw (Canvas gra, float camx, float camy, int rec) {
		

			pict.Draw(gra, camx + posx, camy + posy);

			Label.draw(gra, level, camx + posx + pict.Pers.getWidth()/3 + (Label.mainy.Pers.getWidth())/10, camy + posy+ (Label.mainy.Pers.getHeight())/1.5f);
			Smallable.draw(gra, rec, camx + posx + pict.Pers.getWidth()/3 + (Label.mainy.Pers.getWidth())/10, camy + posy+ (pict.Pers.getHeight()));
			
	}
	
	
	
	
}
