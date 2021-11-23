package TimeChecker;

public class Reloj {
    // Datos de configuración
    private int segundosMaximo = 6;
    private int minutosMaximo = 6;
    private int horasMaximo = 6;
    private int diasMaximo = 4;

    // contadores.
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    private int dias = 0;
    private int anios = 0;

    private Logger logger = new Logger();
    private Partida partida;

    public Reloj(Partida partida){
        segundosMaximo = 60;
        minutosMaximo = 60;
        horasMaximo = 24;
        diasMaximo = 365;
        this.partida = partida;
//        System.out.println(partida.);

    }

    public Reloj(Partida partida, int segundosMaximo, int minutosMaximo, int horasMaximo, int diasMaximo){
        this.segundosMaximo = segundosMaximo;
        this.minutosMaximo = minutosMaximo;
        this.horasMaximo = horasMaximo;
        this.diasMaximo = diasMaximo;
        this.partida = partida;
        System.out.println(partida.tex);
    }

    public Logger getLogger() {
        return logger;
    }

    public int getSegundosMaximo() {
        return segundosMaximo;
    }

    public void setSegundosMaximo(int segundosMaximo) {
        this.segundosMaximo = segundosMaximo;
    }

    public int getMinutosMaximo() {
        return minutosMaximo;
    }

    public void setMinutosMaximo(int minutosMaximo) {
        this.minutosMaximo = minutosMaximo;
    }

    public int getHorasMaximo() {
        return horasMaximo;
    }

    public void setHorasMaximo(int horasMaximo) {
        this.horasMaximo = horasMaximo;
    }

    public int getDiasMaximo() {
        return diasMaximo;
    }

    public void setDiasMaximo(int diasMaximo) {
        this.diasMaximo = diasMaximo;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public void aumentar(){
        segundos++;
        if (segundos == segundosMaximo){
            segundos = 0;
            minutos++;
            if (minutos == minutosMaximo){
                minutos = 0;
                horas++;
                if (horas == horasMaximo){
                    horas = 0;
                    System.out.println(partida);
                    String partidaSerializada = logger.serializarObjeto(logger);
                    logger.guardarDia(dias, anios, "src/TimeChecker/Dias/", partidaSerializada);
                    logger.saveJson("src/TimeChecker/Dias/dias.json");
                    dias++;
                    if (dias == diasMaximo){
                        dias = 0;
                        anios++;
                    }
                }
            }
        }
    }

    public String verHora(){
        String tiempo = "Segundos: " + segundos;
            tiempo += ", Minutos: " + minutos;
            tiempo += ", Horas: " + horas;
            tiempo += ", Días: " + dias;
            tiempo += ", Años: " + anios;
        return tiempo;
    }

}
