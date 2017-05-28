/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TDolgnost;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Александр
 */
@Stateless
public class TDolgnostFacade extends AbstractFacade<TDolgnost> {

    @PersistenceContext(unitName = "myProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TDolgnostFacade() {
        super(TDolgnost.class);
    }
    
}
