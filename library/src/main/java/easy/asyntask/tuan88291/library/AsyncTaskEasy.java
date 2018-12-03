package easy.asyntask.tuan88291.library;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

@SuppressLint("StaticFieldLeak")
public abstract class AsyncTaskEasy {
    private Asyn sync;
    protected AsyncTaskEasy() {
        sync = new Asyn();
        sync.execute();
    }
    public AsyncTaskEasy stop() {
        if (sync != null) {
            sync.cancel(true);
        }
        return this;
    }

    private class Asyn extends AsyncTask<Object, Integer, Object> {
        @Override
        protected Object doInBackground(Object... strings) {
            try {
                return AsyncTaskEasy.this.doBackground();
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
                onFail("Value return null from doBackground method");
                return;
            }
            try {
                onSuccess(s);
            } catch (Exception e) {
                onFail(e.toString());
            }
        }
    }
    protected abstract Object doBackground() throws Exception;
    protected void onSuccess(Object s) {}
    protected void onLoading() {}
    protected void onFail(String err) {}
}
