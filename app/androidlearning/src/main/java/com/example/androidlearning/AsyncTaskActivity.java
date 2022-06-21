package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class AsyncTaskActivity extends AppCompatActivity {

    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);


    }
    public void startAsyncTask(View view) {
        ExampleAsyncTask task = new ExampleAsyncTask(this);
        task.execute(10);
    }

    // https://youtu.be/uKx0FuVriqA
    // input param, post param, return type
    // for a mp3 downloader:
    // pass url as String, post integer (percent) of progress, and return mp3
    // if we do not make it static, this inner class holds an implicit reference to the
    // outer class (AsyncTaskActivity). (This can be proved because we can access progress bar,
    // which belongs to AsyncTaskActivity) So when the activity is destroyed, this inner
    // class may live longer than activity and the reference, progress bar, cannot be
    // garbage collected, and causing memory leaks.
    // But if we make it static, we cannot access progress bar, so we make weak reference
    private static class ExampleAsyncTask extends AsyncTask<Integer, Integer, String>{
        private final WeakReference<AsyncTaskActivity> activityWeakReference;
        ExampleAsyncTask(AsyncTaskActivity activity) {
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // here we use weak ref. to get a strong ref.
            AsyncTaskActivity activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()){
                return;
            }
            activity.progressBar.setVisibility(View.VISIBLE);
        }

        // Integer... integers means var, means we can pass as many as params as we want
        @Override
        protected String doInBackground(Integer... integers) {
            for(int i = 0; i< integers[0]; i++){
                // This calls onProgressUpdate method
                publishProgress((i * 100) / integers[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "AsyncTask Finished!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            // here we use weak ref. to get a strong ref.
            AsyncTaskActivity activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()){
                return;
            }
            activity.progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            AsyncTaskActivity activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()){
                return;
            }
            // to ui
            Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
            activity.progressBar.setProgress(0);
            activity.progressBar.setVisibility(View.INVISIBLE);
        }

    }
}