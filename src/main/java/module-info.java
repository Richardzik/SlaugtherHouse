module com.example.slaughterhouse {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.example.slaughterhouse to javafx.fxml;
  exports com.example.slaughterhouse;
}