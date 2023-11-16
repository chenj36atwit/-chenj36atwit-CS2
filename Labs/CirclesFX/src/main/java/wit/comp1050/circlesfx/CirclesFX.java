package wit.comp1050.circlesfx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CirclesFX extends Application {

    Pane pane = new Pane();
    ArrayList<Circle> mCircles = new ArrayList<>();
    @Override// w w w.  j av a  2s . c o  m
    public void start(Stage primaryStage) {

        double width = 600;
        double height = 400;
        // VBox
        VBox infoVBox = new VBox();
        infoVBox.setPadding(new Insets(5, 5, 5, 5));
        infoVBox.setStyle("-fx-border-color: blue");

        Label info1 = new Label("CircleFX Instructions:");
        Label info2 = new Label("To Add Circle: Left Click");
        Label info3 = new Label("To Remove Circle: Right Click");

        infoVBox.getChildren().addAll(info1, info2, info3);
        Pane infoPane = new Pane(infoVBox);
        infoPane.setPadding(new Insets(10, 10, 10, 10));

        // Pane
        pane.getChildren().addAll(infoPane);
        infoVBox.setLayoutX(10);
        infoVBox.setLayoutY(10);

        pane.setOnMouseClicked(e-> {
            double x = e.getX();
            double y = e.getY();
            if (infoPane.contains(x, y)) return;

            if (e.getButton() == MouseButton.PRIMARY) {
                Circle c = drawPoint(x,y);
                mCircles.add(c);
                pane.getChildren().add(c);
                drawMinBoundingRec();

            } else if (e.getButton() == MouseButton.SECONDARY) {
                removePoint(x, y);
                drawMinBoundingRec();

            }

        });

        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Easy TO Click CirclesFX!!!");
        primaryStage.show();
    }

    private Circle drawPoint(double x, double y) {
        Circle c = new Circle(x, y, 20, Color.GREEN);
        c.setStroke(Color.RED);
        return c;
    }

    private void drawMinBoundingRec() {

        removeRec();

        if (mCircles.size() == 0) return;

        Circle top = mCircles.get(0);
        Circle bottom = mCircles.get(0);
        Circle right = mCircles.get(0);
        Circle left = mCircles.get(0);
        for (Circle c : mCircles) {
            if (c.getCenterX() < left.getCenterX()) left = c;
            if (c.getCenterX() > right.getCenterX()) right = c;
            if (c.getCenterY() > bottom.getCenterY()) bottom = c;
            if (c.getCenterY() < top.getCenterY()) top = c;
        }
        double width = right.getCenterX() - left.getCenterX() +  top.getRadius() * 2;
        double height = bottom.getCenterY() - top.getCenterY() +  top.getRadius() * 2;
        double centerX = (right.getCenterX() + left.getCenterX()) / 2;
        double centerY = (top.getCenterY() + bottom.getCenterY()) / 2;

        Rectangle rec = new Rectangle(centerX - width / 2, centerY - height / 2, width, height);
        rec.setStroke(Color.BLACK);
        rec.setFill(Color.TRANSPARENT);
        pane.getChildren().add(rec);

    }
    private void removePoint(double x, double y) {
        ObservableList<Node> list = pane.getChildren();
        for (int i = list.size() - 1; i >= 0; i--) {
            Node c = list.get(i);

            if (c instanceof Circle && c.contains(x, y)) {
                pane.getChildren().remove(c);
                mCircles.remove(c);

                break;
            }
        }
    }

    private void removeRec(){
        ObservableList<Node> list = pane.getChildren();

        for (Node c : list) {
            if (c instanceof Rectangle) {
                pane.getChildren().remove(c);

                break;
            }
        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}