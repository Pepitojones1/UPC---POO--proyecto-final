package model;

import java.util.List;

public class BaseBanco {

    private Integer idCredito;
    private String codigoAlumno;
    private String estadoPrestamo;
    private String fechaInicio;
    private String  tipoPrestamo;
    private List<DetallePrestamo> listaDetalleBaseBanco;

    public List<DetallePrestamo> getListaDetalleBaseBanco() {
        return listaDetalleBaseBanco;
    }

    public void setListaDetalleBaseBanco(List<DetallePrestamo> listaDetalleBaseBanco) {
        this.listaDetalleBaseBanco = listaDetalleBaseBanco;
    }

    public Integer getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Integer idCredito) {
        this.idCredito = idCredito;
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(String estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }
}


