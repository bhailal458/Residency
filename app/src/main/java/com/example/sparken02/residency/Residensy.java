package com.example.sparken02.residency;

/**
 * Created by sparken02 on 10/6/17.
 */

public abstract class Residensy {
    public int prize = 0;
    public int maintenance = 0;

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    abstract public int expense();
}
