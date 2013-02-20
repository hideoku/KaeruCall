package spring.hope.KaeruCall;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LabeledIntent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {

    private SharedPreferences preferences;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setTitle(R.string.app_name);

        preferences = getSharedPreferences("KaeruCall", Activity.MODE_PRIVATE);

        Button buttonCall = (Button) this.findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tellNumber = preferences.getString("call", null);
                Log.d("KaeruCall", tellNumber);

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tellNumber));
                startActivity(intent);
            }
        });

        Button buttonMail = (Button) findViewById(R.id.buttonMail);
        buttonMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailAddress =  preferences.getString("mail", null);
                Log.d("KaeruCall", mailAddress);

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + mailAddress));
                startActivity(intent);
            }
        });


        Button buttonSetting = (Button) findViewById(R.id.buttonSetting);
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
}


}
