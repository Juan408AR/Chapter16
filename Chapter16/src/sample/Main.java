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

    16.5 Radio Button: you can group the buttons into their own little grouped where you can only select one of many radio Buttons
    but you have to group them explicitly

    16.6 TextField: used to enter or display a string of text inside of a field
    ...TextField tfMessage = new TextField("T-Strom");
    tfMessage.someMethod();

    16.7 TextArea: enables you to enter multiple lines of text

    16.8 ComboBox: known as a dropdown list, contains a list of items from which the user can choose from
    syntax...ComboBox<data type> cbo = new ComboBox<>();
    cbo.getItems().addAll(...)  // similar to nodes, is this a node?
    cbo.setStyle("html code");
    cbo.setValue("which will appear first ?");

    16.9 ListView: similar to comboBox in that you get a list of items, except with list view you
    can select one or multiple items from the list.

 */