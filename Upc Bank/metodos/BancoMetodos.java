package Metodos;

import model.BaseAlumno;
import model.BaseBanco;
import model.DetallePrestamo;
import model.TipoPrestamo;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class BancoMetodos {


    public void listarAlumnos( List<BaseAlumno> listaAlumnos){
        System.out.println("Listar todo los Alumnos");
        System.out.println("CODIGO DEL ALUMNO |   DNI   |   NOMBRE   | APELLIDOS |  PROMEDIO");

        for( BaseAlumno alumn :  listaAlumnos){

            System.out.println(alumn.getCodigoalumno()+ " | "  + alumn.getDni() + " | " + alumn.getNombre() + "  |   "+ alumn.getApellidos() + "   |  " + alumn.getPromedioActual() );
        }
    }

    public void listarCreditosAlumnnos ( List<BaseBanco> listaCreditos){
        System.out.println("Listar todo los Creditos de los Alumnos");
        System.out.println("ID Credito     |   CODIGO DEL ALUMNO   |   ESTADO PRESTAMO   | FECHA INICIO |  TIPO PRESTAMO");

        for( BaseBanco cred :  listaCreditos){

            System.out.println(cred.getIdCredito()+ " | "  + cred.getCodigoAlumno() + " | " + cred.getEstadoPrestamo() + "  |   "+ cred.getFechaInicio() + "   |  " + cred.getTipoPrestamo() );
        }
        System.out.println("");
    }

    public void cargarListaPrestamo(List<TipoPrestamo> listaTipoPrestamo) {

        TipoPrestamo tc1 = new TipoPrestamo("VIP", 20,18,2400,10, 12);
        TipoPrestamo tc2 = new TipoPrestamo("REGULAR", 17, 15,1600, 15, 12);
        TipoPrestamo tc3 = new TipoPrestamo("BASICO", 14,13,900, 20,12);

        listaTipoPrestamo.add(tc1);
        listaTipoPrestamo.add(tc2);
        listaTipoPrestamo.add(tc3);
    }

    public void cabeceraCredito(BaseBanco cred){
        System.out.println("--------------------------------");
        System.out.println(" ID CREDITO: " + cred.getIdCredito());
        System.out.println(" Codigo de Alumno: " + cred.getCodigoAlumno());
        System.out.println(" Estado Prestamo: " + cred.getEstadoPrestamo());
        System.out.println(" Fecha Inicio: " + cred.getFechaInicio());
        System.out.println(" Tipo Prestamo: " + cred.getTipoPrestamo());
    }

    public void detalleCredito(DetallePrestamo credDetalle ){
        System.out.println("--------------------------------");
        System.out.println("|  Nro Cuota : " +  credDetalle.getIndiceCuota());
        System.out.println("|  Monto Cuota : " +  credDetalle.getMontoCuota());
        System.out.println("|  Estado : " +  credDetalle.getEstado());
        System.out.println("|  Fecha Vencimiento : " +  credDetalle.getFecVencimiento());
    }

    public BaseAlumno buscarAlumnoPorCodigo(String codigoAlumno, List<BaseAlumno> listaAlumnos) {
        for(BaseAlumno alumno : listaAlumnos){
            if(alumno.getCodigoalumno().equals(codigoAlumno)){
                return alumno;
            }
        }
        return null;
    }

    public  String cadenaAleatoria(int longitud) {
        // El banco de caracteres
        String banco = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    public  String formatearCalendar(Calendar c) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        return df.format(c.getTime());
    }

    public void cargarAlumnosDefecto( List<BaseAlumno> listaAlumnos){
        //registrando alumnos y agregando
        BaseAlumno alumno1 = new BaseAlumno("u202121097", "73058335", "Johann", "Moreno Padilla");
        alumno1.setPromedioActual(19.9f);
        listaAlumnos.add(alumno1);

        BaseAlumno alumno2 = new BaseAlumno("u202013333","48054873","Rudi", "Aymara Quispe");
        alumno2.setPromedioActual(16.0f);
        listaAlumnos.add(alumno2);

        BaseAlumno alumno3 = new BaseAlumno("u20211332","12436547","Jenny", "Gomez Jimenez");
        alumno3.setPromedioActual(15.0f);
        listaAlumnos.add(alumno3);

        BaseAlumno alumno4 = new BaseAlumno("u201913331","45325076","Andrea", "Pinto Herrera");
        alumno4.setPromedioActual(13.0f);
        listaAlumnos.add(alumno4);

        BaseAlumno alumno5 = new BaseAlumno("u202313322","23045932","Gerardo", "Torres Guzman");
        alumno5.setPromedioActual(8.0f);
        listaAlumnos.add(alumno5);

        BaseAlumno alumno6 = new BaseAlumno("U202222170","23145912","Andres", "zevallos Huaman");
        alumno6.setPromedioActual(17.0f);
        listaAlumnos.add(alumno6);
    }
}
