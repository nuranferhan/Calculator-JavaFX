package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    private Pane headerPane;

    @FXML
    private ImageView minimizeButton, closeButton;

    @FXML
    private Label displayLabel;

    private double offsetX, offsetY;
    private double firstOperand = 0;
    private String currentOperator = "+";

    public void initialize(Stage primaryStage) {
        headerPane.setOnMousePressed(event -> {
            offsetX = event.getSceneX();
            offsetY = event.getSceneY();
        });

        headerPane.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - offsetX);
            primaryStage.setY(event.getScreenY() - offsetY);
        });

        closeButton.setOnMouseClicked(event -> primaryStage.close());
        minimizeButton.setOnMouseClicked(event -> primaryStage.setIconified(true));
    }

    @FXML
    private void handleNumberInput(MouseEvent event) {
        Pane source = (Pane) event.getSource();
        int digit = Integer.parseInt(source.getId().replace("btn", ""));
        String currentText = displayLabel.getText();

        if (currentText.equals("0.0")) {
            displayLabel.setText(String.valueOf(digit));
        } else {
            displayLabel.setText(currentText + digit);
        }
    }

    @FXML
    private void handleOperatorInput(MouseEvent event) {
        Pane source = (Pane) event.getSource();
        String operation = source.getId().replace("btn", "");

        if (operation.equals("Equals")) {
            double secondOperand = Double.parseDouble(displayLabel.getText());
            switch (currentOperator) {
                case "+" -> displayLabel.setText(String.valueOf(firstOperand + secondOperand));
                case "-" -> displayLabel.setText(String.valueOf(firstOperand - secondOperand));
                case "*" -> displayLabel.setText(String.valueOf(firstOperand * secondOperand));
                case "/" -> displayLabel.setText(String.valueOf(firstOperand / secondOperand));
            }
            currentOperator = ".";
        } else if (operation.equals("Clear")) {
            displayLabel.setText("0.0");
            firstOperand = 0;
            currentOperator = "+";
        } else {
            firstOperand = Double.parseDouble(displayLabel.getText());
            displayLabel.setText("");

            switch (operation) {
                case "Plus" -> currentOperator = "+";
                case "Minus" -> currentOperator = "-";
                case "Multiply" -> currentOperator = "*";
                case "Divide" -> currentOperator = "/";
            }
        }
    }
}






