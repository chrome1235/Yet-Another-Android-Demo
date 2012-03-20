package com.hfk.yatv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class TouchVisualizerSingleTouchGraphicActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        vw = new TouchVisualizerSingleTouchGraphicView(this);

        setContentView(vw);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.single_graphic_config, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
		int menuItem = item.getItemId();
		int menuSingleGraphicConfigId = R.id.mnu_single_graphic_config;
	    switch (menuItem) {
	        case R.id.mnu_single_graphic_config:
	    		Intent myIntent = new Intent(TouchVisualizerSingleTouchGraphicActivity.this, TouchVisualizerTouchGraphicConfigActivity.class);
	    	    
	    		Bundle b = new Bundle();
	    	    b.putBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_CALL_BASECLASS, vw.getCallBaseClass());
	    	    b.putBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_TOUCHEVENT, vw.getHandleTouchEvent());
	    	    b.putBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_RETURNVALUE_ONACTIONDOWN, vw.getReturnValueOnActionDown());
	    	    b.putBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_RETURNVALUE_ONACTIONMOVE, vw.getReturnValueOnActionMove());
	    	    b.putBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_RETURNVALUE_ONACTIONUP, vw.getReturnValueOnActionUp());
	    	    b.putFloat(TouchVisualizerTouchGraphicConfigActivity.VALUE_PRESSUREAMP, vw.getPressureAmplification());

	    	    myIntent.putExtras(b);

	    	    startActivityForResult(myIntent, 0);
	    		return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
    	Bundle config = intent.getExtras();
    	
    	vw.setCallBaseClass(config.getBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_CALL_BASECLASS));
    	vw.setHandleTouchEvent(config.getBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_TOUCHEVENT));
    	vw.setReturnValueOnActionDown(config.getBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_RETURNVALUE_ONACTIONDOWN));
    	vw.setReturnValueOnActionMove(config.getBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_RETURNVALUE_ONACTIONMOVE));
    	vw.setReturnValueOnActionUp(config.getBoolean(TouchVisualizerTouchGraphicConfigActivity.PROCESS_RETURNVALUE_ONACTIONUP));
    	vw.setPressureAmplification(config.getFloat(TouchVisualizerTouchGraphicConfigActivity.VALUE_PRESSUREAMP));

    }
    
    TouchVisualizerSingleTouchGraphicView vw;
}
