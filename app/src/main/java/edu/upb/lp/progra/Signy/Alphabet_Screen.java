package edu.upb.lp.progra.Signy;

public class Alphabet_Screen {
    private SignyGame game;

    //arreglo de imagenes y de acuerdo a su indice que haga cierta accion del connector.
    public Alphabet_Screen(SignyGame game) {
        this.game = game;
    }

    public void mostrar_alphabeto() {
        game.mostrar_alfabeto1();
    }

    public void mostrar_alphabeto2() {
        game.mostrar_alfabeto2();
    }

    public void mostrar_alphabeto3() {
        game.mostrar_alfabeto3();
    }
}