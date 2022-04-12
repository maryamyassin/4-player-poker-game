/**
 *
 * @author maryam
 */


import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.io.*;
import java.net.*;

public class Player extends Application {

    private Socket socket;
    private int playerId;
    private VBox vbox;
    private Label title;
    private Label name;
    private Label welcome;
    private TextField nametext;
    private Button btn;
    private Scene scene2;
    private String playername;

    @Override
    public void start(Stage primaryStage) {

        //Pane root = new Pane();
        vbox = new VBox();

        title = new Label("Texas Holdem Poker");
        name = new Label("Enter your name");
        nametext = new TextField();
        btn = new Button();
        btn.setText("PLAY");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                VBox vbox2 = new VBox();
                playername = nametext.getText();
                
                connectToServer();

                welcome = new Label ("Hi " + playername + "! you are player #" + playerId + ".");
                vbox2.getChildren().add(welcome);
                vbox2.setAlignment(Pos.CENTER);

                scene2 = new Scene(vbox2, 400, 156);
                primaryStage.setScene(scene2);
                primaryStage.show();
            }
        });

        vbox.getChildren().addAll(title, name, nametext, btn);
        vbox.setAlignment(Pos.CENTER);

        //root.getChildren().add(vbox);
        Scene scene = new Scene(vbox, 400, 156);

        primaryStage.setTitle("Texas Hold'em Poker");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void connectToServer() {

        try {
            socket = new Socket("localhost", 8899);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            playerId = in.readInt();  
            
            
        } catch (IOException e) {
            System.out.println("IOException at connectToServer()");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
