package views;

import se.kth.csc.iprog.dinnerplanner.R;
import android.widget.*;
import android.app.Activity;


public class GuestSelection_View {
	
	// Activity used by the view
	public Activity activity;
	
	// Components used in the view and the controller
	public TextView guestSelectionTitle, guestSelectionEnteringNumberLabel;
	public EditText guestSelectionEnteringNumberField;
	public ImageButton guestSelectionConfirmButton;
	
	public GuestSelection_View(Activity newActivity){
		
		// Setting the view and the widgets.
		activity = newActivity;
		guestSelectionTitle = (TextView) activity.findViewById(R.id.guestSelectionTitle);
		guestSelectionEnteringNumberLabel = (TextView) activity.findViewById(R.id.guestSelectionEnteringNumberLabel);
		guestSelectionEnteringNumberField = (EditText) activity.findViewById(R.id.guestSelectionEnteringNumberField);
		guestSelectionConfirmButton = (ImageButton) activity.findViewById(R.id.guestSelectionConfirmButton);
		
		// Creation of custom fonts.
		//android.graphics.Typeface tfBalqBold = android.graphics.Typeface.createFromAsset(activity.getAssets(),
		//                                       "fonts/BalsamiqSansBold.ttf");
		//android.graphics.Typeface tfBalqBoldIt = android.graphics.Typeface.createFromAsset(activity.getAssets(),
		//                                       "fonts/BalsamiqSansBoldItalic.ttf");
		//android.graphics.Typeface tfBalqIt = android.graphics.Typeface.createFromAsset(activity.getAssets(),
		//                                     "fonts/BalsamiqSansItalic.ttf");
		android.graphics.Typeface tfBalqReg = android.graphics.Typeface.createFromAsset(activity.getAssets(),
		                                      "fonts/BalsamiqSansRegular.ttf");
		
		// Application of fonts
		guestSelectionTitle.setTypeface(tfBalqReg);
		guestSelectionEnteringNumberLabel.setTypeface(tfBalqReg);
		guestSelectionEnteringNumberField.setTypeface(tfBalqReg);
	}
	
}