package edu.upb.lp.progra.Signy;

import edu.upb.lp.progra.adapterFiles.AndroidLibrary;
import edu.upb.lp.progra.adapterFiles.AppConnector;

public class SignyConnector implements AppConnector {
    //Declara una variable.
    private AndroidLibrary lib;
    private SignyGame game;
    //Builds the constructor.
    private String al_screen []={"a_to_l","m_to_x","y_to_0"};
    public SignyConnector(AndroidLibrary lib) {
        this.lib = lib;
        this.game = new SignyGame(this);
    }
    //Interface is added to not instancee again.
    @Override
    public void onButtonPressed(String name) {
        game.firstButton(name);
        game.secondButton(name);
        game.thirdButton(name);
        game.fourthButton(name);
        game.fifthButton(name);
        game.sixthButton(name);
    }
    @Override
    public void onCellPressed(int vertical, int horizontal) {
        game.clic(vertical, horizontal);
    }
    @Override
    public void initialiseInterface() {
        lib.configureScreen(1, 1, 0, 0, false, 0.15);
        lib.setImageOnCell(0,0,"parrot");
        lib.addButton("Comenzar", 15, 40);
    }
    //Dibuja la pantalla de dos botonws.
    public void draw_first_twoButtons() {
        lib.configureScreen(3,5,0,0,false,0.15);
        for (int h = 0; h < 5; h++) {
            lib.setImageOnCell(0, h, "ligth_blue");
        }
        for (int v = 0; v < 3; v++) {
            for(int h = 0; h < 5; h++){
                lib.setImageOnCell(2, h, "ligth_blue");
            }
        }
        lib.setImageOnCell(1, 1, "alfabeto");
        lib.setImageOnCell(1, 3, "minijuegos");
        lib.setImageOnCell(1, 0, "ligth_blue");
        lib.setImageOnCell(1, 2, "ligth_blue");
        lib.setImageOnCell(1, 4, "ligth_blue");
        lib.removeButton("Comenzar");
        lib.removeButton("Volver a Jugar");
        lib.removeButton("Siguiente");
        lib.removeButton("Atras");
        lib.removeButton("Continuar");
        lib.removeButton("Menú Principal");
        game.outofMinigame();

    }
    //Pasa a la segunda pantalla.
    public void minigamesbuttonPressed(ArrayGameScreen screen){
        lib.configureScreen(3,5,0,0,false,0.15);
        draw_game_screen(screen);
        lib.removeButton("Comenzar");
        lib.addButton("Continuar", 15, 40);
    }
    //En caso de se aprete la celda de alfabeto, la pantalla se configura a 1*1.
    public void alphabetbuttonPressed(){
        lib.configureScreen(1,1,0,0,false,0.15);
        lib.setImageOnCell(0,0,al_screen[0]);
        lib.addButton("Siguiente", 15, 40);
        lib.addButton("Menú Principal", 15, 40);
    }
    //Dibuja la segunda pantalla del alfabeto.
    public void next_alphabet(){
        lib.setImageOnCell(0,0,al_screen[1]);
        lib.addButton("Atras", 15, 40);
        lib.addButton("Siguiente", 15, 40);

    }
    //Dibuja la tercera pantalla del alfabeto y crea un boton.
    public void next_alphabet2(){
        lib.setImageOnCell(0,0,al_screen[2]);
        lib.removeButton("Siguiente");
    }
    public void back_button(){
        lib.removeButton("Menú Principal");
    }

    public void draw_game_screen(ArrayGameScreen screens) {
        lib.configureScreen(4,5,0,0,false,0.15);
        for (int h = 0; h < 5; h++) {
            lib.setImageOnCell(0, h, screens.getManos()[h]);
            lib.setImageOnCell(1, h, screens.getLetrasCorrectas()[h]);
            lib.setImageOnCell(2, h, screens.getLetras()[h]);
            lib.setImageOnCell(3, h, screens.getLetras()[h+5]);
        }
        lib.addButton("Menú Principal", 15, 40);
    }

    public void pantallaDeFinDeJuego() {
        lib.configureScreen(1,1,0,0,false,0.15);
        lib.setImageOnCell(0,0,"ending");
        lib.removeButton("Continuar");
        lib.addButton("Volver a Jugar", 15, 40);
    }

    public void dibujarLetra(int v, int h, String letra) {
        lib.setImageOnCell(v,h,letra);
    }
    public void error_message() {
        lib.showTemporaryMessage("Vuelve a Intentar");
    }
    public void backButtonRemover(){
        lib.removeButton("Atras");
}
}