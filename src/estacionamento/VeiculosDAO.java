package estacionamento;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class VeiculosDAO{

    public Veiculos create(Veiculos veiculos) throws SQLException {
        String sql = """
            INSERT INTO alunos (placa, marca, modelo, cor)
            VALUES (?, ?, ?, ?);
        """;

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection
                    .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ) {

                statement.setString(1, veiculos.getPlaca());
                statement.setString(2, veiculos.getMarca());
                statement.setDouble(3, veiculos.getModelo());
                statement.setDouble(4, veiculos.getCor());
                statement.executeUpdate();

                ResultSet rs = statement.getGeneratedKeys();

                if(rs.next()) {
                    aluno.setId(rs.getInt(1));
                }

                rs.close();

                return aluno;
            
        } 
        
    }

        public Veiculos update(Veiculos veiculo) throws SQLException {
        String sql = """
            UPDATE veiculos 
            SET placa = ?, marca = ?, modelo = ?, cor = ?
            WHERE cod = ?;
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, veiculos.getPlaca());
            statement.setString(2, veiculos.getMarca());
            statement.setDouble(3, veiculos.getModelo());
            statement.setDouble(4, veiculos.getCor());
            statement.setInt(5, veiculos.getCod());
            
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                return veiculos;
            }
            
            return null;

        } catch (SQLException e) {
            return null;
        }
    }

        public void delete(Integer cod) {
        String sql = "DELETE FROM veiculos WHERE cod = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, cod);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void delete(Veiculos veiculo) {
        delete(veiculos.getCod());
    }

        public Veiculos findByCod(Integer cod) {
        String sql = "SELECT * FROM veiculos WHERE cod = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return resultSetToVeiculos(rs);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public List<Veiculos> findAll() {
        String sql = "SELECT * FROM veiculos;";
        List<Veiculos> veiculos = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                alunos.add(resultSetToVeiculos(rs));
            }

            return veiculos;
        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        
    }

    private Veiculos resultSetToVeiculos(ResultSet rs) throws SQLException {
        return new Veiculos(
            rs.getInt("cod"),
            rs.getString("placa"),
            rs.getString("marca"),
            rs.getDouble("modelo"),
            rs.getDouble("cor")
        );
    }
}
