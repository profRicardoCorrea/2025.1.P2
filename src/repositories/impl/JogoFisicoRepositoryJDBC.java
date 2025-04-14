package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConfig;
import entities.JogoFisico;
import repositories.IJogoFisicoRepository;

public class JogoFisicoRepositoryJDBC implements IJogoFisicoRepository {
    
    @Override
    public void salvar(JogoFisico jogo) {
        String sql = "INSERT INTO jogos_fisicos (id, nome, preco, midia) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, jogo.getId());
            stmt.setString(2, jogo.getNome());
            stmt.setDouble(3, jogo.getPreco());
            stmt.setString(4, jogo.getMidia());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar jogo físico", e);
        }
    }
    
    @Override
    public void remover(Long id) {
        String sql = "DELETE FROM jogos_fisicos WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover jogo físico", e);
        }
    }
    
    @Override
    public void alterar(JogoFisico jogo) {
        String sql = "UPDATE jogos_fisicos SET nome = ?, preco = ?, midia = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, jogo.getNome());
            stmt.setDouble(2, jogo.getPreco());
            stmt.setString(3, jogo.getMidia());
            stmt.setLong(4, jogo.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar jogo físico", e);
        }
    }
    
    @Override
    public List<JogoFisico> listar() {
        List<JogoFisico> jogos = new ArrayList<>();
        String sql = "SELECT * FROM jogos_fisicos";
        
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                JogoFisico jogo = new JogoFisico();
                jogo.setId(rs.getLong("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setPreco(rs.getDouble("preco"));
                jogo.setMidia(rs.getString("midia"));
                jogos.add(jogo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar jogos físicos", e);
        }
        
        return jogos;
    }
    
    @Override
    public JogoFisico buscarPorId(Long id) {
        String sql = "SELECT * FROM jogos_fisicos WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    JogoFisico jogo = new JogoFisico();
                    jogo.setId(rs.getLong("id"));
                    jogo.setNome(rs.getString("nome"));
                    jogo.setPreco(rs.getDouble("preco"));
                    jogo.setMidia(rs.getString("midia"));
                    return jogo;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar jogo físico por ID", e);
        }
        
        return null;
    }
    
    @Override
    public List<JogoFisico> buscarPorMidia(String midia) {
        List<JogoFisico> jogos = new ArrayList<>();
        String sql = "SELECT * FROM jogos_fisicos WHERE midia = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, midia);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    JogoFisico jogo = new JogoFisico();
                    jogo.setId(rs.getLong("id"));
                    jogo.setNome(rs.getString("nome"));
                    jogo.setPreco(rs.getDouble("preco"));
                    jogo.setMidia(rs.getString("midia"));
                    jogos.add(jogo);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar jogos por mídia", e);
        }
        
        return jogos;
    }
} 