package com.vipuldamor87.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHelper myDb = new DataBaseHelper(this);
        PrimeThread p = new PrimeThread(myDb);
        new Thread(p).start();

        GraphView graph = (GraphView) findViewById(R.id.graph);
       /* LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        /*LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6),
                new DataPoint(5, 7),
                new DataPoint(6, 6),
                new DataPoint(7, 12),
                new DataPoint(8, 13)

        });
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(10);
        graph.getViewport().setMaxX(50);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(150);

        graph.getViewport().setScrollable(true);
        graph.getViewport().setScrollableY(true);
        graph.getViewport().setScalable(true);


        graph.addSeries(series);*/
        SecondThread s = new SecondThread(myDb,graph);
        new Thread(s).start();
    }

    private DataPoint[] getDataPoint() {
        Random rand = new Random();
        int i = 1;
        DataBaseHelper myDb = new DataBaseHelper(this);
        int max= myDb.getCount();
        DataPoint[] dp = new DataPoint[max];
               /* {
                        new DataPoint(0, 90),

                };*/
        dp[0] = new DataPoint(0, 90);
        for (i = 1; i < max; i++)
        {
            dp[i] = new DataPoint(i, myDb.getValue(i));
        }

        return  dp;
    }
}