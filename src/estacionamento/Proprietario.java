package estacionamento;

import java.sql.*;

class Proprietario{

    private String cod;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;

    public static void main(String args[]){

        String sNome, sEmail, sCargo, sTelefone, sEndereco, sComando;
        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacionamento","root","bts4");

            Statement stmt=con.createStatement();


            System.out.println();
            System.out.println("INCLUSAO DE PROPRIETARIOS");
            System.out.println();

            sNome = "Lucas";
            sEndereco = "Rua Mauricio de Oliveira";
            sEmail = "lucas@gmail.com";
            sTelefone = "11999843581";
            
            sComando = "INSERT INTO tbl_proprietarios " +
                        "(cod, nome, endereco, email, telefone) " +
                        "VALUE ("+
                        "null, " +
                        "'" + sNome + "'" + ", " +
                        "'" + sEndereco + "'" + ", " +
                        "'" + sEmail + "'"+ ", " +
                        "'" + sTelefone + "'" +
                        ")";

            stmt.execute(sComando);


            System.out.println();
            System.out.println("RELATORIO DE PROPRIETARIOS");
            System.out.println();

            rs = stmt.executeQuery("select * from tbl_proprietarios");

            while(rs.next()){
                System.out.println(
                    rs.getInt(1)    +"  "+
                    rs.getString(2) +"  "+
                    rs.getString(3) +"  "+
                    rs.getString(4) +"  "+
                    rs.getString(5)
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