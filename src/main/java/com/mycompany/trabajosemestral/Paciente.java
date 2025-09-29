package com.mycompany.trabajosemestral;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Paciente {

    public String rutP;
    public String nombreP;
    public Date fechaNacimientoP;
    public String sexo;

    public Paciente(String rutP, String nombreP, Date fechaNacimientoP, String sexo) {

        if (rutP == null || rutP.trim().isEmpty()) {
            throw new IllegalArgumentException("El RUT no puede ser nulo ni vacio");
        }
        if (nombreP == null || nombreP.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacio");
        }
        if (fechaNacimientoP == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        if (sexo == null || sexo.trim().isEmpty()) {
            throw new IllegalArgumentException("El sexo no puede ser nulo ni vacio");
        }

        this.rutP = rutP;
        this.nombreP = nombreP;
        this.fechaNacimientoP = fechaNacimientoP;
        this.sexo = sexo;
    }

    public void registrar(List<Paciente> p, Paciente nuevoPaciente) {

        if (p.contains(nuevoPaciente) == false) {
            p.add(nuevoPaciente);
            System.out.println("El paciente se ha registrado correctamente");
        } else {
            System.out.println("El paciente se ha registrado anteriormente");
        }
    }

    public void eliminar(List<Paciente> listaPacientes, List<CitaMedica> listaCitas, Paciente pacienteAEliminar) {

        if (listaPacientes.remove(pacienteAEliminar)) {
            for (int i = 0; i < listaCitas.size(); i++) {
                CitaMedica cm = listaCitas.get(i);
                if (cm.paciente != null && cm.paciente.equals(pacienteAEliminar)) {
                    listaCitas.remove(i);
                    i--;
                }
            }
            System.out.println("Paciente y citas asociadas eliminados");
        } else {
            System.out.println("El paciente no estaba registrado");
        }
    }

    public void modificar(List<Paciente> lista, Paciente pacienteAModificar, String rut, String nombre, Date fechaNac, String sexo) {

        int idx = lista.indexOf(pacienteAModificar);

        if (idx != -1) {
            Paciente p = lista.get(idx);
            p.rutP = rut;
            p.nombreP = nombre;
            p.fechaNacimientoP = fechaNac;
            p.sexo = sexo;
            System.out.println("El paciente se ha modificado correctamente");
        } else {
            System.out.println("El paciente no estaba registrado");
        }
    }

    @Override
    public String toString() {

        //NECESARIO PARA DEJAR MAS LIMPIO AL EJECUTAR EL CODIGO
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String fechaSTR = (fechaNacimientoP != null)
                ? sdf.format(fechaNacimientoP)
                : "N/A";

        return "\nPaciente:"
                + "\n  Rut       : " + rutP
                + "\n  Nombre    : " + nombreP
                + "\n  FechaNac  : " + fechaSTR
                + "\n  Sexo      : " + sexo
                + "\n-----------------------------";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Paciente otro = (Paciente) obj;
        return rutP != null && rutP.equals(otro.rutP);
    }
}
