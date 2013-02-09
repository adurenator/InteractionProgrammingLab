package se.kth.csc.iprog.dinnerplanner;

import controllers.StartScreen_Controller;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import views.StartScreen_View;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	@SuppressWarnings("unused")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_screen);
		
		// Setting the view and the controller for the start screen.
		StartScreen_View startScreen_View = new StartScreen_View(this);
		StartScreen_Controller startScreen_Controller = new StartScreen_Controller(startScreen_View);
		
		// To get the dinner model you can use the following code:
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}

}
