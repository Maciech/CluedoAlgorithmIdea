package org.cluedo;

import java.util.*;

public class Deck {
    private final List<Murderer> murdererList;
    private final List<Room> roomList;
    private final List<MurderTools> murderToolList;

    private final List<String> deckMap = new ArrayList<>();

    public List<String> getDeckMap() {
        return deckMap;
    }

    public Deck(List<Murderer> murdererList, List<Room> roomList, List<MurderTools> murderToolList) {
        this.murdererList = murdererList;
        this.roomList = roomList;
        this.murderToolList = murderToolList;

        collectAllCards();
    }
    private void collectAllCards(){
        for (int i = 0 ; i < 5; i++){
            deckMap.add(murdererList.get(i).getMurdererName());
        }
        for (int i = 0 ; i < 8; i++){
            deckMap.add(roomList.get(i).getMurderRoomName());
        }
        for (int i = 0 ; i < 8; i++){
            deckMap.add(murderToolList.get(i).getMurderToolName());
        }
        shuffleCards();
    }
    private void shuffleCards(){
        Collections.shuffle(deckMap);
    }
}
