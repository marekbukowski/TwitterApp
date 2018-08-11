package sda.java6.twitter.service;

public class LoginServiceImpl implements LoginService {

    @Override
    public boolean login(String email, String password) {
        if ("tomcat@sda.pl".equals(email) && "tomcat".equals(password)
                || "admin@sda.pl".equals(email) && "admin".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
