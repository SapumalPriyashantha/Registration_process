package lk.ijse.hibernate.controller;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.entity.TM.StudentdetailsView;

import java.io.IOException;
import java.util.List;

public class ViewStudentDetailsFormController {
    public AnchorPane root;
    public TableView tblViewStudentDetails;
    public TableColumn colStudentID;
    public TableColumn colStudentName;
    public TableColumn colPhoneNumber;
    public TableColumn colProgrammeName;
    public TableColumn colRegistrationDate;
    public ImageView imgBack;

    StudentDetailsController sdi = new StudentDetailsController();

    static ObservableList<StudentdetailsView> exsisStudentDetails= FXCollections.observableArrayList();
    public void initialize() {
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("studentPhoneNumber"));
        colProgrammeName.setCellValueFactory(new PropertyValueFactory<>("programmeName"));
        colRegistrationDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));

        tblViewStudentDetails.setItems(exsisStudentDetails);
        exsisStudentDetails.clear();

        showStudentDetails();
    }

    private void showStudentDetails() {
        List<StudentdetailsView> objects = sdi.viewStudentDetails();
        exsisStudentDetails.clear();

        for (StudentdetailsView s1 : objects) {
            exsisStudentDetails.add(new StudentdetailsView(s1.getStudentId(), s1.getStudentName(),
                    s1.getStudentPhoneNumber(), s1.getProgrammeName(), s1.getRegistrationDate()));
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
}
