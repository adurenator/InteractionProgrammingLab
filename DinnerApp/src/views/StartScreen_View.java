package views;

import android.widget.*;
import android.app.Activity;

import se.kth.csc.iprog.dinnerplanner.R;

public class StartScreen_View {
	
	// Activity used by the view
	public Activity activity;
	
	// Components used in the view and the controller
	public TextView dinnerAppTitle, dinnerAppDescription;
	public ImageView startScreenImage;
	public ImageButton newDinnerButton;
	
	@SuppressWarnings("unused")
	public StartScreen_View(Activity newActivity){
		
		// Setting the view and the widgets.
		activity = newActivity;
		dinnerAppTitle = (TextView) activity.findViewById(R.id.dinnerAppTitle);
		dinnerAppDescription = (TextView) activity.findViewById(R.id.dinnerAppDescription);
		startScreenImage = (ImageView) activity.findViewById(R.id.startScreenImage);
		newDinnerButton = (ImageButton) activity.findViewById(R.id.startScreenButton);
		
		// Creation of custom fonts.
		android.graphics.Typeface tfBalqBold = android.graphics.Typeface.createFromAsset(activity.getAssets(),
		                                       "fonts/BalsamiqSansBold.ttf");
		android.graphics.Typeface tfBalqBoldIt = android.graphics.Typeface.createFromAsset(activity.getAssets(),
		                                       "fonts/BalsamiqSansBoldItalic.ttf");
		android.graphics.Typeface tfBalqIt = android.graphics.Typeface.createFromAsset(activity.getAssets(),
		                                     "fonts/BalsamiqSansItalic.ttf");
		android.graphics.Typeface tfBalqReg = android.graphics.Typeface.createFromAsset(activity.getAssets(),
		                                      "fonts/BalsamiqSansRegular.ttf");
		
		// Application of fonts
		dinnerAppTitle.setTypeface(tfBalqBoldIt);
		dinnerAppDescription.setTypeface(tfBalqReg);
	}
	
}