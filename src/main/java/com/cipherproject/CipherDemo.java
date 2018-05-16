package com.cipherproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI class to demonstrate the functionality of the Caesar cipher
 * @author Alex Franklin
 */
public class CipherDemo extends JFrame implements ActionListener {
    private JPanel labelPanel, inputPanel, buttonPanel;
    private JLabel messageLabel, keyLabel;
    private JTextField messageInput, keyInput;
    private JButton encrypt, decrypt;
    private CipherLogic logic = new CipherLogic();

    /**
     * Constructor
     */
    CipherDemo() {
        setTitle("Caesar Cipher Demo");
        Container content = getContentPane();
        content.setLayout(new BorderLayout());

        // Populate upper panel with text labels
        labelPanel = new JPanel(new GridLayout(1,2));
        labelPanel.setPreferredSize(new Dimension(0,30));
        messageLabel = new JLabel("Enter a message:");
        keyLabel = new JLabel("Enter a key value:");
        labelPanel.add(messageLabel);
        labelPanel.add(keyLabel);

        // Populate central panel text entry fields
        inputPanel = new JPanel(new GridLayout(1,2));
        inputPanel.setPreferredSize(new Dimension(0,30));
        messageInput = new JTextField();
        keyInput = new JTextField();
        inputPanel.add(messageInput);
        inputPanel.add(keyInput);

        // Populate lower panel with action buttons
        buttonPanel = new JPanel(new GridLayout(1,2));
        buttonPanel.setPreferredSize(new Dimension(0,40));
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");
        buttonPanel.add(encrypt);
        buttonPanel.add(decrypt);
        encrypt.addActionListener(this);
        decrypt.addActionListener(this);

        // Populate and display the demo frame
        content.add(labelPanel, BorderLayout.NORTH);
        content.add(inputPanel, BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Implementation of the ActionListener interface method actionPerformed
     * Determines which button has been clicked and carries out the appropriate encryption/decryption logic
     * @param event ActionEvent
     */
    public void actionPerformed(ActionEvent event) {
        String message = messageInput.getText();
        int key;

        try {
            key = Integer.parseInt(keyInput.getText());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
            return;
        }

        if (event.getSource().equals(encrypt)) {
            messageInput.setText(logic.encrypt(message, key));
        } else if (event.getSource().equals(decrypt)) {
            messageInput.setText(logic.decrypt(message, key));
        }
    }

    /**
     * Starts the demo
     * @param args Not used
     */
    public static void main(String[] args) {
        CipherDemo demo = new CipherDemo();
    }
}