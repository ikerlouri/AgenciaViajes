package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBBDD extends Conector {

	Cliente cliente = new Cliente();

	public static ArrayList<Cliente> VER_SOCIOS() {
		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			conectar();
			Statement st = conexion.createStatement();

			String sentenciaSelect = "SELECT * FROM clientes";

			ResultSet resultado = st.executeQuery(sentenciaSelect);

			while (resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setDni(resultado.getString("dni"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setApellidos(resultado.getString("apellidos"));
				cliente.setDireccion(resultado.getString("direccion"));
				cliente.setLocalidad(resultado.getString("localidad"));

				clientes.add(cliente);

			}

			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientes;

	}

	public static void insertarClientes(Cliente cliente) {
		conectar();

		try {
			PreparedStatement preparedSt = conexion.prepareStatement(
					"INSERT INTO clientes (dni,nombre,apellidos,direccion,localidad) VALUES (?,?,?,?,?)");

			preparedSt.setString(1, cliente.getDni());
			preparedSt.setString(2, cliente.getNombre());
			preparedSt.setString(3, cliente.getApellidos());
			preparedSt.setString(4, cliente.getDireccion());
			preparedSt.setString(5, cliente.getLocalidad());
			preparedSt.execute();

			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Habitacion> verHabitaciones(int id_hotel) {
		ArrayList<Habitacion> habitaciones = new ArrayList<>();

		conectar();

		try {
			Statement st = conexion.createStatement();

			String sentenciaSelect = "SELECT * FROM habitaciones WHERE id_hotel =" + id_hotel;

			ResultSet resultado = st.executeQuery(sentenciaSelect);

			while (resultado.next()) {
				Habitacion habitacion = new Habitacion();
				habitacion.setId(resultado.getInt("id"));
				habitacion.setIdHotel(id_hotel);
				habitacion.setNumero(resultado.getString("numero"));
				habitacion.setDescripcion(resultado.getString("descripcion"));
				habitacion.setPrecio(resultado.getDouble("precio"));

				habitaciones.add(habitacion);
			}
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return habitaciones;

	}

	public static Hotel verHotel(String cif) {
		Hotel hotel = new Hotel();
		conectar();

		try {
			Statement st = conexion.createStatement();

			String sentenciaSelect = "SELECT * FROM hoteles WHERE cif =" + cif;

			ResultSet resultado = st.executeQuery(sentenciaSelect);

			while (resultado.next()) {

				hotel.setId(resultado.getInt("id"));
				hotel.setCif(resultado.getString("cif"));
				hotel.setNombre(resultado.getString("nombre"));
				hotel.setGerente(resultado.getString("gerente"));
				hotel.setEstrellas(resultado.getInt("estrellas"));
				hotel.setCompania(resultado.getString("compania"));
			}

			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotel;
	}
	
	public static void realizarReserva() {
		conectar();
		Reserva reserva = new Reserva();
		try {
			PreparedStatement preparedSt = conexion.prepareStatement("INSERT INTO reservas (id,id_habitacion,dni,desde,hasta) VALUES (?,?,?,?,?)");
		
		preparedSt.setInt(1, reserva.getId());
		preparedSt.setInt(2, reserva.getId());
		preparedSt.setString(3, reserva.getDni());
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
