package com.tosim.interview.designpartten.struction.proxy;

public class Proxy implements Sourceable{

    private Sourceable source;
    private boolean isAuth;

    public Proxy(boolean isAuth){
        this.source = new Source();
        this.isAuth = isAuth;
    }

    public void doAction() {
        if (this.isAuth) {
            this.source.doAction();
        } else {
            System.out.println("you have no access");
        }
    }
}
