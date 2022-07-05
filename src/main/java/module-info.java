module ifpr.pgua.eic.atividade3bim {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ifpr.pgua.eic.atividade3bim.telas to javafx.fxml;
    exports ifpr.pgua.eic.atividade3bim;
}
