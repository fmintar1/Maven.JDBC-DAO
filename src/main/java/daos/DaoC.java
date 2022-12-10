package daos;
import models.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DaoC implements DAO<Car> {

    public Car findById(int id) {
        Connection connection = MySqlConnection.getConnection();
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE id = " + id);

                if(rs.next())
                {
                    Car car = new Car();

                    car.setId( rs.getInt("id"));
                    car.setMake( rs.getString("make"));
                    car.setModel( rs.getString("model"));
                    car.setYear( rs.getInt("year"));
                    car.setColor( rs.getString("color"));
                    car.setVin( rs.getString("vin"));

                    return car;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return null;
        }
    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        Connection connection = MySqlConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");
            while(rs.next())
            {
                Car car = extractCarsFromResultSet(rs);
                carList.add(car);
            }
            return carList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean update(Car dto) {
        Connection connection = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET name=?, pass=?, age=? WHERE id=?");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            ps.setInt(6, dto.getId());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean create(Car dto) {
        Connection connection = MySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES ?, ?, ?, ?, ?");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean delete(int id) {
        Connection connection = MySqlConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Car WHERE id =" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    private Car extractCarsFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();

        car.setId( rs.getInt("id"));
        car.setMake( rs.getString("make"));
        car.setModel( rs.getString("model"));
        car.setYear( rs.getInt("year"));
        car.setColor( rs.getString("color"));
        car.setVin( rs.getString("vin"));

        return car;
    }
}
