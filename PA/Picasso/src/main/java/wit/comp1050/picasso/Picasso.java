package wit.comp1050.picasso;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;
import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;

public class Picasso extends Application
{
    static Pane pane = new Pane();
    VBox infoVBox = new VBox();
    private static Color ccc1;
    ArrayList<Circle> mCircles = new ArrayList<>();

    public static void main(String args[]){
        launch(args);
    }
        public void start(Stage primaryStage)
        {
        double width = 1000;
        double height = 1000;

        infoVBox.setPadding(new Insets(5, 5, 5, 5));
        infoVBox.setStyle("-fx-border-color: blue");

        Label info1 = new Label("Note that the default shape is Circle. Triangle is random and Rectangle is fix in one place. Use the option 7 when you to switch back to Circle. Please pick a Color first!" +
                                   "FX Instructions below:");
        Label info2 = new Label("To Add Circle/Rectangle/Triangle: Left Click");
        Label info3 = new Label("To Remove Circle is just right click the Circle. Clear Rectangle by click anything the white screen not the shape itself. Clear Triangle same thing as Rectangle.");

            Button button1 = new Button("Change Color to Red");
            Button button2 = new Button("Change Color to Blue");
            Button button3 = new Button("Change Color to Green");
            Button button4 = new Button("Change Color to Purple");
            Button button5 = new Button("Change Shape to Triangle");
            Button button6 = new Button("Change Shape to Rectangle");
            Button button7 = new Button("Change Shape to Circle");
            Button button8 = new Button("Clear everything/Exit Program");

            infoVBox.getChildren().add(button1);
            infoVBox.getChildren().add(button2);
            infoVBox.getChildren().add(button3);
            infoVBox.getChildren().add(button4);
            infoVBox.getChildren().add(button5);
            infoVBox.getChildren().add(button6);
            infoVBox.getChildren().add(button7);
            infoVBox.getChildren().add(button8);

            button1.setOnAction(t -> new VBox());
            button2.setOnAction(t -> new VBox());
            button3.setOnAction(t -> new VBox());
            button4.setOnAction(t -> new VBox());
            button5.setOnAction(t -> new VBox());
            button6.setOnAction(t -> new VBox());
            button7.setOnAction(t -> new VBox());
            button8.setOnAction(t -> new VBox());

        button1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ccc1 = Color.RED;
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ccc1 = Color.BLUE;
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ccc1 = Color.GREEN;
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ccc1 = Color.PURPLE;
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) {

                pane.setOnMouseClicked(e -> {
                    double x = e.getX();
                    double y = e.getY();

                    if (e.getButton() == PRIMARY) {
                    Polygon triangle = new Polygon();
                    Random generator = new Random();
                    int x1 = generator.nextInt(500);
                    int x2 = generator.nextInt(500);
                    int x3 = generator.nextInt(500);
                    int x4 = generator.nextInt(500);
                    int x5 = generator.nextInt(500);
                    int x6 = generator.nextInt(500);
                    pane.getChildren().add(triangle);
                    triangle.getPoints().addAll((double) x2, (double) x3, (double) x4, (double) x5, (double) x6, (double) x1);
                    triangle.setFill(ccc1);

                } else if (e.getButton() == SECONDARY) {
                    removePoint(x,y);
                    drawMinBoundingRec();
                }
                });
            }
        });
        button6.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                pane.setOnMouseClicked(e -> {
                    double x = e.getX();
                    double y = e.getY();
                    double width1, height1;

                    if (e.getButton() == PRIMARY) {
                        Rectangle rect = new Rectangle();
                        Random generator = new Random();
                        pane.getChildren().add(rect);
                        width1 = generator.nextDouble() * 200;
                        height1 = generator.nextDouble() * 200;
                        rect.setX(250);
                        rect.setY(250);
                        rect.setWidth(width1);
                        rect.setHeight(height1);
                        rect.setFill(ccc1);

                    } else if (e.getButton() == SECONDARY) {
                        removePoint(x, y);
                        drawMinBoundingRec();
                    }
                });
            }
        });
        button7.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
               button7.setOnAction(t -> new Picasso().start(primaryStage));
            }
        });
        button8.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        infoVBox.getChildren().addAll(info1, info2, info3);
        Pane infoPane = new Pane(infoVBox);
        infoPane.setPadding(new Insets(10, 10, 10, 10));

        //Pane
        pane.getChildren().addAll(infoPane);
        infoVBox.setLayoutX(10);
        infoVBox.setLayoutY(10);

        pane.setOnMouseClicked(e-> {
            double x = e.getX();
            double y = e.getY();
            if (infoPane.contains(x, y)) return;

            if (e.getButton() == PRIMARY) {
                Circle c = drawPoint1(x,y,String.valueOf(ccc1));
                mCircles.add(c);
                pane.getChildren().add(c);
                drawMinBoundingRec();

            } else if (e.getButton() == SECONDARY) {
                removePoint(x, y);
                drawMinBoundingRec();

            }

        });

        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Easy TO Click CirclesFX!!!");
        primaryStage.show();
    }

        private Circle drawPoint1(double x, double y, String Color) {
            Circle c = new Circle(x, y, 20, ccc1);
            c.setStroke(ccc1);
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
        rec.setStroke(Color.TRANSPARENT);
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
}
