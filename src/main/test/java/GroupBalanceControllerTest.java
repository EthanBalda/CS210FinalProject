import com.example.team_project_unit2_item2ui_development.GroupBalanceController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class GroupBalanceControllerTest {

    static CountDownLatch latch = new CountDownLatch(1);

    @BeforeAll
    public static void initJavaFX() throws Exception {
        Platform.startup(() -> {
        });
        latch.countDown();
    }

    @Test
    public void testValidInput() throws Exception {
        latch.await(3, TimeUnit.SECONDS);

        Platform.runLater(() -> {
            GroupBalanceController controller = new GroupBalanceController();
            controller.totalField = new TextField("200");
            controller.peopleField = new TextField("4");
            controller.showSplitCheckBox = new CheckBox();
            controller.showSplitCheckBox.setSelected(true);
            controller.resultLabel = new Label();
            controller.splitLabel = new Label();

            controller.handleCalculate();

            assertEquals("Total Amount: $200.00", controller.resultLabel.getText());
            assertEquals("Each person should contribute: $50.00", controller.splitLabel.getText());
        });

        Thread.sleep(1000);
    }
}
