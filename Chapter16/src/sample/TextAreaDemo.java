package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class TextAreaDemo extends Application{
    @Override
    public void start(Stage stage){
        // declare and create the description
        DescriptionPane descriptionPane = new DescriptionPane();

        // set the title,text, and image
        descriptionPane.setTitle("Mexico");
        String description = "The Mexican national Flag...";
        descriptionPane.setImageView( new ImageView("file:\\C:\\Users\\Juan\\Desktop\\Flag_of_Mexico.png"));
        descriptionPane.setTaDescription(description);

        // preping the stage
        Scene scene = new Scene(descriptionPane);
        stage.setTitle("TextAreaDemo");
        stage.setScene(scene);
        stage.show();
    }
}
