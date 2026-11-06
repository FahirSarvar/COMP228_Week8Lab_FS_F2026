package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
		//Top Hbox
		Label title = new Label("College Student Services");
		
		HBox header = new HBox(title);
		header.setStyle("-fx-background-color: #414142");
		title.setStyle("-fx-text-fill: #FFFFFF");
		header.setPadding(new Insets(15));
		
		root.setTop(header);
		
		//Left Vbox
		
		Button dashboardButton = new Button("Dashboard");
		Button registrationButton = new Button("Registration");
		Button courseButton = new Button("Courses");
		Button helpButton = new Button("Help");
		
		VBox navigation = new VBox(12, dashboardButton,registrationButton,courseButton,helpButton );
		navigation.setStyle("-fx-background-color: #D4DF38 ");
		navigation.setPadding(new Insets(15));
		dashboardButton.setPrefWidth(100);
		registrationButton.setPrefWidth(100);
		courseButton.setPrefWidth(100);
		helpButton.setPrefWidth(100);
		root.setLeft(navigation);
		
		//form controls
		
		TextField idField = new TextField();
		TextField nameField = new TextField();
		TextField emailField = new TextField();
		
		ComboBox<String> programBox = new ComboBox<>();
		programBox.getItems().addAll("Sofware Engineering Technology", "Business", "Nursing" );
		programBox.setPromptText("Select a program");
		
		//grid pane
		
		GridPane form = new GridPane();
		form.setMaxWidth(400);
		form.setPadding(new Insets(15));
		form.setHgap(12);
		form.setVgap(14);
		form.setStyle("-fx-border-color: lightgray; -fx-border-width: 2; -fx-border-radius: 5;-fx-background-radius: 8; -fx-background-color: #f0f0f0");
		form.add(new Label("Student ID:"), 0, 0);
		form.add(idField, 1, 0);
		form.add(new Label("Full Name:"), 0, 1);
		form.add(nameField, 1, 1);
		form.add(new Label("Email:"), 0, 2);
		form.add(emailField, 1, 2);
		form.add(new Label("Program:"), 0, 3);
		form.add(programBox, 1, 3);
		
		//buttons
		
		Button registerButton = new Button("Register");
		Button clearButton = new Button("Clear");
		
		HBox actions = new HBox(10, registerButton, clearButton);
		
		Label formTitle = new Label("Student Registration");
		Label statusLabel = new Label("");
		
		VBox center = new VBox(15,formTitle, form, actions, statusLabel);
		
		center.setPadding(new Insets(20));
		root.setCenter(center);
		
		//register  button
		
		registerButton.setOnAction(event ->{
			String id = idField.getText().trim();
			String name = nameField.getText().trim();
			String email = emailField.getText().trim();
			
			if (id.isEmpty() || name.isEmpty() || email.isEmpty() || programBox.getValue() == null) {
				
				statusLabel.setText("Error: please fill in all fields");
			} 
			else {
				statusLabel.setText("Registration is successful");
			}
		});
		
		clearButton.setOnAction(event ->{
			idField.clear();
			nameField.clear();
			emailField.clear();
			programBox.getSelectionModel().clearSelection();
			statusLabel.setText("");
		});
		
		Scene scene = new Scene(root, 850, 520);
		primaryStage.setTitle("College Student Services");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
