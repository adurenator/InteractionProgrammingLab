package controllers;

import views.StartScreen_View;
import android.app.*;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

public class StartScreen_Controller implements OnClickListener{
	
	// Activity used by the view
	private StartScreen_View view;
	//private SuperController superController;

	public StartScreen_Controller(StartScreen_View associatedView){
		view = associatedView;
		view.newDinnerButton.setOnClickListener(this);
		// superController = new SuperController();
	}

	@Override
	public void onClick(View v) {
		//superController.performPositive(view.activity);	
	}
	
}