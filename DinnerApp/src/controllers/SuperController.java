package controllers;

import java.util.ArrayList;

import Types.ExtraContent;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SuperController
{	
	/**
	 * Starts a new activity.
	 * If no new activity is specified the previous activity is terminated.
	 * If the new activity is the same as the previous activity nothing happens.
	 * If popup is set to true the previous activity is not terminated. 
	 * @param srcAct the source/previous activity.
	 * @param dstAct the destination/new activity.
	 * @param popup if true the dstAct is started as a popup, otherwise srcAct is stopped.
	 */
	@SuppressWarnings("rawtypes")
	public static void changeActivity(Activity srcAct, Class dstAct, boolean popup, ArrayList<ExtraContent> extras)
	{
		Intent i = null;
		Context c = srcAct.getApplicationContext();
		Log.v("DinnerApp", "Activity title: " + srcAct.getLocalClassName());
		
		if(dstAct == null) {
			srcAct.finish();
			return;
		}
		
		if(srcAct.getClass() == dstAct)
			return;
		
		if(!popup)
			srcAct.finish();

		i = new Intent(srcAct.getApplicationContext(), dstAct);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		if (extras != null) addExtras(i, extras);
		
		if (i != null) c.startActivity(i);
	}
	
	private static void addExtras(Intent i, ArrayList<ExtraContent> extras)
	{
		for (int j = 0; j < extras.size(); ++j) {
			i.putExtra(extras.get(j).name, extras.get(j).extra);
		}
	}

}
