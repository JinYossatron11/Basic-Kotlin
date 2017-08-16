package com.example.add.begibkotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MyFirebaseInstance extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_firebase_instance);
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
            }
        }

        findViewById(R.id.subscribeButton).setOnClickListener(this);
        findViewById(R.id.unsubscribeButton).setOnClickListener(this);
        findViewById(R.id.logTokenButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

            switch (view.getId()) {
                case R.id.subscribeButton:
                    FirebaseMessaging.getInstance().subscribeToTopic("droiddev/news");
                    Log.d(TAG, "SubscribeToTopic");
                    Toast.makeText(MyFirebaseInstance.this, "SubscribeToTopic", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.unsubscribeButton:
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("droiddev/news");
                    Log.d(TAG, "UnsubscribeFromTopic");
                    Toast.makeText(MyFirebaseInstance.this, "UnsubscribeFromTopic", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.logTokenButton:
                    String token = FirebaseInstanceId.getInstance().getToken();
                    Log.d(TAG, "Token : " + token);
                    Toast.makeText(MyFirebaseInstance.this, "Token : " + token, Toast.LENGTH_SHORT).show();
                    break;
            }
    }
}
