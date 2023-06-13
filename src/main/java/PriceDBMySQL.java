import java.sql.*;

public class PriceDBMySQL extends PriceDB {

    Connection mysqlConnection;
    String driverClass = "com.mysql.cj.jdbc.Driver";
    String mysqlUrl = "jdbc:mysql://localhost:3306/coffeeshop";

    @Override
    public double findPrice(SizeType size, DrinkType type) {

        double price = 0;

        try (PreparedStatement s = mysqlConnection.prepareStatement(
                """
                        SELECT price
                        FROM drinks
                        WHERE size = ? AND type = ?
                        """)) {

            s.setString(1, size.toString());
            s.setString(2, type.toString());
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                price = rs.getDouble("price");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return price;
    }

    public PriceDBMySQL() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            mysqlConnection = DriverManager.getConnection(mysqlUrl, "paul", "baibai");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
