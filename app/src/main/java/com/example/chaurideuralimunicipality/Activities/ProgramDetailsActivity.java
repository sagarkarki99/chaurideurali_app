package com.example.chaurideuralimunicipality.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.chaurideuralimunicipality.R;
import com.example.chaurideuralimunicipality.model.Program;

import java.io.Serializable;

public class ProgramDetailsActivity extends AppCompatActivity implements Serializable {

    Toolbar toolbar;
    TextView programtitle,programdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_details);
        //setting up toolbar
        toolbar = findViewById(R.id.program_details_toolbar);
        toolbar.setTitle("Program Details");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //applying data to program details activity getting from Program object sent from programadaptor
        programtitle = findViewById(R.id.program_details_title);
        programdetails = findViewById(R.id.program_details_information);
        programtitle.setText(getProgramData().getTitle());
        programdetails.setText(getProgramData().getBody());
    }

    public Program getProgramData(){
        Program program = (Program) getIntent().getSerializableExtra("programdetails");
        return program;
    }
}