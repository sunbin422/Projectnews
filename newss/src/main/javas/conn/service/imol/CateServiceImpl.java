package conn.service.imol;

import conn.Dao.CategoryDao;
import conn.entity.category;
import conn.service.ICateService;

import java.util.List;

/**
 * Created by sunbin on 2017/8/2.
 */
public class CateServiceImpl implements ICateService {
    private CategoryDao cate;
    public List<category> lists(int cid) {
        return getCate().lists(cid);
    }


    public CategoryDao getCate() {
        return cate;
    }

    public void setCate(CategoryDao cate) {
        this.cate = cate;
    }
}
