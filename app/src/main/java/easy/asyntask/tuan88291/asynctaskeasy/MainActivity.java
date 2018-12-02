package easy.asyntask.tuan88291.asynctaskeasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import easy.asyntask.tuan88291.asynctaskeasy.Room.AppDatabase;
import easy.asyntask.tuan88291.asynctaskeasy.Room._Data;
import easy.asyntask.tuan88291.library.Async;

public class MainActivity extends AppCompatActivity {

    private TextView mSecond;
    private AppDatabase db;
    private List<_Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSecond = findViewById(R.id.second);
        db = AppDatabase.getAppDatabase(this);
        getData();

    }

    private void getData() {
        Async job = new Async() {
            @Override
            protected Object doBackground() {
                data = db.queries().getAll();
                return data;
            }

            @Override
            protected void onSuccess(Object s) {
                super.onSuccess(s);
                //do your result
                List<_Data> item = (List<_Data>) s;
                mSecond.setText(item.get(4).getName());
            }

            @Override
            protected void onFail(String err) {
                super.onFail(err);
                mSecond.setText(err);

            }

            @Override
            protected void onLoading() {
                super.onLoading();
                mSecond.setText("loading");
            }
        };
        ///stop async
//        job.stop();
    }
}
