package database.models;

import java.util.ArrayList;

public class Pokemon {

  private String tipo;
  private int id;
  private int geracao;
  private String nome;
  private Treinador treinador;


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

  public int setIdUpload(Integer id) {
    return this.id = id;
  }


  public int setId() {
    return this.id++;
  }

  public Treinador getTreinador() {
    return this.treinador;
  }


  public void setTreinador(Treinador treinador) {
    this.treinador = treinador;
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