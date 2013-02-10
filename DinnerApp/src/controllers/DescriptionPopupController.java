package controllers;

import views.DescriptionPopupView;
import android.view.View;
import android.view.View.OnClickListener;

public class DescriptionPopupController implements OnClickListener
{

	private DescriptionPopupView dpv;
	
	public DescriptionPopupController(DescriptionPopupView dpv)
	{
		this.dpv = dpv;
		dpv.back.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View arg0)
	{
		SuperController.changeActivity(dpv.a, null, false, null);
	}

}
