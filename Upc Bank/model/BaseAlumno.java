package model;

public class BaseAlumno extends Persona{

    private String codigoalumno;
    private float promedioActual;

    public BaseAlumno() {
        super();
        this.promedioActual = 0;
    }

    public BaseAlumno(String codigoalumno, String dni, String nombre, String apellidos) {
        super(dni,nombre,apellidos);
        this.codigoalumno = codigoalumno;
        this.promedioActual = 0;
    }

    public String getCodigoalumno() {
        return codigoalumno;
    }

    public void setCodigoalumno(String codigoalumno) {
        this.codigoalumno = codigoalumno;
    }

    public float getPromedioActual() {
        return promedioActual;
    }

    public void setPromedioActual(float promedioActual) {
        this.promedioActual = promedioActual;
    }

}
