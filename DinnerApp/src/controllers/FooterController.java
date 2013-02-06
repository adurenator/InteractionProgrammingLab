package controllers;

import android.view.View;
import android.view.View.OnClickListener;
import se.kth.csc.iprog.dinnerplanner.R;
import views.FooterView;

public class FooterController implements OnClickListener{

	
	public FooterController(FooterView fv, FooterInterface fi){
		
		fv.back_button.setOnClickListener(this);
		fv.next_button.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.back_button){
			fi.performBack();
		} else if(v.getId()==R.id.next_button){
			fi.performNext();
		}
		
	}
	
}
