package com.tosim.interview.designpartten.struction.bridge;

public abstract class Bridge {

    private Sourceable source;

    public void method() {
        if (source == null) {
            return;
        }
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
