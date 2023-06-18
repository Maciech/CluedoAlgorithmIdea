package org.cluedo;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Gameplay {
    private static final int MAX_NUMBER_OF_PLAYERS = 6;
    private static final int MIN_NUMBER_OF_PLAYERS = 2;
    private static final int MURDER_TOOLS_NUMBER = 9;
    private static final int MURDERERS_NUMBER = 6;
    private static final int ROOM_NUMBER = 9;
    private static final int NUMBER_OF_CARDS = 24;
    private static final int NUMBER_OF_CARDS_TO_SOLUTION = 3;
    private static final String urlMurderers = "src/main/resources/Murderers.json";
    private static final String urlRooms = "src/main/resources/Rooms.json";
    private static final String urlMurderTools = "src/main/resources/MurderTools.json";
    private int numberOfPlayers;
    private int numberOfCardsPerPlayer;
    //= ;

    public static List<Murderer> murdererList;
    public static List<Room> roomList;
    public static List<MurderTools> murderToolList;
    public static Solution solution;
    public static List<String> shuffledDeck;

    public Gameplay(int numberOfPlayers) throws IOException {
        if (numberOfPlayers >= MIN_NUMBER_OF_PLAYERS && numberOfPlayers <= MAX_NUMBER_OF_PLAYERS){
            this.numberOfPlayers = numberOfPlayers;
            this.numberOfCardsPerPlayer = (NUMBER_OF_CARDS - NUMBER_OF_CARDS_TO_SOLUTION) / numberOfPlayers;
            initalizePlayers();
            drawCards(numberOfPlayers);
        }

    }

    private void initalizePlayers() throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int number = Integer.parseInt(reader.readLine());
            public void run() {
                new Formularz(number);
            }
        });
    }

    static {
        initializeDeck();
    }

    private static void initializeDeck(){
        readMurderers();
        readRooms();
        readMurdererTools();
        solution = crimeCardDraw();
        shuffledDeck = completeDeck();
        shuffledDeck.forEach(System.out::println);

    }

    private void drawCards(int numberOfPlayers){


    }
    private static Solution crimeCardDraw() {
            int randMurderer = (int) (Math.random() * MURDERERS_NUMBER);
            var randRoom = (int) (Math.random() * ROOM_NUMBER);
            var randMurderTool = (int) (Math.random() * MURDER_TOOLS_NUMBER);
            var mockSolution = new Solution(murdererList.get(randMurderer).getMurdererName(),
                    roomList.get(randRoom).getMurderRoomName(),
                    murderToolList.get(randMurderTool).getMurderToolName());
           // murdererList.remove(randMurderer);
           // roomList.remove(randRoom);
           // murderToolList.remove(randMurderTool);

        return mockSolution;
    }
    private static List<String> completeDeck(){
        var murderList = murdererList;
        murderList.remove(solution.getMurdererName());
        var deck = new Deck(murderList, roomList, murderToolList);
        return deck.getDeckMap();
    }

    /**
     * Read murderers from JSON file once after gameplay class initialized
     * add data to murderer list
     */
    private static void readMurderers(){
        var parser = new JSONParser();
        List<Murderer> murderersList = new ArrayList<>();

        try {
            var jsonArray = (JSONArray) parser.parse(new FileReader(urlMurderers));
            for (Object m : jsonArray){
                JSONObject murderer = (JSONObject) m;
                int murdererId = ((Long) (murderer.get("murdererId"))).intValue();
                String murdererName = (String) murderer.get("murdererName");
                murderersList.add(new Murderer(murdererId, murdererName));
                //System.out.println(murdererId + " " + murdererName);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        murdererList = murderersList;
    }
    private static void readRooms(){
        var parser = new JSONParser();
        List<Room> roomsList = new ArrayList<>();

        try {
            var jsonArray = (JSONArray) parser.parse(new FileReader(urlRooms));
            for (Object m : jsonArray){
                JSONObject murderer = (JSONObject) m;
                int roomId = ((Long) (murderer.get("roomId"))).intValue();
                String roomName = (String) murderer.get("roomName");
                roomsList.add(new Room(roomId, roomName));
                //System.out.println(roomId + " " + roomName);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        roomList = roomsList;
    }
    private static void readMurdererTools(){
        var parser = new JSONParser();
        List<MurderTools> murderToolsList = new ArrayList<>();

        try {
            var jsonArray = (JSONArray) parser.parse(new FileReader(urlMurderTools));
            for (Object m : jsonArray){
                JSONObject murderer = (JSONObject) m;
                int murderToolId = ((Long) (murderer.get("murderToolId"))).intValue();
                String murderToolName = (String) murderer.get("murderToolName");
                murderToolsList.add(new MurderTools(murderToolId, murderToolName));
                //System.out.println(murderToolId + " " + murderToolName);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        murderToolList = murderToolsList;
    }

}
