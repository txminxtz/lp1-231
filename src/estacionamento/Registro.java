package estacionamento;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Registro{

    private int cod;
    private String placa;
    private String entrada;
    private String saida;
    private Double valor;

    public Registro(){}

    public Registro (
        int cod, 
        String placa, 
        String entrada, 
        String saida, 
        Double valor) 
    {

        this.cod = cod;
        this.placa = placa;
        this.entrada = entrada;
        this.saida = saida;
        this.valor = valor;

    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    public int getCod () {
        return this.cod;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getPlaca () {
        return this.placa;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
    public String getEntrada () {
        return this.entrada;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }
    public String getSaida () {
        return this.saida;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Double getValor () {
        return this.valor;
    }

    public void exibeDados(int iTab){ 

        int i;

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Codigo: " + cod);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Placa: " + placa);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Entrada: " + entrada);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Saida: " + saida);

        for (i=1; i<=iTab; i++) System.out.print("\t");
        System.out.println("Valor: " + valor);
    }

    public static void main(String args[]){

        String sData, sUsuario, sPlaca, sEntrada, sSaida, sValor, sComando;
        ResultSet rs;

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacionamento","root","bts4");

            Statement stmt=con.createStatement();

            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:ms");
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
            DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            

            System.out.println();
            System.out.println("INCLUSAO DE REGISTROS");
            System.out.println();

            sData = dateFormat1.format(cal.getTime());
            System.out.println(sData);

            sEntrada = dateFormat2.format(cal.getTime());
            System.out.println(sEntrada);

            sUsuario = "1";
            sPlaca = "JUI9823";
            sSaida = "null, ";

            sValor = "0.0";
            
            sComando = "INSERT INTO tbl_registros " +
                        "(cod, data, usuario, placa, entrada, saida, valor) " +
                        "VALUE ("+
                        "null, " +
                        "'" + sData + "'" + ", " +
                        "'" + sUsuario + "'"+ ", " +
                        "'" + sPlaca + "'" + ", " +
                        "'" + sEntrada + "'" + ", " +
                        "'" + sSaida + "'" + ", " +
                        "'" + sValor + "'" + 
                        ")";

            stmt.execute(sComando);


            System.out.println();
            System.out.println("RELATORIO DE REGISTROS");
            System.out.println();

            rs = stmt.executeQuery("select * from tbl_registros");

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