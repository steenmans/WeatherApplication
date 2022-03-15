module com.samsteenmans.weatherapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires okhttp3;
    requires json.simple;
    requires org.controlsfx.controls;


    opens com.samsteenmans.weatherapplication to javafx.fxml;
    exports com.samsteenmans.weatherapplication;
}