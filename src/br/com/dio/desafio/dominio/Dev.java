package br.com.dio.desafio.dominio;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.*;
@Data
public class Dev {
    private String nome;
    private Nivel nivel = Nivel.Estagiário;
    private int xp = 0;

    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Iterator<Conteudo> iterator = conteudosInscritos.iterator();

        if (iterator.hasNext()) {
            Conteudo conteudo = iterator.next();

            conteudosConcluidos.add(conteudo);
            xp += conteudo.calcularXp(); // acumula XP
            iterator.remove();

            calcularNivel(); // verifica se mudou nível

        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while (iterator.hasNext()) {
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }

    public void calcularNivel() {
        if (xp < 100) {
            nivel = Nivel.Estagiário;
        } else if (xp < 300) {
            nivel = Nivel.Júnior;
        } else if (xp < 450) {
            nivel = Nivel.Pleno;
        } else if (xp < 700) {
            nivel = Nivel.Senior;
        }else if (xp < 800) {
            nivel = Nivel.Expert;

        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
