package com.hugo.actfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class NewAd extends AppCompatActivity {

    private EditText title;
    private EditText description;
    private Button submit;
    private String titleText;
    private String descriptionText;
    private RadioGroup category;
    private int RadioSelectedId;
    private RadioButton selectedRadioButton;
    private String categoryText;
    private String user;
    private String timestamp;

    private FirebaseUser mUserName;
    private FirebaseAuth mFirebaseAuth;


    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("project/actfinder-65b02");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_ad);

        // Create a object of "ClassifiedsEntry" class in Parse.
        // A new object(new row in Parse.com cloud) is created everytime this activity is run.
        //entry = new ParseObject("ClassifiedsEntry");


        title = (EditText)findViewById(R.id.title);
        description = (EditText)findViewById(R.id.description);

        category = (RadioGroup)findViewById(R.id.category);


        submit = (Button)findViewById(R.id.submit);

    }


    public String GetTitle(){
        titleText = title.getText().toString();
        return  titleText;
    }



    public void DataSubmit(View view){
//        mUserName = "anonymous";


        mFirebaseAuth = FirebaseAuth.getInstance();
        mUserName = mFirebaseAuth.getCurrentUser();
        user = mUserName.getDisplayName();

        titleText = title.getText().toString();
        descriptionText = description.getText().toString();

        RadioSelectedId = category.getCheckedRadioButtonId();
        selectedRadioButton = (RadioButton)findViewById(RadioSelectedId);

        categoryText = selectedRadioButton.getText().toString();

        DatabaseReference usersRef = ref.child("Post");

        Map<String, Post> posts = new HashMap<String, Post>();

        posts.put(titleText, new Post(user,titleText,descriptionText,categoryText));
        usersRef.setValue(posts);



    }




//    public void GoBack(){
//        Intent c = new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(c);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.go_to_main_activity, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.go_back) {
//            GoBack();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }





}
