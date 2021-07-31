package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class DescriptionPane extends BorderPane{
    // label for image and title
    private Label lblImageTitle = new Label();

    // text area
    private TextArea taDescription = new TextArea();

    public DescriptionPane(){
        // center the icon and text, put the text under the icon
        lblImageTitle.setContentDisplay(ContentDisplay.TOP);
        lblImageTitle.setPrefSize(200, 100);

        // set the font
        lblImageTitle.setFont(new Font("SansSerif", 16));
        taDescription.setFont(new Font("Serif", 16));

        taDescription.setWrapText(true);
        taDescription.setEditable(false);

        // create a scroll pane to hold the text area object
        ScrollPane scrollPane = new ScrollPane(taDescription);

        // place label and scroll pane in border pane
        setLeft(lblImageTitle); // this is inside of pane object so this works calling these methods
        setCenter(scrollPane);
        setPadding(new Insets(5,5,5,5));
    }

    public void setTitle(String title){
        lblImageTitle.setText(title);
    }

    public void setImageView(ImageView icon){
        lblImageTitle.setGraphic(icon);
    }

    public void setTaDescription(String text){
        taDescription.setText(text);
    }

}
