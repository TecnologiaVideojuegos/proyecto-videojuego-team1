package EstadosJuego.CoreGame.drylands;


import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.io.IOException;
import java.util.ArrayList;


/**
 * A test for basic animation rendering
 *
 * @author kevin
 */
public class Tutorial extends BasicGameState {

    /** The ID given to this state */
    public static final int ID = 99;
    private Combo combo;
    private static final int SCREENRESX = 1366, SCREENRESY = 768, maxFPS = 60;
    private static final boolean VSYNC = true;
    private final int TAMX = 48, TAMY = 60;
    private GameContainer container;
    private Player player;
    private ArrayList<Enemigo> enemigos, enemigosMuertos, limpiaEnemigos;
    //private double avance;
    private Mapa mapa;
    private SpriteSheet spritesplayer;
    private boolean combate;
    private Guardado partida;
    private Animation cursor;
    private Image uidash,uiblock,uibar,uihp,uicd;
    private StateBasedGame game;
    private enum fases{primera,atacar,bloquear,cooldownq,cooldownw,combo}
    private fases fase;
    private Image teclaq,teclaw;
    private int contadorMs;

    private java.awt.Font UIFont1;
    private UnicodeFont uniFont;
    private Sound dash, block;
    /*public CoreGame() {
        super("Dryland: Kingdoms Across");
    }*/

    public int getID() {
        return ID;
    }

    /*public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new CoreGame());
            container.setDisplayMode(SCREENRESX, SCREENRESY, FULLSCREEN);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }/*

    /**
     * @see org.newdawn.slick.BasicGame#init(org.newdawn.slick.GameContainer)
     */
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.game = game;
        partida = new Guardado("partida");
        
        combo=new Combo();
        container.setTargetFrameRate(maxFPS);
        container.setVSync(VSYNC);
        container.setSmoothDeltas(true);
        try {
            spritesplayer = new SpriteSheet("ficheros/sprites/personaje.png", TAMX, TAMY);

        } catch (SlickException e) {

        }
        teclaq = new Image("res/teclas/q.png");
        teclaw = new Image("res/teclas/w.png");



        combate = false;
        fase=fases.primera;

        player = new Player(spritesplayer,10,combo);

        container.getGraphics().setBackground(new Color(0.15f, 0.05f, 0.1f));





            mapa = new Mapa("ficheros/desierto-tut.tmx","ficheros/desierto-tut.tmx", "ficheros", SCREENRESX, SCREENRESY);

            player.setX(2450);
            player.setY(1150);
            mapa.actCamara(1,player);
            mapa.forzarCentro(player);
            partida.setCargada();



        enemigos = new ArrayList<Enemigo>();
        enemigosMuertos = new ArrayList<Enemigo>();
        limpiaEnemigos = new ArrayList<Enemigo>();


        uihp = new Image("ficheros/GUI/vida.png");
        uidash = new Image("ficheros/GUI/dash.png");
        uiblock = new Image("ficheros/GUI/block.png");
        uibar = new Image("ficheros/GUI/barra.png");
        uicd = new Image("ficheros/GUI/sombra.png");

        try {
            UIFont1 = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,
                    org.newdawn.slick.util.ResourceLoader.getResourceAsStream("res/Sangoku4.ttf"));
            UIFont1 = UIFont1.deriveFont(java.awt.Font.PLAIN, 24.f); //You can change "PLAIN" to "BOLD" or "ITALIC"... and 16.f is the size of your font
            uniFont = new UnicodeFont(UIFont1);
            uniFont.addAsciiGlyphs();
            uniFont.getEffects().add(new ColorEffect(java.awt.Color.white)); //You can change your color here, but you can also change it in the render{ ... }
            uniFont.addAsciiGlyphs();
            uniFont.loadGlyphs();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        dash = new Sound("res/Dash.ogg");
        block = new Sound("res/Bloqueo.ogg");


    }

    /**
     * @see BasicGame#render(GameContainer, Graphics)
     */
    public void render(GameContainer container,StateBasedGame game, Graphics g) {



            mapa.render();

            if (player.dash.estaActiva()) {
                g.drawGradientLine(player.dash.getStartX() + mapa.getOffX(), player.dash.getStartY() + mapa.getOffY(), (float) 1.0, (float) 1.0, (float) 1.0, (float) 0.0, player.getX() + mapa.getOffX() + player.TAMX / 2, player.getY() + mapa.getOffY() + player.TAMY / 2, (float) 1.0, (float) 1.0, (float) 1.0, (float) 1.0);
                g.drawGradientLine(player.dash.getStartX() + mapa.getOffX() + 1, player.dash.getStartY() + mapa.getOffY(), (float) 1.0, (float) 1.0, (float) 1.0, (float) 0.0, player.getX() + mapa.getOffX() + player.TAMX / 2, player.getY() + mapa.getOffY() + player.TAMY / 2, (float) 1.0, (float) 1.0, (float) 1.0, (float) 1.0);
                g.drawGradientLine(player.dash.getStartX() + mapa.getOffX() - 1, player.dash.getStartY() + mapa.getOffY(), (float) 1.0, (float) 1.0, (float) 1.0, (float) 0.0, player.getX() + mapa.getOffX() + player.TAMX / 2, player.getY() + mapa.getOffY() + player.TAMY / 2, (float) 1.0, (float) 1.0, (float) 1.0, (float) 1.0);
                g.drawGradientLine(player.dash.getStartX() + mapa.getOffX(), player.dash.getStartY() + mapa.getOffY() + 1, (float) 1.0, (float) 1.0, (float) 1.0, (float) 0.0, player.getX() + mapa.getOffX() + player.TAMX / 2, player.getY() + mapa.getOffY() + player.TAMY / 2, (float) 1.0, (float) 1.0, (float) 1.0, (float) 1.0);
                g.drawGradientLine(player.dash.getStartX() + mapa.getOffX(), player.dash.getStartY() + mapa.getOffY() - 1, (float) 1.0, (float) 1.0, (float) 1.0, (float) 0.0, player.getX() + mapa.getOffX() + player.TAMX / 2, player.getY() + mapa.getOffY() + player.TAMY / 2, (float) 1.0, (float) 1.0, (float) 1.0, (float) 1.0);
                g.drawGradientLine(player.dash.getStartX() + mapa.getOffX() + 1, player.dash.getStartY() + mapa.getOffY() + 1, (float) 1.0, (float) 1.0, (float) 1.0, (float) 0.0, player.getX() + mapa.getOffX() + player.TAMX / 2, player.getY() + mapa.getOffY() + player.TAMY / 2, (float) 1.0, (float) 1.0, (float) 1.0, (float) 1.0);


            }
            ArrayList<Personaje> listaentidadesrender = new ArrayList<>();
            listaentidadesrender.addAll(enemigos);

            listaentidadesrender.add(player);

            Personaje.renderOrdenados(mapa,listaentidadesrender);
            for (Enemigo enemigomuerto : enemigosMuertos) {
                enemigomuerto.getAnim("muerto").draw(enemigomuerto.getX() + mapa.getOffX(), enemigomuerto.getY() + mapa.getOffY());
            }
            


        switch (fase){

            case primera:

                uibar.draw(894,674);
                uihp.getScaledCopy((int)(382*(float)player.getVida()/player.getVidamax()),42).draw(927,684);
                break;

            case atacar:

                g.setFont(uniFont);
                g.drawString("Pulse Q para atacar", 830, 710);
                teclaq.draw(1200, 700);
                break;


            case bloquear:

                g.setFont(uniFont);
                g.drawString("Deje pulsado W para bloquear", 830, 710);
                teclaw.draw(1200, 700);
                break;

            case cooldownq:

                g.setFont(uniFont);
                g.drawString("Ataque y fíjese en el enfriamiento", 830, 710);
                break;
            case cooldownw:

                g.setFont(uniFont);
                g.drawString("El enfriamiento del bloqueo es mayor", 830, 710);
                break;

            case combo:

                g.setFont(uniFont);
                g.drawString("No fallar hará el enfriamiento más corto", 830, 710);
                break;

        }




            if(player.dash.estaActiva()){
                uidash.draw(33,674,new Color(1f, 0.8f, 0.8f));
            }
            else{
                uidash.draw(33,674);
                uicd.getScaledCopy(45,(int)(42*(float)player.dash.getCDRestante()/player.dash.getCdmax())).draw(43,683+42-(int)(42*(float)player.dash.getCDRestante()/player.dash.getCdmax()));
            }
            if(player.block.estaActiva()){
                uiblock.draw(109,674,new Color(1f, 0.8f, 0.8f));

            }
            else{
                uiblock.draw(109,674);
                uicd.getScaledCopy(45,(int)(42*(float)player.block.getCDRestante()/player.block.getCdmax())).draw(119,683+42-(int)(42*(float)player.block.getCDRestante()/player.block.getCdmax()));
            }



    }

    /**
     * @see BasicGame#update(GameContainer, int)
     */
    public void update(GameContainer container, StateBasedGame game,int delta) {
        partida.guardarEstado(this.getID());
        

        switch (fase){

            case primera:

                contadorMs+=delta;
                if(contadorMs>=3000){
                    contadorMs=0;
                    fase=fases.atacar;
                    
                    
                }
                break;
                
            

            


            case combo:

                contadorMs+=delta;
                if(contadorMs>=3000){
                    contadorMs=0;
                    game.enterState(11, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
                }
                break;

        }


        mapa.actCamara(delta, player);
        //Actualizo las hitbox
        player.actHitbox();
        for (Enemigo enemigo : enemigos) {
            enemigo.actHitbox();
        }


        player.lowerCDs(delta);
        combo.contarMs(delta);

        if (Keyboard.isKeyDown(Input.KEY_W) && player.block.getCDRestante() == 0) {
            player.block.block(delta);
            if(fase==fases.cooldownw){
                fase=fases.combo;
            
            }else  if(fase==fases.bloquear){
                                    fase=fases.cooldownq;
                            }
        }

        if (Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            player.setCorriendo();
        } else {
            player.setIdle();
        }

        player.calcNuevaPos(delta, mapa);
        for (Enemigo enemigo : enemigos) {
            enemigo.update(player, delta);
        }

        if (mapa.checkColX(player)) {//comprobamos colisiones muros
            player.resetX();
        }

        if (mapa.checkColY(player)) {
            player.resetY();
        }
        player.updAngulo();

        //Compruebo colisiones con enemigos
        if (!player.retrocediendo())
            for (Enemigo enemigo : enemigos) {
                if (enemigo.collidesCon(player.getHitbox())) {//ha habido colision, determino el contexto
                    if (!player.estaAtacando()) {//si el jugador no ataca, sufredaño
                        if(player.estaBloqueando()){
                                enemigo.retroceder(enemigo.getAngulo()+180);
                               
                        }
                        else{
                            player.rcvDmg(enemigo.getDmg());
                        player.retroceder(player.getAngulo()+180);
                        }
        
                        
                    } else { //si ataca compruebo si el enemigo no esta atacando
                        if (!enemigo.estaAtacando()) {
                            player.dash.landed();
                            combo.moreCombo();
                            
                            enemigo.rcvDmg(1);
                        } else {
                            player.retroceder(player.getAngulo()+180);
                            enemigo.retroceder(enemigo.getAngulo()+180);
                        }


                    }


                    break;
                }
            }

        player.updPosX();
        player.updPosY();

        for (Enemigo enemigo : enemigos) {

            enemigo.updPosX();
            enemigo.updPosY();

        }


        if (enemigos.size() > 0) {
            if (!combate) {
                combate = true;
            }
        } else {
            if (combate && enemigosMuertos.size() == 0) {

                System.out.println("Sala limpiada, aqui deberia guardar");


                combate = false;
                try {
                    partida.guardarMapa(mapa);
                    partida.guardarPlayer(player);
                } catch (IOException error) {
                    System.out.println("Error al guardar");
                }

            }
        }


        //Compruebo vida de los personajes
        if(player.getVida()==0){
            game.enterState(6, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

        for (Enemigo enemigo : enemigos) {

            if (enemigo.getVida() <= 0) {

                enemigosMuertos.add(enemigo);
            }

        }
        if (enemigosMuertos.size() > 0)
            enemigos.removeAll(enemigosMuertos);//Lo quito aqui porque en el bucle da error


        //Limpio ahora el array de enemigos muertos
        for (Enemigo enemigomuerto : enemigosMuertos) {
            if (enemigomuerto.getAnim("muerto").getFrame() == 6) {
                limpiaEnemigos.add(enemigomuerto);
            }

        }
        if (limpiaEnemigos.size() > 0) {
            enemigosMuertos.removeAll(limpiaEnemigos);//Lo quito aqui porque en el bucle da error
            limpiaEnemigos.clear();
        }
    }
    

    /**
     * @see BasicGame#keyPressed(int, char)
     */
    public void keyPressed(int key, char c) {

        if (key == Input.KEY_ESCAPE) {


            game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.blue));

        } else if (key == Input.KEY_Q && player.dash.getCDRestante() == 0 && !player.dash.estaActiva()) {
                        
                if(fase==fases.atacar){
                                fase=fases.bloquear;
                            } else if(fase==fases.cooldownq){
                                fase=fases.cooldownw;
                            }


            dash.play();
            float difx = mapa.getAbsMouseX() - (player.getX() + player.TAMX / 2);
            float dify = mapa.getAbsMouseY() - (player.getY() + player.TAMY / 2);
            float difcuadrados = (difx * difx) + (dify * dify);
            float dist = (float) Math.sqrt(difcuadrados);
            int maxstep = player.dash.getRango();
            if (dist > (maxstep)) {
                float incx = (difx * maxstep / dist);

                int targetx = (int) Math.round(incx);


                float incy = (dify * maxstep / dist);
                int targety = (int) Math.round(incy);

                player.dash.cast(player, player.getX() + player.TAMX / 2 + targetx, player.getY() + player.TAMY / 2 + targety);

            } else {

                player.dash.cast(player, player.getX() + player.TAMX / 2 + (int) difx, player.getY() + player.TAMY / 2 + (int) dify);
                //System.out.println("Casteado movimiento a ",difx);
            }
        } else if (key == Input.KEY_P) {

        }
        if (key == Input.KEY_W && player.block.getCDRestante() == 0 && !player.block.estaActiva()){
            block.play();
        }

    }

    public void keyReleased(int key, char c) {
        if (key == Input.KEY_W && player.block.estaActiva()) {
            player.block.terminar();
            player.block.contarCD();

        }
    }

}
