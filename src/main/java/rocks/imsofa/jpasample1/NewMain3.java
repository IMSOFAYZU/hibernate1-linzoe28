/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.imsofa.jpasample1;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author lendle
 */
public class NewMain3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em=Persistence.createEntityManagerFactory("database_systems").createEntityManager();
        em.getTransaction().begin();
        //use merge to update a previously created Bar via em.merge
        Bar bar =new Bar();
        bar.setName("test1");
        bar.setLicense("123");
        bar.setAddr("123");
        em.merge(bar);
        ///////////////////////////////////////////////////////////
        em.getTransaction().commit();
        em.close();
        System.exit(0);
    }
    
}
