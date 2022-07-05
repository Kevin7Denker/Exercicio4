package ifpr.pgua.eic.atividade3bim.modelos;

public class Carro {
    private int id;
    private String modelo;
    private String marca;
    private String cor;
    private String placa;
    private int anoFabricacao;
    private int anoModelo;
    private double peso;
    private double kilometragemAtual;
    
    public Carro(int id, String modelo, String marca, String placa,String cor, int anoFabricacao, int anoModelo, double peso,
            double kilometragemAtual) {
        this.setId(id);
        this.setModelo(modelo);
        this.setMarca(marca);
        this.setCor(cor);
        this.setAnoFabricacao(anoFabricacao);
        this.setAnoModelo(anoModelo);
        this.setPeso(peso);
        this.setKilometragemAtual(kilometragemAtual);
        this.setPlaca(placa);
    }



    public Carro(String modelo, String marca, String placa,String cor, int anoFabricacao, int anoModelo, double peso,
    double kilometragemAtual) {
        this(-1, modelo, marca, placa,cor, anoFabricacao, anoModelo, peso, kilometragemAtual);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getModelo() {
        return modelo;
    }



    public void setModelo(String modelo) {
        this.modelo = modelo;
    }



    public String getMarca() {
        return marca;
    }



    public void setMarca(String marca) {
        this.marca = marca;
    }



    public String getCor() {
        return cor;
    }



    public void setCor(String cor) {
        this.cor = cor;
    }



    public int getAnoFabricacao() {
        return anoFabricacao;
    }



    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }



    public int getAnoModelo() {
        return anoModelo;
    }



    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }



    public double getPeso() {
        return peso;
    }



    public void setPeso(double peso) {
        this.peso = peso;
    }





    

    public double getKilometragemAtual() {
        return kilometragemAtual;
    }

    public void setKilometragemAtual(double kilometragemAtual) {
        this.kilometragemAtual = kilometragemAtual;
    }


    

}
