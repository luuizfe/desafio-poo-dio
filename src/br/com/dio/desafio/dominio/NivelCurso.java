package br.com.dio.desafio.dominio;

public enum NivelCurso {

        BASICO(1.0),
        INTERMEDIARIO(1.5),
        AVANCADO(2.0);

        private final double fatorXp;

        NivelCurso(double fatorXp) {
            this.fatorXp = fatorXp;
        }

        public double getFatorXp() {
            return fatorXp;
        }
    }


