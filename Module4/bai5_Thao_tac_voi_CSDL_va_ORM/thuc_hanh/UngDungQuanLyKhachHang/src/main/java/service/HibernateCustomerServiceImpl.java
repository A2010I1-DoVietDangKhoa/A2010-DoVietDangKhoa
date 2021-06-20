package service;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class HibernateCustomerServiceImpl implements CustomerService {

    @Bean
    public CustomerService customerService() {
        return new HibernateCustomerServiceImpl();
    }

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findOne(int id) {
        String queryStr = "SELECT c FROM Customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Customer save(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Customer origin = findOne(customer.getId());
            origin.setName(customer.getName());
            origin.setEmail(customer.getEmail());
            origin.setAddress(customer.getAddress());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Integer> ids) {
        return Collections.emptyList();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void delete(Customer customer) {
    }

    @Override
    public void delete(List<Customer> customers) {
    }

    @Override
    public void deleteAll() {
    }
}
