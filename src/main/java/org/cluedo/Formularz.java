package org.cluedo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Formularz extends JFrame {
    private List<JTextField> textField = new ArrayList<>();
    private List<JComboBox> comboField = new ArrayList<>();

    Map<String,String> testMap = new HashMap<>();
    List<String> names = Initialization.murdererList.stream()
            .map(Murderer::getMurdererName)
            .collect(Collectors.toList());


    public Formularz(int numberOfPlayers) {
        setTitle("Formularz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Tworzenie komponentów
        for(int i = 0; i < numberOfPlayers; i++) {
            textField.add(new JTextField(40));
            comboField.add(new JComboBox(names.toArray()));
        }

        JButton button1 = new JButton("Potwierdź");

        // Utworzenie panelu
        JPanel panel = new JPanel();
        panel.add(new JLabel("Imię: "));
        panel.setLayout(new GridLayout(3,3));
        textField.forEach(panel::add);
        comboField.forEach(panel::add);
        panel.add(button1);

        add(panel);

        // Ustawienie ActionListenera dla przycisku
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Pobranie wartości z pól
                List<String> players = textField.stream()
                        .map(JTextField::getText)
                        .toList();
                players.forEach(System.out::println);
                List<String> characters = comboField.stream()
                        .map(jComboBox -> (String) jComboBox.getSelectedItem())
                                .toList();
                characters.forEach(System.out::println);

                for (int i = 0; i < numberOfPlayers; i++){
                    testMap.put(players.get(i), characters.get(i));
                }
                testMap.entrySet().stream()
                        .map(entry -> entry.getKey() + " -> " + entry.getValue())
                        .forEach(System.out::println);
                // Wyświetlenie wartości w konsoli
                //System.out.println("Imię: " + name);
                System.out.println("Warunki zaakceptowane: "+ Initialization.solution);
                panel.setVisible(false);
                dispose();
            }
        });

        // Wyśrodkowanie ramki na ekranie
        setLocationRelativeTo(null);

        // Wyświetlenie ramki
        pack();
        setVisible(true);
    }

}
