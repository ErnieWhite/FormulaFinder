package com.archiewhite;

public class App {
    public static void main(String[] args) {
        Model m = new Model(0, 0,"6");
        View v = new View("Formula Finder");
        Controller c = new Controller(m, v);
        c.initController();
    }
}
