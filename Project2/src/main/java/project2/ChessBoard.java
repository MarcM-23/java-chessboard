package project2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessBoard extends Application
{

    final GridPane board = new GridPane();

    StackPane[][] squares = new StackPane[8][8]; //I use this array to store each of the squares on the chessboard

    @Override
    public void start(Stage primaryStage)
    {
        //Uncomment the method calls to test your methods

        colorBoard();
        setupBoard();

        Scene scene = new Scene(board, 320, 320);

        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void colorBoard()
    {
        //Size of the board is 8 by 8
        for (int i = 0; i < 8; i++) // This loop helps create the 8 rows on the board
        {

            for (int j = 0; j < 8; j++) // This loop helps create the 8 columns on the board
            {

                StackPane pane = new StackPane();
                Rectangle space = new Rectangle();

                if ( (i + j) % 2 == 0)     // This helps switch between the colors of each square space.
                {
                    space.setFill(Color.WHITE);
                }

                else
                {
                    space.setFill(Color.GRAY);
                }


                space.widthProperty().bind(board.widthProperty().divide(8));

                space.heightProperty().bind(board.heightProperty().divide(8));

                pane.getChildren().add(space);

                board.add(pane,j,i); // We add the Stack Pane to our Grid pane at column j and row i

                squares[i][j] = pane; // I store the square space into the array

            }
        }
    }

    public void setupBoard()
    {

        String[] BackRowPieces = {"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook"};

        for (int i = 0; i < 8; i++) // Loops through the rows
        {

            for (int j = 0; j < 8; j++) //Loops through the columns
            {

                StackPane pane = squares[i][j]; //I get the square spaces from the array

                ImageView chessPiece = null;

                if (i == 0) // This fills the Black pieces in row 0
                {
                    chessPiece = new ImageView(new Image("file:src/images/Black" + BackRowPieces[j] + ".png"));
                }

                else if (i == 1) // This fills the Black pawn pieces in row 1
                {
                    chessPiece = new ImageView(new Image("file:src/images/BlackPawn.png"));
                }

                else if (i == 6) // This fills the White Pawn pieces in row 6
                {
                    chessPiece = new ImageView(new Image("file:src/images/WhitePawn.png"));
                }

                else if (i == 7)  // This fills the White pieces in row 7
                {
                    chessPiece = new ImageView(new Image("file:src/images/White" + BackRowPieces[j] + ".png"));
                }

                if (chessPiece != null)
                {

                    chessPiece.setPreserveRatio(true); //this helps keep the chess piece images from being stretched

                    chessPiece.fitWidthProperty().bind(board.widthProperty().divide(8));

                    chessPiece.fitHeightProperty().bind(board.heightProperty().divide(8));

                    pane.getChildren().add(chessPiece); //Makes sure the image goes over the square space
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}

