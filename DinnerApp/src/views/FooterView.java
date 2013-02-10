package views;

import se.kth.csc.iprog.dinnerplanner.R;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class FooterView {

	
	public Button next_button;
	public Button back_button; 

	public FooterView(Activity activity, boolean back, boolean next) {
		
		next_button = (Button) activity.findViewById(R.id.next_button);
		back_button = (Button) activity.findViewById(R.id.back_button);
		
		if(!back)
			back_button.setVisibility(View.INVISIBLE);
		
		if(!next)
			next_button.setVisibility(View.INVISIBLE);
	}
	
	public FooterView(Activity activity) {
		
		this(activity, true, true);
	}
}
