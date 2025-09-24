package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private final DictionaryController controller = new DictionaryController();

    @Override
    public void start(Stage primaryStage) {
        // Search section
        TextField wordField = new TextField();
        wordField.setPromptText("Enter a word");
        Button searchButton = new Button("Search");
        TextArea meaningArea = new TextArea();
        meaningArea.setEditable(false);
        meaningArea.setPrefRowCount(4);
        meaningArea.setWrapText(true);

        // Add word section
        TextField newWordField = new TextField();
        newWordField.setPromptText("New word");
        TextField newMeaningField = new TextField();
        newMeaningField.setPromptText("Meaning of new word");
        Button addButton = new Button("Add Word");
        Label feedbackLabel = new Label();

        // Layout
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        root.getChildren().addAll(
                new Label("Word:"), wordField, searchButton,
                new Label("Meaning:"), meaningArea,
                new Separator(),
                new Label("Add New Word:"), newWordField,
                new Label("Meaning:"), newMeaningField, addButton,
                feedbackLabel
        );

        // Events
        searchButton.setOnAction(event -> {
            String word = wordField.getText();
            String result = controller.search(word);
            meaningArea.setText(result);
        });

        addButton.setOnAction(event -> {
            String newWord = newWordField.getText().trim();
            String newMeaning = newMeaningField.getText().trim();
            String feedback = controller.addWord(newWord, newMeaning);
            feedbackLabel.setText(feedback);
            if (!feedback.startsWith("Word and")) { // clear inputs if successful
                newWordField.clear();
                newMeaningField.clear();
            }
        });

        Scene scene = new Scene(root, 550, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dictionary App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
