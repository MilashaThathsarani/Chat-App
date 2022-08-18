package controller.client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;
import static controller.LogIn.username;

public class ChatRoom extends Thread{
    public TextField msgField;
    public JFXButton btnSend;
    public Label userNametxt;
    public JFXTextArea txtChatRoom;

    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public void connectSocket() {
        try {
            socket = new Socket("localhost", 5000);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void initialize(){
        connectSocket();
       userNametxt.setText(username);
   }

    public void sendOnAction(ActionEvent actionEvent) {
    }

}
