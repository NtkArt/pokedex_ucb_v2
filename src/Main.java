import database.controllers.Conexao;
import database.controllers.PokemonController;

import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
    Conexao connection = new Conexao();
    PokemonController pkController = new PokemonController();
    System.out.println("Efetuando conexao com o banco de dados");
    try {
      connection.connect();
      System.out.println("Conexao estabelecida.");
      
      try {
        System.out.println("Checando tabelas....");
        connection.checkTable();
      } catch (Exception e) {
        e.getStackTrace();
      }

    } catch (Exception e) {
      e.getStackTrace();
    }

  }
}
