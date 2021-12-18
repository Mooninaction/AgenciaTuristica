package logica.enumera;

public enum TipoContratacion {
    IND("individual"),
    PAQ("paquete");

    private String tipo;

    private TipoContratacion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoContratacion() {
        return this.tipo;

    }
}
