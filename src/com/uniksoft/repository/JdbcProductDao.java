package com.uniksoft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.uniksoft.domain.Product;

public class JdbcProductDao extends SimpleJdbcDaoSupport implements ProductDao {

	public List<Product> getProductList() {
		String sql = "select id, description, price from products";
		List<Product> products = getSimpleJdbcTemplate().query(sql, new ProductMapper());
		return products;
	}

	public void saveProduct(Product prod) {
		String sql = "update products set description = :description, price = :price where id = :id";
		int count = getSimpleJdbcTemplate().update(sql, new MapSqlParameterSource().addValue("description", prod.getDescription())
                .addValue("price", prod.getPrice())
                .addValue("id", prod.getId()));
	}

	private static class ProductMapper implements ParameterizedRowMapper<Product> {
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product prod = new Product();
			prod.setId(rs.getInt("id"));
			prod.setDescription(rs.getString("description"));
			prod.setPrice(new Double(rs.getDouble("price")));
			return prod;
		}
	}
}
