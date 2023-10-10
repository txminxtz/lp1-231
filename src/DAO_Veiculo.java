package estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Veiculo extends DAO_Comum{

    public DAO_Veiculo(){
        super("tbl_veiculos");
    }


    //////////////////////////
    ////////// CREATE
    //////////////////////////
    public void create(Veiculo v){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql = "INSERT INTO tbl_veiculos VALUES (?, ?, ?, ?, ?);";
        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setString(1, v.getPlaca());
        stmt.setString(2, v.getMarca());
        stmt.setString(3, v.getModelo());
        stmt.setString(4, v.getCor());
        stmt.setInt(5, v.getProprietario());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "O veiculo " + 
            v.getPlaca() + 
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
    public Veiculo read(String sPlaca, Boolean bShow){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        Veiculo v;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca o aluno pela matrícula
        sSql = "SELECT * FROM tbl_veiculos WHERE placa = ?";
        stmt = con.prepareStatement(sSql);
        stmt.setString(1, sPlaca);

        rs = stmt.executeQuery();
        
        if(rs.next()){

            v = new Veiculo();

            v.setPlaca(rs.getString("placa"));
            v.setMarca(rs.getString("marca"));
            v.setModelo(rs.getString("modelo"));
            v.setCor(rs.getString("cor"));
            v.setProprietario(rs.getInt("proprietario"));

            if (bShow) v.exibeDados(0);

            return v;

        }
        else{
            if (bShow) System.out.println("Veiculo nao encontrado!");
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
    public void update(Veiculo v){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql =  "UPDATE tbl_veiculos " +
                "SET " +
                "marca = ?, " +
                "modelo = ?, " +
                "cor = ?, " +
                "proprietario = ? " +
                "WHERE placa = ?";

        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setString(1, v.getMarca());
        stmt.setString(2, v.getModelo());
        stmt.setString(3, v.getCor());
        stmt.setInt(4, v.getProprietario());
        stmt.setString(5, v.getPlaca());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "O veiculo " + 
            v.getPlaca() + 
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
    public void delete (Veiculo v){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Remove o veiculo
        sSql = "DELETE FROM tbl_veiculos WHERE placa = ?";

        stmt = con.prepareStatement(sSql);
        stmt.setString(1, v.getPlaca());

        stmt.execute();
        
        stmt.close();
        con.close();

        System.out.println(
            "O veiculo " + 
            v.getPlaca() + 
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
    public void exibeTodos(){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        int iCont;
        String sAux;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca os veiculos
        sSql = "select * from tbl_veiculos";
        stmt = con.prepareStatement(sSql);

        rs = stmt.executeQuery();

        iCont = 0;

        System.out.println(
            "Placa     " + " " + 
            "Marca     " + " " +
            "Modelo    " +" " +
            "Cor       " +" " +
            "Proprietario"
            );

            System.out.println(
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------"
            );
        

        while(rs.next()){

            for (int i=1;i<=5;i++){
                sAux = rs.getString(i);
                sAux = this.completaString(sAux, 10);
                System.out.print(sAux + " ");
            }

            System.out.println();

            iCont++;
        }           

        if (iCont==0){
            System.out.println("Veiculos nao encontrados!");
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