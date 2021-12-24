package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hibernate.bo.BoFactory;
import lk.ijse.hibernate.bo.custom.ProgrammeBO;
import lk.ijse.hibernate.dto.ProgrammeDTO;
import lk.ijse.hibernate.entity.Programme;

import java.io.IOException;
import java.sql.SQLException;

public class AddTrainingProgramFormController {
    public AnchorPane root;
    public JFXTextField txtSProgramID;
    public JFXTextField txtSProgramName;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public JFXButton btnAdd;
    public ImageView imgBack;

    private final ProgrammeBO programmeBO = (ProgrammeBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.PROGRAMME);

    public void initialize(){

        try {
            setProgrammeId();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setProgrammeId() throws SQLException, ClassNotFoundException {
        txtSProgramID.setText(programmeBO.setProgrammeId());
    }

    public void AddNewProgramOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ProgrammeDTO p1 = new ProgrammeDTO(
                txtSProgramID.getText(),txtSProgramName.getText(),
                Double.parseDouble(txtDuration.getText()),
                Double.parseDouble(txtFee.getText())
        );

        if(programmeBO.addProgramme(p1)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        }
    }

    public void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

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
        }
    }

    public void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgBack":
                    root = FXMLLoader.load(this.getClass().getResource("../views/DashBoardForm.fxml"));
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.imgBack.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }
}
