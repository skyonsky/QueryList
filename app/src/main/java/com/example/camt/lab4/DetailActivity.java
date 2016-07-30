package com.example.camt.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public ImageView actorImage;
    public TextView actorName;
    public TextView actorDesc;
    public TextView actorDob;
    public TextView actorCountry;
    public TextView actorHeight;
    public TextView actorSpouse;
    public TextView actorChildren;
    Actors selectedActor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bindView();
        selectedActor = (Actors) getIntent().getExtras().getSerializable("actor");
        setValueToView();
    }

    private void bindView(){
        actorImage = (ImageView) findViewById(R.id.img_SelectedActor);
        actorName = (TextView) findViewById(R.id.name_SelectedActor);
        actorDesc = (TextView) findViewById(R.id.desc_SelectedActor);
        actorDob = (TextView) findViewById(R.id.dob_SelectedActor);
        actorCountry = (TextView) findViewById(R.id.country_SelectedActor);
        actorHeight = (TextView) findViewById(R.id.height_SelectedActor);
        actorSpouse = (TextView) findViewById(R.id.spouse_SelectedActor);
        actorChildren = (TextView) findViewById(R.id.children_SelectedActor);

    }

    private void setValueToView(){
        Picasso.with(this).load(selectedActor.getImage()).into(actorImage);

        actorName.setText(selectedActor.getName());
        actorDesc.setText(selectedActor.getDescription());
        actorDob.setText(selectedActor.getDob());
        actorCountry.setText(selectedActor.getCountry());
        actorHeight.setText(selectedActor.getHeight());
        actorSpouse.setText(selectedActor.getSpouse());
        actorChildren.setText(selectedActor.getChildren());

    }


}
