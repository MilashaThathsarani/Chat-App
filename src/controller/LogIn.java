package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class LogIn {
    public Button btnLogin;
    public TextField userNametxt;

    private void loadChat() throws IOException {
        Stage exitstage = (Stage) btnLogin.getScene().getWindow();
        exitstage.close();
        URL resource = this.getClass().getResource("view/ChatPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        //stage.getIcons().add(new Image("assets/livechatLogo.png"));
        stage.setScene(scene);
        //enableMove(scene,stage);
        stage.show();
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        loadChat();
    }
}