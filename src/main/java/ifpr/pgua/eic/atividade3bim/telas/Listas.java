package ifpr.pgua.eic.atividade3bim.telas;


import java.util.Optional;

import ifpr.pgua.eic.atividade3bim.App;
import ifpr.pgua.eic.atividade3bim.modelos.Carro;
import ifpr.pgua.eic.atividade3bim.repositorios.RepositorioCarros;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class Listas {

    @FXML
    private ListView<Carro> lstCarros;

    @FXML
    private Pane rootPane;

    private RepositorioCarros repositorio;
    
    public Listas(RepositorioCarros repositorio){
        this.repositorio = repositorio;
    }

    public void initialize(){

        lstCarros.setCellFactory(lista -> new ListCell<>(){
            protected void updateItem(Carro carro, boolean alterou) {
                super.updateItem(carro, alterou);
                if(carro != null){
                    setText("("+carro.getPlaca()+")"+carro.getModelo());
                }else{
                    setText(null);
                }
            };
        });

        try{
            atualizarLista();
            
        }catch(Exception e){
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
        
    }

    @FXML
    public void atualizarRemoverCarro(MouseEvent event){
        Carro c = lstCarros.getSelectionModel().getSelectedItem();
        try{
            if(c != null){
                if(event.getButton() == MouseButton.SECONDARY){
                    Alert alert = new Alert(AlertType.CONFIRMATION,"Deseja remover o carro "+c.getPlaca()+"?",ButtonType.YES);
                    
                    alert.setHeaderText("REMOVER!!!");
                    Optional<ButtonType> result =  alert.showAndWait();
                    System.out.println(result);
                    if(result.isPresent() && result.get() == ButtonType.YES){
                        repositorio.remover(c);
                        atualizarLista();
                    }
                }else if(event.getButton() == MouseButton.PRIMARY && event.getClickCount()==2){
                    //substituir o painelCentral do Home
                    StackPane painelCentral = (StackPane) rootPane.getParent();
    
                    painelCentral.getChildren().clear();
                    painelCentral.getChildren().add(App.loadTela("fxmls/cadastro_carro.fxml", (o)->new CadastroCarro(c,repositorio)));
                }
            }
        }catch(Exception e){

        }
        
    }

    private void atualizarLista() throws Exception{
        lstCarros.getItems().clear();
        lstCarros.getItems().addAll(repositorio.listar());
    }
}
