package semana06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTeste {
    
    @Test
    public void somaDoisNumerosPositivos() {
        // AAA
        
        // Arrance 
        double n1 = 10.0;
        double n2 = 2.0;

        // Act
        double soma = Calculadora.somar(n1, n2);

        // Assert
        assertEquals(12.0, soma);

    }

    @Test
    public void somaDoisNumerosNegativos() {
        double n1 = -10.0;
        double n2 = -2.0;

        double subtrair = Calculadora.subtrair(n1, n2);

        assertEquals(-12.0, subtrair);

    }

    @Test
    public void MultiplicarDoisNumerosPositivos() {
        double n1 = 10.0;
        double n2 = 2.0;

        double multiplicar = Calculadora.multiplicar(n1, n2);

        assertEquals(20.0, multiplicar);

    }

    @Test
    public void MultiplicarDoisNumerosNegativos() {
        double n1 = -10.0;
        double n2 = -2.0;

        double multiplicar = Calculadora.multiplicar(n1, n2);

        assertEquals(20.0, multiplicar);

    }

    @Test
    public void DividirDoisNumerosPositivos() {
        double n1 = 10.0;
        double n2 = 2.0;

        double dividir = Calculadora.dividir(n1, n2);

        assertEquals(5.0, dividir);

    }

    @Test
    public void DividirDoisNumerosNegativos() {
        double n1 = -10.0;
        double n2 = -2.0;

        double dividir = Calculadora.dividir(n1, n2);

        assertEquals(5.0, dividir);

    }

}
