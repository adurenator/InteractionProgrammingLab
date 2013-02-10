package controllers;

import java.util.ArrayList;

import Types.ExtraContent;
import android.view.View;
import android.view.View.OnClickListener;

import se.kth.csc.iprog.dinnerplanner.DishChooser;
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
			
			ArrayList<ExtraContent> ec = new ArrayList<ExtraContent>();
			ExtraContent ec1 = new ExtraContent();
			ec1.name = "init";
			ec1.extra = "1";
			ec.add(ec1);
			
			SuperController.changeActivity(view.activity, DishChooser.class, false, ec);
		} catch (NumberFormatException e){
			view.guestSelectionEnteringNumberField.setText("");
		}
			
	}
	
}