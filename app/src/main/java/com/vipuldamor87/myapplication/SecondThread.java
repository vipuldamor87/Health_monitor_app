package com.vipuldamor87.myapplication;

import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

import static android.content.ContentValues.TAG;

public class SecondThread extends Thread implements Runnable {
     DataBaseHelper myDb;
    GraphView graph;
    LineGraphSeries<DataPoint> series;
    int max,min;
    public SecondThread(DataBaseHelper myDb,GraphView graph) {
        this.myDb = myDb; this.graph = graph;
    }
    public void run()
    {
        Log.e(TAG, "run: runnn");
        while (true) {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
            min = myDb.getCount() - 20;
            max = myDb.getCount() + 10;
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setMinX(min);
            graph.getViewport().setMaxX(max);
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(150);
            graph.getViewport().setScrollable(true);
            graph.getViewport().setScrollableY(true);
            graph.getViewport().setScalable(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            graph.addSeries(series);
        }
    }
    private DataPoint[] getDataPoint() {
        Random rand = new Random();
        int i = 1;
        //DataBaseHelper myDb = new DataBaseHelper(this);
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
