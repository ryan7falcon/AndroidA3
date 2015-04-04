/** Class: MainActivity
 *  This program is an implementation of a simple student database
 *  with basic information about a student and features of adding and sorting 
 *  database entries.
 *   @author Ryan
 */
package com.example.a3;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity {

	//Array list that is representing a database
	private ArrayList<Student> _studentList;
	//Controls
	private EditText _fName;
	private EditText _fGpa;
	private EditText _fAddress;
	private Button _btnAdd;
	private Button _btnSort;
	private Button _btnDisplay;
	private CheckBox _cbFees;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		_studentList = new ArrayList<Student>();

		_fName = (EditText) findViewById(R.id.fName);
		_fAddress = (EditText) findViewById(R.id.fAddress);
		_fGpa = (EditText) findViewById(R.id.fGpa);
		_btnAdd = (Button) findViewById(R.id.btnAdd);
		_btnSort = (Button) findViewById(R.id.btnSort);
		_btnDisplay = (Button) findViewById(R.id.btnDisplay);
		_cbFees = (CheckBox) findViewById(R.id.cbFees);
		
		_btnAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onAdd();			
			}
		});

		_btnSort.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onSort();			
			}
		});

		_btnDisplay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onDisplay();			
			}
		});
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

	/**
	 * Adds an entry to the database using the information from text fields
	 */
	public void onAdd(){
		_studentList.add(new Student(
				_fName.getText().toString(), _fAddress.getText().toString(), 
				Double.parseDouble(_fGpa.getText().toString()), _cbFees.isChecked()
				)
		);
		_fName.setText("");
		_fAddress.setText("");
		_fGpa.setText("");
		_cbFees.setChecked(false);
	}

	/**
	 * Sorts entries alphabetically by students name
	 */
	public void onSort(){
		Collections.sort(_studentList);
		AlertDialog dlg = new AlertDialog.Builder(this).create();
		dlg.setTitle("Sorting");
		//A string that will be displayed
		String message = "Database has been sorted!";
		dlg.setMessage(message);
		dlg.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (DialogInterface.OnClickListener)null);
		dlg.show(); 
	}

	/**
	 * Displays a list of entries in a dialog
	 */
	public void onDisplay(){
		AlertDialog dlg = new AlertDialog.Builder(this).create();
		dlg.setTitle("Student List");
		//A string that will be displayed
		String message = "";
		//Fill the string with data
		for (int i = 0; i < _studentList.size(); i++)
		{
			message += _studentList.get(i) + "\n";
		}
		dlg.setMessage(message);
		dlg.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (DialogInterface.OnClickListener)null);
		dlg.show(); 
	}
}
