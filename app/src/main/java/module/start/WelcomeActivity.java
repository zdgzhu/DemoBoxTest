package module.start;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demoboxtest.R;

public class WelcomeActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, WelcomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
}
