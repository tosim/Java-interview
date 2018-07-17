package com.tosim.interview.designpartten.creation.prototype;

public class ProtoItem implements Cloneable{

    private String value;

    public ProtoItem clone(){
        ProtoItem copy = null;
        try{
            copy = (ProtoItem) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return copy;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
