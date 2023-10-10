package estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Usuario extends DAO_Comum{

    public DAO_Usuario(){
        super("tbl_uruarios");
    }

    //////////////////////////
    ////////// CREATE
    //////////////////////////
    public void create(Usuario u){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql = "INSERT INTO tbl_Usuarios VALUES (?, ?, ?, ?, ?, ?);";
        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getNome());
        stmt.setString(3, u.getCargo());
        stmt.setString(4, u.getEmail());
        stmt.setString(5, u.getTelefone());
        stmt.setString(6, u.getSenha());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "O usuario " + 
            //v.cod() + 
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
    public Usuario read(String sLogin, Boolean bShow){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        Usuario u;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Busca o aluno pela matrícula
        sSql = "SELECT * FROM tbl_Usuarios WHERE login = ?";
        stmt = con.prepareStatement(sSql);
        stmt.setString(1, sLogin);

        rs = stmt.executeQuery();
        
        if(rs.next()){

            u = new Usuario();

            u.setLogin(rs.getString("login"));
            u.setNome(rs.getString("nome"));
            u.setCargo(rs.getString("cargo"));
            u.setEmail(rs.getString("email"));
            u.setTelefone(rs.getString("telefone"));
            u.setSenha(rs.getString("senha"));

            if (bShow ) u.exibeDados(0);

            return u;

        }
        else{
            if (bShow ) System.out.println("Usuario nao encontrado!");
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
    public void update(Usuario u){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // cria um preparedStatement baseado em uma string SQL
        sSql =  "UPDATE tbl_Usuarios " +
                "SET " +
                "nome = ?, " +
                "cargo = ?, " +
                "email = ?, " +
                "telefone = ? " +
                "senha = ? " +
                "WHERE login = ?";

        stmt = con.prepareStatement(sSql);

        // preenche os valores para (?,?, ..., ?)
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCargo());
        stmt.setString(3, u.getEmail());
        stmt.setString(4, u.getTelefone());
        stmt.setString(5, u.getSenha());
        stmt.setString(6, u.getLogin());

        // executa o comando SQL
        stmt.executeUpdate();

        stmt.close();
        con.close();

        System.out.println(
            "O Usuario " + 
            u.getLogin() + 
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
    public void delete (Usuario u){
    try {

        String sSql;

        ConnectionFactory fabricaCon;
        Connection con;
        PreparedStatement stmt;

        // Utiliza a fábrica de conexões para criar uma Connection Sql
        fabricaCon = new ConnectionFactory();
        con = fabricaCon.createConnection();

        // Remove o Usuario
        sSql = "DELETE FROM tbl_Usuarios WHERE login = ?";

        stmt = con.prepareStatement(sSql);
        stmt.setString(1, u.getLogin());

        stmt.execute();
        
        stmt.close();
        con.close();

        System.out.println(
            "O Usuario " + 
            u.getLogin() + 
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

        // Busca os Usuarios
        sSql = "select * from tbl_Usuarios";
        stmt = con.prepareStatement(sSql);

        rs = stmt.executeQuery();

        System.out.println(
            "Login     " + " " + 
            "Nome      " + " " + 
            "Cargo     " + " " +
            "Email     " + " " +
            "Telefone  " + " " +
            "Senha     "
            );

            System.out.println(
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------" + " " +
            "----------"
            );
        
        iCont = 0;

        while(rs.next()){

            for (int i=1;i<=6;i++){
                sAux = rs.getString(i);
                sAux = this.completaString(sAux, 10);
                System.out.print(sAux + " ");
            }

            System.out.println();

            iCont++;
        }           

        if (iCont==0){
            System.out.println("Usuarios nao encontrados!");
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