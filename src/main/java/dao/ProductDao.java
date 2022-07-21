package dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Products {
    private Connection connection = null;

    public ProductDao(P_Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.url(),
                    config.user(),
                    config.pass()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Trying to make a connection", e);
        }
    }

    @Override
    public List<Product> all() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM products_table");
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                products.add(new Product(
                        rs.getString("url"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return products;

        } catch (SQLException e) {
            throw new RuntimeException("This is from the all method", e);
        }
    }

    @Override
    public ResultSet insert(Product product) {
        String query = "INSERT INTO products_table(url,title,description) VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, product.getUrl());
            ps.setString(2, product.getTitle());
            ps.setString(3, product.getDescription());


            ps.executeUpdate();

            return ps.getGeneratedKeys();

        } catch (SQLException e) {
            throw new RuntimeException("This is from the insert method", e);
        }
    }
}
