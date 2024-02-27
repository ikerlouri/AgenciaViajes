package vista;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Habitacion;
import modelo.Hotel;

public class Visor {

	public static void visualizarClientes(ArrayList<Cliente> clientes) {
		for(Cliente cliente : clientes)
		System.out.println(cliente.toString());
	}
	public static void visualizarHotel(Hotel hotel) {
		System.out.println(hotel.toString());
	}
	public static void visualizarHabitaciones(ArrayList<Habitacion> habitaciones) {
		for(Habitacion habitacion : habitaciones) {
			System.out.println(habitacion.toString());
		}
	}
}

