package estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Registro extends DAO_Comum{

    public DAO_Registro(){
        super("tbl_registros");
    }


    //////////////////////////
    ////////// CREATE
    //////////////////////////
    public void create(Registro r){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql = "INSERT INTO tbl_registros VALUES (?, ?, ?, ?, ?, ?, ?);";
        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setInt(1, r.getCod());
        stmt.setString(2, r.getPlaca());
        stmt.setString(3, r.getEntrada());
        stmt.setString(4, r.getSaida());
        stmt.setInt(5, r.getTarifa());
        stmt.setDouble(6, r.getValor());
        stmt.setString(7, r.getUsuario());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "O Registro " + 
            //p.cod() + 
            " foi incluido com sucesso."
            );

    } 
    catch (SQLException e) {
        System.err.println("Falha na comunicacao com o BD!");
        e.printStackTrace();
    }
    }

    //////////////////////////
    ////////// READ
    //////////////////////////
    public Registro read(int iCod, boolean bShow){
    try {

        String sSql, sEntrada, sSaida;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        Registro r;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca o registro pelo codigo
        sSql = "SELECT * FROM tbl_registros WHERE cod = ?";
        stmt = con.prepareStatement(sSql);
        stmt.setInt(1, iCod);

        rs = stmt.executeQuery();
        
        if(rs.next()){

            sEntrada = rs.getString("entrada");
            sSaida = rs.getString("saida");
            
            if (sSaida.compareTo(sEntrada) == 0) sSaida = "";

            r = new Registro();

            r.setCod(rs.getInt("cod"));
            r.setPlaca(rs.getString("placa"));
            r.setEntrada(sEntrada);
            r.setSaida(sSaida);
            r.setTarifa(rs.getInt("tarifa"));
            r.setValor(rs.getDouble("valor"));
            r.setUsuario(rs.getString("usuario"));

            if (bShow) r.exibeDados(0);

            return r;

        }
        else{
            if (bShow) System.out.println("Registro nao encontrado!");
        }

        stmt.close();
        con.close();

        return null;

    } 
    catch (SQLException e) {
        System.err.println("Falha na comunicacao com o BD!");
        e.printStackTrace();
        return null;
    }
    }

    //////////////////////////
    ////////// UPDATE
    //////////////////////////
    public void update(Registro r){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql =  "UPDATE tbl_registros " +
                "SET " +
                "placa = ?, " +
                "entrada = ?, " +
                "saida = ?, " +
                "tarifa = ?, " +
                "valor = ?, " +
                "usuario = ? " +
                "WHERE cod = ?";

        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setString(1, r.getPlaca());
        stmt.setString(2, r.getEntrada());
        stmt.setString(3, r.getSaida());
        stmt.setInt(4, r.getTarifa());
        stmt.setDouble(5, r.getValor());
        stmt.setString(6, r.getUsuario());
        stmt.setInt(7, r.getCod());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "O registro " + 
            //p.getPlaca() + 
            " foi atualizado com sucesso."
            );

    } 
    catch (SQLException e) {
        System.err.println("Falha na comunicacao com o BD!");
        e.printStackTrace();
    }
    }
    
    //////////////////////////
    ////////// DELETE
    //////////////////////////
    public void delete (Registro r){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Remove o Proprietario
        sSql = "DELETE FROM tbl_registros WHERE cod = ?";

        stmt = con.prepareStatement(sSql);
        stmt.setInt(1, r.getCod());

        stmt.execute();
        
        stmt.close();
        con.close();

        System.out.println(
            "O registro " + 
            r.getCod() + 
            " foi excluido com sucesso."
            );

    } 
    catch (SQLException e) {
        System.err.println("Falha na comunicacao com o BD!");
        e.printStackTrace();
    }
    }
        
    //////////////////////////
    ////////// EXIBE
    //////////////////////////
    public Double exibeTodos(int iTipo, String sPlaca, String sData_i, String sData_f){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt=null;
        ResultSet rs;

        int iCont, iCod;
        String sAux;
        double dAux, dTotal=0;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca os Registros

        switch(iTipo) {
        case 0:
            sSql = "select * from tbl_registros";
            stmt = con.prepareStatement(sSql);
            break;
        case 1:
            sSql = 
                "SELECT * FROM tbl_registros "+
                "WHERE saida BETWEEN ? AND ? "+
                "AND saida > entrada AND valor > 0";
            stmt = con.prepareStatement(sSql);
            stmt.setString(1, sData_i);
            stmt.setString(2, sData_f);
            break;
        case 2:
            sSql = 
                "SELECT * FROM tbl_registros "+
                "WHERE placa = ? "+
                "AND saida BETWEEN ? AND ? "+
                "AND saida > entrada AND valor > 0";
            stmt = con.prepareStatement(sSql);
            stmt.setString(1, sPlaca);
            stmt.setString(2, sData_i);
            stmt.setString(3, sData_f);
            break;
        case 3:
            sSql = 
                "SELECT * FROM tbl_registros "+
                "WHERE saida = entrada";
            stmt = con.prepareStatement(sSql);
            break;
        default:
            System.out.println("Tipo Invalido! " + iTipo);
            return 0.0;
        }


        rs = stmt.executeQuery();

        iCont = 0;

        System.out.println(
            "Cod" + " " + 
            "Placa  " + " " + 
            "Entrada            " + " " +
            "Saida              " +" " +
            "Tar" +" " +
            "Valor" +" " +
            "Usuario      "
            );

        System.out.println(
            "---" + " " +
            "-------" + " " +
            "-------------------" + " " +
            "-------------------" + " " +
            "---" + " " +
            "-----" + " " +
            "-------------"
            );
        

        while(rs.next()){

            // Cod
            iCod = rs.getInt(1);
            sAux = Integer.toString(iCod);
            sAux = this.completaString(sAux, 3);
            System.out.print(sAux + " ");

            // Placa
            sAux = rs.getString(2);
            sAux = this.completaString(sAux, 7);
            System.out.print(sAux + " ");

            // Entrada
            sAux = rs.getString(3);
            sAux = this.completaString(sAux, 19);
            System.out.print(sAux + " ");

            // Saida
            sAux = rs.getString(4);
            sAux = this.completaString(sAux, 19);
            System.out.print(sAux + " ");

            // Tarifa
            sAux = rs.getString(5);
            sAux = this.completaString(sAux, 3);
            System.out.print(sAux + " ");
            
            // Valor
            dAux = rs.getDouble(6);
            sAux = Double.toString(dAux);
            sAux = this.completaString(sAux, 5);
            System.out.print(sAux + " ");

            dTotal += dAux;

            // Usuario
            sAux = rs.getString(7);
            sAux = this.completaString(sAux, 13);
            System.out.print(sAux + " ");

            System.out.println();

            iCont++;
        }           

        if (iCont==0){
            System.out.println("Registros nao encontrados!");
        }

        stmt.close();
        con.close();

        return dTotal;

    } 
    catch (SQLException e) {
        System.err.println("Falha na comunicacao com o BD!");
        e.printStackTrace();
        return 0.0;
    }
    }

}