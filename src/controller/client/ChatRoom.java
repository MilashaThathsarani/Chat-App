package controller.client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import controller.Data;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.ConnectionUtil;

import java.io.*;
import java.net.Socket;

public class ChatRoom extends Thread{
    public TextField msgField;
    public JFXButton btnSend;
    public Label userNametxt;
    public JFXTextArea txtChatRoom;

    Socket socket = null;
    public String username;
    PrintWriter writer;

   public void initialize() throws IOException {
       userNametxt.setText(username);
       System.out.println("userName is : " + Data.username);
       socket = new Socket(ConnectionUtil.host, ConnectionUtil.port);
       txtChatRoom.appendText("Connect. \n");
       writer = new PrintWriter(socket.getOutputStream());
       TaskReadThread task = new TaskReadThread(socket, this);
       Thread thread = new Thread(task);
       thread.start();
   }

    public void sendOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter= new PrintWriter(socket.getOutputStream());
        printWriter.println(Data.username + " : " + msgField.getText());
        printWriter.flush();
        msgField.clear();
    }

}
