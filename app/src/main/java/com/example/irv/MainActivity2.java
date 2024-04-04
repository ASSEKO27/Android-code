package com.example.irv;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

import com.example.irv.R;

public class MainActivity2 extends AppCompatActivity {
    JSONArray jArray;
    JSONObject json_data;
    int i;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        jArray=null;
        EditText rech = (findViewById(R.id.rech));
        findViewById(R.id.button).setOnClickListener(view -> {
            try {
                String adresse = "http://192.168.1.149/test.php?rech="+rech.getText().toString();
                String wololo = new HTTPRequest.HTTPSELECTRequest().execute(adresse).get();
                jArray = new JSONArray(wololo);
                i=0;
                json_data = jArray.getJSONObject(i);
                ((TextView) findViewById(R.id.name1)).setText(json_data.getString("name"));
                ((TextView) findViewById(R.id.street)).setText(json_data.getString("street"));
                ((TextView) findViewById(R.id.mail)).setText(json_data.getString("email"));
                ((TextView) findViewById(R.id.phone)).setText(json_data.getString("phone"));
                ((TextView) findViewById(R.id.ville)).setText(json_data.getString("city"));
                ((TextView) findViewById(R.id.fonction)).setText(json_data.getString("function"));
                ((TextView) findViewById(R.id.companie)).setText(json_data.getString("commercial_company_name"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.button2).setOnClickListener(view -> {
            try {
                if(i>0) {
                    i--;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.name1)).setText(json_data.getString("name"));
                    ((TextView) findViewById(R.id.street)).setText(json_data.getString("street"));
                    ((TextView) findViewById(R.id.mail)).setText(json_data.getString("email"));
                    ((TextView) findViewById(R.id.phone)).setText(json_data.getString("phone"));
                    ((TextView) findViewById(R.id.ville)).setText(json_data.getString("city"));
                    ((TextView) findViewById(R.id.fonction)).setText(json_data.getString("function"));
                    ((TextView) findViewById(R.id.companie)).setText(json_data.getString("commercial_company_name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.button3).setOnClickListener(view -> {
            try {
                if(i<jArray.length()-1) {
                    i++;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.name1)).setText(json_data.getString("name"));
                    ((TextView) findViewById(R.id.street)).setText(json_data.getString("street"));
                    ((TextView) findViewById(R.id.mail)).setText(json_data.getString("email"));
                    ((TextView) findViewById(R.id.phone)).setText(json_data.getString("phone"));
                    ((TextView) findViewById(R.id.ville)).setText(json_data.getString("city"));
                    ((TextView) findViewById(R.id.fonction)).setText(json_data.getString("function"));
                    ((TextView) findViewById(R.id.companie)).setText(json_data.getString("commercial_company_name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}