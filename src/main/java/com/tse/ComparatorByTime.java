package com.tse;

import java.util.Comparator;

public class ComparatorByTime implements Comparator<Athlete> {

    @Override
    public int compare(Athlete o1, Athlete o2) {
        return o1.getTime().compareTo(o2.getTime());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
