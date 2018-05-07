/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoreGame.drylands;

import org.newdawn.slick.Animation;

/**
 * @author FairLight
 */
public abstract class Habilidad {
    private final String nombre;
    protected boolean activa;
    protected int cdmax, cdrestante;
    Animation der, izq;

    public Habilidad(String nombre, int cdmax) {
        this.nombre = nombre;
        this.cdmax = cdmax;
    }

    public int getCdmax() {
        return cdmax;
    }

    public void setCdmax(int cdmax) {
        this.cdmax = cdmax;
    }

    public Animation getDAnim() {
        return der;
    }

    public Animation getIAnim() {
        return izq;
    }

    public void lowerCD(int delta) {
        if ((cdrestante - delta) > 0)
            cdrestante -= delta;
        else
            cdrestante = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void calcNuevaPos(Personaje pj, int delta);

    //public abstract void cast();
    public void terminar() {
        activa = false;

    }

    public void contarCD() {
        cdrestante = cdmax;
    }

    public boolean estaActiva() {
        return activa;
    }

    public int getCDRestante() {
        return cdrestante;
    }
}

