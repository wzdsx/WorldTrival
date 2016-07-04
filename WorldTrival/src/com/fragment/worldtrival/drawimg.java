package com.fragment.worldtrival;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;


public class drawimg extends ImageView{
	
	public drawimg(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
   
	   
	public drawimg(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public drawimg(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
   @Override
protected void onDraw(Canvas canvas) {
	// TODO Auto-generated method stub
	//super.onDraw(canvas);
	Drawable image= getDrawable();
	BitmapDrawable bd=(BitmapDrawable) image;
	Bitmap res=bd.getBitmap();
	
	if(res==null){
		return;
		
	}
	Bitmap target=Bitmap.createBitmap(getWidth(), 
			getHeight(), Config.ARGB_8888);
	Canvas c=new Canvas(target);
	Paint p=new Paint();
	p.setAntiAlias(true);
	RectF rect=new RectF(0,0, getWidth(),getHeight());
	c.drawRoundRect(rect,getWidth()/2, getHeight()/2, p);
	p.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	c.drawBitmap(res, 0, 0,p);
	p.reset();
	canvas.drawBitmap(target, 0,0, p);
	
}
}


