package appMain;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppMain extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();
    }

    /**
     * ���� ���̾ƿ��� �ʱ�ȭ�Ѵ�.
     */
    public void initRootLayout() {
        try {
            // fxml ���Ͽ��� ���� ���̾ƿ��� �����´�.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resource/view/AppMain.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // ���� ���̾ƿ��� �����ϴ� scene�� �����ش�.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���� ���������� ��ȯ�Ѵ�.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
