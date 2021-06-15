import database.ConexaoDAO;
import database.controllers.PokemonController;
import database.views.Menu;

import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
    ConexaoDAO connection = new ConexaoDAO();
    PokemonController pkController = new PokemonController();
    try {
      System.out.println("Efetuando conexao com o banco de dados");
      connection.connect();
      System.out.println("Conexao estabelecida.");

      try {
        System.out.println("Checando tabelas....");
        if (connection.checkTable()) {
          Menu menu = new Menu();
          menu.inicializar(connection);
        }
      } catch (Exception e) {
        System.out.println("Erro ao checar as tabelas");
        System.out.println(e.toString());
      }

    } catch (Exception e) {
      System.out.println("Nao foi possivel efetuar a conexao");
      System.out.println(e.toString());
    }


  }
}
