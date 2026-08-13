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

        System.out.println("--\tOrdem aleatória\t--");
        Set<Gibi> meusGibis = new HashSet<>(){{
            add(new Gibi("Thor", 2020, 240));
            add(new Gibi("X-MEN", 2001, 300));
            add(new Gibi("Guerras Secretas", 2015, 110));
        }};
        for (Gibi gibi: meusGibis) System.out.println(gibi.getNome() + " - " +
                gibi.getAno() + " - " + gibi.getPaginas());

        System.out.println("--\tOrdem aleatória\t--");
        Set<Gibi> meusGibis1 = new LinkedHashSet<>(){{
            add(new Gibi("Thor", 2020, 240));
            add(new Gibi("X-MEN", 2001, 300));
            add(new Gibi("Guerras Secretas", 2015, 110));
        }};
        for (Gibi gibi: meusGibis1) System.out.println(gibi.getNome() + " - " +
                gibi.getAno() + " - " + gibi.getPaginas());

        System.out.println("--\tOrdem natural(paginas)\t--");
        Set<Gibi> meusGibis2 = new TreeSet<>(meusGibis1);
        for (Gibi gibi: meusGibis) System.out.println(gibi.getNome() + " - " +
                gibi.getAno() + " - " + gibi.getPaginas());

        System.out.println("--\tOrdem Nome/Ano/Paginas\t--");
        Set<Gibi> meusGibis3 = new TreeSet<>(new Gibi.ComparadorNomeAnoPaginas());
        meusGibis3.addAll(meusGibis);
        for (Gibi gibi: meusGibis) System.out.println(gibi.getNome() + " - " +
                gibi.getAno() + " - " + gibi.getPaginas());
    }
static class Gibi implements Comparable<Gibi> {
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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gibi gibi = (Gibi) o;
        return nome.equals(gibi.nome) && ano.equals(gibi.ano) && paginas.equals(gibi.paginas);
    }
     @Override
    public int hashCode(){
        return Objects.hash(nome, ano, paginas);
    }

    @Override
    public int compareTo(Gibi gibi){
        int paginas = Integer.compare(this.getPaginas(), gibi.getPaginas());
        if (paginas !=0) return paginas;

        return this.getAno().compareTo(gibi.getAno());
    }

    static class ComparadorNomeAnoPaginas implements Comparator<Gibi>{

        @Override
        public int compare(Gibi g1, Gibi g2){
            int nome = g1.getNome().compareTo(g2.getNome());
            if(nome != 0) return nome;

            int ano = g1.getAno().compareTo(g2.getAno());
            if (ano != 0) return ano;

            return Integer.compare(g1.getPaginas(), g2.getPaginas());
        }
    }


}
}