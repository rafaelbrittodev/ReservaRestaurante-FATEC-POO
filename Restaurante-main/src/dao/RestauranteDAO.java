/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectionBD.*;
import java.sql.Connection;
import java.sql.SQLException;
import model.Restaurante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beatriz
 */
public class RestauranteDAO {

    // Método para inserir um novo cadastro no banco de dados
    public boolean inserirCadastro(Restaurante restaurante) throws SQLException {
        ConnectionBD conexao = new ConnectionBD();
        Connection conn = conexao.conectar();

        if (conn != null) {
            try {
                // Inserir paciente
                String insertRestauranteQuery = "INSERT INTO Reservas (nome, telefone, email, restaurante, qtddpessoas, datareserva) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement insertRestauranteStatement = conn.prepareStatement(insertRestauranteQuery);
                insertRestauranteStatement.setString(1, restaurante.getNome());
                insertRestauranteStatement.setString(2, restaurante.getTelefone());
                insertRestauranteStatement.setString(3, restaurante.getEmail());
                insertRestauranteStatement.setString(4, restaurante.getRestaurante());
                insertRestauranteStatement.setString(5, restaurante.getQtddpessoas());
                insertRestauranteStatement.setString(6, restaurante.getData());

                int rowsAffected = insertRestauranteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Cadastro inserido com sucesso!");
                    return true;
                } else {
                    System.out.println("Falha ao inserir o cadastro.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Fecha a conexão
                conexao.desconectar(conn);
            }
        }
        return false;
    }
    
    public List<Restaurante> obterTodosCadastros() throws SQLException {

        List<Restaurante> listaRestaurante = new ArrayList<>();

        ConnectionBD conexao = new ConnectionBD();

        Connection conn = conexao.conectar();

        if (conn != null) {

            try {

                String query = "SELECT * FROM Reservas ";

                try (PreparedStatement statement = conn.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {

                        // Mapeia os resultados para criar objetos Cadastro, Paciente e Endereco
                        Restaurante restaurante = new Restaurante(
                                resultSet.getString("nome"),
                                resultSet.getString("telefone"),
                                resultSet.getString("email"),
                                resultSet.getString("restaurante"),
                                resultSet.getString("qtddpessoas"),
                                resultSet.getString("datareserva")                                                                      
                        );

                        listaRestaurante.add(restaurante);

                    }

                }

            } catch (SQLException e) {

                e.printStackTrace();

            } finally {

                // Fecha a conexão
                conexao.desconectar(conn);

            }

        }

        return listaRestaurante;

    }
}
