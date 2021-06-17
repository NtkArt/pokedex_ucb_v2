package database.controllers;

import database.ConexaoDAO;
import database.models.UsuarioHasPokemon;
import database.views.Menu;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioHasPokemonController {
  public int salvarUsuarioPokemon(UsuarioHasPokemon usuarioHasPokemon, ConexaoDAO connection) throws SQLException {
    String queryString = "INSERT INTO usuario_has_pokemon(" +
            "pokemon_id, treinador_id) VALUES " +
            "('" + usuarioHasPokemon.getPokemonTreinadorId() + "'," +
            "'" + usuarioHasPokemon.getTreinadorPokemonId() + "')";
    try {
      return connection.executeQuery(queryString);
    } catch (SQLException e) {
      System.out.println(e.toString());
      return 0;
    }
  }

  public void listar(ConexaoDAO connection) throws SQLException {
    UsuarioHasPokemon up = new UsuarioHasPokemon();
    String queryString = "SELECT t.nome , t.regiao , p.nome , p.tipo , p.geracao FROM treinador t " +
            "INNER JOIN usuario_has_pokemon uhp" +
            "ON t.id = " + up.getTreinadorPokemonId() + " " +
            "INNER JOIN pokemon p" +
            "ON p.id = " + up.getPokemonTreinadorId() + "";

    Menu menu = new Menu();
    ResultSet rs = connection.search(queryString);
    try {
      while (rs.next()) {

//        int id = rs.getInt("id");
//        String nome = rs.getString("nome");
//        String regiao = rs.getString("regiao");
//        String regiao = rs.getString("tipo");
//        String regiao = rs.getString("regiao");
//        menu.menuUpController(id, nome, regiao);
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }


}
