/*
 * LonelyTwitterActivity
 *
 * September 28th, 2017
 *
 * Copyright (c) Team X, CMPUT301, University of Alberta. All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behavior at
 *
 *
 */


package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Represents an activity
 * @author minfeng1
 * @see Tweet
 */

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets=new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	/** Called when the activity is first created. */

	/**
	 *
	 * @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tweets.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

			setResult(RESULT_OK);
			String text = bodyText.getText().toString();
			tweets.add(new NormalTweet(text));
			adapter.notifyDataSetChanged();
			saveInFile();
			}
		});
	}

	/**
	 * onStart
	 * @see Tweet
	 * @see ArrayAdapter
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * loadFromFile
	 * @see Gson
	 * @throws FileNotFoundException
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in,listType);
			String line = in.readLine();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * saveInFIle
	 * @see Gson
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets,writer);
			writer.flush();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}