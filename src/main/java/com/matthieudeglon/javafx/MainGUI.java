package com.matthieudeglon.javafx;

import com.matthieudeglon.javafx.Interface.ClientPanel;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MainGUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientPanel clientPanel = new ClientPanel();

        Group root = new Group();
        root.getChildren().add(clientPanel);

        Scene scene = new Scene(root, 600, 500);
        scene.setFill(Paint.valueOf("red"));
        stage.setTitle("JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(MainGUI.class, args);
    }
}
