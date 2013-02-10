package controllers;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import views.HeaderView;
import se.kth.csc.iprog.dinnerplanner.GuestSelection_Activity;
import se.kth.csc.iprog.dinnerplanner.PreparationActivity;
import se.kth.csc.iprog.dinnerplanner.R;

public class HeaderController implements OnClickListener{
	
	private Activity activity;
	
	public HeaderController(HeaderView hv, Activity activity){
		
		this.activity = activity;
		
		hv.guests_button.setOnClickListener(this);
		hv.summary_button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.guests_button:
			SuperController.changeActivity(activity, GuestSelection_Activity.class, false, null);
			break;
		case R.id.summary_button:
			SuperController.changeActivity(activity, PreparationActivity.class, false, null);
			break;
		default:
			break;
		}
		
	}
	
}
