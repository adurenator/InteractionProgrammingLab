package se.kth.csc.iprog.dinnerplanner;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import views.FooterView;
import views.HeaderView;
import views.IngredientsView;
import Interfaces.FooterInterface;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import controllers.FooterController;
import controllers.HeaderController;
import controllers.IngredientsController;
import controllers.SuperController;

public class Ingredients extends Activity implements FooterInterface{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingredients);
		
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		/*TextView price = (TextView) findViewById(R.id.total_price);
		price.setText(""+model.getTotalMenuPrice()+'$');  //TODO how to reference to @string/currency ?
		
		TextView guestsN = (TextView) findViewById(R.id.guests_number);
		guestsN.setText(""+model.getNumberOfGuests());*/
		
		// Added the new header
		new HeaderController(new HeaderView(this, model), this);
		new FooterController(new FooterView(this,true,false), this);
		new IngredientsController(new IngredientsView(this, model));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void performNext() {}

	@Override
	public void performBack() {
		SuperController.changeActivity(this, null, false, null);
	}

}
