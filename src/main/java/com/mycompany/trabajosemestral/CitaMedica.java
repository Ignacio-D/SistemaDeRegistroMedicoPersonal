package com.mycompany.trabajosemestral;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CitaMedica {

    public Date fecha;
    public Time hora;
    public String lugar;
    public Paciente paciente;
    public Medico medico;

    public CitaMedica(Date fecha, Time hora, String lugar, Paciente paciente, Medico medico) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nulo ni vacio");
        }
        if (hora == null) {
            throw new IllegalArgumentException("La hora no puede ser nulo ni vacio");
        }
        if (lugar == null) {
            throw new IllegalArgumentException("El lugar no puede ser nulo");
        }
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo ni vacio");
        }
        if (medico == null) {
            throw new IllegalArgumentException("El medico no puede ser nulo ni vacio");
        }

        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.paciente = paciente;
        this.medico = medico;
    }

    public void registrar(List<CitaMedica> citas, List<Paciente> pacientes, List<Medico> medicos, CitaMedica cm) {

        if (!pacientes.contains(cm.paciente)) {
            System.out.println("No se puede registrar la cita: paciente no esta registrado");
            return;
        }
        if (!medicos.contains(cm.medico)) {
            System.out.println("No se puede registrar la cita: medico no esta registrado");
            return;
        }

        citas.add(cm);
        System.out.println("Cita registrada correctamente");
    }

    public void eliminar(List<CitaMedica> citas, CitaMedica cm) {
        if (citas.remove(cm)) {
            System.out.println("Cita eliminada correctamente");
        } else {
            System.out.println("La cita no estaba registrada");
        }
    }

    public void modificar(List<CitaMedica> citas, List<Paciente> pacientes, List<Medico> medicos, CitaMedica cmAModificar, Date nuevaFecha, Time nuevaHora, String nuevoLugar, Paciente nuevoPaciente, Medico nuevoMedico) {

        int idx = citas.indexOf(cmAModificar);
        if (idx == -1) {
            System.out.println("La cita no estaba registrada");
            return;
        }

        // 2) validaciones obligatorias (no nulos)
        if (nuevaFecha == null || nuevaHora == null || nuevoPaciente == null || nuevoMedico == null) {
            System.out.println("No se puede modificar con valores nulos");
            return;
        }

        if (!pacientes.contains(nuevoPaciente)) {
            System.out.println("No se puede modificar la cita: paciente no esta registrado");
            return;
        }
        if (!medicos.contains(nuevoMedico)) {
            System.out.println("No se puede modificar la cita: médico no esta registrado");
            return;
        }

        CitaMedica c = citas.get(idx);
        c.fecha = nuevaFecha;
        c.hora = nuevaHora;
        c.lugar = nuevoLugar;
        c.paciente = nuevoPaciente;
        c.medico = nuevoMedico;

        System.out.println("Cita modificada correctamente");
    }

    @Override
    public String toString() {

        //NECESARIO PARA DEJAR MAS LIMPIO AL EJECUTAR EL CODIGO
        SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

        return "\nCitaMedica:"
                + "\n Fecha   : " + sdfFecha.format(fecha)
                + "\n Hora    : " + sdfHora.format(hora)
                + "\n Lugar   : " + lugar
                + "\n  " + paciente
                + "\n " + medico
                + "\n-----------------------------";
    }

}
