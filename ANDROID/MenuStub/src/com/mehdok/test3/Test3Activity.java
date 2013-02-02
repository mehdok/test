package com.mehdok.test3;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Toast;

public class Test3Activity extends Activity
{
	//private int clickCount = 0;
	ViewStub menuStub1;
	ViewStub menuStub2;
	boolean click1 = true;
	boolean click2 = true;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //tap menu
        menuStub1 =(ViewStub)findViewById(R.id.menu_stub);
        //move menu
        menuStub2 =(ViewStub)findViewById(R.id.menu_stub2);
        //clickCount = 0;
    }
    
    public void showHiddenMenu(View v)
    {/*
    	++clickCount ;
    	if(clickCount % 2 != 0)
    		((ViewStub) findViewById(R.id.menu_stub)).setVisibility(View.VISIBLE);
    	else
    		((ViewStub) findViewById(R.id.menu_stub)).setVisibility(View.INVISIBLE);
*/
    }

	
    boolean moveOccur = false;
    
    public boolean onTouchEvent(MotionEvent event)
    {
    	
    	int action = event.getAction();
    	switch(action)
    	{
    	case MotionEvent.ACTION_DOWN:
    		moveOccur = false;
    		break;
    		
    	case MotionEvent.ACTION_UP:
    		if(!moveOccur)
    		{
    			//Toast.makeText(this, "tap occured", Toast.LENGTH_LONG);
    			if(click1)
            	{
            		menuStub1.setVisibility(View.VISIBLE);
            		click1 = false;
            	}
            	else
            	{
            		menuStub1.setVisibility(View.INVISIBLE);
            		click1 = true;
            	}
    		}
    		break;
    	
    	case MotionEvent.ACTION_MOVE:
    		moveOccur = true;
    		if(click2)
        	{
        		menuStub2.setVisibility(View.VISIBLE);
        		click2 = false;
        	}
        	else
        	{
        		menuStub2.setVisibility(View.INVISIBLE);
        		click2 = true;
        	}
    		//Toast.makeText(this, "move occured", Toast.LENGTH_LONG);
    		break;    		
    	}
    	/*
    	try
    	{
    		++clickCount ;
        	if(clickCount % 2 != 0)
        		((ViewStub) findViewById(R.id.menu_stub)).setVisibility(View.VISIBLE);
        	else
        		((ViewStub) findViewById(R.id.menu_stub)).setVisibility(View.INVISIBLE);
    	}
    	catch(Exception e)
    	{
    		String text = e.toString();
    		Toast.makeText(this, text, Toast.LENGTH_LONG);
    	}
    	return true;
    	*/
    	
    	/* this work correctly
    	if(event.getAction() == MotionEvent.ACTION_UP)
    	{
    		if(click)
        	{
        		menuStub.setVisibility(View.VISIBLE);
        		click = false;
        	}
        	else
        	{
        		menuStub.setVisibility(View.INVISIBLE);
        		click = true;
        	}
    	}
    	*/
    	/*
    	int action = event.getAction();    	
    	switch(action)
    	{
    		case MotionEvent.ACTION_DOWN:
    		case MotionEvent.ACTION_UP:
    			if(click)
    			{
    				menuStub.setVisibility(View.VISIBLE);
    				click = false;
    			}
    			else
    			{
    				menuStub.setVisibility(View.INVISIBLE);
    				click = true;
    			}
    			break;
    	}
    	*/
    	return (true);
    	
    }


	
}