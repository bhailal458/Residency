package com.example.sparken02.residency;

import android.util.Log;

/**
 * Created by sparken02 on 10/6/17.
 */

public class House  extends Residensy{

    int gardenExpense = 50;
    public int expense() {
        maintenance += (prize*20)/100;
       return maintenance+ gardenExpense;
    }
}
