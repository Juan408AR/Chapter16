package sample;
import javafx.application.Application;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javax.print.attribute.standard.OrientationRequested;

public class ScrollBarDemo extends Application{
    @Override
    public void start(Stage stage){
        ScrollBar sbHorizontal = new ScrollBar();
        ScrollBar sbVertical = new ScrollBar();
        sbVertical.setOrientation(Orientation.VERTICAL);
        sbHorizontal.setOrientation(Orientation.HORIZONTAL);
        Text text = new Text(20,20, "JavaFX Programming");
        // creating the pane for the text
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        // creating the pane for the text and scroll bar
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setBottom(sbHorizontal);
        pane.setRight(sbVertical);

        // listener for the horizontal scroll bar
        sbHorizontal.valueProperty().addListener(ov ->
                text.setX(sbHorizontal.getValue() * paneForText.getWidth() / sbHorizontal.getMax()));

        // listener for the vertical scroll bar
        sbVertical.valueProperty().addListener(ov ->
                text.setY(sbVertical.getValue() * paneForText.getHeight() / sbVertical.getMax()));

        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("ScrollBarDemo");
        stage.setScene(scene);
        stage.show();

    }
}
