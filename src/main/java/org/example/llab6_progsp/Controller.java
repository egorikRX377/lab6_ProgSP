package org.example.llab6_progsp;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class Controller {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView imageCar;

    @FXML
    private ImageView imageHuman;

    @FXML
    private Button startMovingButton;

    @FXML
    private void initialize()
    {
        startMovingButton.setOnAction(event -> startAnimation());
        imageHuman.setOpacity(0);
    }

    private void startAnimation()
    {
        Thread carThread = new Thread(() -> {

            TranslateTransition carTransition = new TranslateTransition(Duration.seconds(2), imageCar);
            carTransition.setByX(-200);
            carTransition.play();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            TranslateTransition carContinueTransition = new TranslateTransition(Duration.seconds(2), imageCar);
            carContinueTransition.setByX(-400);
            carContinueTransition.play();
        });

        Thread humanThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            FadeTransition fadeInHuman = new FadeTransition(Duration.seconds(0.5), imageHuman);
            fadeInHuman.setFromValue(0);
            fadeInHuman.setToValue(1);
            fadeInHuman.play();

            imageHuman.setLayoutX(imageCar.getLayoutX());
            imageHuman.setLayoutY(imageCar.getLayoutY() + 50);

            TranslateTransition humanTransition = new TranslateTransition(Duration.seconds(7), imageHuman);
            humanTransition.setByX(200);
            humanTransition.play();
        });

        carThread.start();
        humanThread.start();
    }
}