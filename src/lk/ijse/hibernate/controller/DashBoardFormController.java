package lk.ijse.hibernate.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class DashBoardFormController {
    public Label lblSipsewana;
    public Label lblDasshBoard;
    public ImageView imgAddStudent;
    public ImageView imgAddSubject;
    public ImageView imgStudentDetails;
    public Label lblMenu;
    public Label lblDescription;
    public AnchorPane root;

    public void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgAddStudent":
                    root = FXMLLoader.load(this.getClass().getResource("../views/AddNewStudentsForm.fxml"));
                    break;
                case "imgAddSubject":
                    root = FXMLLoader.load(this.getClass().getResource("../views/AddTrainingProgramForm.fxml"));
                    break;
                case "imgStudentDetails":
                    root = FXMLLoader.load(this.getClass().getResource("../views/ViewStudentDetailsForm.fxml"));
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    public void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()) {
                case "imgAddStudent":
                    lblMenu.setText("Add Students");
                    lblDescription.setText("Click to add, edit students");
                    break;
                case "imgAddSubject":
                    lblMenu.setText("Add Training Programmes");
                    lblDescription.setText("Click to add, edit training programs");
                    break;
                case "imgStudentDetails":
                    lblMenu.setText("View Students Details");
                    lblDescription.setText("if you want to view students details click this");
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblMenu.setText("Welcome");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }
}
