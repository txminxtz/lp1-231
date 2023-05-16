package semana05.exercicios;

import javax.swing.JOptionPane;

public class Aquario {
    
    public static void main(String[] args) {
        
        float 
            fComprimento, 
            fLargura, 
            fAltura,
            fVolume,
            fPotencia,
            fTemp_Ambiente,
            fTemp_Desejada;
        
        fComprimento = Float.parseFloat(JOptionPane.showInputDialog("Comprimento (cm): "));
        fLargura = Float.parseFloat(JOptionPane.showInputDialog("Largura (cm): "));
        fAltura = Float.parseFloat(JOptionPane.showInputDialog("Altura (cm): "));
        fTemp_Ambiente = Float.parseFloat(JOptionPane.showInputDialog("Temperatura Ambiente (oC): "));
        fTemp_Desejada = Float.parseFloat(JOptionPane.showInputDialog("Temperatura Desejada (oC): "));
        
        fVolume = fComprimento * fLargura * fAltura / 1000;
        fPotencia = fVolume * 5/100 * (fTemp_Desejada-fTemp_Ambiente);
        
        System.out.println("Comprimento (cm): " + fComprimento);
        System.out.println("Largura (cm): " + fLargura);
        System.out.println("Altura (cm): " + fAltura);
        System.out.println("Temperatura Ambiente (oC): " + fTemp_Ambiente);
        System.out.println("Temperatura Desejada (oC): " + fTemp_Desejada);
        System.out.println("Volume (l): " + fVolume);
        System.out.println("Potencia (W): " + fPotencia);
        System.out.println("Filtragem Mínima (l/h): " + fVolume*2);
        System.out.println("Filtragem Máxima (l/h): " + fVolume*3);
         
     }
   
}