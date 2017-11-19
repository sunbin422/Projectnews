package conn.Dao;

import conn.entity.category;

import java.util.List;

/**
 * Created by sunbin on 2017/8/2.
 */
public interface CategoryDao {
    public List<category> lists(int cid);
}
