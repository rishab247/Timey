package rishab.listview.com.testmyapplication;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class mathstop extends AppCompatActivity {
TextView txtlable,txtproblem,txtprobno;
EditText ans;
    private PendingIntent pending_intent;
    AlarmManager alarmManager;
    SparseArray<String> question = new SparseArray<>();
    SparseArray<String> ansarray = new SparseArray<>();
int count=1;
Button btn;
int max = 99,min=10,max1=30,min1=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathstop);
        Intent intent = getIntent();
        String lable = Objects.requireNonNull(intent.getExtras()).getString("lable");
        txtlable =  findViewById(R.id.mathlable);
        txtproblem = findViewById(R.id.mathproblem);
        txtprobno = findViewById(R.id.mathcount);
        ans = findViewById(R.id.mathans);
        btn = findViewById(R.id.mathstopbut);
        txtlable.setText(lable);
        final Intent myIntent = new Intent(this, AlarmReceiver.class);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final String datanoofmath = intent.getExtras().getString("datanoofmath");
        String datadiffmath = intent.getExtras().getString("datadiffmath");
        final String time  =  (intent.getExtras()).getString("time");
        final int code = Integer.valueOf(time);

        String strresult;

        //question
        for(int i=0;i<Integer.parseInt(datanoofmath);i++){
        int result;
        int no1 = (int) Math.round((Math.random() * ((max - min) + 1)) + min);
        int no2 = (int) Math.round((Math.random() * ((max - min) + 1)) + min);
        int no3 = (int) Math.round((Math.random() * ((max - min) + 1)) + min);
        int no4 = (int) Math.round((Math.random() * ((max1 - min1) + 1)) + min1);
        int no5 = (int) Math.round((Math.random() * ((max1 - min1) + 1)) + min1);
        int no6 = largestPrimeFactor(no3);
        int no7 =no3/no6;
        int no8 = (int) Math.round((Math.random() * (11) + 2));


        switch (Integer.parseInt(datadiffmath)) {
            case 0:
                result= no1+no2;
                strresult = no1+"+"+no2;
                break;
            case 1:
                result= no1+no2+no3;
                strresult = no1+"+"+no2+"+"+no3;

                break;
            case 2:
                result= no4*no5;
                strresult = no4+"x"+no5;

                break;
            case 3:
                result=no3/no7;
                strresult = no3+"/"+no7;

                break;
            case 4:
                result = (no3/no7)*no8;
                strresult ="("+no3+"/"+no7+")"+"x"+no8;

                break;
            default:
                result= no1+no2;
                strresult = no1+"+"+no2;

                break; }
                question.put(i,strresult);
                ansarray.put(i,Integer.toString(result));


        }
txtproblem.setText(question.get(0));
        Log.e("time", time );
        txtprobno.setText("1/"+datanoofmath);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = ans.getText().toString().trim();
                if(count == Integer.valueOf(datanoofmath)+1){
                    pending_intent = PendingIntent.getBroadcast(mathstop.this,code, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    Log.e("   ", "close" );
                    myIntent.putExtra("extra", "no");
                    sendBroadcast(myIntent);
                    alarmManager.cancel(pending_intent);
                }
                if(str.equals(ansarray.get(count - 1))) {
                    count++;
                    txtproblem.setText(question.get(count));
                    txtprobno.setText(count+"/"+datanoofmath);



                }

                        

            }
        });
    }
    public static int largestPrimeFactor(long number) { int i; long copyOfInput = number; for (i = 2; i <= copyOfInput; i++) { if (copyOfInput % i == 0) { copyOfInput /= i; i--; } } return i; }

}
