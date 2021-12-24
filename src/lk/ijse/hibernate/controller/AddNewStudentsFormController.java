package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.bo.BoFactory;
import lk.ijse.hibernate.bo.custom.ProgrammeBO;
import lk.ijse.hibernate.bo.custom.StudentBO;
import lk.ijse.hibernate.bo.custom.StudentDetailsBO;
import lk.ijse.hibernate.dto.ProgrammeDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.dto.StudentDetailsDTO;
import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.entity.StudentDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddNewStudentsFormController {
    public AnchorPane addStudent;
    public JFXTextField txtStudentID;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentPhoneNumber;
    public JFXButton btnAdd;
    public JFXButton btnexistingStudent;
    public ImageView imgBack;
    public JFXComboBox cmbSelectTrainingProgramme;
    String day;
    String programmeId;

    private final StudentBO studentBO = (StudentBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENT);
    private final ProgrammeBO programmeBO = (ProgrammeBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.PROGRAMME);
    private final StudentDetailsBO studentDetailsBO = (StudentDetailsBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENTDETAILS);

    public void initialize(){
        try {
            loadTrainingProgrammes();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            setStudentId();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        loadDate();
    }

    private void loadTrainingProgrammes() throws SQLException, ClassNotFoundException {
        List<String> trainingProgrammeName =programmeBO.getAllTrainingProgrammeIds();
        cmbSelectTrainingProgramme.getItems().addAll(trainingProgrammeName);
    }
    private void setStudentId() throws SQLException, ClassNotFoundException {
        txtStudentID.setText(studentBO.setStudentId());
    }

    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        day=f.format(date);
    }

    public void AddNewStudentOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        StudentDTO s2 = new StudentDTO(
                txtStudentID.getText(),txtStudentName.getText(),
                txtStudentAddress.getText(),
                Integer.parseInt(txtStudentPhoneNumber.getText())
        );

        if(studentBO.addStudent(s2)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        }

        List<ProgrammeDTO> programmeobject = programmeBO.getTrainingProgrammeId((String) cmbSelectTrainingProgramme.getValue());
        for (ProgrammeDTO p:programmeobject) {
            programmeId=p.getProgrammeId();
        }

        saveStudentDetails();

    }

    private void saveStudentDetails() throws SQLException, ClassNotFoundException {
        StudentDetailsDTO studentDetails = new StudentDetailsDTO(programmeId,txtStudentID.getText(),day);

        if(studentDetailsBO.addStudentDetails(studentDetails)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved Student Details..").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
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
                Stage primaryStage = (Stage) this.addStudent.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    public void ExistingStudentOnAction(MouseEvent event) throws IOException {
                if (event.getSource() instanceof JFXButton) {
            JFXButton icon = (JFXButton) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "btnexistingStudent":
                    root = FXMLLoader.load(this.getClass().getResource("../views/ExistingStudentForm.fxml"));
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.addStudent.getScene().getWindow();
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
}
