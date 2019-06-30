package com.itcast.service.system;

import com.itcast.bean.system.User;

import java.util.List;

public interface UserService {

    //1 查询所有
    public List<User> findAll();

    //2. 条件查询
    public User findById(String userId);

    //3. 新增数据
    public void save(User user);

    //4. 修改数据
    public void update(User user);

    //5. 删除数据
    public void delete(String userId);

}
