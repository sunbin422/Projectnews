package cns.service.imol;

import cns.Dao.ICategory;
import cns.entity.category;
import cns.service.ICateService;

import java.util.List;

/**
 * Created by sunbin on 2017/8/2.
 */
public class CateServiceImpl implements ICateService {
    private ICategory cate;
    public List<category> list() {
        return getCate().list();
    }


    public ICategory getCate() {
        return cate;
    }

    public void setCate(ICategory cate) {
        this.cate = cate;
    }
}
