import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;
import model.Product;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        JdbcPooledConnectionSource connectionSource = new JdbcPooledConnectionSource("jdbc:sqlite:mydb.sqlite");

        TableUtils.createTableIfNotExists(connectionSource, Product.class);

        Dao<Product, Long> productDao =  DaoManager.createDao(connectionSource, Product.class);

        Product product = new Product();
        product.setName("My Product");
        productDao.create(product);
//
//        Product result = productDao.queryForId(1L);
//
//        product.setName("My Product Library");
//        productDao.update(product);
//
//        productDao.delete(product);

        connectionSource.close();
    }
}
