package model;

public class TipoPrestamo {
    private String codigo;
    private float notaMaxima;
    private float notaMinima;
    private float  monto;
    private Integer porcentajeInteres;
    private Integer nroCuota;

    public TipoPrestamo(String codigo, float notaMaxima, float notaMinima, float monto, Integer porcentajeInteres, Integer nroCuota) {
        this.codigo = codigo;
        this.notaMaxima = notaMaxima;
        this.notaMinima = notaMinima;
        this.monto = monto;
        this.porcentajeInteres = porcentajeInteres;
        this.nroCuota = nroCuota;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getNotaMaxima() {
        return notaMaxima;
    }

    public void setNotaMaxima(float notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    public float getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(float notaMinima) {
        this.notaMinima = notaMinima;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Integer getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public void setPorcentajeInteres(Integer porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }

    public Integer getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(Integer nroCuota) {
        this.nroCuota = nroCuota;
    }
}
