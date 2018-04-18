package control;


import domain.Order;
import domain.OrderLine;
import domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class ProductApplication {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
	addOrder();
	emf.close();
	}

	private static void addOrder(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Order order = new Order();
			List<OrderLine> orderLines = new ArrayList<>();

			Product product = new Product("Product A","This is product A");
			em.persist(product);
			orderLines.add(new OrderLine(product,4));

			order.setDate(Calendar.getInstance().getTime());
			order.setOrderLines(orderLines);
			em.persist(order);

			tx.commit();
		}catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}

	}
}
