package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class LogInController {
    public TextField userNametxt;
    public Button btnLogin;

    public void userNameOnAction(ActionEvent actionEvent) {
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
       loadChat();
    }

    private void loadChat() throws IOException {
        Stage exitstage = (Stage) btnLogin.getScene().getWindow();
        exitstage.close();
        URL resource = this.getClass().getResource("/view/ChatPage.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        //enableMove(scene,stage);
        stage.show();
    }
}
