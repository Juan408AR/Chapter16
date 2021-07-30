package sample;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RadioButtonDemo extends CheckBoxDemo{
    @Override // override the pane in the super class
    protected BorderPane getPane(){
        BorderPane pane = super.getPane();

        VBox paneForRadioButtons = new VBox(20);
        paneForRadioButtons.setPadding(new Insets(5,5,5,5));
        paneForRadioButtons.setStyle("-fx-border-color: green");
        paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color: green");

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");
        paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);
        pane.setLeft(paneForRadioButtons);

        // setting the grouping for the radio buttons so that they belong to the same group
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);

        // now we will set actions/events to handle when one of the buttons is clicked
        rbRed.setOnAction(e -> {
            if(rbRed.isSelected())
                text.setFill(Color.RED);

        });

        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected())
                text.setFill(Color.GREEN);
        });

        rbBlue.setOnAction(e -> {
            if(rbBlue.isSelected())
                text.setFill(Color.BLUE);
        });



        return pane;
    }
}
