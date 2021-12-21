package logica.enumera;

public enum tipoServicio {
    HOTELNOCHE("Noche de hotel"),
    ALQUILERAUTO("Alquiler de auto"),
    PASAJECOLECTIVO("Pasaje de colectivo"),
    PASAJEAVION("Pasaje de avión"),
    PASAJETREN("Pasaje en tren"),
    EXCURSIONES("Excursiones"),
    ENTRADAS("Evento"),
    ;
    
    private String tipo;
    
    private tipoServicio(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
   
}
