package easy.asyntask.tuan88291.library;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
/*Created by vantuan88291
01 Dec 2018
 */

public abstract class AsyncTaskEasy {
    @SuppressLint("CheckResult")
    protected AsyncTaskEasy() {
        this.onLoading();
        Observable.fromCallable(this::doBackground)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Object>() {

                    @Override
                    public void onNext(Object o) {
                        try {
                            onSuccess(o);
                        } catch (Exception e) {
                            onFail(e.getLocalizedMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        onFail(e.getLocalizedMessage());
                        onComplete();
                    }

                    @Override
                    public void onComplete() {
                        onLoadComplete();
                    }
                });
    }

    protected abstract Object doBackground();

    protected void onSuccess(Object result) {
    }

    protected void onLoading() {
    }
    protected void onLoadComplete() {
    }
    protected void onFail(String err) {
    }
}
