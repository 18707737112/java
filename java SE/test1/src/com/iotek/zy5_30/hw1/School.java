package com.iotek.zy5_30.hw1;

public class School {
    private Printer p=null;
    public School() {
    }
    public School(Printer p) {
        this.p = p;
    }
    public void setPrinter(Printer p){
        this.p=p;
    }
    public Printer getPrinter() {
        return p;
    }
    public void startPrint(ISwich is){
        if(is!=null)
            p.print(is.detail());
    }
}
