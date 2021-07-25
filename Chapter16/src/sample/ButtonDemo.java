package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ButtonDemo extends Application {
    protected Text text = new Text(50, 50, "JavaFX Programming");

    protected BorderPane getPane(){
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("Left", new ImageView("file:/Users/jra408/Downloads/Takaki Mirror.pdf"));
        Button btRight = new Button("Right", new ImageView("file:/Users/jra408/Downloads/Takaki Mirror.pdf"));
        paneForButtons.getChildren().addAll(btLeft,btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        return pane;
    }

    @Override
    public void start(Stage stage){
        Scene scene = new Scene(getPane(), 450, 200);
        stage.setTitle("ButtonDemo");
        stage.setScene(scene);
        stage.show();
    }
}
