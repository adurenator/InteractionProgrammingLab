package views;

import se.kth.csc.iprog.dinnerplanner.R;
import android.app.Activity;
import android.widget.Button;

public class FooterView {

	
	public Button next_button;
	public Button back_button; 
	
	public FooterView(Activity activity) {
		
		next_button = (Button) activity.findViewById(R.id.next_button);
		back_button = (Button) activity.findViewById(R.id.back_button);
	}
}
