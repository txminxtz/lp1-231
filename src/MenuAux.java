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
    public void relatorio(String sTipo) { 

        DAO_Usuario usuarioDAO = new DAO_Usuario();;
        DAO_Proprietario proprietarioDAO = new DAO_Proprietario();
        DAO_Veiculo veiculoDAO = new DAO_Veiculo();
        DAO_Valor valorDAO = new DAO_Valor();
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
                registroDAO.exibeTodos(); 
                break;
        }

    }
/*

    // RELATORIO DE USUARIOS
    public void relatorio_Usuarios() { 

        System.out.println();
        System.out.println("RELATORIO DE USUARIOS");
        System.out.println();

        //Cria o DAO para conexão com o banco de dados
        DAO_Usuario usuarioDAO = new DAO_Usuario();

        //Salva o veiculo no banco de dados;
        usuarioDAO.exibeTodos(); 

    }

    // RELATORIO DE PROPRIETARIOS
    public void relatorio_Proprietarios() { 

        System.out.println();
        System.out.println("RELATORIO DE PROPRIETARIOS");
        System.out.println();

        //Cria o DAO para conexão com o banco de dados
        DAO_Proprietario proprietarioDAO = new DAO_Proprietario();

        //Salva o veiculo no banco de dados;
        proprietarioDAO.exibeTodos(); 

    }

    // RELATORIO DE VEICULOS
    public void relatorio_Veiculos() { 

        System.out.println();
        System.out.println("RELATORIO DE VEICULOS");
        System.out.println();

        //Cria o DAO para conexão com o banco de dados
        DAO_Veiculo veiculoDAO = new DAO_Veiculo();

        //Salva o veiculo no banco de dados;
        veiculoDAO.exibeTodos(); 

    }

    // RELATORIO DE VALORES
    public void relatorio_Valores() { 

        System.out.println();
        System.out.println("RELATORIO DE VALORES");
        System.out.println();

        //Cria o DAO para conexão com o banco de dados
        DAO_Valor valorDAO = new DAO_Valor();

        //Salva o veiculo no banco de dados;
        valorDAO.exibeTodos(); 

    }
    */

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

            String sCod, sNome, sEndereco, sEmail, sTelefone, sAux, sOp;
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
            sEndereco = textInput("Endereco: ");
            sEmail = textInput("Email: ");
            sTelefone = textInput("Telefone: ");

            sAux = textInput("Confirma " + sOp + " (S/N) ? ");

            if  (sAux.equalsIgnoreCase("s")==false){
                return;
            }

            if (sOp == "Inclusao"){

                //Cria o objeto proprietario
                proprietario= new Proprietario(iCod, sNome, sEndereco, sEmail, sTelefone);
                
                //Salva o proprietario no banco de dados;
                proprietarioDAO.create(proprietario); 

            }
            else {

                proprietario.setCod(iCod);
                proprietario.setNome(sNome);
                proprietario.setEndereco(sEndereco);
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
    public void dadosInput_Valor() throws SQLException { 

        try
        {

            String sAux, sOp, sPrimeira, sDemais, sDiaria, sMensalidade; 
            double dPrimeira, dDemais, dDiaria, dMensalidade;
            
            int iCod;

            System.out.println("Cadastro de Valores");
            System.out.println();

            Valor valor;
            DAO_Valor valorDAO;

            //Cria o DAO para conexão com o banco de dados
            valorDAO = new DAO_Valor();

            iCod = 1;

            System.out.println("Prox: "+iCod);

            System.out.println();

            //Cria o DAO para conexão com o banco de dados
            valorDAO = new DAO_Valor();

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
                valor = new Valor(iCod, dPrimeira, dDemais, dDiaria, dMensalidade);
                
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
    public void dadosInput_Estacionamento() throws SQLException { 
    try
    {

        String sPlaca="", sEntrada, sSaida, sAux, sOp, sCod, sData;
        int iCod;
        double dValor;
        DateFormat dateFormat;
        Calendar cal;

        System.out.println("Registro de Estacionamento");
        System.out.println();

        Valor valor;
        DAO_Valor valorDAO;

        Registro registro;
        DAO_Registro registroDAO;


        //Cria o DAO para conexão com o banco de dados
        valorDAO = new DAO_Valor();
        valor = valorDAO.read(1, true);
        
        if (valor == null){
            this.textInput("Registro de valores nao encontrado. Tecle enter <enter>.");
            return;
        }

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

            sAux = textInput(
                "Estacionamento registrado! "+
                "Edita (1), "+
                "Exclui (2) ou "+
                "Passa (3) ? "
                );

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
            
            sOp = "Edicao";

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

        sAux = textInput("Confirma " + sOp + " (S/N) ? ");

        if  (sAux.equalsIgnoreCase("s")==false){
            return;
        }

        if (sOp == "Inclusao"){


            sEntrada = sData;
            sSaida = sData;
            dValor = 0;

            //Cria o objeto registro
            registro = new Registro(iCod, sPlaca, sEntrada, sSaida, dValor);
            
            //Salva o registro no banco de dados;
            registroDAO.create(registro); 

        }
        else {

            sEntrada = registro.getEntrada();
            sSaida = sData;
            dValor = 10.0;

            dValor = valor.getPrimeira();
            dValor = dValor + (hoursBetween(sEntrada, sSaida) - 1) * valor.getDemais();

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

// 2023-10-07 20:50:20

        int iHora_Entrada, iMin_Entrada, iSeg_Entrada, iTotal_Entrada, 
            iHora_Saida, iMin_Saida, iSeg_Saida, iTotal_Saida;

        double dTotal;
        String sAux;

        //System.out.println("Entrada: "+sEntrada);

        sAux = sEntrada.substring(11, 13);
        //System.out.println(sAux);
        iHora_Entrada = Integer.parseInt(sAux);

        sAux = sEntrada.substring(14, 16);
        //System.out.println(sAux);
        iMin_Entrada = Integer.parseInt(sAux);

        sAux = sEntrada.substring(17, 19);
        //System.out.println(sAux);
        iSeg_Entrada = Integer.parseInt(sAux);

        iTotal_Entrada = 
            iSeg_Entrada +
            iMin_Entrada * 60 +
            iHora_Entrada * 3600;

        //System.out.println("Total: "+iTotal_Entrada);
        //System.out.println();

        System.out.println("Saida: "+sSaida);

        sAux = sSaida.substring(11, 13);
        //System.out.println(sAux);
        iHora_Saida = Integer.parseInt(sAux);

        sAux = sSaida.substring(14, 16);
        //System.out.println(sAux);
        iMin_Saida = Integer.parseInt(sAux);

        sAux = sSaida.substring(17, 19);
        //System.out.println(sAux);
        iSeg_Saida = Integer.parseInt(sAux);

        iTotal_Saida = 
            iSeg_Saida +
            iMin_Saida * 60 +
            iHora_Saida * 3600;

        //System.out.println("Total: "+iTotal_Saida);
        //System.out.println();


        dTotal = (iTotal_Saida - iTotal_Entrada) / 3600.0;

        //System.out.println("dTotal: "+dTotal);


        dTotal = Math.ceil(dTotal);
        //System.out.println("dTotal Arredondado: "+dTotal);

        //System.out.println("(int)dTotal: "+(int)dTotal);

        //System.out.println();


        return (int)dTotal;

    }



}

