package a21.sdj2.thread;


import a21.sdj2.thread.model.TemperatureModel;
import a21.sdj2.thread.model.TemperatureModelManager;
import a21.sdj2.thread.view.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);

  }
}
