package ifpr.pgua.eic.atividade3bim.telas;

import java.sql.SQLException;

import ifpr.pgua.eic.atividade3bim.modelos.Carro;
import ifpr.pgua.eic.atividade3bim.repositorios.RepositorioCarros;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroCarro {

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfPlaca;

    @FXML
    private TextField tfCor;

    @FXML
    private TextField tfAnoFabricacao;

    @FXML
    private TextField tfAnoModelo;

    @FXML
    private TextField tfPeso;

    @FXML
    private TextField tfKilometragemAtual;

    @FXML
    private Button btlimpar; 
    
    @FXML
    private Button btCadastrar; 

    private RepositorioCarros repositorio;

    private Carro carroAntigo;

    public CadastroCarro(RepositorioCarros repositorio){
        this.repositorio = repositorio;
    }

    public CadastroCarro(Carro carroAntigo,RepositorioCarros repositorio){
        this.carroAntigo = carroAntigo;
        this.repositorio = repositorio;
    }

    public void initialize(){
        if(carroAntigo != null){
            tfModelo.setText(carroAntigo.getModelo());
            tfMarca.setText(carroAntigo.getMarca());
            tfPlaca.setText(carroAntigo.getPlaca());
            tfCor.setText(carroAntigo.getCor());
            tfAnoFabricacao.setText(""+carroAntigo.getAnoFabricacao());
            tfAnoModelo.setText(""+carroAntigo.getAnoModelo());
            tfPeso.setText(""+carroAntigo.getPeso());
            tfKilometragemAtual.setText(""+carroAntigo.getKilometragemAtual()); 

            btCadastrar.setText("Atualizar");
            btlimpar.setDisable(true);    
        }
    }

    @FXML
    private void cadastrar(){

        String modelo = tfModelo.getText();
        String marca = tfMarca.getText();
        String placa = tfPlaca.getText();
        String cor = tfCor.getText();
        String strAnoFabricacao = tfAnoFabricacao.getText();
        String strAnoModelo = tfAnoModelo.getText();
        String strPeso = tfPeso.getText();
        String strKilometragemAtual = tfKilometragemAtual.getText();

        boolean temErro = false;
        String msg="";

        int anoFabricacao = 0;
        int anoModelo = 0;
        double peso = 0.0;
        double kilometragemAtual = 0.0;

        if(modelo.isEmpty() || modelo.isBlank()){
            temErro = true;
            msg += "Modelo não pode ser vazio!\n";
        }

        if(marca.isEmpty() || marca.isBlank()){
            temErro = true;
            msg += "Marca não pode ser vazio!\n";
        }

        if(placa.isEmpty() || placa.isBlank()){
            temErro = true;
            msg += "Placa não pode ser vazio!\n";
        }

        if(cor.isEmpty() || cor.isBlank()){
            temErro = true;
            msg += "Cor não pode ser vazio!\n";
        }

        try{
            anoFabricacao = Integer.parseInt(strAnoFabricacao);
        }catch(NumberFormatException e){
            temErro = true;
            msg += "Ano de Fabricação inválido!";
        }

        try{
            anoModelo = Integer.parseInt(strAnoModelo);
        }catch(NumberFormatException e){
            temErro = true;
            msg += "Ano de Modelo inválido!";
        }

        try{
            peso = Double.parseDouble(strPeso);
        }catch(NumberFormatException e){
            temErro = true;
            msg += "Peso inválido!";
        }

        try{
            kilometragemAtual = Double.parseDouble(strKilometragemAtual);
        }catch(NumberFormatException e){
            temErro = true;
            msg += "Kilometragem Atual inválida!";
        }




        if(!temErro){
            try{
                boolean ret = true;
                if(carroAntigo != null){
                    ret = repositorio.atualizar(carroAntigo.getId(), modelo, marca, placa, cor, anoFabricacao, anoModelo, peso, kilometragemAtual);
                }else{
                    ret = repositorio.cadastrar(modelo, marca, placa, cor, anoFabricacao, anoModelo, peso, kilometragemAtual);
                }
                
                if(ret){
                    msg = "Carro cadastrado com sucesso!";
                    limpar();
                }else{
                    msg = "Erro ao cadastrar carro!";
                }
            }catch(Exception e){
                temErro = true;
                msg = e.getMessage();
            } 
        }

        Alert alert = new Alert(temErro?AlertType.ERROR:AlertType.INFORMATION,msg);
        alert.showAndWait();
    }

    @FXML
    private void limpar(){
        tfModelo.clear();
        tfMarca.clear();
        tfPlaca.clear();
        tfCor.clear();
        tfAnoFabricacao.clear();
        tfAnoModelo.clear();
        tfPeso.clear();
        tfKilometragemAtual.clear();
    }



}
