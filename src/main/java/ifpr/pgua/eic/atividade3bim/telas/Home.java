package ifpr.pgua.eic.atividade3bim.telas;

import ifpr.pgua.eic.atividade3bim.App;
import ifpr.pgua.eic.atividade3bim.repositorios.RepositorioCarros;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class Home {
    
    private RepositorioCarros repositorio;
    
    @FXML
    private StackPane painelCentral;


    public Home(RepositorioCarros repositorio){
        this.repositorio = repositorio;
    }

    @FXML
    private void loadListas(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxmls/listas.fxml", (o)->new Listas(repositorio)));
    }

    @FXML
    private void loadCadastroCarro(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxmls/cadastro_carro.fxml", (o)->new CadastroCarro(repositorio)));
    }
}
