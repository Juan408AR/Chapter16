package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextFieldDemo extends RadioButtonDemo {
    @Override
    protected BorderPane getPane(){
        BorderPane pane = super.getPane();

        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5,5,5,5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter a new message: ")); // inside of the borderpane to the left put a label which is this one here

        TextField tfMessage = new TextField();
        tfMessage.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tfMessage);
        pane.setTop(paneForTextField);

        // we want to create an event/action whenever text is entered into the textfield in order to replace the
        // text inside of the center of the border plane which is the text

        tfMessage.setOnAction(e -> text.setText(tfMessage.getText())); // we set the text to whatever we get inside of the textfield that is above

        return pane;
    }
}
