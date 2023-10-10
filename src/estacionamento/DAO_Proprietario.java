package estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Proprietario extends DAO_Comum{

    public DAO_Proprietario(){
        super("tbl_proprietarios");
    }


    //////////////////////////
    ////////// CREATE
    //////////////////////////
    public void create(Proprietario p){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql = "INSERT INTO tbl_proprietarios VALUES (?, ?, ?, ?);";
        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEndereco());
        stmt.setString(3, p.getEmail());
        stmt.setString(4, p.getTelefone());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "O Proprietario " + 
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
    public Proprietario read(int iCod, Boolean bShow){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        Proprietario p;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca o aluno pela matrícula
        sSql = "SELECT * FROM tbl_proprietarios WHERE cod = ?";
        stmt = con.prepareStatement(sSql);
        stmt.setInt(1, iCod);

        rs = stmt.executeQuery();
        
        if(rs.next()){

            p = new Proprietario();

            p.setCod(rs.getInt("cod"));
            p.setNome(rs.getString("nome"));
            p.setEndereco(rs.getString("endereco"));
            p.setEmail(rs.getString("email"));
            p.setTelefone(rs.getString("telefone"));

            if (bShow) p.exibeDados(0);

            return p;

        }
        else{
            if (bShow) System.out.println("Proprietario nao encontrado!");
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
    public void update(Proprietario p){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql =  "UPDATE tbl_proprietarios " +
                "SET " +
                "nome = ?, " +
                "endereco = ?, " +
                "email = ?, " +
                "telefone = ? " +
                "WHERE cod = ?";

        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEndereco());
        stmt.setString(3, p.getEmail());
        stmt.setString(4, p.getTelefone());
        stmt.setDouble(5, p.getCod());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "O proprietario " + 
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
    public void delete (Proprietario p){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Remove o Proprietario
        sSql = "DELETE FROM tbl_proprietarios WHERE placa = ?";

        stmt = con.prepareStatement(sSql);
        stmt.setInt(1, p.getCod());

        stmt.execute();
        
        stmt.close();
        con.close();

        System.out.println(
            "O proprietario " + 
            p.getCod() + 
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

        int iCont, iCod;
        String sAux;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca os Proprietarios
        sSql = "select * from tbl_proprietarios";
        stmt = con.prepareStatement(sSql);

        rs = stmt.executeQuery();

        iCont = 0;

        System.out.println(
            "Cod       " + " " + 
            "Nome      " + " " + 
            "Endereco  " + " " +
            "Email     " +" " +
            "Telefone  "
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
                sAux = rs.getString(i);
                sAux = this.completaString(sAux, 10);
                System.out.print(sAux + " ");
            }
            
            System.out.println();

            iCont++;
        }           

        if (iCont==0){
            System.out.println("Proprietarios nao encontrados!");
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