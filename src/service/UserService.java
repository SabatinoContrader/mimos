package service;

import dao.UserDAO;
import model.AUser;
import model.Administrator;
import model.BaseUser;
import model.Doctor;
import model.Patient;
import model.Pharmacist;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<BaseUser> getAllUsers () {
        return this.userDAO.getAllUsers();
    }

    public boolean insertPatient (Patient user) {
        return this.userDAO.insertPatient(user);
    }

    public boolean insertAdministrator (Administrator user) {
        return this.userDAO.insertAdmin(user);
    }

    public boolean insertDoctor (Doctor user) {
        return this.userDAO.insertDoctor(user);
    }

    public boolean insertPharmacist (Pharmacist user) {
        return this.userDAO.insertPharmacist(user);
    }
}


