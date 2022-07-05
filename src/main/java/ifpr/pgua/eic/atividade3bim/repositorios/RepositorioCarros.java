package ifpr.pgua.eic.atividade3bim.repositorios;

import java.util.ArrayList;

import ifpr.pgua.eic.atividade3bim.daos.interfaces.CarroDAO;
import ifpr.pgua.eic.atividade3bim.modelos.Carro;

public class RepositorioCarros {

    private CarroDAO carroDAO;

    public RepositorioCarros(CarroDAO carroDAO) {
        this.carroDAO = carroDAO;
    }


    public boolean cadastrar(String modelo, String marca, String placa,String cor, int anoFabricacao, int anoModelo, double peso,
    double kilometragemAtual) throws Exception{
        Carro c = new Carro(modelo, marca, placa, cor, anoFabricacao, anoModelo, peso, kilometragemAtual);
        return carroDAO.cadastrar(c);
    }

    public boolean atualizar(int id, String modelo, String marca, String placa,String cor, int anoFabricacao, int anoModelo, double peso,
    double kilometragemAtual) throws Exception{
        Carro c = new Carro(modelo, marca, placa, cor, anoFabricacao, anoModelo, peso, kilometragemAtual);
        return carroDAO.atualizar(id,c);
    }

    public boolean remover(Carro c) throws Exception{
        return carroDAO.remover(c);
    }

    public ArrayList<Carro> listar() throws Exception{
        return carroDAO.listar();
    }
      
}
