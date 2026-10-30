package co.edu.uniquindio.poo.empresajfx.model;

import java.util.*;

public class Empresa {
    private String nombre;
    private Collection<Cliente> clientes;
    private List<Departamento> listaDepartamentos = new ArrayList<>();

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }
    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellido(actualizado.getApellido());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean agregarDepartamento(Departamento departamento) {
        boolean centinela = false;
        if (buscarDepartamento(departamento.getCodigo()).isPresent()) {
            System.out.println("El departamento ya esta registrado");
            return centinela;
        }else{
            listaDepartamentos.add(departamento);
            centinela = true;
        }
        return centinela;
    }

    public Optional<Departamento> buscarDepartamento(String codigo) {
        return listaDepartamentos.stream()
                .filter(d -> d.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public boolean actualizarDepartamento(String codigo, String nuevoNombre, Departamento departamento) {
        if (buscarDepartamento(departamento.getCodigo()).isPresent()) {
            departamento.setNombre(nuevoNombre);
            return true;
        }
        return false;
    }

    public String eliminarDepartamento ( Departamento departamento){
        if (buscarDepartamento(departamento.getCodigo()).isPresent()){
            listaDepartamentos.remove(departamento);
            return "El departamento se ha eliminado";
        }
        else{
            return  "El departamento no esta registrado";
        }
    }
}
