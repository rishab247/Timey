package rishab.listview.com.testmyapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

import rishab.listview.com.testmyapplication.database.databasehandler;


public class DETAILS_Activity extends AppCompatActivity implements View.OnClickListener {
databasehandler db;


     private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;




    private boolean mtimeformat = false;
    private boolean msnooze = false;
    private Button closeDialog;
    private ImageView imageview,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();


        fab  = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        fab2 = findViewById(R.id.fab2);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open1);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close1);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward1);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new  Intent(DETAILS_Activity.this, MenuActivity.class);

                startActivity(intent);
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new  Intent(DETAILS_Activity.this, location.class);

                startActivity(intent);
            }
        });
         ListView listView = findViewById(R.id.recycler);
        db = new databasehandler(this);
        Cursor cursor = db.getdata();

            while(cursor.moveToNext()){
                HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
                hashMap.put("time", cursor.getString(1)+":"+cursor.getString(2));
                hashMap.put("code", cursor.getString(1)+cursor.getString(2));
                hashMap.put("repeat", cursor.getString(3));
                hashMap.put("lable", cursor.getString(4));
                arrayList.add(hashMap);//add the hashmap into arrayList
            }
        String[] from = {"time", "lable"};
        int[] to = {R.id.detailssettime, R.id.detailstitle};//int array of views id's
        final customMyAdapter simpleAdapter = new customMyAdapter(this, arrayList, R.layout.details_row, from, to);//Create object and set the parameters for simpleAdapter
        listView.setAdapter(simpleAdapter);//sets the adapter for listView

db.close();


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
          case R.id.Theme:
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (this).getLayoutInflater();

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
                        Toast.makeText(getApplicationContext(),"Coming Soon....",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Coming Soon....",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Coming Soon....",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Coming Soon....",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Coming Soon....",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Coming Soon....",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Coming Soon....",Toast.LENGTH_SHORT).show();
                    }
                });
                imageView8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Coming Soon....",Toast.LENGTH_SHORT).show();
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

                Log.d(" ", "Fab 1");
                break;
            case R.id.fab2:

                Log.d(" ", "Fab 2");
                break;
        }

    }

}



