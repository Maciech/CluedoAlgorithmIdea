package org.cluedo;

public class Solution {
    private String murdererName;
    private String murderRoomName;
    private String murdererToolName;

    public Solution(String murdererName, String murderRoomName, String murdererToolName) {
        this.murdererName = murdererName;
        this.murderRoomName = murderRoomName;
        this.murdererToolName = murdererToolName;
    }

    public String getMurdererName() {
        return murdererName;
    }

    public String getMurderRoomName() {
        return murderRoomName;
    }

    public String getMurdererToolName() {
        return murdererToolName;
    }
}
