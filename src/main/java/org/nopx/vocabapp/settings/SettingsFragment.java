package org.nopx.vocabapp.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import org.nopx.vocabapp.R;

public class SettingsFragment extends PreferenceFragment{
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			// Load the preferences from an XML resource
			addPreferencesFromResource(R.xml.preferences);
		}
	}
