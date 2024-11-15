package com.matthieudeglon.javafx.Interface;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;

public class ClientPanel extends Pane {
    private TextArea textToSend;
    private ScrollPane scrollReceivedText;
    private TextFlow receivedText;
    private Button sendBtn;
    private Button clearBtn;

    public ClientPanel() {
        textToSend = new TextArea();
        scrollReceivedText = new ScrollPane();
        receivedText = new TextFlow();
        sendBtn = new Button("Envoyer");
        clearBtn = new Button("Effacer");

        scrollReceivedText.setLayoutX(50);
        scrollReceivedText.setLayoutY(50);
        scrollReceivedText.setPrefWidth(400);
        scrollReceivedText.setPrefHeight(350);
        scrollReceivedText.setContent(receivedText);
        scrollReceivedText.vvalueProperty().bind(receivedText.heightProperty());

        textToSend.setLayoutX(50);
        textToSend.setLayoutY(420);
        textToSend.setPrefWidth(300);
        textToSend.setPrefHeight(50);

        sendBtn.setLayoutX(370);
        sendBtn.setLayoutY(420);
        sendBtn.setPrefWidth(80);

        clearBtn.setLayoutX(460);
        clearBtn.setLayoutY(420);
        clearBtn.setPrefWidth(80);

        this.getChildren().addAll(scrollReceivedText, textToSend, sendBtn, clearBtn);
        setupActions();
    }

    private void setupActions() {
        clearBtn.setOnAction(event -> textToSend.setText(""));

        sendBtn.setOnAction(event -> {
            String message = textToSend.getText();
            if (!message.isEmpty()) {
                printNewMessage("Moi: " + message);
                textToSend.setText("");
            }
        });
    }

    public void printNewMessage(String message) {
        receivedText.getChildren().add(new javafx.scene.control.Label("\n" + message));
    }
}