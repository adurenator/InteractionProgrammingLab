package se.kth.csc.iprog.dinnerplanner;

import android.app.Activity;
import android.widget.TextView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class HeaderView {
	
	private Activity activity;
	private DinnerModel model;
	
	public HeaderView(Activity activity, DinnerModel model) {
		this.activity = activity;
		this.model = model;
	}
	
	/**
	 * Updates the fields in the header (number of guests and total menu price).
	 */
	public void updateHeaderFields() {
		TextView textView;
		
		// Update the number of guests
		textView = (TextView) activity.findViewById(R.id.guests_number);
		textView.setText(Integer.toString(model.getNumberOfGuests()));
		
		// Update the total menu price
		textView = (TextView) activity.findViewById(R.id.total_price);
		textView.setText(Float.toString(model.getTotalMenuPrice()) + " kr");
	}
}
