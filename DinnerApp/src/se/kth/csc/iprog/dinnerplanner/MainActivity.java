package se.kth.csc.iprog.dinnerplanner;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_screen);
		
		// CUSTOMiZE FONT (We'll use it on the new lab)
		// Creation of custom fonts.
		//android.graphics.Typeface tfBalqBold = android.graphics.Typeface.createFromAsset(getAssets(),
        //                                       "fonts/BalsamiqSansBold.ttf");
		//android.graphics.Typeface tfBalqBoldIt = android.graphics.Typeface.createFromAsset(getAssets(),
        //                                       "fonts/BalsamiqSansBoldItalic.ttf");
		//android.graphics.Typeface tfBalqIt = android.graphics.Typeface.createFromAsset(getAssets(),
        //                                     "fonts/BalsamiqSansItalic.ttf");
		//android.graphics.Typeface tfBalqReg = android.graphics.Typeface.createFromAsset(getAssets(),
        //                                      "fonts/BalsamiqSansRegular.ttf");
		
		// Setting of custom fonts on the different textViews
		//ViewGroup view = (ViewGroup)getWindow().getDecorView();
		//if(((ViewGroup)findViewById(android.R.id.content)).getChildAt(0).getId()==R.layout.activity_start_screen){
		//	android.widget.TextView tvStartScreenTitle = (android.widget.TextView) findViewById(R.id.dinnerAppTitle);
		//	tvStartScreenTitle.setTypeface(tfBalqBoldIt);
        
		//	android.widget.TextView tvStartScreenDescription = (android.widget.TextView) findViewById(R.id.dinnerAppDescription);
		//	tvStartScreenDescription.setTypeface(tfBalqReg);
		
		// To get the dinner model you can use the following code:
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
