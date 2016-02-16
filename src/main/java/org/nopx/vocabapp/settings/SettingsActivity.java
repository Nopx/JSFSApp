package org.nopx.vocabapp.settings;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import org.nopx.vocabapp.R;
import android.support.v4.app.FragmentActivity;
import android.app.Fragment;
import android.view.View;

public class SettingsActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//NOSUCHMETHOD Line16
		setContentView(R.layout.settingslayout);
	}
	
	public void selectAll(View view){
		
	}
	
	public void deselectAll(View view){
		
	}
}
