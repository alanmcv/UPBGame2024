package edu.upb.lp.progra.Signy;

public class Button {

    ///Create buttons
    private SignyGame game;

    public Button(SignyGame game) {
        this.game = game;
    }

    public void startingButton(String name) {
        if (name.equals("Comenzar")) {
            //secondScreen.onButttonPressed()
            if (game.getnrScreen_alphabet() == 0) {
                game.setNrScreen_alphabet(1);
                game.twoButtons();
            }

        }
    }

    public void nextButton(String name) {
        if (name.equals("Sigu")) {
            if (game.getnrScreen_alphabet() == 1) {
                game.setNrScreen_alphabet(2);
                game.mostrar_alfabeto2();
            } else if (game.getnrScreen_alphabet() == 2) {
                game.setNrScreen_alphabet(3);
                game.mostrar_alfabeto3();
            }
        }
    }

    public void mainButton(String name) {
        if (name.equals("Menú Principal")) {
            game.setNrScreen_alphabet(1);
            game.draw_2_buttons();
            game.buttonBack();
            game.resetGameScreen();

        }
    }

    public void backButton(String name) {
        if (name.equals("Atras")) {
//            if(nrScreen_alphabet < 5){
//                nrScreen_alphabet--;
//            }
            if (game.getnrScreen_alphabet() == 3) {
                game.setNrScreen_alphabet(2);
                game.connect_next_alphabet();
            } else if (game.getnrScreen_alphabet() == 2) {
                game.setNrScreen_alphabet(1);
                //connect.next_alphabet();
                game.connect_alphabetbuttonPressed();
                game.connect_backButtonRemover();
            }
        }
    }

    public void continueButton(String name) {
        if (name.equals("Continuar")) {
            game.passing_game_screens();
        }
    }

    public void playingBackButton(String name) {
        if (name.equals("Volver a Jugr")) {
            game.connect_draw_first_twoButtons(name);
            game.outofMinigame();
        }

    }
}