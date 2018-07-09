package service;

import java.util.ArrayList;
import dao.HomeDAO;

public class HomeService {

    private HomeDAO homeDAO;

    public HomeService() {
        this.homeDAO = new HomeDAO();
    }

    public ArrayList<String> getDataUser (String username, String role) {
        return this.homeDAO.getDataUser(username, role);
    }
}
