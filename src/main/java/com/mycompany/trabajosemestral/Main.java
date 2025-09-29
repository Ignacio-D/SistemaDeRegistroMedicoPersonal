package com.mycompany.trabajosemestral;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Time;

public class Main {

    public static void main(String[] args) throws ParseException {
        List<Paciente> pacientes = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();
        List<CitaMedica> citasMedicas = new ArrayList<>();

        //PARA DAR FORMATO A LAS FECHAS DE NACIMIENTO
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //CREACION DE FECHAS QUE SE OCUPARAN EN LOS OBJETOS 
        Date fechaNacP1 = sdf.parse("15/03/1995");
        Date fechaNacP2 = sdf.parse("08/11/1997");
        Date fechaNacM1 = sdf.parse("21/07/1985");
        Date fechaNacM2 = sdf.parse("02/01/1988");

        //CREACION DE FECHAS QUE SE OCUPARAN EN LOS OBJETOS
        Date fechaCita1 = sdf.parse("20/09/2025");
        Date fechaCita2 = sdf.parse("21/09/2025");

        //CREACION DE HORAS QUE SE OCUPARAN EN LOS OBJETOS
        Time horaCita1 = Time.valueOf("10:30:00");
        Time horaCita2 = Time.valueOf("11:15:00");

        Paciente p1 = new Paciente("21.412.601-5", "Ignacio Duran", fechaNacP1, "Masculino");
        Paciente p2 = new Paciente("22.412.601-1", "Amaro Godoy", fechaNacP2, "Masculino");

        Medico m1 = new Medico("20.412.321-4", "Alvaro Diaz", fechaNacM1, "Nutricionista");
        Medico m2 = new Medico("19.788.321-4", "Cristian Ruiz", fechaNacM2, "Kinesiologo");

        CitaMedica cm1 = new CitaMedica(fechaCita1, horaCita1, "Concepcion", p1, m1);
        CitaMedica cm2 = new CitaMedica(fechaCita2, horaCita2, "Concepcion", p2, m2);

        p1.registrar(pacientes, p1);
        m1.registrar(medicos, m1);
        cm1.registrar(citasMedicas, pacientes, medicos, cm1);
        p1.modificar(pacientes, p1, "21.412.601-4", "Ignacio Duran", fechaNacP1, "Masculino");

        p2.registrar(pacientes, p2);
        cm2.registrar(citasMedicas, pacientes, medicos, cm2);

        System.out.println(pacientes);
        System.out.println(medicos);
        System.out.println(citasMedicas);
    }
}
