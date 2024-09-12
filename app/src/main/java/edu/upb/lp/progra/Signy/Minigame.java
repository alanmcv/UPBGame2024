package edu.upb.lp.progra.Signy;

public class Minigame {
    private SignyGame game;

    public Minigame(SignyGame game) {
        this.game = game;
    }

    public void organize_minigamescreen() {
        game.crearPantallas();
    }

    public void onLetterPress(int vertical, int horizontal) {
        game.letterPressed(vertical,horizontal);
}
}