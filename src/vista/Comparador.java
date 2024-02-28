package vista;

import java.util.Comparator;

import modelo.Cliente;


public class Comparador implements Comparator<Cliente>{

	@Override
	public int compare(Cliente o1, Cliente o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}