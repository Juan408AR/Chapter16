package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class ComboBoxDemo extends Application{
    // string array containing the title of the flags
    private String [] flagTitle ={"Mexico", "Canada", "Russia"};

    // Create an imageview array to store the path of the images/images themselves
    private ImageView [] flagImage = {new ImageView("file:\\C:\\Users\\Juan\\Desktop\\Flag_of_Mexico.png"),
            new ImageView(new Image("file:\\C:\\Users\\Juan\\Desktop\\2560px-Flag_of_Canada_(Pantone).svg.png",300,300,true,true)),
            new ImageView(new Image("file:\\C:\\Users\\Juan\\Desktop\\1920px-Flag_of_Russia.svg.png", 350,350, true, true))};
    // array of strings for the description of the flags
    private String [] flagDescription = new String[3];

    // declare and create a description pane
    private DescriptionPane descriptionPane = new DescriptionPane();

    // create a combo box
    private ComboBox<String> cbo = new ComboBox<>(); // the flag titles will be stored here

    @Override
    public void start(Stage stage){
        flagDescription[0] = "The flag of Mexico...";
        flagDescription[1] = "The flag of Canada";
        flagDescription[2] = "The flag of Russia";

        // set the first country to display... in our case it is mexico
        setDisplay(0);

        // adding the combo box and description to the pane
        BorderPane pane = new BorderPane();

        BorderPane paneForComboBox = new BorderPane(); // is there a pane for each? combo box and description
        paneForComboBox.setLeft(new Label("Select a Country: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);

        cbo.setPrefWidth(400);
        cbo.setValue("Mexico"); // get the info regarding this value...this is sort of like a key

        ObservableList<String> items = FXCollections.observableArrayList(flagTitle);
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        // display the selected country
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue()))); // in a way...get the info using the key that is in the value

        Scene scene = new Scene(pane, 600, 300);
        stage.setTitle("ComboBoxDemo");
        stage.setScene(scene);
        stage.show();



    }

    public void setDisplay(int index){
        descriptionPane.setTitle(flagTitle[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setTaDescription(flagDescription[index]);
    }
}
