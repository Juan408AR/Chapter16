package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");

        primaryStage.show();
    }

}

/*
    16.2 Labeled and Label: using the Label area on text, node, or both.
    When we create a label we pass an object/node into it , we have access to the node via the label

    16.3 Button: controls the trigger of an action event when clicked, it is like a button except it also has an action.
    It extends Labeled.

    16.4 CheckBox: Similar to button except that is has a method to check if the check box has been selected.

 */