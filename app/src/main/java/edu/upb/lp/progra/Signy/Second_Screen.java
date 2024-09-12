package edu.upb.lp.progra.Signy;

public class Second_Screen {
    private SignyGame game;
    public Second_Screen(SignyGame game){
        this.game=game;
    }
    public void onButttonPressed(int vertical, int horizontal) {
        game.two_options_buttonPressed(vertical, horizontal);
    }

}