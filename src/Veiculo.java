package estacionamento;

public class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int proprietario;

    public Veiculo (){}

    public Veiculo (
        String placa, 
        String marca, 
        String modelo, 
        String cor,
        int proprietario) 
    {

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.proprietario = proprietario;

    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getPlaca () {
        return this.placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getMarca () {
        return this.marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getModelo () {
        return this.modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getCor () {
        return this.cor;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }
    public int getProprietario () {
        return this.proprietario;
    }

    public void exibeDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Placa: " + placa);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Marca: " + marca);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Modelo: " + modelo);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Cor: " + cor);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Proprietario: " + proprietario);

    }

}