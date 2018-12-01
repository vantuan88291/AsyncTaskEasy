package easy.asyntask.tuan88291.asynctaskeasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import easy.asyntask.tuan88291.library.Async;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Async() {
            @Override
            protected String doBackground() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "sleep 5s";
            }

            @Override
            protected void onSuccess(String s) {
                super.onSuccess(s);
                //do your result
            }
        };

    }
}
