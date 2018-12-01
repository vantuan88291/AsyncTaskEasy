package easy.asyntask.tuan88291.library;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

@SuppressLint("StaticFieldLeak")
public abstract class Async {
    public Async() {

        Asyn sync = new Asyn() {
            @Override
            protected void onLoading() {
                Async.this.onLoading();
            }
            @Override
            protected String doInBackGround() throws Exception{
                return Async.this.doBackground();
            }
            @Override
            protected void onSuccess(String s) {
                Async.this.onSuccess(s);
            }
        };
        sync.execute();
    }


    private abstract class Asyn extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... strings) {

            try {
                return doInBackGround();
            } catch (Exception e) {
                return e.getLocalizedMessage();
            }
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            onLoading();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            onSuccess(s);
        }
        protected abstract void onLoading();

        protected abstract String doInBackGround() throws Exception;

        protected abstract void onSuccess(String s);
    }

    protected abstract String doBackground() throws Exception;
    protected void onSuccess(String s) {

    }
    protected void onLoading() {

    }
}
