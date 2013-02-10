package controllers;

import se.kth.csc.iprog.dinnerplanner.DescriptionPopup;
import se.kth.csc.iprog.dinnerplanner.DishChooser;
import se.kth.csc.iprog.dinnerplanner.GuestSelection_Activity;
import se.kth.csc.iprog.dinnerplanner.Ingredients;
import se.kth.csc.iprog.dinnerplanner.PreparationActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SuperController
{
	
	/*
	 * NOTE:
	 * Even if it seem that the implementation has a lot
	 * of replicated code, leave it as it is. 
	 * Depending on whether the activity to call is a popup or not
	 * the super-controllers behavior is different.
	 */
	
	// This method is the one to be called in any action button
	// that performs a "positive" action, like "accept/next/OK/.."
	public static void performPositive(Activity a, Object parameter)
	{
		Intent i = null;
		Context c = a.getApplicationContext();
		String name = a.getLocalClassName();
		Log.v("DinnerApp", "Activity title: " + name);
		
		if (name.equals("MainActivity")) {
			Log.v("DinnerApp", "Entered 1");
			a.finish();
			i = new Intent(a.getApplicationContext(), GuestSelection_Activity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		}
		
		else if (name.equals("GuestSelection_Activity")) {
			Log.v("DinnerApp", "Entered 2");
			a.finish();
			i = new Intent(a.getApplicationContext(), DishChooser.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			i.putExtra("init", 1);
		}
		
		else if (name.equals("DishChooser")) {
			Log.v("DinnerApp", "Entered 3");
			
			// shows description popup
			if ((String) parameter == "description") {
				i = new Intent(a.getApplicationContext(), DescriptionPopup.class);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			}
			
			// shows ingredients popup
			else if ((String) parameter == "ingredients") {
				i = new Intent(a.getApplicationContext(), Ingredients.class);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			}
			
			// shows preparation activity
			else {
				a.finish();
				i = new Intent(a.getApplicationContext(), PreparationActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			}
		}
		
		// DescriptionPopup activity has not positive event, its only "back"
		//else if (name == "DescriptionPopup") { }
		
		// Ingredients activity has not positive event, its only "back"
		//else if (name == "Ingredients") { }
		
		// Preparation activity has not positive event, its only "back"
		//else if (name == "PreparationActivity") { }
		
		if (i != null) c.startActivity(i);
	}
	
	// This method is the one to be called in any action button
	// that performs a "negative" action, like "decline/back/cancel/.."
	public static void performNegative(Activity a, Object parameter)
	{
		Intent i = null;
		Context c = a.getApplicationContext();
		String name = a.getLocalClassName();
		Log.v("DinnerApp", "Activity title: " + name);
		
		// MainActivity activity has not negative event, its only "next"
		//if (name.equals("MainActivity")) { }
		
		// GuestSelection_Activity activity has not negative event, its only "next"
		//else if (name.equals("GuestSelection_Activity")) { }
		
		if (name.equals("DishChooser")) {
			a.finish();
			i = new Intent(a.getApplicationContext(), GuestSelection_Activity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		}
		
		else if (name.equals("DescriptionPopup")) {
			a.finish();
		}
		
		else if (name.equals("Ingredients")) {
			a.finish();
		}
		
		else if (name.equals("PreparationActivity")) {
			Log.v("DinnerApp", "Entered 6");
			a.finish();
			i = new Intent(a.getApplicationContext(), DishChooser.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			i.putExtra("init", 3);
		}
		
		if (i != null) c.startActivity(i);
	}
	
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
	public static void changeActivity(Activity srcAct, Class dstAct, boolean popup, ExtraContent[] extras)
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
	
	private static void addExtras(Intent i, ExtraContent[] extras)
	{
		for (int j = 0; j < extras.length; ++j) {
			i.putExtra(extras[j].name, extras[j].extra);
		}
	}
	
	public class ExtraContent {
		public String name;
		public String extra;
	};

}
