package com.jogern.diagnosis;

import com.jogern.diagnosis.controller.MainPanelController;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Create on 2019/1/28.
 * @author jogern
 */

public class MainApp extends Application {


      @Override
      public void start(Stage primaryStage) throws Exception {
            URL url = getClass().getResource("/fxml/main-panel.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Parent root = fxmlLoader.load();
            MainPanelController controller = fxmlLoader.getController();
            primaryStage.setTitle("");
            primaryStage.setScene(new Scene(root, 800, 575));
            primaryStage.show();
            primaryStage.setOnCloseRequest(controller);
      }


      public static void main(String[] args) {
            launch(args);
      }
}
