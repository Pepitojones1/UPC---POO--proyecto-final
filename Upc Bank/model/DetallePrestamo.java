package model;

public class DetallePrestamo {
    private Integer idCredito;
    private float montoCuota;
    private Integer IndiceCuota;
    private String estado;
    private String fecVencimiento;

    public DetallePrestamo(Integer idCredito, float montoCuota, Integer indiceCuota, String estado, String fecVencimiento) {
        this.idCredito = idCredito;
        this.montoCuota = montoCuota;
        IndiceCuota = indiceCuota;
        this.estado = estado;
        this.fecVencimiento = fecVencimiento;
    }

    public Integer getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public float getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(float montoCuota) {
        this.montoCuota = montoCuota;
    }

    public Integer getIndiceCuota() {
        return IndiceCuota;
    }

    public void setIndiceCuota(Integer indiceCuota) {
        IndiceCuota = indiceCuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(String fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }
}
