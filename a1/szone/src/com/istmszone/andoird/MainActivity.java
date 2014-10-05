package com.istmszone.andoird;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText userEmail = null;
	private EditText password = null;
	private Button login, register = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		userEmail = (EditText)findViewById(R.id.editTextEmail);
		password = (EditText)findViewById(R.id.editTextPassword);
		login = (Button)findViewById(R.id.buttonLogin);
		register = (Button)findViewById(R.id.buttonRegister);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void login(View view) {
		
		if (userEmail == null){
			Toast.makeText(getApplicationContext(), "Wrong Credentials",
				      Toast.LENGTH_SHORT).show();
		}
		else {
			Toast.makeText(getApplicationContext(), "something Credentials",
				      Toast.LENGTH_SHORT).show();
		}

	}
	
	
}
