package estacionamento;

import java.sql.*;

class Usuario{

    private String cod;
    private String nome;
    private String cargo;
    private String email;
    private String telefone;
    private String senha;

    public static void main(String args[]){

        String sNome, sEmail, sCargo, sTelefone, sSenha, sComando;
        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacionamento","root","bts4");

            Statement stmt=con.createStatement();


            System.out.println();
            System.out.println("INCLUSAO DE USUARIOS");
            System.out.println();

            sNome = "Lucas";
            sCargo = "Contador";
            sEmail = "lucas@gmail.com";
            sTelefone = "11999843581";
            sSenha = "lucas213";
            
            sComando = "INSERT INTO tbl_usuarios " +
                        "(cod, nome, cargo, email, telefone, senha) " +
                        "VALUE ("+
                        "null, " +
                        "'" + sNome + "'" + ", " +
                        "'" + sCargo + "'" + ", " +
                        "'" + sEmail + "'"+ ", " +
                        "'" + sTelefone + "'"+ ", " +
                        "'" + sSenha + "'" +
                        ")";

            stmt.execute(sComando);


            System.out.println();
            System.out.println("RELATORIO DE USUARIOS");
            System.out.println();

            rs = stmt.executeQuery("select * from tbl_usuarios");

            while(rs.next()){
                System.out.println(
                    rs.getInt(1)    +"  "+
                    rs.getString(2) +"  "+
                    rs.getString(3) +"  "+
                    rs.getString(4) +"  "+
                    rs.getString(5) +"  "+
                    rs.getString(6)
                    );
            }           

            System.out.println();

            con.close();

        }
        catch(Exception e)
        { 
            System.out.println(e);
        }

    }

}