package main.service;

import main.dao.MisuraDAO;
import main.model.Misura;

import java.util.List;

public class MisuraService {

    private MisuraDAO misuraDAO;

    public MisuraService() {
        this.misuraDAO = new MisuraDAO();
    }

    public List<Misura> getAllMisura () {
        return this.misuraDAO.getAllMisura();
    }

    public boolean insertMisura (Misura misura) {
        return this.misuraDAO.insertMisura(misura);
    }
}


