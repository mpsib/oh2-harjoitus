package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Balsalevy;

public class JDBCBalsalevyDao implements BalsalevyDao {

	@Override
	public List<Balsalevy> getAllItems() {
		List<Balsalevy> balsalevyt = new ArrayList<Balsalevy>();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = Database.connect();
			String queryString = "SELECT * FROM Balsalevy";
			PreparedStatement query = connection.prepareStatement(queryString);
			ResultSet results = query.executeQuery();
			while (results.next()) {
				long id = results.getLong("id");
				double tiheys = results.getDouble("tiheys");
				double korkeus = results.getDouble("korkeus");
				double leveys = results.getDouble("leveys");
				double paino = results.getDouble("paino");
				double pituus = results.getDouble("pituus");
				String grain = results.getString("grain");
				balsalevyt.add(new Balsalevy(id, tiheys, korkeus, leveys, paino, pituus, grain));
			}
			results.close();
			query.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return balsalevyt;
	}

	@Override
	public Balsalevy getItem(long id) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = Database.connect();
			String queryString = "SELECT * FROM Balsalevy WHERE id = ?";
			PreparedStatement query = connection.prepareStatement(queryString);
			query.setLong(1, id);
			ResultSet results = query.executeQuery();
			Balsalevy levy = null;
			while (results.next()) {
				double tiheys = results.getDouble("tiheys");
				double korkeus = results.getDouble("korkeus");
				double leveys = results.getDouble("leveys");
				double paino = results.getDouble("paino");
				double pituus = results.getDouble("pituus");
				String grain = results.getString("grain");
				levy = new Balsalevy(id, tiheys, korkeus, leveys, paino, pituus, grain);
			}
			results.close();
			query.close();
			connection.close();
			return levy;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addItem(Balsalevy newItem) {
		double tiheys = newItem.getTiheys();
		double korkeus = newItem.getKorkeus();
		double leveys = newItem.getLeveys();
		double paino = newItem.getPaino();
		double pituus = newItem.getPituus();
		String grain = newItem.getGrain();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = Database.connect();
			String queryString = "INSERT INTO Balsalevy (tiheys, korkeus, leveys, paino, pituus, grain)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement query = connection.prepareStatement(queryString);
			query.setDouble(1, tiheys);
			query.setDouble(2, korkeus);
			query.setDouble(3, leveys);
			query.setDouble(4, paino);
			query.setDouble(5, pituus);
			query.setString(6, grain);
			query.executeQuery();
			query.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	//vain id tarvitaan poistamiseen
	public boolean removeItem(Balsalevy item) {
		Long id = item.getId();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = Database.connect();
			String queryString = "DELETE FROM Balsalevy WHERE ID = ?";
			PreparedStatement query = connection.prepareStatement(queryString);
			query.setString(1, String.valueOf(id));
			query.executeUpdate();
			query.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
