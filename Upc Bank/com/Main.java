package com.upc.banco;

import Metodos.BancoMetodos;
import model.BaseAlumno;
import model.BaseBanco;
import model.DetallePrestamo;
import model.TipoPrestamo;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        BancoMetodos bmetodos = new BancoMetodos();
        List<BaseAlumno> listaAlumnos = new ArrayList<>();
        List<BaseBanco> listaCreditos = new ArrayList<>();
        List<TipoPrestamo> listaTipoPrestamo = new ArrayList<>();

        bmetodos.cargarListaPrestamo(listaTipoPrestamo);
        bmetodos.cargarAlumnosDefecto(listaAlumnos);

        // parametro de opcion
        int i = 0;

        do {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("Bienvenido");
                System.out.println("Ingrese el codigo para realizar la siguiente acción: ");

                System.out.println("1.- Ingresar alumno nuevo");
                System.out.println("2.- Buscar Alumno de la UPC");
                System.out.println("3.- Registrar Credito del alumno con la UPC");
                System.out.println("4.- Listar Todo los Alumnos");
                System.out.println("5.- Listar Creditos de todos los Alumnos");
                System.out.println("6.- Registrar Pagos");
                System.out.println("7.- Salir");
                /* ------------------   */
                System.out.println("--------------------------------");
                System.out.println("Código seleccionado: ");

                i = sc.nextInt();
            }catch (Exception e){
                System.out.println("Lo ingresado no es una de nuestras opciones, por favor ingresar un valor numerico correcto.");
                i=0;
            }

            switch(i) {
                case 1:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Ingrese la siguiente informacion del Alumno");
                    System.out.println("Nombre alumnno: ");
                    System.out.println("--------------------------------");
                    String nombre = sc1.nextLine();


                    System.out.println("Apellidos alumno");
                    System.out.println("--------------------------------");
                    String apellidos = sc1.nextLine();


                    System.out.println("Ingrese DNI");
                    System.out.println("--------------------------------");
                    String dni = sc1.nextLine();

                    //Creando el objeto del alumno e ingresando los valores tipeados.

                    BaseAlumno alumno = new BaseAlumno();
                    alumno.setNombre(nombre);
                    alumno.setApellidos(apellidos);
                    alumno.setDni(dni);

                    String generatedString = bmetodos.cadenaAleatoria(7);
                    alumno.setCodigoalumno(generatedString);

                    // Estamos ingresando en la lista de alumnos
                    listaAlumnos.add(alumno);
                    alumno.bienvenido();
                    System.out.println("Se registro correctamente el alumno con codigo: " + generatedString );
                    System.out.println("--------------------------------");
                    break;
                case 2:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Ingrese DNI del alumno");
                    System.out.println("--------------------------------");
                    String documento = sc2.nextLine();
                    for(BaseAlumno alumn : listaAlumnos ){
                        if(alumn.getDni().equals(documento)){
                            System.out.println("Codigo alumno: " + alumn.getCodigoalumno() );
                            System.out.println("Codigo nombre: " + alumn.getNombre() );
                            System.out.println("Codigo apellidos: " + alumn.getApellidos() );
                            System.out.println("Promedio Actual: " + alumn.getPromedioActual() );

                            if(alumn.getPromedioActual() == 0){
                                System.out.println("Deseas agregar Promedio actual del alumno? S / N");
                                Scanner scResp = new Scanner(System.in);
                                String resp = scResp.nextLine();
                                if(resp.equals("S")){
                                    System.out.println("Ingrese la nota del alumno " + alumn.getNombre());
                                    float notaPromedio = sc2.nextFloat();
                                    alumn.setPromedioActual(notaPromedio);
                                }

                            }
                        }
                    }

                    System.out.println("--------------------------------");
                    break;
                case 3:
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("Ingresa el codigo del alumno:");
                    String respt = sc3.nextLine();

                    /* evaluar credito: Esta validacion, filtra a los creditos que puede haber tenido el alumno pero estan cancelados,
                    * si estan vigente entonces no deberia permitirle crear otro credito vigente */
                    String listaCreditosAlumno = "";
                    for(BaseBanco credito :  listaCreditos ){
                        if(respt.equals(credito.getCodigoAlumno()) && credito.getEstadoPrestamo().equals("vigente") ){
                            listaCreditosAlumno = listaCreditosAlumno + credito.getIdCredito().toString() + " " ;
                        }
                    }

                    /* VALIDACION*/
                    if(listaCreditosAlumno.equals("")){
                        System.out.println("No cuenta creditos con nosotros");
                        System.out.println("--------------------------------");
                        BaseAlumno balumno =  bmetodos.buscarAlumnoPorCodigo(respt, listaAlumnos);
                        // Validacion que el alumno debe estar registrado.
                        if(balumno!= null) {

                            // Solo reciben creditos los alumnos mayores e igual a 13
                            if (balumno.getPromedioActual() < 13) {
                                System.out.println("No califica para el prestamo");
                            } else {
                                for (TipoPrestamo tprestamo : listaTipoPrestamo) {
                                    // validando rangos de promedio de nota para asignar el tipo de prestamo A, B o C
                                    if (tprestamo.getNotaMaxima() >= balumno.getPromedioActual() && tprestamo.getNotaMinima() < balumno.getPromedioActual()) {
                                        System.out.println("Usted cuenta con un prestamo pre-aprobado");
                                        System.out.println(" ");
                                        System.out.println("Monto :" + tprestamo.getMonto());
                                        System.out.println("Intereses :" + tprestamo.getPorcentajeInteres() + "%");
                                        System.out.println("Nro cuotas :" + tprestamo.getNroCuota());
                                        System.out.println("--------------------------------");

                                        System.out.println("Usted desea acceder al credito estudiantil: S / N");
                                        String respuestaCredito = sc3.nextLine();
                                        if (respuestaCredito.equals("S")) {
                                            System.out.println("----Creando registro Banco------------");
                                            BaseBanco bBancoEstudiante = new BaseBanco();
                                            bBancoEstudiante.setCodigoAlumno(balumno.getCodigoalumno());

                                            Calendar c = Calendar.getInstance();
                                            String date = bmetodos.formatearCalendar(c);
                                            bBancoEstudiante.setFechaInicio(date);
                                            bBancoEstudiante.setTipoPrestamo(tprestamo.getCodigo());
                                            bBancoEstudiante.setIdCredito(listaCreditos.size() + 1);
                                            bBancoEstudiante.setEstadoPrestamo("vigente");

                                            System.out.println("---Registrando Detalle-----");

                                            float cuotaMensual = (tprestamo.getMonto() * ((tprestamo.getPorcentajeInteres() + 100)/100) ) / tprestamo.getNroCuota();
                                            List<DetallePrestamo> listaCreditosDetalle = new ArrayList<>();
                                            for (int k = 0; k < 12; k++) {
                                                // aca se le aumenta 1 mes cada vez q retorna del for
                                                c.add(Calendar.MONTH, 1);
                                                DetallePrestamo dp = new DetallePrestamo(listaCreditos.size() + 1, cuotaMensual, k + 1, "pendiente", bmetodos.formatearCalendar(c));
                                                listaCreditosDetalle.add(dp);
                                            }


                                            bBancoEstudiante.setListaDetalleBaseBanco(listaCreditosDetalle);
                                            listaCreditos.add(bBancoEstudiante);
                                            System.out.println("---Registro exitoso-----");
                                            System.out.println("");
                                            System.out.println("Presione enter para continuar");
                                            Scanner sc6 = new Scanner(System.in);
                                            sc6.nextLine();
                                        }

                                        System.out.println("--------------------------------");

                                    }
                                }
                            }
                        }else{
                            System.out.println("El código del alumno " + respt + "no es valido");
                        }


                    }else{
                        System.out.println("El alumno " + respt +" cuenta con los siguientes creditos: " + listaCreditosAlumno);
                    }





                    System.out.println("--------------------------------");
                    break;
                case 4:
                    bmetodos.listarAlumnos(listaAlumnos);
                    System.out.println("");
                    System.out.println("Presione enter para continuar");
                    Scanner sc4 = new Scanner(System.in);
                    sc4.nextLine();

                    System.out.println("--------------------------------");
                    break;

                case 5:
                    bmetodos.listarCreditosAlumnnos(listaCreditos);
                    System.out.println("Ingrese el ID Credito si requiere ver el detalle, en caso de no Presione 'N' : ");
                    Scanner sc5 = new Scanner(System.in);
                    String idCredito = sc5.nextLine();

                    if(!idCredito.equals("N")){

                        for( BaseBanco cred :  listaCreditos){
                             // compara los id de credito con el ingresado por el usuario, pero antes tranforma
                             // un Integer en String para poder compararlos
                            if(idCredito.equals(String.valueOf(cred.getIdCredito()))){

                                bmetodos.cabeceraCredito(cred);

                                for( DetallePrestamo credDetalle :  cred.getListaDetalleBaseBanco()) {
                                    bmetodos.detalleCredito(credDetalle);
                                }
                            }
                        }

                        System.out.println("");
                        System.out.println("Presione enter para continuar");
                        Scanner sc6 = new Scanner(System.in);
                        sc6.nextLine();

                    }

                    System.out.println("--------------------------------");
                    break;
                case 6:
                    Scanner sc7 = new Scanner(System.in);
                    System.out.println("Ingrese el codigo del alumno");
                    System.out.println("--------------------------------");
                    String codiAlumno = sc7.nextLine();


                    for( BaseBanco cred :  listaCreditos){

                        if(codiAlumno.equals(cred.getCodigoAlumno()) && cred.getEstadoPrestamo().equals("vigente")){

                            bmetodos.cabeceraCredito(cred);

                            // Esta variable es para saber cuantas cuotas me falta pagar
                            int cuotasPorPagar= 0;

                            for( DetallePrestamo credDetalle :  cred.getListaDetalleBaseBanco()) {
                                if(credDetalle.getEstado().equals("pendiente")){
                                    cuotasPorPagar++;
                                    bmetodos.detalleCredito(credDetalle);
                                }

                            }
                            System.out.println("--------------------------------");
                            System.out.println("¿Cuantas cuotas va a cancelar? Escriba el nro de cuotas :");
                            Scanner sc8 = new Scanner(System.in);
                            int cuotasCanceladas = sc8.nextInt();
                            int contadorNoExederCuotasPlaneadas = 0;
                                for( DetallePrestamo credDetalle :  cred.getListaDetalleBaseBanco()) {
                                    if(credDetalle.getEstado().equals("pendiente") && contadorNoExederCuotasPlaneadas < cuotasCanceladas) {
                                        credDetalle.setEstado("pagado");
                                        contadorNoExederCuotasPlaneadas++;
                                    }
                                }

                             // cambia el estado del credito de vigente a cancelado
                            if(cuotasPorPagar <= cuotasCanceladas){
                                cred.setEstadoPrestamo("cancelado");
                            }
                            System.out.println("Cuotas actualizadas");
                        }
                    }
                    System.out.println("Presione enter para continuar");
                    Scanner sc9 = new Scanner(System.in);
                    String salida = sc9.nextLine();

                    System.out.println("--------------------------------");
                    break;

                default:
                    System.out.println("Salida exitosa");
            }
        }while(i != 7);

    }

}