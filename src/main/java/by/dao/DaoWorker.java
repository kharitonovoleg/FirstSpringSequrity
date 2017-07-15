package by.dao;

import by.model.Workers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoWorker {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveWorker(Workers workers) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(workers);
    }

    @SuppressWarnings("unchecked")
    public List<Workers> listWorker() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Workers> list = session.createQuery("from Workers ").list();
        return list;
    }

    public void deleteWorker(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Workers workers = getById(id);
        session.delete(workers);

    }

    public Workers getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Workers workers = (Workers) session.load(Workers.class, new Integer(id));
        workers.getFirstName();
        return workers;
    }

    public void updateWorker (Workers workers) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(workers);

    }

}
