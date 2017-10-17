package com.drolmen.viewpagerdemo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by drolmen on 2017/10/17.
 */

public class CircleList<T> extends ArrayList<T> {

    public CircleList() {
    }

    public CircleList(Collection<? extends T> c) {
        super(c);
    }

    @Override
    public T get(int index) {
        return super.get(index % size());
    }
}
