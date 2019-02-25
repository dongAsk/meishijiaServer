package action;

import bean.User;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginAction implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userinfo = request.getParameter("jsonString");
        System.out.println(userinfo);
        Gson gson = new Gson();
        User user = gson.fromJson(userinfo, User.class);
        Map<String, Object> map = new HashMap<>();
        try {
            User userdb = DaoFactory.getUserDAOInstance().queryByName(user.getUsername());
            if (user.getPassword().equals(userdb.getPassword())){
                map.clear();
                map.put("login", true);
            }else{
                map.clear();
                map.put("login", false);
            }
        } catch (Exception e) {
            map.clear();
            map.put("login", false);
        }
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
}
