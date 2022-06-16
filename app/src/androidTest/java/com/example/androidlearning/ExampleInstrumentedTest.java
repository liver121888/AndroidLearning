package com.example.androidlearning;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.androidlearning.service.MyBackgroundService;

import java.util.concurrent.TimeoutException;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.androidlearning", appContext.getPackageName());
    }
    //
    //    @Rule
    //    public final ServiceTestRule serviceRule = new ServiceTestRule();
    //    @Test
    //    public void testWithBoundService() {
    //        // Create the service Intent.
    //        Intent serviceIntent =
    //                new Intent(ApplicationProvider.getApplicationContext(),
    //                        MyBackgroundService.class);
    //
    //        // Data can be passed to the service via the Intent.
    //        serviceIntent.putExtra(MyBackgroundService.SEED_KEY, 42L);
    //
    //        // Bind the service and grab a reference to the binder.
    //        IBinder binder = serviceRule.bindService(serviceIntent);
    //
    //        // Get the reference to the service, or you can call
    //        // public methods on the binder directly.
    //        MyBackgroundService service =
    //                ((MyBackgroundService.LocalBinder) binder).getService();
    //
    //        // Verify that the service is working correctly.
    //        //        assertThat(service.getRandomInt()).isAssignableTo(Integer.class);
    //    }
    //

}