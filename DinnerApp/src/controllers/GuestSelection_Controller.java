package controllers;

import views.GuestSelection_View;
import android.view.View;
import android.view.View.OnClickListener;

public class GuestSelection_Controller implements OnClickListener{
	
	// Activity used by the view
	private GuestSelection_View view;
	

	public GuestSelection_Controller(GuestSelection_View associatedView){
		view = associatedView;
		view.guestSelectionConfirmButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		//superController.performPositive(view.activity);		
	}
	
}