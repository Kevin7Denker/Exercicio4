package ifpr.pgua.eic.atividade3bim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

import ifpr.pgua.eic.atividade3bim.daos.JDBCarroDAO;
import ifpr.pgua.eic.atividade3bim.daos.interfaces.CarroDAO;
import ifpr.pgua.eic.atividade3bim.repositorios.RepositorioCarros;
import ifpr.pgua.eic.atividade3bim.telas.Home;
import ifpr.pgua.eic.atividade3bim.utils.FabricaConexoes;


public class App extends Application {

    FabricaConexoes fabricaConexoes = FabricaConexoes.getInstance();

    
   
    CarroDAO carroDAO = new JDBCarroDAO(fabricaConexoes);

    RepositorioCarros repositorio = new RepositorioCarros(carroDAO);


    @Override
    public void start(Stage stage) throws IOException {
        

        Scene scene = new Scene(loadTela("fxmls/home.fxml", o->new Home(repositorio)), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    
    public static Parent loadTela(String fxml, Callback controller){
        Parent root = null;
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource(fxml));
            loader.setControllerFactory(controller);

            root = loader.load();
            
        }catch (Exception e){
            System.out.println("Problema no arquivo fxml. Está correto?? "+fxml);
            e.printStackTrace();
            System.exit(0);
        }
        return root;   
    }

    public static void main(String[] args) {
        launch();
    }

}