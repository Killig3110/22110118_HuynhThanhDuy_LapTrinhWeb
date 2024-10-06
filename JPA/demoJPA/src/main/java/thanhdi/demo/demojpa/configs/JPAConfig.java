package thanhdi.demo.demojpa.configs;

import jakarta.persistence.*;

public class JPAConfig {
    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dataSource");
        return factory.createEntityManager();
    }
}
