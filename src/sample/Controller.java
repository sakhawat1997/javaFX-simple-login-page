package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button submit;
    @FXML
    private Label noticeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginCheck(ActionEvent event){

        String uName = userName.getText();
        String uPassword = password.getText();

        if (uName.isBlank()==false && uPassword.isBlank()==false){
            validLogin();
        }else {
            noticeButton.setText("Can not Empty");
        }
    }

    public void validLogin(){
        String verifyLogin = "SELECT * FROM userlogin WHERE username='"+userName.getText()+"' AND password ='"+password.getText()+"'";
        Connectioneg connection = new Connectioneg();
        Connection connectdb = connection.getConnection();
        try{
            Statement statement = connectdb.createStatement();
            ResultSet queryResultset = statement.executeQuery(verifyLogin);
            if (!queryResultset.next()){
                noticeButton.setText("Incorrect UserName or Password");
            }else {
                noticeButton.setText("Login Successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
