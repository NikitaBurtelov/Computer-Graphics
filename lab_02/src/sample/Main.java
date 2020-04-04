package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Group root = new Group();

    public static void main(String[] args) {
        launch(args);
    }

    private void readTextArea(TextArea taOne, TextArea taTwo) {
        System.out.println(taOne.getText() + taTwo.getText());
        String[] str1 = taOne.getText().split(" ");
        String[] str2 = taTwo.getText().split(" ");

        double[] absDataOne = new double[str1.length / 2];
        double[] ordDataOne = new double[str1.length / 2];
        double[] absDataTwo = new double[str2.length / 2];
        double[] ordDataTwo = new double[str2.length / 2];

        for (int i = 0, j = 0; j < str1.length; i++, j += 2) {
            absDataOne[i] = Double.valueOf(str1[j]);
            ordDataOne[i] = Double.valueOf(str1[j + 1]);
        }
        for (int i = 0, j = 0; j < str2.length; i++, j += 2) {
            absDataTwo[i] = Double.valueOf(str2[j]);
            ordDataTwo[i] = Double.valueOf(str2[j + 1]);
        }
    }

    private void inputTextArea(TextArea textArea, int x, int y) {
        textArea.setLayoutX(x);
        textArea.setLayoutY(y);
        textArea.setPrefRowCount(2);
        textArea.setPrefColumnCount(13);
    }

    private void getButton(Button btn, int x, int y, int width, int height) {
        btn.setLayoutX(x);
        btn.setLayoutY(y);
        btn.setPrefWidth(width);
        btn.setPrefHeight(height);
    }

    private Line getLine(Line line, Color color, int width) {
        line.setStroke(color);
        line.setStrokeWidth(width);

        return line;
    }

    private void getLabel(Label label, int x, int y) {
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setFont(new Font("Arial", 14));
        label.setTextFill(Color.web("#0076a3"));
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        BorderPane root = new BorderPane();//FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane pane = new Pane();

        primaryStage.setTitle("Lab_01");

        TextArea textAreaOne = new TextArea("Перенос");
        TextArea textAreaTwo = new TextArea("Масштабирование");
        TextArea textAreaThree = new TextArea("Поворот");

        inputTextArea(textAreaOne, 710, 40);
        inputTextArea(textAreaTwo, 710, 140);
        inputTextArea(textAreaThree, 710, 240);

        Line line = new Line(690, 0, 690, 600);
        getLine(line, Color.GRAY, 3);

        Label label1 = new Label("Введите коорд. переноса");
        Label label2 = new Label("Введите % масштабирования");
        Label label3 = new Label("Введите угол поворота");

        getLabel(label1, 710, 10);
        getLabel(label2, 710, 110);
        getLabel(label3, 710, 210);

        Button runBtn = new Button("Run");
        Button cleanBtn = new Button("Clean");

        getButton(runBtn, 800, 310, 80, 37);
        getButton(cleanBtn, 800, 360, 80, 37);

        runBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                readTextArea(textAreaOne, textAreaTwo);
            }
        });

        cleanBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textAreaOne.clear();
                textAreaTwo.clear();
                textAreaThree.clear();
            }
        });

        pane.getChildren().addAll(runBtn, cleanBtn, textAreaOne,
                textAreaTwo, textAreaThree, line, label1, label2, label3);
        root.setTop(pane);

        primaryStage.setScene(new Scene(root, 920, 600));
        primaryStage.show();

    }
}
