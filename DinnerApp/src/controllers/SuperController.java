package controllers;

import se.kth.csc.iprog.dinnerplanner.DishChooser;
import se.kth.csc.iprog.dinnerplanner.GuestSelection_Activity;
import se.kth.csc.iprog.dinnerplanner.PreparationActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SuperController
{
	
	// This method is the one to be called in any action button
	// that performs a "positive" action, like "accept/next/OK/.."
	public static void performPositive(Activity a, Object parameter)
	{
		Intent i = null;
		Context c = a.getApplicationContext();
		a.finish();
		String name = a.getTitle().toString();
		Log.v("DinnerApp", "Activity title: " + name);
		
		if (name == "MainActivity") {
			i = new Intent(a.getApplicationContext(), GuestSelection_Activity.class);
		}
		else if (name == "GuestSelection_Activity") {
			i = new Intent(a.getApplicationContext(), DishChooser.class);
		}
		else if (name == "DishChooser") {
			i = new Intent(a.getApplicationContext(), PreparationActivity.class);
		}
		else if (name == "DescriptionPopup") {
			
		}
		else if (name == "Ingredients") {
			
		}
		else if (name == "PreparationActivity") {
			
		}
		c.startActivity(i);
	}
	
	// This method is the one to be called in any action button
	// that performs a "negative" action, like "decline/back/cancel/.."
	public static void performNegative(Activity a, Object parameter)
	{
		String name = a.getTitle().toString();
		Log.v("DinnerApp", "Activity title: " + name);
		
		if (name == "MainActivity") {
			
		}
		else if (name == "GuestSelection_Activity") {
			
		}
		else if (name == "DishChooser") {
			
		}
		else if (name == "DescriptionPopup") {
			
		}
		else if (name == "Ingredients") {
			
		}
		else if (name == "PreparationActivity") {
			
		}
	}

}
