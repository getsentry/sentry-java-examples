package com.getsentry.raven_android_example;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.getsentry.raven.android.Raven;
import com.getsentry.raven.event.BreadcrumbBuilder;
import com.getsentry.raven.event.Breadcrumbs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context ctx = this.getApplicationContext();
        // Use the Sentry DSN (client key) from the Project Settings page on Sentry
        String sentryDsn = "https://publicKey:secretKey@host:port/1?options";

        // Initialize the Raven client
        Raven.init(ctx, sentryDsn);

        // Record a breadcrumb that will be sent with the next event(s)
        Breadcrumbs.record(
                new BreadcrumbBuilder().setMessage("User made an action").build()
        );

        // Manually catch and send an exception
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            Raven.capture(e);
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clicking this will throw an unhandled exception that Raven will send to the Sentry server
                throw new RuntimeException("Button press caused an exception!");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
