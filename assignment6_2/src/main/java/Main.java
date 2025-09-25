import model.CurrencyModel;
import view.CurrencyView;
import controller.CurrencyController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        CurrencyModel model = new CurrencyModel();
        CurrencyView view = new CurrencyView();
        CurrencyController controller = new CurrencyController(model, view);

        view.start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
