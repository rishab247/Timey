package rishab.listview.com.testmyapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class DETAILS_Activity extends AppCompatActivity implements View.OnClickListener {


    RecyclerView recyclerView;

    customMyAdapter adapter;


    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;




    private boolean mtimeformat = false;
    private boolean msnooze = false;
    private Button closeDialog;
    private ImageView imageview,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8;
    ArrayList<Information> data = new ArrayList<>();
    Information current = new Information();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab1 = (FloatingActionButton)findViewById(R.id.fab1);
        fab2 = (FloatingActionButton)findViewById(R.id.fab2);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open1);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close1);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward1);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data.add(current);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        adapter = new customMyAdapter(this,data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Vertical Orientation By Default

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
           // case R.id.about:
                //Toast.makeText(getApplicationContext(),"about",Toast.LENGTH_SHORT).show();
            case R.id.Theme:
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                // Get the layout inflater
                LayoutInflater inflater = (this).getLayoutInflater();
                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the
                // dialog layout
                builder.setTitle("theme");

                builder.setCancelable(false);
               // builder.setIcon(R.drawable.galleryalart);
                final View dialogView= inflater.inflate(R.layout.activity_theme, null);
                imageview=dialogView.findViewById(R.id.dialog_image);
                imageView2=dialogView.findViewById(R.id.dialog_image2);
                imageView3=dialogView.findViewById(R.id.dialog_image3);
                imageView4=dialogView.findViewById(R.id.dialog_image4);
                imageView5=dialogView.findViewById(R.id.dialog_image5);
                imageView6=dialogView.findViewById(R.id.dialog_image6);
                imageView7=dialogView.findViewById(R.id.dialog_image7);
                imageView8=dialogView.findViewById(R.id.dialog_image8);
                builder.setTitle("THEME");
                builder.setNegativeButton("CLOSE",new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
                imageview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"imageview 1",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"imageview 2",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"imageview 3",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"imageview 4",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"imageview 5",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"imageview 6",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"imageview 7",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"imageview 8",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setView(dialogView);

                   builder.create();
                    builder.show();

               return true;
            case R.id.time24:
                if(item.isChecked()){
                    // If item already checked then unchecked it
                    item.setChecked(false);
                    mtimeformat = false;
                }else{
                    // If item is unchecked then checked it
                    item.setChecked(true);
                    mtimeformat = true;
                }
                return true;
           // case R.id.setting:
                //
            case R.id.snooze:
                if(item.isChecked()){
                    // If item already checked then unchecked it
                    item.setChecked(false);
                    msnooze = false;
                }else {
                    // If item is unchecked then checked it
                    item.setChecked(true);
                    msnooze = true;
                }
                return true;
                default: return super.onOptionsItemSelected(item);
        }

    }
    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
            Log.d("Raj","open");

        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id){
            case R.id.fab:

                animateFAB();

                break;
            case R.id.fab1:

                Log.d("Raj", "Fab 1");
                break;
            case R.id.fab2:

                Log.d("Raj", "Fab 2");
                break;
        }

    }

}



