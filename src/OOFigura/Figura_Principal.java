package OOFigura;

public class Figura_Principal {

    public static void main(String[] args) {
        
        Triangulo triangulo = new Triangulo("Azul", 5, 12);
        Circulo circulo = new Circulo("Verde", 10);
        Retangulo retangulo = new Retangulo("Rosa", 3, 4);
        Quadrado quadrado = new Quadrado("Roxo", 4);

        System.out.println(triangulo);
        System.out.println(circulo);
        System.out.println(retangulo);
        System.out.println(quadrado);
        
    }
}
