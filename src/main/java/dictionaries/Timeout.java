package main.java.dictionaries;

public enum Timeout {
    TIME_OUT_IN_SECONDS_FOR_FIND_WEB_ELEMENT(10);

    private int time;

    Timeout(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

}
