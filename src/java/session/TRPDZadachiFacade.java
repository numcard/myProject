/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TRPDZadachi;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Александр
 */
@Stateless
public class TRPDZadachiFacade extends AbstractFacade<TRPDZadachi> {

    @PersistenceContext(unitName = "myProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public TRPDZadachi find()
    {
        return (TRPDZadachi) em.createNamedQuery("TRPDZadachi.findByIdRPDZadachi").getSingleResult();
    }

    public TRPDZadachiFacade() {
        super(TRPDZadachi.class);
    }
    
}
