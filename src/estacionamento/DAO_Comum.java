package estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Comum{

    private String tabela;

    public DAO_Comum(String sTabela){
        this.tabela = sTabela;
    }

    //////////////////////////
    ////////// MAX
    //////////////////////////
    public int prox(String sCampo) throws SQLException {
    try {

        int iAux;

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca o aluno pela matrícula
        sSql = "SELECT MAX(" + sCampo + ") FROM " + this.tabela + ";" ;
        stmt = con.prepareStatement(sSql);

        rs = stmt.executeQuery();
        
        if(rs.next()){

            iAux = rs.getInt("MAX(" + sCampo + ")") + 1;

        }
        else{
            iAux = 1;
        }

        stmt.close();
        con.close();

        return iAux;

    } 
    catch (SQLException e) {
        System.err.println("Falha na comunicacao com o BD!");
        e.printStackTrace();
        return 0;
    }
    }


    public String completaString(String sAux, int iTam){

        for (int i=sAux.length(); i<iTam; i++){
            sAux += " ";
        }
        return sAux.substring(0, iTam); 
    }

}