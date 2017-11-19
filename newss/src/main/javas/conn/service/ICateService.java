package conn.service;

import conn.entity.category;

import java.util.List;

/**
 * Created by sunbin on 2017/8/2.
 */
public interface ICateService {
    public List<category> lists(int cid);
}
