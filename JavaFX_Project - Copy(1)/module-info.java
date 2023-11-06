module com.example.javafx_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    requires java.json;
    requires Maven.Project;
    requires java.net.http;
    requires json.simple;
    requires com.google.gson;

    opens com.example.javafx_project to javafx.fxml;
    exports com.example.javafx_project;


}
