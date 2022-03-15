module com.samsteenmans.weatherapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires okhttp3;
    requires json.simple;

    opens com.samsteenmans.weatherapplication to javafx.fxml;
    exports com.samsteenmans.weatherapplication;
}