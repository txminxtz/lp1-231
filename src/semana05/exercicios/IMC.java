package semana05.exercicios;

import javax.swing.JOptionPane;

public class IMC {
    
    public static void main(String[] args) {
        
        float 
            fMassa, 
            fAltura,
            fIMC,
            fDif;
    
        String  
            sMsg;

        fMassa = Float.parseFloat(JOptionPane.showInputDialog("Peso (Kg): "));
        fAltura = Float.parseFloat(JOptionPane.showInputDialog("Altura (m): "));

        fIMC = fMassa / fAltura / fAltura;

        if (fIMC < 18.5)        sMsg = "Baixo peso";
        else if (fIMC < 24.9)   sMsg = "Peso Normal";
        else if (fIMC < 29.9)   sMsg = "Excesso de Peso";
        else if (fIMC < 34.9)   sMsg = "Obesidade de Classe 1";
        else if (fIMC < 39.9)   sMsg = "Obesidade de Classe 2";
        else                    sMsg = "Obesidade de Classe 3";
        
        System.out.println("Massa (Kg): " + fMassa);
        System.out.println("Altura (m): " + fAltura);
        System.out.println("IMC: " + fIMC);
        System.out.println("Classificacao: " + sMsg);

        if (fIMC < 18.5){
            fDif = (float) ((18.5 - fIMC) * fAltura * fAltura);
            System.out.println("Você precisa GANHAR " + fDif + " Kg.");
        }
        else if (fIMC > 24.9){
            fDif = (float) ((fIMC-24.9) * fAltura * fAltura);
            System.out.println("Você precisa PERDER " + fDif + " Kg.");
        } 

    }
 
        
}