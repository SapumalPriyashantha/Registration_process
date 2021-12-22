package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ExistingStudentFormController {
    public AnchorPane root;
    public ImageView imgBack;
    public TableView<Student> tblExistingStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colStudentAddress;
    public TableColumn colPhoneNumber;
    public JFXTextField txtSearchQuery;
    public JFXButton btnSearch;
    public JFXTextField txtNewStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAddress;
    public JFXComboBox txtSelectProgram;
    public JFXButton btnUpdate;
    int cartSelectedRowForRemove  ;

    StudentController s1 = new StudentController();
    StudentController sc = new StudentController();
    static ObservableList<Student> exsisStudentDetails= FXCollections.observableArrayList();

    public void initialize() {

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colStudentAddress.setCellValueFactory(new PropertyValueFactory<>("studentAddress"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("studentPhoneNumber"));

        tblExistingStudent.setItems(exsisStudentDetails);
        exsisStudentDetails.clear();

        tblExistingStudent.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            cartSelectedRowForRemove = (int) newValue;
        });

        setStudentId();

        try {
            loadTrainingProgrammes();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void loadTrainingProgrammes() throws SQLException, ClassNotFoundException {
        List<String> trainingProgrammeName =s1.getAllTrainingProgrammeIds();
        txtSelectProgram.getItems().addAll(trainingProgrammeName);
    }
    private void setStudentId() {

        txtNewStudentId.setText(s1.setStudentId());
    }
    public void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgBack":
                    root = FXMLLoader.load(this.getClass().getResource("../views/AddNewStudentsForm.fxml"));
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

    public void searchOnAction(ActionEvent actionEvent) {
        List<Student> students = sc.searchStudents(txtSearchQuery.getText());
        exsisStudentDetails.clear();

        for (Student s1 : students) {
            exsisStudentDetails.add(new Student(s1.getStudentId(), s1.getStudentName(),
                                 s1.getStudentAddress(), s1.getStudentPhoneNumber()));
        }
    }

    public void updateOnaction(ActionEvent actionEvent) {

    }

    public void getRowdataOnAction(ActionEvent actionEvent) {
        Student temp = exsisStudentDetails.get(cartSelectedRowForRemove);
        txtStudentName.setText(temp.getStudentName());
        txtStudentAddress.setText(temp.getStudentAddress());
    }
}
