package com.istmszone.andoird;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.istmszone.andoird.mock.AuthenticationService;

public class MainActivity extends Activity {
	
	private EditText userEmail = null;
	private EditText password = null;
	private Button login, register, forgotPassword = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		userEmail = (EditText)findViewById(R.id.editTextEmail);
		password = (EditText)findViewById(R.id.editTextPassword);
		login = (Button)findViewById(R.id.buttonLogin);
		register = (Button)findViewById(R.id.buttonRegister);
		forgotPassword = (Button)findViewById(R.id.buttonForgotPassword);
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
		
		if (userEmail == null || password == null){
			Toast.makeText(getApplicationContext(), "Credentials not provided",
				      Toast.LENGTH_SHORT).show();
			
			Intent intent = new Intent(this, NotificationActivity.class);
/*		    EditText editText = (EditText) findViewById(R.id.edit_message);
		    String message = editText.getText().toString();
		    intent.putExtra(EXTRA_MESSAGE, message);*/
		    startActivity(intent);
		}
		else {
			
			boolean loginStatus = AuthenticationService.login(this, this.userEmail.getText().toString(), this.password.getText().toString());
			
			Toast.makeText(getApplicationContext(), "Login status: "+loginStatus,
				      Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, NotificationActivity.class);
			/*		    EditText editText = (EditText) findViewById(R.id.edit_message);
					    String message = editText.getText().toString();
					    intent.putExtra(EXTRA_MESSAGE, message);*/
					    startActivity(intent);
		}

	}
	
	public void register(View view) {
		
		if (userEmail == null || password == null){
			Toast.makeText(getApplicationContext(), "Credentials not provided",
				      Toast.LENGTH_SHORT).show();
		}
		else {
			AuthenticationService.register(this, this.userEmail.getText().toString(), this.password.getText().toString());
			
			Toast.makeText(getApplicationContext(), "Registration Complete",
				      Toast.LENGTH_SHORT).show();
		}

	}
	
	public void forgotPassword(View view) {
		
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
