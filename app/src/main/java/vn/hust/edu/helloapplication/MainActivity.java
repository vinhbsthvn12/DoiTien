package vn.hust.edu.helloapplication;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class B2Activity extends AppCompatActivity implements View.OnClickListener {

    public static final double USD = 23340;
    public static final double VND = 1;
    public static final double YEN = 208.92;
    public static final double EUR = 24987;
    public static final double THB = 633.97;

    private List<String> items;
    ArrayAdapter<String> adapter1;
    Spinner spinner, spinner2;
    Boolean convert1[] = new Boolean[5];
    Boolean convert2[] = new Boolean[5];
    Double ExchangeRate[] = new Double[5];
    Double ExchangeRate1, ExchangeRate2;
    Boolean text_edit1 = false, text_edit2 = true;
    private  TextView textView1, textView2;
    private StringBuilder build = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2);

        textView1 = findViewById(R.id.text_convert_1);
        textView2 = findViewById(R.id.text_convert_2);
        textView2.setTextColor(Color.RED);

        findViewById(R.id.btn_c0).setOnClickListener(this);
        findViewById(R.id.btn_c1).setOnClickListener(this);
        findViewById(R.id.btn_c2).setOnClickListener(this);
        findViewById(R.id.btn_c2).setOnClickListener(this);
        findViewById(R.id.btn_c3).setOnClickListener(this);
        findViewById(R.id.btn_c4).setOnClickListener(this);
        findViewById(R.id.btn_c5).setOnClickListener(this);
        findViewById(R.id.btn_c6).setOnClickListener(this);
        findViewById(R.id.btn_c7).setOnClickListener(this);
        findViewById(R.id.btn_c8).setOnClickListener(this);
        findViewById(R.id.btn_c9).setOnClickListener(this);
        findViewById(R.id.btn_bs).setOnClickListener(this);
        findViewById(R.id.btn_ce).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.text_convert_1).setOnClickListener(this);
        findViewById(R.id.text_convert_2).setOnClickListener(this);



        // Create data
        items = new ArrayList<>();

        items.add("Vietnamdong (VND)"); //0
        items.add("US Dollar (USD)");   //1
        items.add("Yen (JPY)");         //2
        items.add("Euro (EUR)");        //3
        items.add("Thailand Baht (THB)");//4

        ExchangeRate[0] = VND;
        ExchangeRate[1] = USD;
        ExchangeRate[2] = YEN;
        ExchangeRate[3] = EUR;
        ExchangeRate[4] = THB;

        for (int i = 0; i < convert1.length ; i++) {
            convert1[i] = false;
            convert2[i] = false;
        }

        //adapter1 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,  items );
        adapter1 = new ArrayAdapter<String>(this, R.layout.layout_item, R.id.text_view  , items );
        spinner = findViewById(R.id.spiner);
        spinner2 = findViewById(R.id.spiner2);
        spinner.setAdapter(adapter1);
        spinner2.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convert1[position] = true;
                for (int i = 0; i < convert1.length ; i++) {
                    if(i != position)
                        convert1[i] = false;
                }
                ExchangeRate1 = ExchangeRate[position];
                Log.v("TAG", "convert1 "+ position +" is " + ExchangeRate1);
                if(!build.toString().equals("")){
                    String str2 = build.toString();
                    inputText(str2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convert2[position] = true;
                for (int i = 0; i < convert1.length ; i++) {
                    if(i != position)
                        convert2[i] = false;
                }
                ExchangeRate2 = ExchangeRate[position];
                Log.v("TAG", "convert2 "+ position +" is " +ExchangeRate2);
                if(!build.toString().equals("")){
                    String str1 = build.toString();
                    inputText(str1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if(id == R.id.btn_c0){

            build.append(0);
            String res = build.toString();
            this.inputText(res);
        }else
        if(id == R.id.btn_c1){
            build.append(1);
            String res = build.toString();
            this.inputText(res);
        }else
        if(id == R.id.btn_c2){
            build.append(2);
            String res = build.toString();
            this.inputText(res);


        }else
        if(id == R.id.btn_c3){
            build.append(3);
            String res = build.toString();
            this.inputText(res);

        }else
        if(id == R.id.btn_c4){
            build.append(4);
            String res = build.toString();
            this.inputText(res);

        }else
        if(id == R.id.btn_c5){
            build.append(5);
            String res = build.toString();
            this.inputText(res);

        }else
        if(id == R.id.btn_c6){
            build.append(6);
            String res = build.toString();
            this.inputText(res);

        }else
        if(id == R.id.btn_c7){
            build.append(7);
            String res = build.toString();
            this.inputText(res);

        }else
        if(id == R.id.btn_c8){
            build.append(8);
            String res = build.toString();
            this.inputText(res);

        }else
        if(id == R.id.btn_c9){
            build.append(9);
            String res = build.toString();
            this.inputText(res);

        }else
        if(id == R.id.btn_dot){
            build.append(".");
            String res = build.toString();
            this.inputText(res);

        }else
        if(id == R.id.btn_ce){
            if(build.length() > 1){
                build.setLength(0);
                build.append(0);
                String res = build.toString();
                textView1.setText(res);
                textView2.setText(res);
                build.setLength(0);
            }

        }else
        if(id == R.id.btn_bs){
            if(build.length() > 1){
                build.setLength(build.length()-1);
                String res = build.toString();
                inputText(res);
            }else{
                build.setLength(0);
                build.append(0);
                String res = build.toString();
                textView1.setText(res);
                textView2.setText(res);
                build.setLength(0);
            }

        }else
        if(id == R.id.text_convert_1){
            text_edit1 = true;
            text_edit2 = false;
            textView1.setTextColor(Color.RED);
            textView2.setTextColor(Color.BLACK);
            String str1 = textView1.getText().toString();
            build.setLength(0);
            build.append(str1);
            Log.v("TAG", "convert 1 is selected");
        }else
        if(id == R.id.text_convert_2){
            Log.v("TAG", "convert 2 is selected");
            text_edit1 = false;
            text_edit2 = true;
            textView2.setTextColor(Color.RED);
            textView1.setTextColor(Color.BLACK);
            String str2 = textView2.getText().toString();
            build.setLength(0);
            build.append(str2);
            Log.v("TAG", "convert 1 is selected");

        }

    }
    private void inputText(String str){

        if(text_edit1){
            textView1.setText(str);
            Double convert_str = Double.parseDouble(str);
            Double db2 = convert_str * (ExchangeRate1/ExchangeRate2);
            Double dbr2 = round(db2);
            String str2 = dbr2.toString();
            textView2.setText(str2);
        }
        if(text_edit2){
            textView2.setText(str);
            Double convert_str = Double.parseDouble(str);
            Double db2 = convert_str * (ExchangeRate2/ExchangeRate1);
            Double dbr2 = round(db2);
            String str2 = dbr2.toString();
            textView1.setText(str2);
        }

    }
    private  double round(double value) {
        long factor = (long) Math.pow(10, 5);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
