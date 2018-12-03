# AsyncTaskEasy
[![](https://jitpack.io/v/vantuan88291/AsyncTaskEasy.svg)](https://jitpack.io/#vantuan88291/AsyncTaskEasy)

Make AsyncTask easier and shorter in your code, just call new Async() and do your job.
### To use font resources add support library to your dependencies:
add maven in to your build.gradle project

```gradle
allprojects {
   repositories {
      ...
      maven { url 'https://jitpack.io' }
   }
}
```

Add the dependency

`implementation 'com.github.vantuan88291:AsyncTaskEasy:1.0.5'`

### Usage
```
Async job = new Async() {
            @Override
            protected Object doBackground() {
                //do your job
                return null;
            }

            @Override
            protected void onSuccess(Object s) {
                super.onSuccess(s);
                //do your result

            }

            @Override
            protected void onFail(String err) {
                super.onFail(err);
                ///do when have some fails

            }

            @Override
            protected void onLoading() {
                super.onLoading();
                //show loading
            }
        };
```



####  Supported Attributes
 function            | Description  |
| ------------- | -----:|
| onLoading      | show loading progress |
| onSuccess     | show your result |
| doBackground | run in background |
| onFail | When have a exeption |
