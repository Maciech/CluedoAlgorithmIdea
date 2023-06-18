package org.cluedo;

public class Solution {
    private final String murdererName;
    private final String murderRoomName;
    private final String murdererToolName;

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

    @Override
    public String toString() {
        return "Solution{" +
                "murdererName='" + murdererName + '\'' +
                ", murderRoomName='" + murderRoomName + '\'' +
                ", murdererToolName='" + murdererToolName + '\'' +
                '}';
    }
}
