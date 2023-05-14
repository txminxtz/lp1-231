package OOFigura;

public class Circulo extends Figura {
    
    private double raio;

    public Circulo(String cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    public Circulo() {
        super();
        raio = 0;
    }

    public double getRaio(){
        return raio;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    @Override
    public double area(){
        return (3.14 * raio * raio);
    }

    @Override
    public String toString(){
        return "Circulo [" +
        "raio = " + raio + ", " +
        "area = " + this.area() + ", " +
        "cor = " + super.getCor() + "]";
    }

}
