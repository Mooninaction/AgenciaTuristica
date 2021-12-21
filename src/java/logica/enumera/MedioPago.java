package logica.enumera;

public enum MedioPago {

    EFECTIVO("Efectivo", 0.0),
    DEBITO("Débito", 0.03),
    CREDITO("Crédito", 0.09),
    TRANSFERENCIA("Transferencia", 2.45);

    private String medio;
    private double comision;

    private MedioPago(String medio, double comision) {
        this.medio = medio;
        this.comision = comision;
    }

    public String getMedio() {
        return this.medio;

    }

    public double getComision() {
        return this.comision;
    }
}
