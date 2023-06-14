import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class PriceDBMySQL extends PriceDB {

    private static final String PROPERTIES_FILE = "database.properties";

    private static BasicDataSource dataSource = new BasicDataSource();

    static {

        Properties properties = loadProperties();
        String driverClass = properties.getProperty("driverClass");

        String mysqlUrl = properties.getProperty("databaseUrl");
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(mysqlUrl);
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));

    }




    @Override
    public double findPrice(SizeType size, DrinkType type) {

        double price = 0;

        try (Connection mysqlConnection = dataSource.getConnection();
             PreparedStatement s = mysqlConnection.prepareStatement(
                """
                        SELECT price
                        FROM drinks
                        WHERE size = ? AND type = ?
                        """))
        {

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


    private static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream input = PriceDBMySQL.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}

