package semana04.exercicios;

import javax.swing.JOptionPane;

public class Desconto {
    
    public static void main(String[] args) {
        
        String cliente;
        float valor_compra, desconto, valor_final;
        
        cliente = JOptionPane.showInputDialog("Digite o nome do cliente : ");
        valor_compra = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor da compra : "));
        
        if (valor_compra < 10)
            desconto = 0;
        else if (valor_compra < 100)
            desconto = valor_compra * 5 / 100;
        else if (valor_compra < 500)
            desconto = valor_compra * 10 / 100;
        else 
            desconto = valor_compra * 15 / 100;
        
        valor_final = valor_compra - desconto;
        
        System.out.println("Nome do cliente : " + cliente);
        System.out.println("Valor da compra : " + valor_compra);
        System.out.println("Valor do desconto : " + desconto);
        System.out.println("Valor a pagar : " + valor_final);
         
     }
   
}