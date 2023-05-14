package semana06.exercicios;

public class Aquario_Metodos {

    public static float f_Func_CalculaVolume (
        float fComprimento, 
        float fLargura, 
        float fAltura 
        ) {

        float 
            fVolume;

        fVolume = fComprimento * fLargura * fAltura / 1000;

        return fVolume;

    }

    public static float f_Func_CalculaPotencia (
        float fVolume, 
        float fTemp_Desejada, 
        float fTemp_Ambiente 
        ) {

        float 
            fPotencia;

        fPotencia = fVolume * 5/100 * (fTemp_Desejada-fTemp_Ambiente);

        return fPotencia;

    }

    public static float f_Func_CalculaFiltragem (
        float fVolume, 
        float fMultiplicador 
        ) {

        float 
            fFiltragem;

            fFiltragem = fVolume * fMultiplicador;

        return fFiltragem;

    }

   
}