package edu.upb.lp.progra.Signy;

public class SignyGame {
    private int nrScreen_alphabet = 0;//inicializa el numero de pantalla del alfabeto

    private int nrScreen_minigames = 0;//inicializa el numero de pantalla del minijuego

    private SignyConnector connect;//atributo que le damos a la clase para que conozca al signy connector
    //private Button button;
    private boolean isMiniGame = false;// inicializando un boolean de nombre isminigame
    //Array of ArrarGameScreen
    private ArrayGameScreen[] screens = new ArrayGameScreen[3]; //atributo, arreglo de screens de tipo ArrayGameScreen
    private Alphabet_Screen alfa = new Alphabet_Screen(this); // estás creando un nuevo objeto de "alphabet screen" y almacenándolo en una variable nombrada alfa
    private Minigame minigame = new Minigame(this);  //estás creando un nuevo objeto "minijuego" y almacenándolo en una variable nombrada minigame
    private Second_Screen secondScreen = new Second_Screen(this); //estás creando un nuevo objeto "second screen" y almacenándolo en una variable secondScreen
    private Button button = new Button(this);// estás creando un nuevo Button y almacenándolo en button

    public SignyGame(SignyConnector connect) {//define un constructor para la SignyGame. Acepta un argumento, un objeto de tipo SignyConnectorllamado connect
        this.connect = connect;//establece una conexión entre SignyGamey la SignyConnectorclase, lo que les permite comunicarse e interactuar.
        minigame.organize_minigamescreen();
    }
    public int getnrScreen_alphabet(){//obtner el valor del numero de la pantalla
        return nrScreen_alphabet;
    }
    public int getNrScreen_minigames() {
        return nrScreen_minigames;
    }

    public void setNrScreen_alphabet(int nrScreen_alphabet) {
        this.nrScreen_alphabet = nrScreen_alphabet;
    }

    public void setNrScreen_minigames(int nrScreen_minigames) {
        this.nrScreen_minigames = nrScreen_minigames;
    }

    //crearPantalla se comunica directamente con el game.
    public void crearPantallas() {
        String[] manos0 = {"mano_j", "mano_a", "mano_p", "mano_o", "mano_n"};
        String[] letras0 = {"letter_s", "letter_o", "letter_a", "letter_j", "letter_p", "letter_n", "letter_m", "letter_a", "letter_l", "letter_k"};
        screens[0] = new ArrayGameScreen(this, manos0, letras0);
        String[] manos1 = {"mano_n", "mano_o", "mano_b", "mano_e", "mano_l"};
        String[] letras1 = {"letter_i", "letter_j", "letter_a", "letter_o", "letter_p", "letter_n", "letter_q", "letter_b", "letter_l", "letter_e"};
        screens[1] = new ArrayGameScreen(this, manos1, letras1);
        String[] manos2 = {"mano_o", "mano_s", "mano_c", "mano_a", "mano_r"};
        String[] letras2 = {"letter_s", "letter_o", "letter_a", "letter_c", "letter_p", "letter_n", "letter_m", "letter_a", "letter_l", "letter_r"};
        screens[2] = new ArrayGameScreen(this, manos2, letras2);
    }
    //Cambie de la primera a la segunda pantalla.
    public void twoButtons(){
        connect.draw_first_twoButtons();
    }
    public void firstButton(String name){
        button.startingButton(name);
    }
    public void secondButton(String name){
        button.nextButton(name);
    }
    public void thirdButton(String name){
        button.mainButton(name);
    }
    public void draw_2_buttons(){
        connect.draw_first_twoButtons();
    }
    public void buttonBack(){
        connect.back_button();
    }
    public void connect_next_alphabet(){
        connect.next_alphabet();
    }
    public void connect_alphabetbuttonPressed(){
        connect.alphabetbuttonPressed();
    }
    public void connect_backButtonRemover(){
        connect.backButtonRemover();
    }
    public void fourthButton(String name){
        button.backButton(name);
    }
    public void passing_game_screens(){
        screens[nrScreen_minigames].reset();
        if (nrScreen_minigames < 2) {
            nrScreen_minigames++;
            connect.draw_game_screen(screens[nrScreen_minigames]);
        } else {
            connect.pantallaDeFinDeJuego();
            nrScreen_minigames = 0;//Either up or down, it works.
        }
    }
    public void fifthButton(String name){
        button.continueButton(name);
    }
    public void connect_draw_first_twoButtons(String name) {
        connect.draw_first_twoButtons();
    }
    public void sixthButton(String name){
        button.playingBackButton(name);
    }
    public void two_options_buttonPressed(int vertical, int horizontal) {//cannot it be v,h?
        if (nrScreen_alphabet == 1) {
            if (vertical == 1 && horizontal == 1) {
                alfa.mostrar_alphabeto();
            } else if (vertical == 1 && horizontal == 3) {
                isMiniGame = true;
                connect.minigamesbuttonPressed(screens[0]);
                //buttonpressed("Volver a Jugar");
            }
        }
    }

    public void letterPressed(int vertical, int horizontal) {
        screens[nrScreen_minigames].letterPressed(vertical, horizontal);
    }

    public void draw_letter(int v, int h, String letra) {
        connect.dibujarLetra(v, h, letra);
    }


    public void clic(int vertical, int horizontal) {
        if (isMiniGame) {
            //screens.organize_minigamescreen[];
            minigame.onLetterPress(vertical, horizontal);
        } else {
            secondScreen.onButttonPressed(vertical, horizontal);
        }
    }

    public void mostrar_alfabeto1() {
        connect.alphabetbuttonPressed();
    }

    public void mostrar_alfabeto2() {
        connect.next_alphabet();
    }

    public void mostrar_alfabeto3() {
        connect.next_alphabet2();
    }

    public void mistake() {
        connect.error_message();
    }
    public void outofMinigame(){
        isMiniGame =false;}

    public void resetGameScreen() {
        for (ArrayGameScreen screen : screens){
            screen.reset();
            //crearPantallas();
        }
    }
}