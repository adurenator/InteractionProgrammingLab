package se.kth.csc.iprog.dinnerplanner;

import controllers.*;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import views.*;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GuestSelection_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guest_selection);
		
		// Setting the view and the controller for the start screen.
		GuestSelection_View guestSelection_View = new GuestSelection_View(this);
		GuestSelection_Controller guestSelection_Controller = new GuestSelection_Controller(guestSelection_View);
		
		// To get the dinner model you can use the following code:
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
	}

}