package Strategy;

import Consumibles.Alimento;
import Consumibles.EnumTipoAlimento;
import ModuloPelea.ModuloPersonajes.Jugador;


public class ControladorComer implements IControlerStrategy{

    Object comida;//Cambiar a comida

    @Override
    public void satisfacer(){
        int mejora = ((Alimento)Jugador.getInstance().consumible).getPuntosEnergía(); // consumible.getmejora()
        EnumTipoAlimento tipo = ((Alimento)Jugador.getInstance().consumible).getTipo();
        if(tipo == EnumTipoAlimento.LIQUIDO)
            Jugador.getInstance().controladorSalud.modLiquidosConsumidos(1);
        else if(tipo == EnumTipoAlimento.SOLIDO)
            Jugador.getInstance().controladorSalud.modSolidosConsumidos(1);
        Jugador.getInstance().controladorSalud.modSatisfaccionHambre(mejora);
        Jugador.getInstance().controladorSalud.modSatisfaccionSuenno(mejora/2);
        Jugador.getInstance().controladorSalud.modSatisfaccionBano(-mejora);
        Jugador.getInstance().controladorSalud.modSaludSocial(-10);
        Jugador.getInstance().controladorSalud.modSaludFisica(-15);

        Jugador.getInstance().controladorSalud.verificar();
    }

    public void setComida(Object comida){
        this.comida = comida;
    }
}
