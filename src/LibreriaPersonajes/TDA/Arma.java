package LibreriaPersonajes.TDA;

import LibreriaPersonajes.Apariencia.LvlImages;
import LibreriaPersonajes.Apariencia.ManagerApariencia;
import LibreriaPersonajes.BuilderPattern.IBuilder;
import LibreriaPersonajes.PrototypePattern.IPrototype;

import java.util.ArrayList;

public class Arma implements IPrototype<Arma> {

    private static final long serialVersionUID = 3L;

    protected String nombre;
    protected int alcance;
    protected  int dano;
    protected int nivel;
    protected int rangoExplosion;
    protected int municion;
    protected ManagerApariencia apariencia;

    public Arma(String nombre, int alcance, int dano, int nivel, int rangoExplosion, ManagerApariencia apariencia){
        this.alcance = alcance;
        this.nombre = nombre;
        this.dano = dano;
        this.nivel = nivel;
        this.rangoExplosion = rangoExplosion;
        this.apariencia = apariencia;
        this.municion = 0;
    }

    public Arma(Arma arma){//Podria usar un deepClone
        this.nombre = arma.nombre;
        this.alcance = arma.alcance;
        this.dano = arma.dano;
        this.nivel = arma.nivel;
        this.rangoExplosion = arma.rangoExplosion;
        this.municion = arma.municion;
        this.apariencia = arma.apariencia;
    }

    public Arma(){

    }


    public static class BuilderArma implements IBuilder<Arma> {
        String nombre;
        int alcance;
        int dano;
        int nivel;
        int rangoExplosion;
        int municion;
        ManagerApariencia apariencia = new ManagerApariencia();

        public BuilderArma(){

        }

        public BuilderArma(Arma arma) {
            this.nombre = arma.nombre;
            this.apariencia = arma.apariencia.deepClone();
            this.dano = arma.dano;
            this.nivel = arma.nivel;
            this.rangoExplosion = arma.rangoExplosion;
            this.municion = arma.municion;
        }

        public BuilderArma setNombre(String nombre){
            this.nombre = nombre;
            return  this;
        }
        public BuilderArma setAlcance(int alcance) {
            this.alcance = alcance;
            return  this;
        }
        public BuilderArma setDano(int dano) {
            this.dano = dano;
            return  this;
        }
        public BuilderArma setNivel(int nivel) {
            this.nivel = nivel;
            return  this;
        }
        public BuilderArma setRangoExplosion(int rangoExplosion) {
            this.rangoExplosion = rangoExplosion;
            return  this;
        }
        public BuilderArma setApariencia(ManagerApariencia apariencia) {
            this.apariencia = apariencia;
            return  this;
        }
        public BuilderArma addApariencia(int nivel,LvlImages images) {
            this.apariencia.addApariencia(nivel,images);
            return  this;
        }

        public BuilderArma addApariencia(String url){
            this.apariencia.addApariencia(url);
            return this;
        }

        //Aca se ponen las imagenes como strings porque van a ser los URL
        public BuilderArma addApariencia(int nivel,String nombre, String imagenes) {
            this.apariencia.addApariencia(nivel,nombre,imagenes);
            return  this;
        }
        public BuilderArma setMunicion(int municion){
            this.municion = municion;
            return  this;
        }

        @Override
        public Arma build() {
            return new Arma(this.nombre,this.alcance,this.dano,this.nivel,this.rangoExplosion,this.apariencia);
        }
    }

    public String getNombre() {
        return nombre;
    }
    public int getAlcance() {
        return alcance;
    }
    public int getDano() {
        return dano;
    }
    public int getNivel() {
        return nivel;
    }
    public int getRangoExplosion() {
        return rangoExplosion;
    }
    public int getMunicion(){return  municion;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setRangoExplosion(int rangoExplosion) {
        this.rangoExplosion = rangoExplosion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }

    public ManagerApariencia getApariencia() {
        return apariencia;
    }

    private void setApariencia(ManagerApariencia apariencia){
        this.apariencia = apariencia;
    }

    //Todo: pensar en como se va a manejar el default de ManagerApariencia.
    @Override
    public Arma clone(){
        return new Arma(this.nombre,this.alcance,this.dano,this.nivel,this.rangoExplosion,new ManagerApariencia());
    }

    //Creo que la apariencia deberia poder ser modificable. Lo mas facil es modificar una lista String. No imagenes individuales.
    @Override
    public Arma deepClone(){
        //Va a copiar las apariencias disponibles
        ManagerApariencia copiaApariencia = this.apariencia.deepClone();
        //Usa el clone normal
        Arma copiaArma = clone();
        //Setea de manera privada las nuevas apariencias.
        copiaArma.setApariencia(copiaApariencia);
        return copiaArma;
    }

    public BuilderArma getBuildable(){
        return new BuilderArma(this);
    }

    public String toString(){
        String string = "Arma: "+ nombre + "\n"+
                        "Alcance: "+ String.valueOf(alcance) + "\n"+
                        "Da??o: "+ String.valueOf(dano) + "\n"+
                        "Nivel: "+ String.valueOf(nivel) + "\n"+
                        "RangoExplosion: "+ String.valueOf(nivel) + "\n"+
                        apariencia.toString();
        return  string;
    }
}