package database.models;

import java.util.*;

public class Pokemon extends Caracteristica {

  private String tipo;
  private String habilidade;
  private Double peso;
  private int id;

  public Pokemon(int id, String tipo, String habilidade, Double peso) {
    super();
    this.id = id;
    this.tipo = tipo;
    this.habilidade = habilidade;
    this.peso = peso;
  }

  public int getId() {
    return id;
  }

  public int setId() {
    return this.id++;
  }


  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getHabilidade() {
    return habilidade;
  }

  public void setHabilidade(String habilidade) {
    this.habilidade = habilidade;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }


}