package com.hugo.actfinder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ClassifiedsListingFragment extends Fragment {

    private ListView listView;
    private SimpleAdapter adapter;
    //private List<ParseObject> ob;
    private String[] titlesFromDB =  new String[500];
    private String[] descFromDB =  new String[500];
    private String[] titlesPassedValues =  new String[500];
    private String[] descPassedValues =  new String[500];
    private String[] getTimestamp =  new String[500];
    private String[] TimestampPassed =  new String[500];
    private int[] categoryFromDBcheck =  new int[500];
    private int[] getCategoryCheck =  new int[500];
    private String PATH;
    private int noOfRows = 0;
    private SharedPreferences sharedPref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from fragmenttab3.xml
        View view = inflater.inflate(R.layout.fragment_classifieds_listing, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

 //       titlesPassedValues = getTitlesFromParseCloudDB();

//        descPassedValues = getDescriptionFromParseCloudDB();
//
//        getCategoryCheck = CheckCategoryFromParseCloudDB();
//
//        TimestampPassed = getTimestampFunc();


        // ListView code starts here.
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

//        for(int i=0;i<noOfRows;i++){
//
//            if(getCategoryCheck[i] == 1){
//                HashMap<String, String> hm = new HashMap<String,String>();
//
//                PATH = "/data/data/com.example.asu.collegeclassifieds/";
//
//                String fileName = TimestampPassed[i]+"-"+titlesPassedValues[i]+".jpg";
//                String fullPath = PATH+fileName;
//
//                hm.put("listViewImage", "" + fullPath);
//                hm.put("listViewTitle", "" + descPassedValues[i]);
//
//                aList.add(hm);
//            }
//
//        }

        // Keys used in Hashmap
        String[] from = { "listViewImage","listViewTitle" };

        // Ids of views in listview_layout
        int[] to = { R.id.listViewImage,R.id.listViewTitle};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        adapter = new SimpleAdapter(getActivity(), aList, R.layout.list_view_layout, from, to);


        // Getting a reference to listview of main.xml layout file
        listView = (ListView)view.findViewById(R.id.listView);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


            }
        });

        return view;



    }


//    String[] getTimestampFunc() {
//
//        // Reading data from parse.com database
//
//        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
//                "ClassifiedsEntry");
//        query.orderByDescending("_created_at");
//        try {
//            ob = query.find();
//        }
//        catch (ParseException e) {
//            Log.e("Error", e.getMessage());
//            e.printStackTrace();
//        }
//
//        int i = 0;
//
//        for (ParseObject country : ob) {
//            getTimestamp[i] = (String) country.get("Timestamp");
//            Log.d("", getTimestamp[i]);
//            i++;
//
//        }
//
//        return getTimestamp;
//    }



//    String[] getTitlesFromParseCloudDB() {

//        // Reading data from parse.com database
//
//        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
//                "ClassifiedsEntry");
//        query.orderByDescending("_created_at");
//        try {
//            ob = query.find();
//        }
//        catch (ParseException e) {
//            Log.e("Error", e.getMessage());
//            e.printStackTrace();
//        }
//
//        int i = 0;
//
//        for (ParseObject country : ob) {
//            titlesFromDB[i] = (String) country.get("AdTitle");
//            Log.d("", titlesFromDB[i]);
//            i++;
//            noOfRows++;
//
//        }
//
//        return titlesFromDB;
//    }
//
//
//    int[] CheckCategoryFromParseCloudDB() {
//
//        // Reading data from parse.com database
//
//        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
//                "ClassifiedsEntry");
//        query.orderByDescending("_created_at");
//        try {
//            ob = query.find();
//        }
//        catch (ParseException e) {
//            Log.e("Error", e.getMessage());
//            e.printStackTrace();
//        }
//
//        int i = 0;
//
//        for (ParseObject country : ob) {
//
//            String categor = (String) country.get("Category");
//            if (categor.equals("Electronics")){
//                categoryFromDBcheck[i] = 1;
//            }
//
//            else{
//                categoryFromDBcheck[i] = 0;
//            }
//            i++;
//        }
//
//        return categoryFromDBcheck;
//    }
//
//
//
//
//    String[] getDescriptionFromParseCloudDB() {
//
//        // Reading data from parse.com database
//
//        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
//                "ClassifiedsEntry");
//        query.orderByDescending("_created_at");
//        try {
//            ob = query.find();
//        }
//        catch (ParseException e) {
//            Log.e("Error", e.getMessage());
//            e.printStackTrace();
//        }
//
//        int i = 0;
//
//        for (ParseObject country : ob) {
//            descFromDB[i] = (String) country.get("DescriptionText");
//            Log.d("", descFromDB[i]);
//            i++;
//
//        }
//
//        return descFromDB;
//   }


}
