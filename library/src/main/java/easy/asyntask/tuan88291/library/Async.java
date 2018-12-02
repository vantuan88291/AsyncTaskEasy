package easy.asyntask.tuan88291.library;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

@SuppressLint("StaticFieldLeak")
public abstract class Async {
    private Asyn sync;

    protected Async() {
        sync = new Asyn() {
            @Override
            protected void onLoading() {
                Async.this.onLoading();
            }

            @Override
            protected Object doInBackGround() throws Exception {
                return Async.this.doBackground();
            }

            @Override
            protected void onSuccess(Object s) {
                Async.this.onSuccess(s);
            }

            @Override
            protected void onFail(String err) {
                Async.this.onFail(err);
            }
        };
        sync.execute();
    }

    public Async stop() {
        if (sync != null) {
            sync.cancel(true);
        }
        return this;
    }

    private abstract class Asyn extends AsyncTask<Object, Integer, Object> {
        @Override
        protected Object doInBackground(Object... strings) {

            try {
                return doInBackGround();
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            onLoading();
        }

        @Override
        protected void onPostExecute(Object s) {
            super.onPostExecute(s);
            if (s == null){
                onFail("Null value");
                return;
            }
            try {
                onSuccess(s);
            } catch (Exception e) {
                onFail(e.toString());
            }
        }

        protected abstract void onLoading();
        protected abstract Object doInBackGround() throws Exception;

        protected abstract void onSuccess(Object s);
        protected abstract void onFail(String err);
    }

    protected abstract Object doBackground() throws Exception;

    protected void onSuccess(Object s) {

    }

    protected void onLoading() {

    }

    protected void onFail(String err) {

    }

}
