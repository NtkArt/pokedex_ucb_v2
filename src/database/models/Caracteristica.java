package database.models;

public class Caracteristica {
  private String nome;
  private Double altura;

  public double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void imprimirAltura() {
    System.out.println("Altura:" + getAltura());
  }

  public void imprimirNome() {
    System.out.println("Nome:" + getNome());
  }
}
