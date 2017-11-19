package cns.Dao.impl;

import cns.Dao.ICategory;
import cns.entity.category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sunbin on 2017/8/2.
 */
public class CategoryImpl implements ICategory {
    private JdbcTemplate jdbcTemplate;
    public List<category> list() {
        List<category> categories = jdbcTemplate.query("select * from category", new RowMapper<category>() {
            public category mapRow(ResultSet rs, int i) throws SQLException {
                category category=new category();
                category.setCid(rs.getInt("cid"));
                category.setCname(rs.getString("cname"));
                category.setPid(rs.getInt("pid"));
                return category;
            }
        });
        return categories;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
