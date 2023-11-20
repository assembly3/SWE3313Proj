module com.example.projectswe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires Maven.Project;
    requires java.json;


    opens com.example.projectswe to javafx.fxml;
    exports com.example.projectswe;
}