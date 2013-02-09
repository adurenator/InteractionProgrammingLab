package controllers;

import android.view.View;
import android.view.View.OnClickListener;

import views.StartScreen_View;

public class StartScreen_Controller implements OnClickListener{
	
	// Activity used by the view
	private StartScreen_View view;

	public StartScreen_Controller(StartScreen_View associatedView){
		view = associatedView;
		view.newDinnerButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		SuperController.performPositive(view.activity, null);	
	}
	
}