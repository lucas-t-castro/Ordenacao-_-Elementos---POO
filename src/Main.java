/*Dadas as seguintes informações sobre meus gibis favoritos,
crie um conjunto e ordene este conjunto exibindo:
(nome - ano - paginas);
Gibis 1 = Nome: Thor, ano: 2020, paginas: 240
Gibis 2 = nome: X-MEN, ano: 2001, paginas: 300
Gibis 3 = nome: Guerras Secretas, ano: 2015, paginas: 110

*///TIP Para <b>executar</b> o código, pressione <shortcut actionId="Run"/> ou
// clique no ícone <icon src="AllIcons.Actions.Execute"/> no gutter.

import  java.util.*;

public class Main {
    public static void main(String[] args){

    }
class Gibi implements Comparable<Gibi> {
    private String nome;
    private Integer ano;
    private Integer paginas;

    public Gibi(String nome, Integer ano, Integer pagians) {
        this.nome = nome;
        this.ano = ano;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public String toString(){
        return "{" +
                "nome='" + nome + '\'' +
                ", ano='" + ano + '\'' +
                ", paginas='" + paginas +
                "}";
    }

}
}