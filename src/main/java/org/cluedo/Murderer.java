package org.cluedo;

public class Murderer {
    private int murdererId;
    private String murdererName;

    public Murderer(int murdererId, String murdererName) {
        this.murdererId = murdererId;
        this.murdererName = murdererName;
    }
    public int getMurdererId() {
        return murdererId;
    }

    public String getMurdererName() {
        return murdererName;
    }
}
