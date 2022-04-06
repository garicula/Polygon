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

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class PolygonController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}