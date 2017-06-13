package com.example.sparken02.residency;


import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner house_spinner;
    private Button button;
    private EditText edtprize , edtmaintenance;
    TextView txtexpense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        house_spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.button);
        edtprize = (EditText) findViewById(R.id.edtprize);
        edtmaintenance = (EditText) findViewById(R.id.edtmantenence);
        txtexpense = (TextView) findViewById(R.id.textview);

        String[] housetype = {" Villa" , "Flate" , "House"};
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, housetype);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        house_spinner.setAdapter(dataAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtprize.getText().toString().equals("") || edtmaintenance.getText().toString().equals("") ){
                    Toast.makeText(MainActivity.this, "field not be empty", Toast.LENGTH_SHORT).show();
                }
                else {

                    int spinner_id = (int) house_spinner.getSelectedItemId();
                    switch (spinner_id) {
                        case 0:
                            Villa villa = new Villa();
                            villa.setPrize(Integer.parseInt(edtprize.getText().toString()));
                            villa.setMaintenance(Integer.parseInt(edtmaintenance.getText().toString()));
                            txtexpense.setText("Expense of Vill : " + String.valueOf(villa.expense()));
                            break;
                        case 1:
                            Flate flate = new Flate();
                            flate.setPrize(Integer.parseInt(edtprize.getText().toString()));
                            flate.setMaintenance(Integer.parseInt(edtmaintenance.getText().toString()));
                            txtexpense.setText("Expense of Flate : " + String.valueOf(flate.expense()));
                            break;
                        case 2:
                            House house = new House();
                            house.setPrize(Integer.parseInt(edtprize.getText().toString()));
                            house.setMaintenance(Integer.parseInt(edtmaintenance.getText().toString()));
                            txtexpense.setText("Expense of Raw House : " + String.valueOf(house.expense()));
                            break;
                    }
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
