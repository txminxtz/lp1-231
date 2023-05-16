package semana06.exercicios;

public class Aquario_Teste {
    
 
    public static void main(String[] args) {
        
        float 
            fComprimento, 
            fLargura, 
            fAltura,
            fVolume,
            fPotencia,
            fTemp_Ambiente,
            fTemp_Desejada,
            fFiltragem_Min,
            fFiltragem_Max;
        
        fComprimento = 20;
        fLargura = 30;
        fAltura = 10;
        fTemp_Ambiente = 20;
        fTemp_Desejada = 25;

        fVolume = Aquario_Metodos.f_Func_CalculaVolume (
                fComprimento, 
                fLargura, 
                fAltura 
            );

        fPotencia = Aquario_Metodos.f_Func_CalculaVolume (
            fVolume, 
            fTemp_Desejada, 
            fTemp_Ambiente 
        );

        fFiltragem_Min = Aquario_Metodos.f_Func_CalculaFiltragem (
            fVolume, 
            2
        );

        fFiltragem_Max = Aquario_Metodos.f_Func_CalculaFiltragem (
            fVolume, 
            3
        );

        System.out.println("Comprimento (cm): " + fComprimento);
        System.out.println("Largura (cm): " + fLargura);
        System.out.println("Altura (cm): " + fAltura);
        System.out.println("Temperatura Ambiente (oC): " + fTemp_Ambiente);
        System.out.println("Temperatura Desejada (oC): " + fTemp_Desejada);
        System.out.println("Volume (l): " + fVolume);
        System.out.println("Potencia (W): " + fPotencia);
        System.out.println("Filtragem Mínima (l/h): " + fFiltragem_Min);
        System.out.println("Filtragem Máxima (l/h): " + fFiltragem_Max);
         
     }
  
}