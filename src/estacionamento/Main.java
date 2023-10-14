package estacionamento;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main 
{
    
    public static void main(String[] args) throws SQLException
    {
    try
    {

        int iCod, iNivel = 0;

        ////////////
        /////// USUARIO

        Usuario usuario=null;
        DAO_Usuario usuarioDAO;

        String sLogin;

        //Cria o DAO para conexão com o banco de dados
        usuarioDAO = new DAO_Usuario();

        sLogin = "root";

        usuario = usuarioDAO.read(sLogin, true);

        if (usuario == null){

            usuario = new Usuario(
                sLogin, 
                "Administrador", 
                "Administrador do Sistema", 
                "bruno.taminato.silva@gmail.com",
                "11955563518", 
                "root"
                );

            //Salva o usuario no banco de dados;
            usuarioDAO.create(usuario); 

        }

        ////////////
        /////// TARIFA

        Tarifa tarifa=null;
        DAO_Tarifa tarifaDAO;

        //Cria o DAO para conexão com o banco de dados
        tarifaDAO = new DAO_Tarifa();

        tarifa = tarifaDAO.read(1, true);

        if (tarifa == null){

            tarifa = new Tarifa(
                1, 
                12.00, 
                6.00, 
                30.00, 
                150.00
                );

            //Salva a tarifa no banco de dados;
            tarifaDAO.create(tarifa); 

        }


        if (iNivel >= 1) {

        ////////////
        /////// REGISTRO

        Registro registro;
        DAO_Registro registroDAO;

        String sData, sPlaca, sCod, sEntrada, sSaida;
        double dValor;
        DateFormat dateFormat;
        Calendar cal;

        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");
        cal = Calendar.getInstance();
        
        sData = dateFormat.format(cal.getTime());
        System.out.println(sData);

        sCod = sData.substring(sData.length() - 3);
        System.out.println(sCod);

        sPlaca = "XYZ0"+sCod;
        System.out.println(sPlaca);

        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cal = Calendar.getInstance();
        
        sData = dateFormat.format(cal.getTime());
        System.out.println(sData);

        //Cria o DAO para conexão com o banco de dados
        registroDAO = new DAO_Registro();

        iCod = registroDAO.prox("cod");

        sPlaca = "XYZ0"+sCod;
        sEntrada = sData;
        sSaida = sData;  
        dValor = 0.0;

        registro = new Registro(iCod, sPlaca, sEntrada, sSaida, tarifa.getCod(), dValor, usuario.getLogin());
            
        //Salva o registro no banco de dados;
        registroDAO.create(registro); 

        //Pesquisa o registro no banco de dados;
        //registroDAO.read(iCod, true); 

        if (iNivel >= 2) {

        ////////////
        /////// VEICULOS

        Veiculo veiculo;
        DAO_Veiculo veiculoDAO;

        String sMarca, sModelo, sCor;
        int iProprietario;


        sMarca = "Renault"; 
        sModelo = "kwid"; 
        sCor = "Branco"; 
        iProprietario = 1;

        veiculo = new Veiculo(sPlaca, sMarca, sModelo, sCor, iProprietario);

        //Cria o DAO para conexão com o banco de dados
        veiculoDAO = new DAO_Veiculo();

        //Salva o veiculo no banco de dados;
        veiculoDAO.create(veiculo); 

        //Pesquisa o veiculo no banco de dados;
        veiculoDAO.read(sPlaca, true); 

        if (iNivel >= 3) {

        ////////////
        /////// PROPRIETARIOS

        Proprietario proprietario;
        DAO_Proprietario proprietarioDAO;

        //Cria o DAO para conexão com o banco de dados
        proprietarioDAO = new DAO_Proprietario();

        iCod = proprietarioDAO.prox("cod");

        proprietario = new Proprietario(
            iCod, 
            "Bernardo", 
            "bernardo@gmail.com",
            "11983248795"
            );

         //Salva o usuario no banco de dados;
        proprietarioDAO.create(proprietario); 

        }}} //if nivel

        ////////////
        /////// MENU
        
        //new Menu(sUrl, sUser, sPassword);
        new Menu(usuario, tarifa);

    }
    catch(Exception e)
    { 
        System.out.println(e);
    }
    }    

}

