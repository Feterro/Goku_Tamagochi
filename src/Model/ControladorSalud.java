package Model;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class ControladorSalud implements Serializable {

    private int satisfaccionHambre = 100;
    private int satisfaccionSuenno = 100;
    private int satisfaccionBano = 100;
    private int saludSocial = 100;
    private int saludFisica = 100;

    private int probabilidadEnfermedad = 0;
    private int liquidosConsumidos = 0;
    private int solidosConsumidos = 0;
    private boolean enfermo = false;
    //public Enfermedad enfermedad; TODO Cambiar a la clase Abstracta


    public ControladorSalud(int probabilidadEnfermedad, int hambre, int suenno, int satisfaccionBano, int saludSocial, int saludFisica, int liquidosConsumidos, int solidosConsumidos, boolean enfermo) {
        this.probabilidadEnfermedad = probabilidadEnfermedad;
        this.satisfaccionHambre = hambre;
        this.satisfaccionSuenno = suenno;
        this.satisfaccionBano = satisfaccionBano;
        this.saludSocial = saludSocial;
        this.saludFisica = saludFisica;
        this.liquidosConsumidos = liquidosConsumidos;
        this.solidosConsumidos = solidosConsumidos;
        this.enfermo = enfermo;
    } //TODO Puede que sea innecesario este constructor entonces se borra


    public ControladorSalud() {

    }

    public void verificar(){
        if(satisfaccionHambre < 0 || satisfaccionHambre >100 ){
            this.probabilidadEnfermedad += 20;
        }
        if(satisfaccionBano < 0){
            this.probabilidadEnfermedad += 20;
        }
        if(saludSocial < 0 || saludSocial > 100){
            this.probabilidadEnfermedad += 20;
        }
        if(saludFisica < 0) {
            this.probabilidadEnfermedad += 20;
        }
        if(satisfaccionSuenno < 0) {
            this.probabilidadEnfermedad += 20;
        }
        int rand_enfermedad = ThreadLocalRandom.current().nextInt(0, 100);
        if (rand_enfermedad < this.probabilidadEnfermedad){
            System.out.println("Se enferma"); //TODO setear enfermedad
        }
    }

    public int getProbabilidadEnfermedad() {
        return probabilidadEnfermedad;
    }

    public void setProbabilidadEnfermedad(int probabilidadEnfermedad) {
        this.probabilidadEnfermedad = probabilidadEnfermedad;
    }

    public void modProbabilidadEnfermedad(int probabilidadEnfermedad) {
        this.probabilidadEnfermedad = this.probabilidadEnfermedad + probabilidadEnfermedad;
        if(this.probabilidadEnfermedad > 100)
            this.probabilidadEnfermedad = 100;
        else if(this.probabilidadEnfermedad < 0)
            this.probabilidadEnfermedad = 0;
    }

    public int getSatisfaccionHambre() {
        return satisfaccionHambre;
    }

    public void setSatisfaccionHambre(int satisfaccionHambre) {
        this.satisfaccionHambre = satisfaccionHambre;
    }

    public void modSatisfaccionHambre(int satisfaccionHambre) {
        this.satisfaccionHambre = this.satisfaccionHambre + satisfaccionHambre;
        if(this.satisfaccionHambre > 100)
            this.satisfaccionHambre = 110;
        else if(this.satisfaccionHambre < 0)
            this.satisfaccionHambre = -10;
    }

    public int getSatisfaccionSuenno() {
        return satisfaccionSuenno;
    }

    public void setSatisfaccionSuenno(int satisfaccionSuenno) {
        this.satisfaccionSuenno = satisfaccionSuenno;
    }

    public void modSatisfaccionSuenno(int satisfaccionSuenno) {
        this.satisfaccionSuenno = this.satisfaccionSuenno + satisfaccionSuenno;
        if(this.satisfaccionSuenno > 100)
            this.satisfaccionSuenno = 100;
        else if(this.satisfaccionSuenno < 0)
            this.satisfaccionSuenno = -10;
    }

    public int getSatisfaccionBano() {
        return satisfaccionBano;
    }

    public void setSatisfaccionBano(int satisfaccionBano) {
        this.satisfaccionBano = satisfaccionBano;
    }

    public void modSatisfaccionBano(int satisfaccionBano) {
        this.satisfaccionBano = this.satisfaccionBano + satisfaccionBano;
        if(this.satisfaccionBano < 0)
            this.satisfaccionBano = -10;
        else if(this.satisfaccionBano > 100)
            this.satisfaccionBano = 100;
    }

    public int getSaludSocial() {
        return saludSocial;
    }

    public void setSaludSocial(int saludSocial) {
        this.saludSocial = saludSocial;
    }

    public void modSaludSocial(int saludSocial) {
        this.saludSocial = this.saludSocial + saludSocial;
        if(this.saludSocial > 100)
            this.saludSocial = 110;
        else if(this.saludSocial < 0)
            this.saludSocial = -10;
    }

    public int getSaludFisica() {
        return saludFisica;
    }

    public void setSaludFisica(int saludFisica) {
        this.saludFisica = saludFisica;
    }

    public void modSaludFisica(int saludFisica) {
        this.saludFisica = this.saludFisica + saludFisica;
        if(this.saludFisica > 100)
            this.saludFisica = 100;
        else if(this.saludFisica < 0)
            this.saludFisica = -10;
    }

    public int getLiquidosConsumidos() {
        return liquidosConsumidos;
    }

    public void setLiquidosConsumidos(int liquidosConsumidos) {
        this.liquidosConsumidos = liquidosConsumidos;
    }

    public void modLiquidosConsumidos(int liquidosConsumidos) {
        this.liquidosConsumidos = this.liquidosConsumidos + liquidosConsumidos;
    }

    public int getSolidosConsumidos() {
        return solidosConsumidos;
    }

    public void setSolidosConsumidos(int solidosConsumidos) {
        this.solidosConsumidos = solidosConsumidos;
    }

    public void modSolidosConsumidos(int solidosConsumidos) {
        this.solidosConsumidos = this.solidosConsumidos + solidosConsumidos;
    }

    public boolean isEnfermo() {
        return enfermo;
    }

    public void setEnfermo(boolean enfermo) {
        this.enfermo = enfermo;
    }
}
