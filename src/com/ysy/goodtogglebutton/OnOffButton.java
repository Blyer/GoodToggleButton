package com.ysy.goodtogglebutton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class OnOffButton extends View
{
	private Bitmap backGroundOn;
	private Bitmap backGroundOff;
	private Bitmap statePot;

	private Paint paint;

	private boolean state;

	private float leftPos;

	public OnOffButton(Context context)
	{
		super(context);
		initView();
	}

	public OnOffButton(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initView();
	}

	private void initView()
	{
		backGroundOn = BitmapFactory.decodeResource(getResources(), R.drawable.skin_switch_track_activited);
		backGroundOff = BitmapFactory.decodeResource(getResources(), R.drawable.skin_switch_track);
		statePot = BitmapFactory.decodeResource(getResources(), R.drawable.skin_pot);

		backGroundOn = decodeBitmap(backGroundOn, 0.5f, 0.5f);
		backGroundOff = decodeBitmap(backGroundOff, 0.5f, 0.5f);
		statePot = decodeBitmap(statePot, 0.5f, 0.5f);
		
		paint = new Paint();
		paint.setAntiAlias(true);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		setMeasuredDimension(backGroundOn.getWidth(), backGroundOn.getHeight());
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		if (state)
			canvas.drawBitmap(backGroundOn, 0, 0, paint);
		else
			canvas.drawBitmap(backGroundOff, 0, 0, paint);
		canvas.drawBitmap(statePot, leftPos, 0, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		switch (event.getAction())
		{
			case MotionEvent.ACTION_UP:
				state = !state;
				leftPos = leftPos != 0 ? 0 : backGroundOn.getWidth() - statePot.getWidth();
				invalidate();
				break;
		}
		return super.onTouchEvent(event);
	}

	public boolean getCurrentState()
	{
		return state;
	}

	private Bitmap decodeBitmap(Bitmap bitmap, float widthScale, float heightScale)
	{
		Matrix matrix = new Matrix();
		matrix.postScale(widthScale, heightScale); // 长和宽放大缩小的比例
		Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return resizeBmp;
	}

}
