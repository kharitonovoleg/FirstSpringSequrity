package by.service;

import by.dao.DaoWorker;
import by.model.Workers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerService {

    private DaoWorker daoWorker;

    public void setDaoWorker(DaoWorker daoWorker) {
        this.daoWorker = daoWorker;
    }

    @Transactional
    public void saveWorker(Workers workers) {
        this.daoWorker.saveWorker(workers);
    }

    @Transactional
    public List<Workers> listWorker() {
        return this.daoWorker.listWorker();
    }

    @Transactional
    public void deleteWorker(int id) {
        this.daoWorker.deleteWorker(id);
    }

    @Transactional
    public Workers getById(int id) {
        return this.daoWorker.getById(id);
    }

    @Transactional
    public void updateWorker (Workers workers) {
        this.daoWorker.updateWorker(workers);
    }

}
