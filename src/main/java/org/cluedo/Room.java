package org.cluedo;

public class Room {
    private int murderRoomId;
    private String murderRoomName;

    public Room(int murderRoomId, String murderRoomName) {
        this.murderRoomId = murderRoomId;
        this.murderRoomName = murderRoomName;
    }

    public int getMurderRoomId() {
        return murderRoomId;
    }

    public String getMurderRoomName() {
        return murderRoomName;
    }
}
