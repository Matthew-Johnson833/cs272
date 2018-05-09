package edu.orangecoastcollege.cs272.ic13.view;

import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class SignUpScene {

    private static Controller controller = Controller.getInstance();

	@FXML
	private Label signUpErrorLabel;
	@FXML
	private Label nameErrorLabel;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	private TextField nameTF;
	@FXML
	private TextField emailAddressTF;
	@FXML
	private TextField passwordTF;

	// Event Listener on Label.onMouseClicked
	@FXML
	public void loadSignIn(MouseEvent event) {
		ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public boolean signUpUser(MouseEvent event) {
	    String email = emailAddressTF.getText();
	    String password = passwordTF.getText();
	    String name = nameTF.getText();

	    // Check to see if the error labels should be made visible:
	    emailErrorLabel.setVisible(email.isEmpty());
	    passwordErrorLabel.setVisible(password.isEmpty());
	    nameErrorLabel.setVisible(name.isEmpty());

	    if (nameErrorLabel.isVisible() || emailErrorLabel.isVisible() || passwordErrorLabel.isVisible())
	        return false;

	    String result = controller.signUpUser(name, email, password);
	    if (result.equalsIgnoreCase("SUCCESS")) {
	        signUpErrorLabel.setVisible(false);
	        ViewNavigator.loadScene("Video Game List", ViewNavigator.VIDEO_GAME_LIST_SCENE);
	        return true;
	    }
	    signUpErrorLabel.setText(result);
	    signUpErrorLabel.setVisible(true);
	    return false;

	}
}
