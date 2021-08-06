package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.geometry.Orientation;

public class SliderDemo extends Application{
    @Override
    public void start(Stage stage){
        Text text = new Text(20,20, "JavaFX Programming");

        Slider slHorizontal = new Slider();
        slHorizontal.setShowTickLabels(true);
        slHorizontal.setShowTickMarks(true);

        Slider slVertical = new Slider();
        slVertical.setOrientation(Orientation.VERTICAL);
        slVertical.setShowTickLabels(true);
        slVertical.setShowTickMarks(true);
        slVertical.setValue(100);

        // create a pane for the text
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        // create a border pane to hold text and scroll bars
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setBottom(slHorizontal);
        pane.setRight(slVertical);

        slHorizontal.valueProperty().addListener(ov ->
                text.setX(slHorizontal.getValue() * paneForText.getWidth() /
                        slHorizontal.getMax()));

        slVertical.valueProperty().addListener(ov ->
               text.setY((slVertical.getMax() - slVertical.getValue())
                * paneForText.getHeight() / slVertical.getMax()));

        Scene scene = new Scene(pane);
        stage.setTitle("SliderDemo");
        stage.setScene(scene);
        stage.show();

    }
}
