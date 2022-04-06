// Garrick Morley
// ISYS 316 Section 1
// Instructor: Hira Herrington
// Programming Assignment #2
// Due Date: 02/15/2022   -->   Date Finished: 02/19/2022
// File Name: MorleyGarrickAssignment2

// This program will display a polygon using javax features, which the user can then add or subtract sides from.

// The inputs for this program include: The initial amount of sides, the height and width of both the polygon and the
// square box surrounding it.

// The outputs for this program include: A polygon that I can only control by manipulating the code itself, check the
// README.txt file for more

// The variables used in this program include: s (for sides), Width, and Height. It's mostly made up of objects and
// functions instead of variables

// The objects used in this program include: PolygonPane, hBox, plus, minus, BoxBorder, and scene.

// Package name to move data between files
package com.example.MorleyGarrickAssignment2;

// The javafx import that allows the application to run
import javafx.application.Application;

// All the javax imports needed for the program
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.*; // This line covers all of the shape related imports using the "*"
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PolygonAssignment extends Application{

    // Create the new object "PolygonPane" for future use
    private PolygonPane PlanePolygon = new PolygonPane();

    @Override
    public void start(Stage primaryStage)
    {
        // This line creates an object in HBox called "hBox", set to 15
        HBox hBox = new HBox(15);

        // This line uses the object "hBox" to set the alignment of the polygon to the center
        hBox.setAlignment(Pos.CENTER);

        // These two lines create two new button objects called "plus" and "minus" that affect the polygon as expected
        Button plus = new Button(" + ");
        Button minus = new Button(" - ");

        // These should be creating buttons, but I can't get them to appear on the screen
        Button Red = new Button("Red");
        Button Blue = new Button("Blue");
        Button Yellow = new Button("Yellow");
        Button Green = new Button("Green");

        // These two lines add children to the parent class
        hBox.getChildren().add(plus);
        hBox.getChildren().add(minus);

        // This line creates a plus handler for the polygon
        plus.setOnAction(new plusHandler());

        // This line creates a minus handler for the polygon
        minus.setOnAction(new minusHandler());

        // This line creates a new object called "BoxBorder"
        BorderPane BoxBorder = new BorderPane();

        // This line sets the center of the box surrounding the polygon
        BoxBorder.setCenter(PlanePolygon);

        // These lines create the hBox to surround the polygon, and center it
        BoxBorder.setBottom(hBox);
        BoxBorder.setAlignment(hBox, Pos.CENTER);

        // This line creates a scene object named "scene" and places it in the stage
        Scene scene = new Scene(BoxBorder, 350, 280);

        // This line uses "primaryStage" to set the stage title of the polygon controls, called "Polygon Controller
        // functions" in this case.
        primaryStage.setTitle("Polygon Controller Functions");

        // This line uses "primaryStage" to place the scene in the stage
        primaryStage.setScene(scene);

        // And finally this line uses "primaryStage.show()" to actually display the stage
        primaryStage.show();
    }


    // This main class launches the whole program
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    // This line creates a handler for the plus action event
    class plusHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            PlanePolygon.plus();
        }
    }

    // This line should work to let the minus button work, same as the one above
    class minusHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            PlanePolygon.minus();
        }
    }

    // This class called "PolygonPane" extends StackPane
    class PolygonPane extends StackPane
    {

        private Polygon polygon = new Polygon();

        // This line sets the starting amount of sides to 5
        int s = 5;

        // This class called "PolygonPane" handles the changing of the polygon
        public PolygonPane(){

            // This line sets the class up to create and return child variables, as well as set the original polygon
            getChildren().add(polygon);

            // This line sets the color of the polygon, only way I cna figure out how to do it is manually
            polygon.setFill(Color.PURPLE);

            // This line gets the coordinates that are coming up next
            ObservableList<Double> list = polygon.getPoints();

            // These two lines set the original polygon size
            final double Width = 210;
            final double Height = 210;

            // These lines set the center of the polygon and the radius of it
            double centerX = Width / 2, centerY = Height / 2;
            double radius = Math.min(Width, Height) * 0.5;


            // This is the part from the assignment page that handles adding and removing sides
            for (int i = 0; i < s; i++)
            {
                list.add(centerX + radius * Math.cos(2 * i * Math.PI / s));
                list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
            }
        }

        // Plus function to add sides (Appears but doesn't work)
        public void plus()
        {
            s = s++;
        }

        // Minus function to remove sides (Appears but doesn't work)
        public void minus()
        {
            s = s--;
        }
    }
}
