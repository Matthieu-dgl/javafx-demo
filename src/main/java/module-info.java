module com.matthieudeglon.javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.matthieudeglon.javafx to javafx.fxml;
    exports com.matthieudeglon.javafx;
}