package encore.stocknews.model.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	private static EntityManagerFactory factory = null;
	
	private DBUtil() {};
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	public static void runFactory() {
		factory = Persistence.createEntityManagerFactory("encore");
	}

	public static void closeFactory() {
		factory.close();
	}
}
