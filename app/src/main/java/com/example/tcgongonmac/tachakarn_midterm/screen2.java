package com.example.tcgongonmac.tachakarn_midterm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class screen2 extends AppCompatActivity {

    private int stamfordV = 0;
    private int thammasatV = 0;
    private int chulaV = 0;
    private int kasetV = 0;
    private int abacV = 0;
    private String selectUni = "";
    private static final int CODE = 8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);


        ListView mListView = (ListView) findViewById(R.id.list_view);
        final Context context = this;

        String [] dataName = {
                "Thammasat University",
                "Chilalongkorn University",
                "Kasetsart university",
                "Assumption University",
                "Stamford International University"
        };

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        selectUni = "thammasat";
                        break;

                    case 1:
                        selectUni = "chula";
                        break;

                    case 2:
                        selectUni = "kaset";
                        break;

                    case 3:
                        selectUni = "abac";
                        break;

                    case 4:
                        selectUni= "stamford";
                        break;
                }
                Intent detailInternet = new Intent (context , screen3.class);
                detailInternet.putExtra("universityName",selectUni);
                startActivityForResult(detailInternet,CODE);
            }
        });



        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, dataName);
        mListView.setAdapter(adapter);




    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView uni1T = (TextView) findViewById(R.id.thammasat);
        TextView uni2T = (TextView) findViewById(R.id.chula);
        TextView uni3T = (TextView) findViewById(R.id.kaset);
        TextView uni4T = (TextView) findViewById(R.id.abac);
        TextView uni5T = (TextView) findViewById(R.id.stamford);

        String uniN = " ";
        if (requestCode == CODE && resultCode == RESULT_OK) {
            switch(selectUni){
                case "thammasat":
                    uniN = "Thammasat University";
                    thammasatV += data.getIntExtra("star", 0);
                    uni1T.setText("Thammasat University: "+thammasatV);
                    break;

                case "chula":
                    uniN = "Chulalongkorn University";
                    chulaV += data.getIntExtra("star", 0);
                    uni2T.setText("Chulalongkorn University: "+ chulaV);
                    break;

                case "kaset":
                    uniN = "Kasetsart University";
                    kasetV += data.getIntExtra("star", 0);
                    uni3T.setText("Kasetsart University: "+ kasetV);
                    break;

                case "abac":
                    uniN = "Assumption University";
                    abacV += data.getIntExtra("star", 0);
                    uni4T.setText("Assumption University: "+ abacV);
                    break;

                case "stamford":
                    uniN = "Stamford International University";
                    stamfordV += data.getIntExtra("star", 0);
                    uni5T.setText("Stamford International University: "+ stamfordV);
                    break;
            }

            String str = "You have Rate " +uniN + " for " + data.getIntExtra("star", 0) + " star(s).";
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }

        }

    }



