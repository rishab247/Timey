package rishab.listview.com.testmyapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shake extends AppCompatActivity {

    private Button shakesve,shakeback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        shakesve=findViewById(R.id.shakesave);
        shakeback=findViewById(R.id.shakeback);
        shakeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbackse();
            }
        });
        shakesve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(shake.this,MenuActivity.class);
                startActivity(intent);
            }
        });

    }
    void onbackse(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);


        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new  Intent(shake.this,MenuActivity.class);
                startActivity(intent);

            }
        });

        alertDialog.setNegativeButton("No",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialog.setMessage("Do you want save changes ?");
        alertDialog.setTitle("Save");
        alertDialog.show();
    }
}
