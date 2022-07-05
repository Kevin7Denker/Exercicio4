package ifpr.pgua.eic.atividade3bim.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ifpr.pgua.eic.atividade3bim.daos.interfaces.CarroDAO;
import ifpr.pgua.eic.atividade3bim.modelos.Carro;
import ifpr.pgua.eic.atividade3bim.utils.FabricaConexoes;


public class JDBCarroDAO implements CarroDAO{

    private FabricaConexoes fabricaConexoes;

    public JDBCarroDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }
    
    @Override
    public boolean cadastrar(Carro carro) throws Exception {
        
        Connection con = fabricaConexoes.getConnection();
        
        String sql = "INSET INTO carros(modelo,marca,placa,cor,ano_fabricação,ano_modelo,peso,kilometragem_atual) VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, carro.getModelo());
          pstmt.setString(2, carro.getMarca());
        pstmt.setString(3, carro.getPlaca());
          pstmt.setString(4, carro.getCor());
        pstmt.setInt(5, carro.getAnoFabricacao());
          pstmt.setInt(6, carro.getAnoModelo());
        pstmt.setDouble(7, carro.getPeso());
          pstmt.setDouble(8, carro.getKilometragemAtual());

        pstmt.execute();
        
        ResultSet rsId = pstmt.getGeneratedKeys();
          rsId.next();
        
        int id = rsId.getInt(1);
          carro.setId(id);

        //----//---//--//-//
        rsId.close();
        pstmt.close();
        con.close();
        
        return true;
    }

    @Override
    public boolean atualizar(int id, Carro carro) throws Exception {
        Connection con = fabricaConexoes.getConnection();

        String sql = "UPDATE carros SET modelo = ?,marca = ?,placa = ?,cor = ?,ano_fabricação = ?,ano_modelo = ?,peso = ?,kilometragem_atual =?  WHERE id = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, carro.getModelo());
          pstmt.setString(2, carro.getMarca());
        pstmt.setString(3, carro.getPlaca());
          pstmt.setString(4, carro.getCor());
        pstmt.setInt(5, carro.getAnoFabricacao());
          pstmt.setInt(6, carro.getAnoModelo());
        pstmt.setDouble(7, carro.getPeso());
          pstmt.setDouble(8, carro.getKilometragemAtual());
        pstmt.setInt(9, id);  

        int retorno = pstmt.executeUpdate();

        pstmt.close();
        con.close();

        return retorno == 1;
    }

    @Override
    public boolean remover(Carro carro) throws Exception {
        
        Connection con = fabricaConexoes.getConnection();

        String sql = "DELETE FROM carros WHERE id = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        
        int id = carro.getId();
         pstmt.setInt(1, id);

        int retorno  = pstmt.executeUpdate();

        pstmt.close();
        con.close(); 

        return retorno == 1;
    }

    @Override
    public ArrayList<Carro> listar() throws Exception {
       
        ArrayList<Carro> lista = new ArrayList<>();

        Connection con = fabricaConexoes.getConnection();

        String sql = "Select * FROM carros";
 
        PreparedStatement pstmt = con.prepareStatement(sql);

        ResultSet result = pstmt.executeQuery();

        while(result.next()){
          
          Carro carro = montarVrumVrum(result);
           lista.add(carro);
        }

        result.close();
        pstmt.close();
        con.close();

        return lista;

    }

    // VRUM VRUM
    private Carro montarVrumVrum(ResultSet result) throws Exception{

        //PRAISE THE SUN YAO
        int id = result.getInt("id");
         String modelo = result.getString("modelo");
        String marca = result.getString("marca");
         String placa = result.getString("placa");
        String cor = result.getString("cor");
         int anoFabricacao = result.getInt("ano_fabricação");
        int anoModelo = result.getInt("ano_modelo");
         Double peso = result.getDouble("peso");
        Double kilometragemAtual = result.getDouble("kilometragem_atual");
        
      Carro carro = new Carro(id, modelo, marca, placa, cor, anoFabricacao, anoModelo, peso, kilometragemAtual);

      return carro;
    }

}