package Strategy;

import ModuloPelea.ModuloPersonajes.Jugador;


public class ControladorComer implements IControlerStrategy{

    Object comida;//Cambiar a comida

    @Override
    public void satisfacer(){ //TODO Aumentar Liquidos y Solidos consumidos
        //Consumible consumible = Bodega.getInstance().getConsumible(); //TODO ver como hacer que agarre uno especifico
        int mejora = 0; // consumible.getmejora()
        Jugador.getInstance().controladorSalud.modSatisfaccionHambre(20);
        Jugador.getInstance().controladorSalud.modSatisfaccionSuenno(mejora/2);
        Jugador.getInstance().controladorSalud.modSatisfaccionBano(-20);
        Jugador.getInstance().controladorSalud.modSaludSocial(-10);
        Jugador.getInstance().controladorSalud.modSaludFisica(-15);

        Jugador.getInstance().controladorSalud.verificar();
    }

    public void setComida(Object comida){
        this.comida = comida;
    }
}
