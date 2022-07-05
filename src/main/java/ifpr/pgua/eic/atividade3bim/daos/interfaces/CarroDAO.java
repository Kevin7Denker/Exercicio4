package ifpr.pgua.eic.atividade3bim.daos.interfaces;

import java.util.ArrayList;

import ifpr.pgua.eic.atividade3bim.modelos.Carro;

public interface CarroDAO {
    
    boolean cadastrar(Carro carro) throws Exception;
    boolean atualizar(int id, Carro carro) throws Exception;
    boolean remover(Carro carro) throws Exception;
    ArrayList<Carro> listar() throws Exception;
    
}
