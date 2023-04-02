package semana06.exercicios;

public class ex01_metodos {
    
    public static float fCalculo_Volume(Float fComprimento, float fLargura, float fAltura) {
        float fVolume = (fComprimento * fAltura * fLargura)/1000;
        return fVolume;
    }

    public static float fCalculo_Potencia(Float fVolume, float fTemp_Desejada, float fTemp_Ambiente) {
        float fPotencia = fVolume * 5/100 * (fTemp_Desejada - fTemp_Ambiente);
        return fPotencia;
    }

    public static float fCalculo_Filtragem(Float fVolume, float fMultiplicador) {
        float fFiltragem = fVolume * fMultiplicador;
        return fFiltragem;
    }

}