package logica.enumera;

public enum TipoServicio {
    HOTELNOCHE("Noche de hotel"),
    ALQUILERAUTO("Alquiler de auto"),
    PASAJECOLECTIVO("Pasaje de colectivo"),
    PASAJEAVION("Pasaje de avión"),
    PASAJETREN("Pasaje en tren"),
    EXCURSIONES("Excursiones"),
    ENTRADAS("Evento"),
    ;
    
    private String tipo;
    
    private TipoServicio(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoServicio{" + "tipo=" + tipo + '}';
    }
    
   
}
