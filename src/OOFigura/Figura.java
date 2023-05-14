package OOFigura;

public abstract class Figura {

    private String cor;

    public Figura(){    
        cor = "";
    }

    public Figura(String cor){
        this.cor = cor;
    }

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    @Override
    public String toString(){
        return "Figura []" +
        "cor = " + this.cor + "]";
    }


    public abstract double area();

}
