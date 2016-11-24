package android.bignerdranch.com.denomination_byr;

import android.provider.Telephony;
import android.renderscript.Double2;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText EditTxtBeforDenon;
    EditText EditTxtThhous;
    TextView txtAfrerDenom;
    TextView txtViewKopeik;
    Button btnDenom;
    double millitonRub;
    double thouthandRubl;
    double result;
    double result1;
    double befDenThouth;
    int resMil;
    int resKop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);

        EditTxtBeforDenon = (EditText) findViewById(R.id.Edittxt_view_befor);
     txtViewKopeik = (TextView)findViewById(R.id.txt_view_res_kopei);

        txtAfrerDenom = (TextView) findViewById(R.id.txt_view_after);
        btnDenom = (Button)findViewById(R.id.button);

       // EditTxtThhous = (EditText)findViewById(R.id.editTxtThouth);
//        txtBeforDenon.setText(0);
//        EditTxtThhous.setText(0);
          btnDenom.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  try {
//
                          //millitonRub = Double.parseDouble(String.valueOf(txtBeforDenon.getText()))*1000000;
                         // thouthandRubl =Double.parseDouble(String.valueOf(EditTxtThhous.getText()))*1000;
                      //result =(millitonRub+thouthandRubl) / 10000;
                      millitonRub = Double.parseDouble(String.valueOf(EditTxtBeforDenon.getText()));
                      result1 =(millitonRub) / 10000;

                      resMil = (int)(result1);
                      resKop = (int)((100*(result1 - (double)(resMil))));

                      /* //Значение в поле тысячи
                       befDenThouth =     Double.parseDouble(String.valueOf(EditTxtThhous.getText()));


                          if (befDenThouth<10&& befDenThouth>=0)
                          {
                              resultKopeiki = befDenThouth;
                             txtViewKopeik.setText(befDenThouth.toString()+" коп.");
                          }

                          //   result = Double.parseDouble((String) txtBeforDenon.getText())/1000;*/

                      //  summAfterDenRub=Integer.parseInt(result.toString());
                      txtAfrerDenom.setText(resMil+ " руб.");
                      txtViewKopeik.setText(resKop+" коп.");

                          Toast toast = Toast.makeText(getApplicationContext(),
                                  resMil + " рублей " +resKop +" копеек", Toast.LENGTH_SHORT);
                          toast.show();
                   //   }
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
