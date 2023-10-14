package estacionamento;

class Registro{


    private int cod;
    private String placa;
    private String entrada;
    private String saida;
    private int tarifa;
    private Double valor;
    private String usuario;

    public Registro(){}

    public Registro (
        int cod, 
        String placa, 
        String entrada, 
        String saida, 
        int tarifa, 
        Double valor, 
        String usuario) 
    {

        this.cod = cod;
        this.placa = placa;
        this.entrada = entrada;
        this.saida = saida;
        this.tarifa = tarifa;
        this.valor = valor;
        this.usuario = usuario;

    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    public int getCod () {
        return this.cod;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getPlaca () {
        return this.placa;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
    public String getEntrada () {
        return this.entrada;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }
    public String getSaida () {
        return this.saida;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }
    public int getTarifa () {
        return this.tarifa;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Double getValor () {
        return this.valor;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getUsuario () {
        return this.usuario;
    }

    public void exibeDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Codigo: " + cod);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Placa: " + placa);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Entrada: " + entrada);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Saida: " + saida);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Tarifa: " + tarifa);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Valor: " + valor);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Usuario: " + usuario);
    }

}