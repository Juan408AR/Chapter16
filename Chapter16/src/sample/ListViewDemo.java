package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ListViewDemo extends Application{
    // an array of strings to hold the name of the flags.
    private String [] flagNames = {"Mexico", "Canada", "Russia"};

    // an array of imageview for holding the image of the countries in the string array above
    private ImageView [] flagImage = {new ImageView(new Image("file:\\C:\\Users\\Juan\\Desktop\\Flag_of_Mexico.png", 350,350, true, true)),
            new ImageView(new Image("file:\\C:\\Users\\Juan\\Desktop\\2560px-Flag_of_Canada_(Pantone).svg.png", 350, 350, true, true)),new ImageView(new Image("file:\\C:\\Users\\Juan\\Desktop\\1920px-Flag_of_Russia.svg.png", 350, 350, true, true))};



    @Override
    public void start(Stage stage){
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(flagNames));
        lv.setPrefSize(400, 400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // create a pane for the image view
        FlowPane imagePane = new FlowPane(3,3); // the args here are the h and v gaps
        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(imagePane);

        lv.getSelectionModel().selectedItemProperty().addListener(
                ov -> {
                imagePane.getChildren().clear();
                for(Integer i: lv.getSelectionModel().getSelectedIndices())
                    imagePane.getChildren().add(flagImage[i]);
            }
        );

        Scene scene = new Scene(pane, 450, 170);
        stage.setTitle("ListViewDemo");
        stage.setScene(scene);
        stage.show();

    }
}
