package estacionamento;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class MenuAux 
{

    private Scanner l;

    public MenuAux(){
        l = new Scanner(System.in);
    }


    ////////////
    /////// RELATORIOS

    // RELATORIO
    public void relatorio_Geral(String sTipo) { 

        DAO_Usuario usuarioDAO = new DAO_Usuario();;
        DAO_Proprietario proprietarioDAO = new DAO_Proprietario();
        DAO_Veiculo veiculoDAO = new DAO_Veiculo();
        DAO_Tarifa valorDAO = new DAO_Tarifa();
        DAO_Registro registroDAO = new DAO_Registro();

        // Verifica se tipo valido

        switch(sTipo) {
        case "USUARIOS":
                break;
        case "PROPRIETARIOS":
                break;
        case "VEICULOS":
                break;
        case "VALORES":
                break;
        case "REGISTROS":
                break;
        default:
                System.out.println("Opcao Invalida: " + sTipo);
                return;
        }

        System.out.println();
        System.out.println("RELATORIO DE " + sTipo);
        System.out.println();

        //Exibe os registros cadastrados

        switch(sTipo) {
        case "USUARIOS":
                usuarioDAO.exibeTodos(); 
                break;
        case "PROPRIETARIOS":
                proprietarioDAO.exibeTodos(); 
                break;
        case "VEICULOS":
                veiculoDAO.exibeTodos(); 
                break;
        case "VALORES":
                valorDAO.exibeTodos(); 
                break;
        case "REGISTROS":
                registroDAO.exibeTodos(0,"","", ""); 
                break;
        }

    }

    // RELATORIO DE VEICULO POR PERIODO
    public void relatorio_Financeiro(int iTipo) throws SQLException { 
        try
        {
    
            String sPlaca, sAux, sData, sData_i, sData_f;
            Double dTotal;
            DateFormat dateFormat;
            Calendar cal;
            
            DAO_Registro registroDAO = new DAO_Registro();
    
            switch(iTipo) {
            case 1:
                System.out.println("Relatorio Geral");
                break;
            case 2:
                System.out.println("Relatorio de Veiculo por Periodo");
                break;
            case 3:
                System.out.println("Relatorio de Veiculos Estacionados");
                break;
            default:
                System.out.println("Tipo Invalido! " + iTipo);
                return;
            }
        
            System.out.println();
    
            // Recupera a hora do sistema
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cal = Calendar.getInstance();
            
            sData = dateFormat.format(cal.getTime());
            System.out.println(sData);
    
            System.out.println();

            // Solicita os dados de restrição
 
            switch(iTipo) {
            case 1:
                sPlaca = "";
                sData_i = textInput("Data Inicial (AAAA-MM-DD): ");
                sData_f = textInput("Data Final (AAAA-MM-DD): ");
                /* 
                sData_i = "2023-09-01";
                sData_f = "2023-09-30";;
                System.out.println("Placa: " + sPlaca);
                System.out.println("Data Inicial: " + sData_i);
                System.out.println("Data Final: " + sData_f);
                */
                break;
            case 2:
                sPlaca = textInput("Placa: ");
                sData_i = textInput("Data Inicial (AAAA-MM-DD): ");
                sData_f = textInput("Data Final (AAAA-MM-DD): ");
                /*
                sPlaca = "GBQ9512";
                sData_i = "2023-09-01";
                sData_f = "2023-09-30";;
                System.out.println("Placa: " + sPlaca);
                System.out.println("Data Inicial: " + sData_i);
                System.out.println("Data Final: " + sData_f);
                */
                break;
            case 3:
                sPlaca = "";
                sData_i = "";
                sData_f = "";                
                break;
            default:
                System.out.println("Tipo Invalido! " + iTipo);
                return;
            }        
    
            System.out.println();
    
            sAux = textInput("Confirma ? (S/N) ? ");
    
            if  (sAux.equalsIgnoreCase("s")==false){
                return;
            }
    
            sData_i = sData_i + " 00:00:00 ";
            sData_f = sData_f + " 23:59:59 ";

            dTotal = registroDAO.exibeTodos(iTipo, sPlaca, sData_i, sData_f); 
    
            System.out.println();
            System.out.println("Total: R$ " + dTotal);

            return;
    
        }
        catch(Exception e)
        { 
            System.out.println(e);
            return;
        }
        }
    

    ////////////
    /////// ENTRADA DE DADOS

    // CADASTRO DE USUARIO
    public void dadosInput_Usuario() throws SQLException { 

        try
        {

            String sLogin, sNome, sCargo, sEmail, sTelefone, sSenha, sAux, sOp;

            System.out.println("Cadastro de Usuario");
            System.out.println();

            Usuario usuario;
            DAO_Usuario usuarioDAO;

            //Cria o DAO para conexão com o banco de dados
            usuarioDAO = new DAO_Usuario();

            sLogin = textInput("Login: ");

            System.out.println();

            usuario = usuarioDAO.read(sLogin, true);

            if (usuario == null){
                sOp = "Inclusao";
            }
            else {

                sAux = textInput(
                    "Usuario ja Cadastrado! "+
                    "Altera (1), "+
                    "Exclui (2) ou "+
                    "Passa (3) ? "
                    );

                if  (sAux.equals("3")) return;

                if  (sAux.equals("2")) {

                    sAux = textInput("Confirma Exclusao (S/N) ? ");

                    if  (sAux.equalsIgnoreCase("s")){
                        usuarioDAO.delete(usuario);
                        return;
                    }

                    return;

                }

            if  (sAux.equals("1")==false) return;
                sOp = "Alteracao";
            }      

            sNome = textInput("Nome: ");
            sCargo = textInput("Cargo: ");
            sEmail = textInput("Email: ");
            sTelefone = textInput("Telefone: ");
            sSenha = textInput("Senha: ");

            sAux = textInput("Confirma " + sOp + " (S/N) ? ");

            if  (sAux.equalsIgnoreCase("s")==false){
                return;
            }

            if (sOp == "Inclusao"){

                //Cria o objeto usuario
                usuario = new Usuario(sLogin, sNome, sCargo, sEmail, sTelefone, sSenha);
                
                //Salva o usuario no banco de dados;
                usuarioDAO.create(usuario); 

            }
            else {

                usuario.setLogin(sLogin);
                usuario.setNome(sNome);
                usuario.setCargo(sCargo);
                usuario.setEmail(sEmail);
                usuario.setTelefone(sTelefone);
                usuario.setSenha(sSenha);

                //Salva o usuario no banco de dados;
                usuarioDAO.update(usuario); 

            }

            return;

        }
        catch(Exception e)
        { 
            System.out.println(e);
            return;
        }

    }


    // CADASTRO DE PROPRIETARIO
    public void dadosInput_Proprietario() throws SQLException { 

        try
        {

            String sCod, sNome, sEmail, sTelefone, sAux, sOp;
            int iCod;

            System.out.println("Cadastro de Proprietario");
            System.out.println();

            Proprietario proprietario;
            DAO_Proprietario proprietarioDAO;


            //Cria o DAO para conexão com o banco de dados
            proprietarioDAO = new DAO_Proprietario();

            iCod = proprietarioDAO.prox("cod");

            System.out.println("Prox: "+iCod);


            sCod = textInput("Cod: ");
            iCod = Integer.parseInt(sCod);

            System.out.println();


            //Cria o DAO para conexão com o banco de dados
            proprietarioDAO = new DAO_Proprietario();

            proprietario = proprietarioDAO.read(iCod, true);

            if (proprietario == null){
                sOp = "Inclusao";
            }
            else {

                sAux = textInput(
                    "Proprietario ja Cadastrado! "+
                    "Altera (1), "+
                    "Exclui (2) ou "+
                    "Passa (3) ? "
                    );

                if  (sAux.equals("3")) return;

                if  (sAux.equals("2")) {

                    sAux = textInput("Confirma Exclusao (S/N) ? ");

                    if  (sAux.equalsIgnoreCase("s")){
                        proprietarioDAO.delete(proprietario);
                        return;
                    }

                    return;

                }

            if  (sAux.equals("1")==false) return;
                sOp = "Alteracao";
            }      

            sNome = textInput("Nome: ");
            sEmail = textInput("Email: ");
            sTelefone = textInput("Telefone: ");

            sAux = textInput("Confirma " + sOp + " (S/N) ? ");

            if  (sAux.equalsIgnoreCase("s")==false){
                return;
            }

            if (sOp == "Inclusao"){

                //Cria o objeto proprietario
                proprietario= new Proprietario(iCod, sNome, sEmail, sTelefone);
                
                //Salva o proprietario no banco de dados;
                proprietarioDAO.create(proprietario); 

            }
            else {

                proprietario.setCod(iCod);
                proprietario.setNome(sNome);
                proprietario.setEmail(sEmail);
                proprietario.setTelefone(sTelefone);

                //Salva o proprietario no banco de dados;
                proprietarioDAO.update(proprietario); 

            }

            return;

        }
        catch(Exception e)
        { 
            System.out.println(e);
            return;
        }

    }


    // CADASTRO DE VEICULO
    public void dadosInput_Veiculo() throws SQLException { 

        String sPlaca, sMarca, sModelo, sCor, sAux, sProprietario, sOp;
        int iProprietario;

        System.out.println("Cadastro de Veiculo");
        System.out.println();

        Veiculo veiculo;
        DAO_Veiculo veiculoDAO;

        sPlaca = textInput("Placa: ");

        System.out.println();

        try
        {

            //Cria o DAO para conexão com o banco de dados
            veiculoDAO = new DAO_Veiculo();

            veiculo = veiculoDAO.read(sPlaca, true);

            if (veiculo == null){
                sOp = "Inclusao";
            }
            else {

                sAux = textInput(
                    "Veiculo ja Cadastrado! "+
                    "Altera (1), "+
                    "Exclui (2) ou "+
                    "Passa (3) ? "
                    );

                if  (sAux.equals("3")) return;

                if  (sAux.equals("2")) {

                    sAux = textInput("Confirma Exclusao (S/N) ? ");

                    if  (sAux.equalsIgnoreCase("s")){
                        veiculoDAO.delete(veiculo);
                        return;
                    }

                    return;

                }

            if  (sAux.equals("1")==false) return;
                sOp = "Alteracao";
            }      

            sMarca = textInput("Marca: ");
            sModelo = textInput("Modelo: ");
            sCor = textInput("Cor: ");
            sProprietario = textInput("Proprietario: ");

            iProprietario = Integer.parseInt(sProprietario);

            sAux = textInput("Confirma " + sOp + " (S/N) ? ");

            if  (sAux.equalsIgnoreCase("s")==false){
                return;
            }

            if (sOp == "Inclusao"){

                //Cria o objeto veiculo
                veiculo = new Veiculo(sPlaca, sMarca, sModelo, sCor, iProprietario);
                
                //Salva o veiculo no banco de dados;
                veiculoDAO.create(veiculo); 

            }
            else {

                veiculo.setMarca(sMarca);
                veiculo.setModelo(sModelo);
                veiculo.setCor(sCor);
                veiculo.setProprietario(iProprietario);

                //Salva o veiculo no banco de dados;
                veiculoDAO.update(veiculo); 

            }

            return;

        }
        catch(Exception e)
        { 
            System.out.println(e);
            return;
        }

    }


    // CADASTRO DE VALORES
    public void dadosInput_Tarifa() throws SQLException { 

        try
        {

            String sAux, sOp, sPrimeira, sDemais, sDiaria, sMensalidade; 
            double dPrimeira, dDemais, dDiaria, dMensalidade;
            
            int iCod;

            System.out.println("Cadastro de Valores");
            System.out.println();

            Tarifa valor;
            DAO_Tarifa valorDAO;

            //Cria o DAO para conexão com o banco de dados
            valorDAO = new DAO_Tarifa();

            iCod = 1;

            System.out.println("Prox: "+iCod);

            System.out.println();

            //Cria o DAO para conexão com o banco de dados
            valorDAO = new DAO_Tarifa();

            valor = valorDAO.read(iCod, true);

            if (valor == null){
                sOp = "Inclusao";
            }
            else {

                sAux = textInput(
                    "Registro ja Cadastrado! "+
                    "Altera (1), "+
                    "Exclui (2) ou "+
                    "Passa (3) ? "
                    );

                if  (sAux.equals("3")) return;

                if  (sAux.equals("2")) {

                    sAux = textInput("Confirma Exclusao (S/N) ? ");

                    if  (sAux.equalsIgnoreCase("s")){
                        valorDAO.delete(valor);
                        return;
                    }

                    return;

                }

            if  (sAux.equals("1")==false) return;
                sOp = "Alteracao";
            }      

            sPrimeira = textInput("Primeira: ");
            sDemais = textInput("Demais: ");
            sDiaria = textInput("Diaria: ");
            sMensalidade = textInput("Mensalidade: ");

            dPrimeira = Double.valueOf(sPrimeira);
            dDemais = Double.valueOf(sDemais);
            dDiaria = Double.valueOf(sDiaria);
            dMensalidade = Double.valueOf(sMensalidade);

            sAux = textInput("Confirma " + sOp + " (S/N) ? ");

            if  (sAux.equalsIgnoreCase("s")==false){
                return;
            }

            if (sOp == "Inclusao"){

                //Cria o objeto valor
                valor = new Tarifa(iCod, dPrimeira, dDemais, dDiaria, dMensalidade);
                
                //Salva o registro no banco de dados;
                valorDAO.create(valor); 

            }
            else {

                valor.setCod(iCod);
                valor.setPrimeira(dPrimeira);
                valor.setDemais(dDemais);
                valor.setDiaria(dDiaria);
                valor.setMensalidade(dMensalidade);

                //Salva o proprietario no banco de dados;
                valorDAO.update(valor); 

            }

            return;

        }
        catch(Exception e)
        { 
            System.out.println(e);
            return;
        }

    }

    // REGISTRO DE ESTACIONAMENTO
    public void dadosInput_Estacionamento(
        Usuario usuario, 
        Tarifa tarifa
        ) throws SQLException { 
    try
    {

        String sPlaca="", sEntrada="", sSaida="", sAux, sOp, sCod, sData;
        int iCod;
        double dValor;
        DateFormat dateFormat;
        Calendar cal;

        System.out.println("Registro de Estacionamento");
        System.out.println();

        Registro registro;
        DAO_Registro registroDAO;
        
        //Cria o DAO para conexão com o banco de dados
        registroDAO = new DAO_Registro();

        iCod = registroDAO.prox("cod");

        System.out.println("Prox: "+iCod);

        sCod = textInput("Cod: ");
        iCod = Integer.parseInt(sCod);

        System.out.println();

        //Cria o DAO para conexão com o banco de dados
        registroDAO = new DAO_Registro();

        registro = registroDAO.read(iCod, true);

        if (registro == null){
            sOp = "Inclusao";
        }
        else {

            sSaida = registro.getSaida();
            sEntrada = registro.getEntrada();

            if (sSaida.compareTo(sEntrada)>0){

                sAux = textInput(
                "Cancela Saida (1), "+
                "Exclui (2) ou "+
                "Passa (3) ? "
                );

            }
            else{

                sAux = textInput(
                "Registra Saida (1), "+
                "Exclui (2) ou "+
                "Passa (3) ? "
                );

            }

            if  (sAux.equals("3")) return;

            if  (sAux.equals("2")) {

                sAux = textInput("Confirma Exclusao (S/N) ? ");

                if  (sAux.equalsIgnoreCase("s")){
                    registroDAO.delete(registro);
                    return;
                }

                return;

            }

            if  (sAux.equals("1")==false) return;
            
            if (sSaida.compareTo(sEntrada)>0){
                sOp = "Cancelamento de Saida";
            }
            else {
                sOp = "Registro de Saida";
            }
        }      
        
        if (sOp == "Inclusao") {
            sPlaca = textInput("Placa: ");
        }
        else {
            // Exibe dados da entrada, S/N
        }

        // Recupera a hora do sistema
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cal = Calendar.getInstance();
        
        sData = dateFormat.format(cal.getTime());
        System.out.println(sData);

        //  Calcula Valor


        if (sOp == "Inclusao"){

            sEntrada = sData;
            sSaida = sData;
            dValor = 0;

        }
        else { 

            if (sSaida.compareTo(sEntrada)>0){
                
                sSaida = sEntrada;
                dValor = 0.0;

            }
            else {

                sEntrada = registro.getEntrada();
                sSaida = sData;

                dValor = calculaValor(tarifa, sEntrada, sSaida);

                System.out.println();
                System.out.println("Valor: R$ " + dValor );
                
            }


        }

        System.out.println();
        sAux = textInput("Confirma " + sOp + " (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return;
        }

        if (sOp == "Inclusao"){

            //Cria o objeto registro
            registro = new Registro(iCod, sPlaca, sEntrada, sSaida, tarifa.getCod(), dValor, usuario.getLogin());
            
            //Salva o registro no banco de dados;
            registroDAO.create(registro); 

        }
        else { 

            registro.setSaida(sSaida);
            registro.setValor(dValor);

            //Salva o registro no banco de dados;
            registroDAO.update(registro); 

        }

        return;

    }
    catch(Exception e)
    { 
        System.out.println(e);
        return;
    }
    }

    ////////////
    /////// FUNÇÕES AUXILIARES


    public Tarifa pesquisa_Tarifa() throws SQLException { 

        try
        {

            Tarifa tarifa;
            DAO_Tarifa tarifaDAO;
            int iCod;
            
            String sAux="S", sCod;

            //Cria o DAO para conexão com o banco de dados
            tarifaDAO = new DAO_Tarifa();

            while (sAux.equalsIgnoreCase("s")) {

                System.out.println();
                sCod = textInput("Codigo da Tarifa: ");
                iCod = Integer.parseInt(sCod);


                tarifa = tarifaDAO.read(iCod, false);

                if (tarifa != null) return tarifa;  

                sAux = this.textInput("Tarifa não Encontrada. Deseja Tentar Novamente (S/N) ? ");

            }

            return null;

        }
        catch(Exception e)
        { 
            System.out.println(e);
            return null;
        }        

    }

    public Usuario pesquisa_Usuario() throws SQLException { 

        try
        {

            Usuario usuario;
            DAO_Usuario usuarioDAO;
            
            String sAux="S", sSenha, sLogin;

            //Cria o DAO para conexão com o banco de dados
            usuarioDAO = new DAO_Usuario();

            while (sAux.equalsIgnoreCase("s")) {

                System.out.println();
                sLogin = textInput("Login: ");
                sSenha = textInput("Senha: ");

                usuario = usuarioDAO.read(sLogin, false);

                if (usuario != null) {
                    if (sSenha.equals(usuario.getSenha())) return usuario;  
                }

                sAux = this.textInput("Acesso Negado. Deseja Tentar Novamente (S/N) ? ");

            }

            return null;

        }
        catch(Exception e)
        { 
            System.out.println(e);
            return null;
        }        

    }


    public String textInput(String label) {
        System.out.print(label);
        return l.nextLine();
    }

    public double doubleInput(String label) {
        System.out.print(label);
        return l.nextDouble();
    }

    public int hoursBetween(
        String sEntrada,
        String sSaida
        )
    {

        int iHora_Entrada, iMin_Entrada, iSeg_Entrada, iTotal_Entrada, 
            iHora_Saida, iMin_Saida, iSeg_Saida, iTotal_Saida;

        double dTotal;
        String sAux;

        sAux = sEntrada.substring(11, 13);
        iHora_Entrada = Integer.parseInt(sAux);

        sAux = sEntrada.substring(14, 16);
        iMin_Entrada = Integer.parseInt(sAux);

        sAux = sEntrada.substring(17, 19);
        iSeg_Entrada = Integer.parseInt(sAux);

        iTotal_Entrada = 
            iSeg_Entrada +
            iMin_Entrada * 60 +
            iHora_Entrada * 3600;

        System.out.println("Saida: "+sSaida);

        sAux = sSaida.substring(11, 13);
        iHora_Saida = Integer.parseInt(sAux);

        sAux = sSaida.substring(14, 16);
        iMin_Saida = Integer.parseInt(sAux);

        sAux = sSaida.substring(17, 19);
        iSeg_Saida = Integer.parseInt(sAux);

        iTotal_Saida = 
            iSeg_Saida +
            iMin_Saida * 60 +
            iHora_Saida * 3600;

        dTotal = (iTotal_Saida - iTotal_Entrada) / 3600.0;

        dTotal = Math.ceil(dTotal);

        return (int)dTotal;

    }


    public double calculaValor(
        Tarifa tarifa,
        String sEntrada,
        String sSaida
        )
    {



        int iAno_Entrada, iMes_Entrada, iHora_Entrada, iDia_Entrada, 
            iMin_Entrada, iSeg_Entrada, iTotal_Entrada, 
            iAno_Saida, iMes_Saida, iDia_Saida,
            iHora_Saida, iMin_Saida, iSeg_Saida, iTotal_Saida;

        double dTotal, dValor;
        String sAux;

        /*
        2023-10-06 09:36:00
        00000000001111111111
        01234567890123456789
        */

        // Entrada

        sAux = sEntrada.substring(0, 4);
        iAno_Entrada = Integer.parseInt(sAux);

        sAux = sEntrada.substring(5, 7);
        iMes_Entrada = Integer.parseInt(sAux);

        sAux = sEntrada.substring(8, 10);
        iDia_Entrada = Integer.parseInt(sAux);

        sAux = sEntrada.substring(11, 13);
        iHora_Entrada = Integer.parseInt(sAux);

        sAux = sEntrada.substring(14, 16);
        iMin_Entrada = Integer.parseInt(sAux);

        sAux = sEntrada.substring(17, 19);
        iSeg_Entrada = Integer.parseInt(sAux);

        // Saida

        sAux = sSaida.substring(0, 04);
        iAno_Saida = Integer.parseInt(sAux);

        sAux = sSaida.substring(5, 7);
        iMes_Saida = Integer.parseInt(sAux);

        sAux = sSaida.substring(8, 10);
        iDia_Saida = Integer.parseInt(sAux);

        sAux = sSaida.substring(11, 13);
        iHora_Saida = Integer.parseInt(sAux);

        sAux = sSaida.substring(14, 16);
        iMin_Saida = Integer.parseInt(sAux);

        sAux = sSaida.substring(17, 19);
        iSeg_Saida = Integer.parseInt(sAux);

        // Calcula o número de meses

        iTotal_Entrada = 
            iDia_Entrada +
            iMes_Entrada * 30 +
            iAno_Entrada * 365;

        iTotal_Saida = 
            iDia_Saida +
            iMes_Saida * 30 +
            iAno_Saida * 365;

        dTotal = (iTotal_Saida - iTotal_Entrada) / 30.0;
        
        dTotal = Math.ceil(dTotal); // Número de Meses

        if ((int)dTotal > 1)	// Se for mais que 1 mês 
        {

                dValor = dTotal * tarifa.getMensalidade();
                return dValor;

        }

        // Calcula o número de dias

        iTotal_Entrada = 
            iHora_Entrada +
            iDia_Entrada * 24 +
            iMes_Entrada * 30 * 24+
            iAno_Entrada * 365 * 24;

        iTotal_Saida = 
            iHora_Saida +
            iDia_Saida * 24 +
            iMes_Saida * 30 * 24 +
            iAno_Saida * 365 * 24;

        dTotal = (iTotal_Saida - iTotal_Entrada) / 24.0;
        
        dTotal = Math.ceil(dTotal); // Número de Dias

        if ((int)dTotal > 1)	// Se for mais que 1 Dia 
        {

                dValor = dTotal * tarifa.getDiaria();
                if (dValor > tarifa.getMensalidade()) dValor = tarifa.getMensalidade();

                return dValor;

        }


        // Calcula o número de Horas

        iTotal_Entrada = 
            iSeg_Entrada +
            iMin_Entrada * 60 +
            iHora_Entrada * 3600;

        iTotal_Saida = 
            iSeg_Saida +
            iMin_Saida * 60 +
            iHora_Saida * 3600;

        dTotal = (iTotal_Saida - iTotal_Entrada) / 3600.0;

        dTotal = Math.ceil(dTotal);

                dValor = tarifa.getPrimeira();
                dValor = dValor + (dTotal - 1) * tarifa.getDemais();

                if (dValor > tarifa.getDiaria()) dValor = tarifa.getDiaria();

                return dValor;

    }



}

