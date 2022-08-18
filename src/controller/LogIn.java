package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class LogIn {
    public static String username;
    public Button btnLogin;
    public TextField userNametxt;

    private void loadChat() throws IOException {
        Stage exitstage = (Stage) btnLogin.getScene().getWindow();
        exitstage.close();
        URL resource = this.getClass().getResource("../view/ChatPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        username = userNametxt.getText().isEmpty() ? "Unknown" : userNametxt.getText();
        Data.username = username;
        System.out.println(Data.username);
        loadChat();
    }

}