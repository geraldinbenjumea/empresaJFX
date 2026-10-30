package co.edu.uniquindio.poo.empresajfx.model;

import java.util.ArrayList;
import java.util.List;

    public class Departamento {
        private String codigo;
        private String nombre;
        private List<Cliente> listaClientes;

        public Departamento(String codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.listaClientes = new ArrayList<>();
        }


        public String getCodigo() { return codigo; }
        public void setCodigo(String codigo) { this.codigo = codigo; }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public List<Cliente> getListaEmpleados() { return listaClientes; }
    }

