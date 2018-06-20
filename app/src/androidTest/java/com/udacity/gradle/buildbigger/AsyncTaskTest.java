package com.udacity.gradle.buildbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest extends AndroidTestCase {
    @Test
    public void test() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(appContext);
        try {
            result = endpointsAsyncTask.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
        assertTrue(!result.isEmpty());
    }
}