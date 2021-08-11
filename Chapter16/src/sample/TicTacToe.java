package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

public class TicTacToe extends Application{
    // The player that will go first
    private char whoseTurn = 'X';

    // creating the cell
    private Cell[][] cell = new Cell[3][3];

    // create status label
    private Label lblStatus = new Label("X's turn to play");


    @Override
    public void start(Stage stage){ // we set up everything...like the structure and brain
        GridPane pane = new GridPane();
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                pane.add(cell[i][j] = new Cell(), j, i);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatus);

        // create a scene and set up stage
        Scene scene = new Scene(borderPane, 450, 170);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
    }

    // is cell full?
    public boolean isFull(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(cell[i][j].getToken() == ' ')
                    return false;

        return true;
    }

    public boolean isWon(char token){   // checking possible winning patterns
        for(int i = 0; i < 3; i++)
            if(cell[i][0].getToken() == token
                && cell[i][1].getToken() == token
                && cell[i][2].getToken() == token){
                return true;
            }

        for(int j = 0; j < 3; j++)
            if(cell[0][j].getToken() == token
            && cell[1][j].getToken() == token
            && cell[2][j].getToken() == token){
                return true;
            }

        if(cell[0][0].getToken() == token
        && cell[1][1].getToken() == token
        && cell[2][2].getToken() == token){
            return true;
        }

        if(cell[0][2].getToken() == token
        && cell[1][1].getToken() == token
        && cell[2][0].getToken() == token){
            return true;
        }

        return false;
    }

    public class Cell extends Pane{
        // token used for the cell
        private char token = ' ';

        public Cell(){
            setStyle("-fx-border-color: black");
            this.setPrefSize(2000,2000);
            this.setOnMouseClicked(e -> handleMouseClick()); // trigger this event
        }

        // return the token
        public char getToken() {
            return token;
        }

        // set a new token
        public void setToken(char c){
            token = c;

            if(token == 'X'){
                Line line1 = new Line(10,10, this.getWidth() - 10, this.getHeight() - 10);
                line1.endXProperty().bind(this.widthProperty().subtract(10));
                line1.endYProperty().bind(this.heightProperty().subtract(10));

                Line line2 = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
                line2.startYProperty().bind(this.heightProperty().subtract(10));
                line2.endXProperty().bind(this.widthProperty().subtract(10));

                // add these lines to the pane
                this.getChildren().addAll(line1,line2);
            }
            else if(token == 'O'){
                Ellipse ellipse = new Ellipse(this.getWidth() / 2, this.getHeight() / 2, this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
                ellipse.centerXProperty().bind(this.widthProperty().divide(2));
                ellipse.centerYProperty().bind(this.heightProperty().divide(2));
                ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
                ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
                ellipse.setStroke(Color.BLACK);
                ellipse.setFill(Color.WHITE);

                getChildren().add(ellipse);

            }
        }

        // mouse click event handler
        private void handleMouseClick(){
            // if game is not over and cell is empty
            if(token == ' ' && whoseTurn != ' '){
                setToken(whoseTurn);

                // is game won?
                if(isWon(whoseTurn)){
                    lblStatus.setText(whoseTurn + "won! The game is over.");
                    whoseTurn = ' '; // game is over
                }

                else if(isFull()){
                    lblStatus.setText("Draw! The game is over");
                    whoseTurn = ' ';
                }
                else{   // change the turn
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    // display whose turn
                    lblStatus.setText(whoseTurn + "'s turn");
                }
            }

        }



    }
}
