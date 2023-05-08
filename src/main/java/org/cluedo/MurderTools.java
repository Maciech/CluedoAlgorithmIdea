package org.cluedo;

public class MurderTools {
    private int murderToolId;
    private String murderToolName;

    public MurderTools(int murderToolId, String murderToolName) {
        this.murderToolId = murderToolId;
        this.murderToolName = murderToolName;
    }
    public int getMurderToolId() {
        return murderToolId;
    }

    public String getMurderToolName() {
        return murderToolName;
    }
}
