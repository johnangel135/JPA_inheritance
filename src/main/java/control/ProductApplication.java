package control;


import domain.Order;
import domain.OrderLine;
import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ProductApplication {
    private static Session session;
    private static Transaction tx;
    private static  final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    private static void initial(){
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

	public static void main(String[] args) {
        initial();
		run();
	}

	private static void run(){
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();

		try {

			Order order = new Order();
			List<OrderLine> orderLines = new ArrayList<>();

			Product product = new Product("Product A","This is product A");
            session.save(product);
			OrderLine line = new OrderLine(product,4);
            session.save(line);
			orderLines.add(line);

			order.setDate(Calendar.getInstance().getTime());
			order.setOrderLines(orderLines);
			session.save(order);
			tx.commit();

		}catch (Throwable e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
			sessionFactory.close();
		}

	}
}
