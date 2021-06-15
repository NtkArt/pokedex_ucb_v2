package database.models;

public class Pokemon {

  private String tipo;
  private int id;
  private int geracao;
  private String nome;

  public Pokemon(int id, String nome, String tipo, Integer geracao) {
    super();
    this.nome = nome;
    this.id = id;
    this.tipo = tipo;
    this.geracao = geracao;
  }

  public Pokemon() {

  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getId() {
    return id;
  }

  public Integer setId() {
    return this.id++;
  }


  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Integer getGeracao() {
    return geracao;
  }

  public void setGeracao(Integer geracao) {
    this.geracao = geracao;
  }


}