package vista;

import java.util.Scanner;

import modelo.Cliente;
import modelo.Reserva;

public class Formulario {
	
	Scanner scan = new Scanner(System.in);
	
	public static Cliente pedirDatosCliente() {
		Scanner scan = new Scanner(System.in);
		Cliente cliente = new Cliente();
		System.out.println("Introduce tu dni:");
		cliente.setDni(scan.nextLine());
		System.out.println("Introduce tu nombre:");
		cliente.setNombre(scan.nextLine());
		System.out.println("Introduce tus apellidos:");
		cliente.setApellidos(scan.nextLine());
		System.out.println("Introduce tu direccion:");
		cliente.setDireccion(scan.nextLine());
		System.out.println("Introduce tu localidad:");
		cliente.setLocalidad(scan.nextLine());
		return cliente;
	}

	public static String pedirCifHotel(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el cif del hotel que quieras ver las habitaciones");
		String cif = scan.nextLine();
		return cif;
		
	}
	
	public static Reserva pedirDatosReserva() {
		Scanner scan = new Scanner(System.in);
		Reserva reserva = new Reserva();
		System.out.println("Introuce el id de la habitacion que quieras reservar:");
		reserva.setId_habitacion(Integer.parseInt(scan.nextLine()));
		System.out.println("Introduce tu dni:");
		reserva.setDni(scan.nextLine());
		System.out.println("Introduce desde que fecha quieres reservar:");
		reserva.setDesde(null);
		System.out.println("Introduce hasta que fecha quieres reservar:");
		reserva.setHasta(null);
		return reserva;
	}
		
}
