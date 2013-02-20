package spring.hope.KaeruCall;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created with IntelliJ IDEA.
 * User: hideoku
 * Date: 13/02/19
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
public class SettingActivity extends Activity {

    private SharedPreferences preferences;

    private EditText textCall;
    private EditText textMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.setting);
        setTitle(R.string.app_name);

        preferences = getSharedPreferences("KaeruCall", Activity.MODE_PRIVATE);

        textCall = (EditText) findViewById(R.id.editTextCall);
        textMail = (EditText) findViewById(R.id.editTextMail);

        textCall.setText(preferences.getString("call", null));
        textMail.setText(preferences.getString("mail", null));

        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String callStr = textCall.getText().toString();


                String mailStr = textMail.getText().toString();

                preferences.edit().putString("call", callStr).commit();
                preferences.edit().putString("mail", mailStr).commit();

                finish();
            }
        });

        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
