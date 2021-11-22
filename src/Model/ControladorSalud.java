package Model;

public class ControladorSalud {

    public int probabilidadEnfermedad = 100;
    public int satisfaccionHambre = 100;
    public int satisfaccionSuenno = 100;
    public int satisfaccionBano = 100;
    public int saludSocial = 100;
    public int saludFisica = 100;
    public int liquidosConsumidos = 0;
    public int solidosConsumidos = 0;
    public boolean enfermo = false;
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

    }

    public int getProbabilidadEnfermedad() {
        return probabilidadEnfermedad;
    }

    public void setProbabilidadEnfermedad(int probabilidadEnfermedad) {
        this.probabilidadEnfermedad = probabilidadEnfermedad;
    }

    public void modProbabilidadEnfermedad(int probabilidadEnfermedad) {
        this.probabilidadEnfermedad = this.probabilidadEnfermedad + probabilidadEnfermedad;
    }

    public int getSatisfaccionHambre() {
        return satisfaccionHambre;
    }

    public void setSatisfaccionHambre(int satisfaccionHambre) {
        this.satisfaccionHambre = satisfaccionHambre;
    }

    public void modSatisfaccionHambre(int satisfaccionHambre) {
        this.satisfaccionHambre = this.satisfaccionHambre + satisfaccionHambre;
    }

    public int getSatisfaccionSuenno() {
        return satisfaccionSuenno;
    }

    public void setSatisfaccionSuenno(int satisfaccionSuenno) {
        this.satisfaccionSuenno = satisfaccionSuenno;
    }

    public void modSatisfaccionSuenno(int satisfaccionSuenno) {
        this.satisfaccionSuenno = this.satisfaccionSuenno + satisfaccionSuenno;
    }

    public int getSatisfaccionBano() {
        return satisfaccionBano;
    }

    public void setSatisfaccionBano(int satisfaccionBano) {
        this.satisfaccionBano = satisfaccionBano;
    }

    public void modSatisfaccionBano(int satisfaccionBano) {
        this.satisfaccionBano = this.satisfaccionBano + satisfaccionBano;
    }

    public int getSaludSocial() {
        return saludSocial;
    }

    public void setSaludSocial(int saludSocial) {
        this.saludSocial = saludSocial;
    }

    public void modSaludSocial(int saludSocial) {
        this.saludSocial = this.saludSocial + saludSocial;
    }

    public int getSaludFisica() {
        return saludFisica;
    }

    public void setSaludFisica(int saludFisica) {
        this.saludFisica = saludFisica;
    }

    public void modSaludFisica(int saludFisica) {
        this.saludFisica = this.saludFisica + saludFisica;
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
