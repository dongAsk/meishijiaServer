package dao;

import bean.User;

public interface UserDao {
    int adduser(User user) throws Exception;
    int editInfo(int uid,String username,String email) throws Exception;
    int editPassword(int uid,String password) throws Exception;
    User queryByName(String username) throws Exception;
    int queryUid(String username) throws Exception;
    User queryByEmail(String emial) throws Exception;
}
