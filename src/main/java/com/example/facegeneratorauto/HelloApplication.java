package com.example.facegeneratorauto;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    static boolean boo = true;
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();
    static int min = 1;
    static int max = 3;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        //drawShape();

        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
            gc.clearRect(0, 0, width, height);
            try {
                autoGenerateFace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
        timeline.setCycleCount(360);
        timeline.play();
    }


    public static int randomNumber (int min, int max) {
        Random random = new Random();
        int randomizer = random.nextInt((max - min + 1) + 1);

        return randomizer;
    }

    public static void autoGenerateFace(){


        drawShape();
        drawMouth();
        drawEyes();
    }


    //Shape of head
    public static void drawShape() {

        System.out.println("What shape of face would you like?");
        System.out.println("Square:\t\t\t\tPress 1\nOval:\t\t\t\tPress 2\nTriangular:\t\t\tPress 3");

        int shapeOfHead = randomNumber(1,3);
        if (shapeOfHead == 1) { //Square head
            gc.strokeRect(150, 150, 300, 300);
        } else if (shapeOfHead == 2) { //Oval head
            gc.strokeOval(150, 150, 300, 300);
        } else if (shapeOfHead == 3) { //Triangular head
            gc.strokePolygon(new double[]{300, 80, 520}, new double[]{500, 160, 160}, 3);
        }

    }


    //Shape of mouth
    public static void drawMouth() {

        System.out.println("How big would you like the mouth to be?");
        System.out.println("Small:\t\t\t\tPress 1\nMedium:\t\t\t\tPress 2\nLarge:\t\t\t\tPress 3");

        int mouthSize = randomNumber(1,3);
        gc.setFill(Color.BLACK);
        if (mouthSize == 1) { //Small mouth
            gc.fillOval(290, 320, 25, 25);
        } else if (mouthSize == 2) { //Medium mouth
            gc.fillOval(260, 310, 80, 80);
        } else if (mouthSize == 3) { //Large mouth
            gc.fillOval(240, 300, 120, 120);
        }

    }


    //Style of eyes
    public static void drawEyes() {

        System.out.println("How big would you like your eyes?");
        System.out.println("Small n' squinty:\tPress 1\nNormal n' boring:\tPress 2\nHuge n' scary:\t\tPress 3");

        int styleOfEyes = randomNumber(1,3);
        gc.setFill(Color.BLACK);
        if (styleOfEyes == 1) { //Small n' squinty
            gc.fillOval(220,220,20,20);
            gc.fillOval(360,220,20,20);
        } else if (styleOfEyes == 2) { //Normal n' boring
            gc.fillOval(220,220,45,45);
            gc.fillOval(360,220,45,45);
        } else if (styleOfEyes == 3) { //Huge n' scary
            gc.fillOval(220,220,65,65);
            gc.fillOval(360,220,65,65);
        }

    }


    public static void main(String[] args) {
        launch();
    }
}