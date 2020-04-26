package startup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/boundary/FXML/AnnunciAppartamenti.fxml"));
        primaryStage.setTitle("AnnunciAppartamentiBoundary");
        primaryStage.setScene(new Scene(root, 1680, 1050));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
