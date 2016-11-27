package android.bignerdranch.com.denomination_byr;

import android.provider.Telephony;
import android.renderscript.Double2;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
public class MainActivity extends AppCompatActivity {
    EditText EditTxtBeforDenon;
     TextView txtAfrerDenom;
    TextView txtViewKopeik;
    Button btnDenom;
    double millitonRub;
  double result1;
    int resMil;
    int resKop;
    RadioButton radioBtnDenom;
    RadioButton radioBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
 //Это первая версия проекта после в репозитории
        EditTxtBeforDenon = (EditText) findViewById(R.id.Edittxt_view_befor);
        txtViewKopeik = (TextView)findViewById(R.id.txt_view_res_kopei);

        txtAfrerDenom = (TextView) findViewById(R.id.txt_view_after);
        btnDenom = (Button)findViewById(R.id.button);

        radioBtnDenom = (RadioButton)findViewById(R.id.radioBtnDenom);
        radioBtnBack = (RadioButton)findViewById(R.id.radioBtnBack);
        btnDenom.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View v) {
                  try {

                      if ( radioBtnDenom.isChecked() && !radioBtnBack.isChecked()){

                      millitonRub = Double.parseDouble(String.valueOf(EditTxtBeforDenon.getText()));
                      result1 =(millitonRub) / 10000;

                      resMil = (int)(result1);
                      resKop = (int)((100*(result1 - (double)(resMil))));

                      txtAfrerDenom.setText(resMil+ " руб.");
                      txtViewKopeik.setText(resKop+" коп.");

                          Toast toast = Toast.makeText(getApplicationContext(),
                                  resMil + " рублей " +resKop +" копеек", Toast.LENGTH_SHORT);
                          toast.show();

                    }else if(!radioBtnDenom.isChecked() && radioBtnBack.isChecked()){
                          Toast toast = Toast.makeText(getApplicationContext(),
                                  " Обратная конвертация ", Toast.LENGTH_SHORT);
                          toast.show();

                      }
                  }catch (Exception e ){
                      Toast toast = Toast.makeText(getApplicationContext(),
                              "Введите сумму до деноминации ", Toast.LENGTH_SHORT);
                      toast.show();
                  }
                  finally {
//                      Toast toast = Toast.makeText(getApplicationContext(),
//                              "Введите сумму до деноминации блок finally", Toast.LENGTH_SHORT);
//                      toast.show();
                  }

              }
          });


    }
}
