package easy.asyntask.tuan88291.asynctaskeasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import easy.asyntask.tuan88291.asynctaskeasy.Room.AppDatabase;
import easy.asyntask.tuan88291.asynctaskeasy.Room._Data;
import easy.asyntask.tuan88291.library.AsyncTaskEasy;

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
//        db.queries().insertData(new _Data("tom", 12));
//        db.queries().insertData(new _Data("tom2", 13));
//        db.queries().insertData(new _Data("tom3", 14));
//        db.queries().insertData(new _Data("tom4", 15));
        getData();
    }

    private void getData() {
        AsyncTaskEasy job = new AsyncTaskEasy() {
            @Override
            protected Object doBackground() {

                data = db.queries().getAll();
                return data.get(6).getName();
            }

            @Override
            protected void onSuccess(Object result) {
                super.onSuccess(result);
                //do your result
                String it = (String) result;
                mSecond.setText(it);
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

            @Override
            protected void onLoadComplete() {
                super.onLoadComplete();
                //do when load complete, even success fail
            }
        };
        ///stop async
//        job.stop();
    }
}
