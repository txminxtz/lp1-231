package estacionamento;

class Tarifa{

    private int cod;
    private double primeira;
    private double demais;
    private double diaria;
    private double mensalidade;


    public Tarifa(){}

    public Tarifa(
        int cod, 
        double primeira, 
        double demais, 
        double diaria, 
        double mensalidade) 
    {

        this.cod = cod;
        this.primeira = primeira;
        this.demais = demais;
        this.diaria = diaria;
        this.mensalidade = mensalidade;

    }

    public int getCod () {
        return this.cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }

    public Double getPrimeira () {
        return this.primeira;
    }
    public void setPrimeira(Double primeira) {
        this.primeira = primeira;
    }

    public Double getDemais () {
        return this.demais;
    }
    public void setDemais(Double demais) {
        this.demais = demais;
    }

    public Double getDiaria () {
        return this.diaria;
    }
    public void setDiaria(Double diaria) {
        this.diaria = diaria;
    }

    public Double getMensalidade () {
        return this.mensalidade;
    }
    public void setMensalidade(Double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public void exibeDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Codigo: " + cod);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Primeira: " + primeira);
 
        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Demais: " + demais);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Diaria: " + diaria);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Mensalidade: " + mensalidade);

    }



}