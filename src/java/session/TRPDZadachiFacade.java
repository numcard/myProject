/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TRPDZadachi;
import java.util.ArrayList;
import java.util.List;
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

    public TRPDZadachiFacade() {
        super(TRPDZadachi.class);
    }

    public List<TRPDZadachi> findAllByIDPredmetDocument(String idUmkPredmetDocument) 
    {
        int id = Integer.parseInt(idUmkPredmetDocument);
        List<TRPDZadachi> list = em.createNamedQuery("TRPDZadachi.findAll").getResultList();
        List<TRPDZadachi> newList = new ArrayList<>();
        
        for(TRPDZadachi o: list)
        {
            if(o.getIdUmkPredmetDocument().getIdUmkPredmetDocument() == id)
                newList.add(o);
        }
        
        return newList;
    }
}
