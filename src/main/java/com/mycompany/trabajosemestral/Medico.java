package com.mycompany.trabajosemestral;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Medico {

    public String rutM;
    public String nombreM;
    public Date fechaNacimientoM;
    public String especialidad;

    public Medico(String rutM, String nombreM, Date fechaNacimientoM, String especialidad) {
        if (rutM == null || rutM.trim().isEmpty()) {
            throw new IllegalArgumentException("El RUT no puede ser nulo ni vacio");
        }
        if (nombreM == null || nombreM.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacio");
        }
        if (fechaNacimientoM == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede ser nulo ni vacio");
        }

        this.rutM = rutM;
        this.nombreM = nombreM;
        this.fechaNacimientoM = fechaNacimientoM;
        this.especialidad = especialidad;
    }

    public void registrar(List<Medico> m, Medico nuevoMedico) {

        if (m.contains(nuevoMedico) == false) {
            m.add(nuevoMedico);
            System.out.println("El medico se ha registrado correctamente");
        } else {
            System.out.println("El medico se ha registrado anteriormente");
        }

    }

    public void eliminar(List<Medico> listaM, List<CitaMedica> listaCM, Medico medicoAEliminar) {

        if (listaM.remove(medicoAEliminar)) {
            for (int i = 0; i < listaCM.size(); i++) {
                CitaMedica cm = listaCM.get(i);
                if (cm.medico != null && cm.medico.equals(medicoAEliminar)) {
                    listaCM.remove(i);
                    i--;
                }
            }
            System.out.println("Medico y citas asociadas eliminados");
        } else {
            System.out.println("El medico no estaba registrado");
        }
    }

    public void modificar(List<Medico> lista, Medico medicoAModificar, String rut, String nombre, Date fechaNac, String esp) {

        int idx = lista.indexOf(medicoAModificar);

        if (idx != -1) {
            Medico m = lista.get(idx);
            m.rutM = rut;
            m.nombreM = nombre;
            m.fechaNacimientoM = fechaNac;
            m.especialidad = esp;
            System.out.println("El medico se ha modificado correctamente");
        } else {
            System.out.println("El medico no estaba registrado");
        }
    }

    @Override
    public String toString() {

        //NECESARIO PARA DEJAR MAS LIMPIO AL EJECUTAR EL CODIGO
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String fechaSTR = (fechaNacimientoM != null)
                ? sdf.format(fechaNacimientoM)
                : "N/A";

        return "\n Medico:"
                + "\n  Rut          : " + rutM
                + "\n  Nombre       : " + nombreM
                + "\n  FechaNac     : " + fechaSTR
                + "\n  Especialidad : " + especialidad
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
        Medico otro = (Medico) obj;
        return rutM != null && rutM.equals(otro.rutM);
    }

}
