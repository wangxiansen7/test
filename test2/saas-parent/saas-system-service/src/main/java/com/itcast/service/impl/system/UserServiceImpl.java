package com.itcast.service.impl.system;

import com.alibaba.dubbo.config.annotation.Service;
import com.itcast.bean.system.User;
import com.itcast.dao.system.UserDao;
import com.itcast.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //自动装配UserDao对象
    @Autowired
    private UserDao userDao;


    //1 查询所有
    @Override
    public List<User> findAll() {
        return userDao.selectByExample(null);
    }

    //2. 条件查询
    @Override
    public User findById(String userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    //3. 新增数据
    @Override
    public void save(User user) {
        userDao.insertSelective(user);
    }

    //4. 修改数据
    @Override
    public void update(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    //5. 删除数据
    @Override
    public void delete(String userId) {
        userDao.deleteByPrimaryKey(userId);
    }

}
