package controller;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;


public class ChatRoom extends Thread implements Initializable {
    public Pane chat;
    public TextArea msgRoom;
    public TextField msgField;
    public JFXButton btnSend;
    public Label clientName;

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public void connectSocket() {
        try {
            socket = new Socket("localhost", 8080);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void sendOnAction(ActionEvent actionEvent) {
    }

    public void handleSendEvent(MouseEvent mouseEvent) {
    }
}
