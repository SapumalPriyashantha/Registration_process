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

    StudentController s1 = new StudentController();
    TrainingProgrammecontroller t1 = new TrainingProgrammecontroller();
    StudentDetailsController sdi = new StudentDetailsController();

    public void initialize(){
        try {
            loadTrainingProgrammes();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        setStudentId();
        loadDate();
    }

    private void loadTrainingProgrammes() throws SQLException, ClassNotFoundException {
        List<String> trainingProgrammeName =s1.getAllTrainingProgrammeIds();
        cmbSelectTrainingProgramme.getItems().addAll(trainingProgrammeName);
    }
    private void setStudentId() {

        txtStudentID.setText(s1.setStudentId());
    }

    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        day=f.format(date);
    }

    public void AddNewStudentOnAction(ActionEvent actionEvent) {
        Student s2 = new Student(
                txtStudentID.getText(),txtStudentName.getText(),
                txtStudentAddress.getText(),
                Integer.parseInt(txtStudentPhoneNumber.getText())
        );

        if(s1.addStudents(s2)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        }

        List<Programme> programmeobject = t1.getTrainingProgrammeId((String) cmbSelectTrainingProgramme.getValue());
        for (Programme p:programmeobject) {
            programmeId=p.getProgrammeId();
        }

        saveStudentDetails();

    }

    private void saveStudentDetails() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student stu1 = session.get(Student.class,txtStudentID.getText());
        Programme pro1 = session.get(Programme.class,programmeId);

        transaction.commit();
        session.close();

        StudentDetails studentDetails = new StudentDetails(pro1,stu1,day);

        if(sdi.AddStudentDetails(studentDetails)) {
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
