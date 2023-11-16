package wit.comp1050.picasso;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PicassoController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}