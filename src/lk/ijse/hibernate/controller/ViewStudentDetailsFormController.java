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
        List<Object[]> objects = sdi.viewStudentDetails();
        exsisStudentDetails.clear();

        for (Object[] s1 : objects) {
//            String sid =
//                    String name =
//                            int phoneNumber =
//                               String programmeName =
//                               String registrationdate  =
            exsisStudentDetails.add(new StudentdetailsView((String) s1[0], (String) s1[1],
                    (int)s1[2], (String) s1[3], (String) s1[4]));
//            System.out.println(s1[0]+":"+s1[1]+":"+s1[2]+":"+s1[3]+":"+s1[4]);
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
