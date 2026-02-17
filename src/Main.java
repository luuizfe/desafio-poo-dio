import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso cursoJavaBasico = new Curso(
                "Java Fundamentos",
                "Introdução à linguagem Java e conceitos básicos",
                8,
                NivelCurso.BASICO
        );

        Curso cursoSpringAvancado = new Curso(
                "Spring Boot Avançado",
                "Criação de APIs REST com Spring Boot e boas práticas",
                12,
                NivelCurso.AVANCADO
        );

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

//        System.out.println(curso1);
//        System.out.println(curso2);
//        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(cursoJavaBasico);
        bootcamp.getConteudos().add(cursoSpringAvancado);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

//        System.out.println("-------");
//
//        Dev devJoao = new Dev();
//        devJoao.setNome("Joao");
//        devJoao.inscreverBootcamp(bootcamp);
//        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
//        devJoao.progredir();
//        devJoao.progredir();
//        devJoao.progredir();
//        System.out.println("-");
//        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
//        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
//        System.out.println("XP:" + devJoao.calcularTotalXp());

    }

}
