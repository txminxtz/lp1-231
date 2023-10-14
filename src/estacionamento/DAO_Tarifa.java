package estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Tarifa extends DAO_Comum{

    public DAO_Tarifa(){
        super("tbl_tarifas");
    }


    //////////////////////////
    ////////// CREATE
    //////////////////////////
    public void create(Tarifa v){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql = "INSERT INTO tbl_tarifas VALUES (?, ?, ?, ?, ?);";
        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setInt(1, v.getCod());
        stmt.setDouble(2, v.getPrimeira());
        stmt.setDouble(3, v.getDemais());
        stmt.setDouble(4, v.getDiaria());
        stmt.setDouble(5, v.getMensalidade());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "A Tarifa " + 
            //p.cod() + 
            " foi incluida com sucesso."
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
    public Tarifa read(int iCod, Boolean bShow){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        Tarifa v;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca o aluno pela matrícula
        sSql = "SELECT * FROM tbl_tarifas WHERE cod = ?";
        stmt = con.prepareStatement(sSql);
        stmt.setInt(1, iCod);

        rs = stmt.executeQuery();
        
        if(rs.next()){

            v = new Tarifa();

            v.setCod(rs.getInt("cod"));
            v.setPrimeira(rs.getDouble("primeira"));
            v.setDemais(rs.getDouble("demais"));
            v.setDiaria(rs.getDouble("diaria"));
            v.setMensalidade(rs.getDouble("mensalidade"));

            if (bShow) v.exibeDados(0);

            return v;

        }
        else{
            if (bShow) System.out.println("Tarifa nao encontrada!");
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
    public void update(Tarifa v){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql =  "UPDATE tbl_tarifas " +
                "SET " +
                "primeira = ?, " +
                "demais = ?, " +
                "diaria = ?, " +
                "mensalidade = ? " +
                "WHERE cod = ?";

        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setDouble(1, v.getPrimeira());
        stmt.setDouble(2, v.getDemais());
        stmt.setDouble(3, v.getDiaria());
        stmt.setDouble(4, v.getMensalidade());
        stmt.setDouble(5, v.getCod());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "A Tarifa " + 
            //p.getPlaca() + 
            " foi atualizada com sucesso."
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
    public void delete (Tarifa v){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Remove o Proprietario
        sSql = "DELETE FROM tbl_tarifas WHERE cod = ?";

        stmt = con.prepareStatement(sSql);
        stmt.setInt(1, v.getCod());

        stmt.execute();
        
        stmt.close();
        con.close();

        System.out.println(
            "A Tarifa " + 
            v.getCod() + 
            " foi excluida com sucesso."
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
    public void exibeTodos(){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        int iCont, iCod;
        String sAux;
        double dAux; 

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca os Proprietarios
        sSql = "select * from tbl_tarifas";
        stmt = con.prepareStatement(sSql);

        rs = stmt.executeQuery();

        iCont = 0;

        System.out.println(
            "Cod       " + " " + 
            "Primeira  " + " " + 
            "Demais    " + " " +
            "Diaria    " +" " +
            "Mensalidade"
            );

        System.out.println(
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------"
            );
        

        while(rs.next()){

            iCod = rs.getInt(1);
 
            sAux = Integer.toString(iCod);
            sAux = this.completaString(sAux, 10);
            System.out.print(sAux + " ");

            for (int i=2;i<=5;i++){
                dAux = rs.getDouble(i);
                sAux = String.valueOf(dAux);

                sAux = this.completaString(sAux, 10);
                System.out.print(sAux + " ");
            }
            
            System.out.println();

            iCont++;
        }           

        if (iCont==0){
            System.out.println("Tarifas nao encontradas!");
        }

        stmt.close();
        con.close();

    } 
    catch (SQLException e) {
        System.err.println("Falha na comunicacao com o BD!");
        e.printStackTrace();
    }
    }

}