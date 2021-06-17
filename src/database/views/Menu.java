package database.views;

import java.sql.SQLException;
import java.util.Scanner;

import database.ConexaoDAO;
import database.controllers.PokemonController;
import database.controllers.TreinadorController;
import database.controllers.UsuarioHasPokemonController;
import database.models.Treinador;
import database.utils.ClearBuffer;

public class Menu {
  public void inicializar(ConexaoDAO connection) throws SQLException {
    Scanner scan = new Scanner(System.in);
    PokemonController pkController = new PokemonController();
    TreinadorController trController = new TreinadorController();

    int opcao = -1;
    while (opcao != 0) {
      System.out.println("------Menu-------");
      System.out.println("1- Pokemons");
      System.out.println("2- Treinador");
      System.out.println("0- Encerrar Programa");
      opcao = scan.nextInt();
      new ClearBuffer(scan);
      switch (opcao) {
        case 1:
          while (opcao != 0) {
            System.out.println("----------Pokemons------------");
            System.out.println("1- Catalogar Pokemon");
            System.out.println("2- Listar Pokedex");
            System.out.println("3- Alterar Pokemon cadastrado");
            System.out.println("4- Excluir Pokemon");
            System.out.println("0- Retornar ao menu anterior");
            opcao = scan.nextInt();
            switch (opcao) {
              case 1:
                pkController.criar(connection);
                break;
              case 2:
                pkController.listar(connection);
                break;
              case 3:
                System.out.println("Alterar pokemon");
                System.out.println("Digite o ID do pokemon que deseja alterar");
                int id = scan.nextInt();
                pkController.alterar(id, connection);
                new ClearBuffer(scan);
                break;
              case 4:
                System.out.println("Excluir pokemon");
                System.out.println("Digite o ID do pokemon que deseja excluir");
                int id_pokemon = scan.nextInt();
                pkController.excluir(id_pokemon, connection);
                new ClearBuffer(scan);
                break;
              case 0:
                break;
              default:
                System.out.println("Opcao invalida");
                break;
            }

          }
          opcao = -1;
          break;
        case 2:
          while (opcao != 0) {
            System.out.println("--------Treinador----------");
            System.out.println("1- Cadastrar Treinador");
            System.out.println("2- Atualizar Treinador");
            System.out.println("3- Listar Treinador");
            System.out.println("4- Remover Treinador");
            System.out.println("0- Retornar ao menu anterior");
            opcao = scan.nextInt();
            new ClearBuffer(scan);
            switch (opcao) {
              case 1:
                trController.criar(connection);
                break;
              case 2:
                System.out.println("Alterar treinador");
                System.out.println("Digite o ID do treinador que deseja alterar");
                int id_treinador;
                id_treinador = scan.nextInt();
                trController.alterar(id_treinador, connection);
                new ClearBuffer(scan);
                break;
              case 3:
                trController.listar(connection);
                break;
              case 4:
                int id_treinador1 = scan.nextInt();
                trController.excluir(id_treinador1, connection);
                new ClearBuffer(scan);
                break;
              case 0:
                break;
              default:
                System.out.println("Opcao invalida");
                break;
            }

          }
          opcao = -1;
          break;
        case 0:
          break;
        default:
          System.out.println("Opcao invalida");
          break;
      }
    }
    scan.close();
  }

  public void menuPokemon(int id, String nome, String tipo, int geracao, Treinador tr, ConexaoDAO connection) {
    System.out.println("--------------------------------------");
    System.out.println("ID do Pokemon: " + id);
    System.out.println("Nome do Pokemon: " + nome);
    System.out.println("Tipo do Pokemon: " + tipo);
    System.out.println("Geracao do Pokemon: " + geracao);
    System.out.println("---------------------------------------");
    System.out.println("ID do Treinador do Pokemon " + tr.getId());
    System.out.println("Nome do Treinador do Pokemon " + tr.getNome());
    System.out.println("Regiao do Treinador do Pokemon " + tr.getRegiao());
    System.out.println("--------------------------------------");
  }


  public void menuTreinador(int id, String nome, String regiao) {
    System.out.println("--------------------------------------");
    System.out.println("ID do Treinador: " + id);
    System.out.println("Nome do Treinador: " + nome);
    System.out.println("Regiao do Treinador: " + regiao);
    System.out.println("--------------------------------------");
  }

  public void menuUpController(int id, String nome, String regiao) {
    System.out.println("--------------------------------------");
    System.out.println("ID do Treinador: " + id);
    System.out.println("Nome do Treinador: " + nome);
    System.out.println("Regiao do Treinador: " + regiao);
    System.out.println("--------------------------------------");
  }
}
