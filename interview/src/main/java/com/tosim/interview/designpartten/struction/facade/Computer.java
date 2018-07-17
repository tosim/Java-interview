package com.tosim.interview.designpartten.struction.facade;

public class Computer {

    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new Disk();
    }

    public void startup(){
        cpu.startup();
        disk.startup();
        memory.startup();
    }

    public void shutdown(){
        memory.shutdown();
        disk.shutdown();
        cpu.shutdown();
    }
}
