package com.vipuldamor87.myapplication;

import android.content.Context;
import android.util.Log;

import java.util.Random;

import static android.content.ContentValues.TAG;

public class PrimeThread extends Thread implements Runnable{

   Random rand = new Random();
   DataBaseHelper myDb;
    int i;
    public PrimeThread(DataBaseHelper myDb) {
        this.myDb = myDb;
    }

    public void run() {
        // compute primes larger than minPrime
        Log.e(TAG, "run: ITs working" );
        while( true )
        {

            while (true)
            {
                 i = rand.nextInt(100);
                if(i>50) break;
            }
            Boolean done = myDb.insertData(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
