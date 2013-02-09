package controllers;

import android.view.View;
import android.view.View.OnClickListener;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import views.GuestSelection_View;

public class GuestSelection_Controller implements OnClickListener{
	
	// Activity used by the view
	private DinnerModel model;
	private GuestSelection_View view;

	public GuestSelection_Controller(GuestSelection_View associatedView, DinnerModel associatedModel){
		model = associatedModel;
		
		view = associatedView;
		view.guestSelectionConfirmButton.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		try{
			int numberOfGuests = Integer.parseInt(view.guestSelectionEnteringNumberField.getText().toString());
			model.setNumberOfGuests(numberOfGuests);
			SuperController.performPositive(view.activity, null);	
		} catch (NumberFormatException e){
			view.guestSelectionEnteringNumberField.setText("");
		}
			
	}
	
}