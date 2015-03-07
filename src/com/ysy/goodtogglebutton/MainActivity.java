package com.ysy.goodtogglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener
{
	private OnOffButton button;
	private OnOffButton button1;
	private OnOffButton button2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (OnOffButton)findViewById(R.id.onOffButton);
		button.setOnClickListener(this);
		button1 = (OnOffButton)findViewById(R.id.onOffButton1);
		button1.setOnClickListener(this);
		button2 = (OnOffButton)findViewById(R.id.onOffButton2);
		button2.setOnClickListener(this);
	}

	public void onClick(View v)
	{
		if (v.getId() == R.id.onOffButton)
		{
			if (button.getCurrentState())
			{
				Toast.makeText(this, "打开", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(this, "关闭", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
