package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainWindow extends Application {

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindowInterface.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load());

        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        mainStage.initStyle(StageStyle.TRANSPARENT);
        mainScene.setFill(Color.TRANSPARENT);
        mainStage.setTitle("Calculator");
        mainStage.show();

        MainWindowController controller = fxmlLoader.getController();
        controller.initialize(mainStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
