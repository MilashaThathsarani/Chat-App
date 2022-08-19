package controller.client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import controller.Data;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.ConnectionUtil;

import java.io.*;
import java.net.Socket;
import static controller.LogIn.username;

public class ChatRoom extends Thread{
    public TextField msgField;
    public JFXButton btnSend;
    public Label userNametxt;
    public JFXTextArea txtChatRoom;
    public Pane emogiPane;

    Socket socket = null;
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

       emogiPane.setVisible(false);
   }

    public void sendOnAction(MouseEvent actionEvent) throws IOException {
        PrintWriter printWriter= new PrintWriter(socket.getOutputStream());
        printWriter.println(Data.username + " : " + msgField.getText());
        printWriter.flush();
        msgField.clear();
    }

    public void emogiOnAction(MouseEvent mouseEvent) {
        if (!emogiPane.isVisible()) {
            emogiPane.setVisible(true);
        } else {
            emogiPane.setVisible(false);
        }
    }

    public void emoji1OnAction(MouseEvent mouseEvent) {
        msgField.appendText("\uD83D\uDE03");
    }

    public void imageOnAction(MouseEvent mouseEvent) {
//        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
//        chooser = new FileChooser();
//        chooser.setTitle("Open Image");
//        this.path = chooser.showOpenDialog(stage);
//        writer.println(clientlbl.getText() + " " + "img" + path.getPath());
//        writer.flush();

    }

    public void emoji2OnAction(MouseEvent mouseEvent) {
        msgField.appendText("\uD83E\uDD17");
    }

    public void emoji3OnAction(MouseEvent mouseEvent) {
        msgField.appendText("❤️❤️");
    }

    public void emoji4OnAction(MouseEvent mouseEvent) {
        msgField.appendText("\uD83D\uDE32");
    }

    public void emoji5OnAction(MouseEvent mouseEvent) {
        msgField.appendText("\uD83D\uDE02");
    }

    public void emoji6OnAction(MouseEvent mouseEvent) {
        msgField.appendText("\uD83D\uDE25");
    }

    public void emoji7OnAction(MouseEvent mouseEvent) {
        msgField.appendText("\uD83D\uDE2B");
    }

    public void emoji8OnAction(MouseEvent mouseEvent) {
        msgField.appendText("\uD83D\uDE24");
    }
}
