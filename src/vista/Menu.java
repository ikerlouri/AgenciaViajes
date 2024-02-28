package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cliente;
import modelo.GestorBBDD;
import modelo.Habitacion;
import modelo.Hotel;

public class Menu {

	public static int VER_CLIENTES = 1;
	public static int INSERTAR_CLIENTES = 2;
	public static int VER_HABITACIONES_HOTEL = 3;
	public static int REALIZAR_RESERVA = 4;

	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion;
		String cif;
		Cliente cliente;
		Hotel hotel;
		int id;
		int id_hotel;
		ArrayList<Cliente> clientes = new ArrayList<>(); 
		ArrayList<Habitacion> habitaciones = new ArrayList<>(); 
		do {

			System.out.println("----Menu----");
			System.out.println(VER_CLIENTES + " " + "VER CLIENTES");
			System.out.println(INSERTAR_CLIENTES + " " + "INSERTAR CLIENTE");
			System.out.println(VER_HABITACIONES_HOTEL + " " + "VER HABITACIONES DE HOTEL CON SU CIF");
			System.out.println(REALIZAR_RESERVA + " " + "REALIZAR UNA RESERVA");

			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case 1:
				
				clientes = GestorBBDD.VER_CLIENTES();
				Visor.visualizarClientes(clientes);
				clientes.sort(new Comparador());
				System.out.println("/n");
				Visor.visualizarClientes(clientes);
				break;
			case 2:
				cliente = Formulario.pedirDatosCliente();
				GestorBBDD.insertarClientes(cliente);
				System.out.println("Cliente insertado correctamente");
				break;
			case 3:
				cif = Formulario.pedirCifHotel();
				hotel = GestorBBDD.verHotel(cif);
				Visor.visualizarHotel(hotel);
				id_hotel = hotel.getId();
				habitaciones = GestorBBDD.verHabitaciones(id_hotel);
				Visor.visualizarHabitaciones(habitaciones);
				break;

			}
		} while (opcion != 0);
	}
}
