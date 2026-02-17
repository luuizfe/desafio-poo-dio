package br.com.dio.desafio.dominio;


import lombok.Data;

@Data
public class Curso extends Conteudo {

    private int cargaHoraria;
    private NivelCurso nivel;

    public Curso(String titulo, String descricao, int cargaHoraria, NivelCurso nivel) {
        setTitulo(titulo);
        setDescricao(descricao);
        this.cargaHoraria = cargaHoraria;
        this.nivel = nivel;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria * nivel.getFatorXp();
    }


    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", nivel=" + nivel +
                '}';
    }
}
