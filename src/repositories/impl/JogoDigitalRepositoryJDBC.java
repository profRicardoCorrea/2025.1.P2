package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConfig;
import entities.JogoDigital;
import repositories.IJogoDigitalRepository;

public class JogoDigitalRepositoryJDBC implements IJogoDigitalRepository {
    
    @Override
    public void salvar(JogoDigital jogo) {
        String sql = "INSERT INTO jogos_digitais (nome, preco, plataforma,desenvolvedora,tamanho_gb) VALUES ( ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            
            stmt.setString(1, jogo.getNome());
            stmt.setDouble(2, jogo.getPreco());
            stmt.setString(3, jogo.getPlataforma());
            stmt.setString(4, jogo.getDesenvolvedora());
            stmt.setDouble(5, jogo.getTamanhoGB());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar jogo digital", e);
        }
    }
    
    @Override
    public void remover(Long id) {
        String sql = "DELETE FROM jogos_digitais WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover jogo digital", e);
        }
    }
    
    @Override
    public void alterar(JogoDigital jogo) {
        String sql = "UPDATE jogos_digitais SET nome = ?, preco = ?, plataforma = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, jogo.getNome());
            stmt.setDouble(2, jogo.getPreco());
            stmt.setString(3, jogo.getPlataforma());
            stmt.setLong(4, jogo.getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar jogo digital", e);
        }
    }
    
    @Override
    public List<JogoDigital> listar() {
        List<JogoDigital> jogos = new ArrayList<>();
        String sql = "SELECT * FROM jogos_digitais";
        
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                JogoDigital jogo = new JogoDigital();
                jogo.setId(rs.getLong("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setPreco(rs.getDouble("preco"));
                jogo.setPlataforma(rs.getString("plataforma"));
                jogos.add(jogo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar jogos digitais", e);
        }
        
        return jogos;
    }
    
    @Override
    public JogoDigital buscarPorId(Long id) {
        String sql = "SELECT * FROM jogos_digitais WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    JogoDigital jogo = new JogoDigital();
                    jogo.setId(rs.getLong("id"));
                    jogo.setNome(rs.getString("nome"));
                    jogo.setPreco(rs.getDouble("preco"));
                    jogo.setPlataforma(rs.getString("plataforma"));
                    return jogo;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar jogo digital por ID", e);
        }
        
        return null;
    }
    
    @Override
    public List<JogoDigital> buscarPorPlataforma(String plataforma) {
        List<JogoDigital> jogos = new ArrayList<>();
        String sql = "SELECT * FROM jogos_digitais WHERE plataforma = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, plataforma);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    JogoDigital jogo = new JogoDigital();
                    jogo.setId(rs.getLong("id"));
                    jogo.setNome(rs.getString("nome"));
                    jogo.setPreco(rs.getDouble("preco"));
                    jogo.setPlataforma(rs.getString("plataforma"));
                    jogos.add(jogo);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar jogos por plataforma", e);
        }
        
        return jogos;
    }
} 