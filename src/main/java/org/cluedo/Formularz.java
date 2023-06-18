package org.cluedo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Formularz extends JFrame {
    private List<JTextField> textField = new ArrayList<>();

    List<String> names = Gameplay.murdererList.stream()
            .map(Murderer::getMurdererName)
            .collect(Collectors.toList());

    private List<JComboBox<String>> characterField = new ArrayList<>();
    private Set<String> selectedNames = new HashSet<>();

    private JButton button;
    private int numberOfPlayers;

    public Formularz(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        setTitle("Formularz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tworzenie komponentów
        for(int i = 0; i < numberOfPlayers; i++) {
            textField.add(new JTextField(40));
        }
        button = new JButton("Wyślij");

        // Utworzenie panelu
        JPanel panel = new JPanel();
        panel.add(new JLabel("Imię: "));
        panel.setLayout(new FlowLayout());
        textField.forEach(panel::add);
        characterField.forEach(panel::add);
        for (int i = 0; i < numberOfPlayers; i++) {
            JComboBox<String> comboBox = new JComboBox<>(new DefaultComboBoxModel<>(names.toArray(new String[0])));
            add(panel);
            while (true) {
                int result = JOptionPane.showConfirmDialog(null, comboBox, "Gracz " + (i + 1) + " - Wybierz nazwę", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    String selectedName = (String) comboBox.getSelectedItem();
                    if (!selectedNames.contains(selectedName)) {
                        characterField.add(comboBox);
                        selectedNames.add(selectedName);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ta nazwa została już wybrana. Wybierz inną nazwę.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Anulowano wybór, możesz podjąć odpowiednie działania
                    break;
                }
            }
            panel.add(comboBox);
        }

// Wyświetlenie wybranych nazw dla każdego combo boxa
        for (int i = 0; i < characterField.size(); i++) {
            JComboBox<String> comboBox = characterField.get(i);
            String selectedName = (String) comboBox.getSelectedItem();
            System.out.println("Gracz " + (i + 1) + " - Wybrana nazwa: " + selectedName);
        }


        panel.add(button);

        // Dodanie panelu do ramki


        // Ustawienie ActionListenera dla przycisku
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Pobranie wartości z pól
                //String name = textField.getText();


                // Wyświetlenie wartości w konsoli
                //System.out.println("Imię: " + name);
                System.out.println("Warunki zaakceptowane: "+ Gameplay.solution);
            }
        });

        // Wyśrodkowanie ramki na ekranie
        setLocationRelativeTo(null);

        // Wyświetlenie ramki
        pack();
        setVisible(true);
    }

}
