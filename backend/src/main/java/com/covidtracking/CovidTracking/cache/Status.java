package com.covidtracking.CovidTracking.cache;


public class Status {

    int hit;
    int miss;

    public Status(int hit, int miss) {
        this.hit = hit;
        this.miss = miss;
    }

    public int getHit() {
        return hit;
    }

    public void setHit() {
        this.hit+=1;
    }

    public int getMiss() {
        return miss;
    }

    public void setMiss() {
        this.miss +=1;
    }

    @Override
    public String toString() {
        return "Cache status{" +
                "hit=" + hit +
                ", miss=" + miss +
                '}';
    }

    public void TimerCache(String obj){
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Cache.cacheMap.remove(obj);
                    }
                },
                300000 //The object stays in cache for 5 minutes
                
        );
    }
}