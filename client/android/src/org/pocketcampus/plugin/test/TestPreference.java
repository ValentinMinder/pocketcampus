package org.pocketcampus.plugin.test;

import org.pocketcampus.core.plugin.PluginPreference;

import android.os.Bundle;
import android.view.Window;

public class TestPreference extends PluginPreference {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
	}
}
