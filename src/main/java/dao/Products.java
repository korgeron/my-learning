package dao;

import java.sql.ResultSet;
import java.util.List;

public interface Products {
    List<Product> all();
    ResultSet insert(Product product);
}
