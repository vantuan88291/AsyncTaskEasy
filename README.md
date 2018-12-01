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

`implementation 'com.github.vantuan88291:AsyncTaskEasy:1.0.3'`

### Usage
- Just add in your code, set visibility to hide and show the Customloadingbar
```new Async() {
               @Override
               protected String doBackground() {
                   //do your job in background
                   return null;
               }

               @Override
               protected void onSuccess(String s) {
                   super.onSuccess(s);
                   //do your result
               }
           };
```



####  Supported Attributes
 function            | Description  |
| ------------- | -----:|
| onLoading()      | show loading progress |
| onSuccess     | show your result |
| doBackground | run in background |