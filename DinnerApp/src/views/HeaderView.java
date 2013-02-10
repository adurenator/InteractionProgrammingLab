package views;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

public class HeaderView implements Observer {

	//private Activity activity;
	private DinnerModel model;
	
	public Button guests_button;
	public Button summary_button;
	public TextView guests_label;
	public TextView total_price;
	
	public HeaderView(Activity activity, DinnerModel model) {
		
		//this.activity = activity;
		this.model    = model;
		
		guests_button  = (Button) activity.findViewById(R.id.guests_button);
		summary_button = (Button) activity.findViewById(R.id.summary_button);
		
		guests_label = (TextView) activity.findViewById(R.id.guests_button);
		total_price  = (TextView) activity.findViewById(R.id.total_price);
		
		// initial value update
		guests_label.setText(Integer.toString(model.getNumberOfGuests()));
		total_price.setText(Float.toString(model.getTotalMenuPrice()) + " kr");
		
		model.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object data) {
		// Update the number of guests
		guests_label.setText(Integer.toString(model.getNumberOfGuests()));
		
		// Update the total menu price
		total_price.setText(Float.toString(model.getTotalMenuPrice()) + " kr");
	}
}
