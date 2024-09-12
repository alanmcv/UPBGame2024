package edu.upb.lp.progra.Signy;

public class ArrayGameScreen {
    private SignyGame game;
    private String[] manos;

    private String[] letrasCorrectas = {"vacio", "vacio", "vacio", "vacio", "vacio"};
    private String[] letras;

    public ArrayGameScreen(SignyGame game, String[] manos, String[] letras) {
        this.game = game;
        this.manos = manos;
        this.letras = letras;
    }

    //    public void orgamizarPantallas(){
//        game.crearPantallas();
//    }
    public String[] getManos() {
        return manos;
    }

    public String[] getLetrasCorrectas() {
        return letrasCorrectas;
    }

    public String[] getLetras() {
        return letras;
    }

    private int cantidadDeLetrasCorrectas = 0;

    public void letterPressed(int vertical, int horizontal) {
        if (vertical >= 2 && cantidadDeLetrasCorrectas < 5) {//ignora las 2 primeras filas.
            if (letras[(vertical - 2) * 5 + horizontal].charAt(7) == manos[cantidadDeLetrasCorrectas].charAt(5)) {
                letrasCorrectas[cantidadDeLetrasCorrectas] = letras[(vertical - 2) * 5 + horizontal];
                game.draw_letter(1, cantidadDeLetrasCorrectas, letras[(vertical - 2) * 5 + horizontal]);
                cantidadDeLetrasCorrectas++;
            } else {
                game.mistake();
            }
        }
    }

    public void reset() {
        for (int i = 0; i < letrasCorrectas.length; i++) {
            letrasCorrectas[i] = "vacio";
        }
        cantidadDeLetrasCorrectas = 0;
    }
}

