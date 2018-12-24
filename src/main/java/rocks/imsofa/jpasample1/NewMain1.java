/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.imsofa.jpasample1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author lendle
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em=Persistence.createEntityManagerFactory("database_systems").createEntityManager();
        //use jpql select b from Bar b where b.name=?1 to select objects
        Query query=em.createQuery("select x from Bar x where x.name=?1");
        query.setParameter(1, "Sue's");
        List list= query.getResultList();
        Bar bar=(Bar) list.get(0);
        System.out.print(bar);
        //////////////////////////////////////////////////////////////////
        em.close();
        System.exit(0);
    }
    
}
