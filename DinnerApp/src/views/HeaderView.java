package views;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

public class HeaderView implements Observer {

	private Activity activity;
	
	public Button guests_button;
	public Button summary_button; 
	
	public HeaderView(Activity activity, DinnerModel model) {
		
		this.activity = activity;
		
		guests_button = (Button) activity.findViewById(R.id.guests_button);
		summary_button = (Button) activity.findViewById(R.id.summary_button);
		
		model.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object data) {
		TextView textView;
		DinnerModel model = (DinnerModel) observable;
		
		// Update the number of guests
		textView = (TextView) activity.findViewById(R.id.guests_button);
		textView.setText(Integer.toString(model.getNumberOfGuests()));
		
		// Update the total menu price
		textView = (TextView) activity.findViewById(R.id.total_price);
		textView.setText(Float.toString(model.getTotalMenuPrice()) + " kr");
	}
}
