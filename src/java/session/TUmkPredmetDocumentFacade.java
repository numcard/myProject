/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TUmkPredmetDocument;
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
public class TUmkPredmetDocumentFacade extends AbstractFacade<TUmkPredmetDocument> {

    @PersistenceContext(unitName = "myProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TUmkPredmetDocumentFacade() {
        super(TUmkPredmetDocument.class);
    }

    public List<TUmkPredmetDocument> findAllByIDPredmet(String IDUmkPredmet) 
    {
        int idUmkPredmet = -1;
        try
        {
            idUmkPredmet = Integer.parseInt(IDUmkPredmet);
        }
        catch(NumberFormatException e)
        {
            //ignored
        }
        
        List<TUmkPredmetDocument> newList = new ArrayList<>();
        if(idUmkPredmet == -1)
            return newList;
        List<TUmkPredmetDocument> list = super.findAll();

        // Ищем элементы по numNapravl 
        for(TUmkPredmetDocument o: list)
        {
            if(o.getIDUmkPredmet().getIDUmkPredmet().equals(idUmkPredmet))
                newList.add(o);
        }

        /*long startTime = System.currentTimeMillis();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
        System.out.println(newList.size());*/
        return newList;
    }

    public TUmkPredmetDocument findByID(int idUmkPredmetDocument)
    {
        Object obj = em.createNamedQuery("TUmkPredmetDocument.findByIdUmkPredmetDocument")
                .setParameter("idUmkPredmetDocument", idUmkPredmetDocument)
                .getSingleResult();
        
        return (TUmkPredmetDocument) obj;
    }
    
    public TUmkPredmetDocument findByID(String idUmkPredmetDocument) 
    {
        int idDoc = -1;
        try
        {
            idDoc = Integer.parseInt(idUmkPredmetDocument);
        }
        catch(NumberFormatException e)
        {
            //ignored
        }
        if(idDoc == -1)
            return new TUmkPredmetDocument();
        
        return findByID(idDoc);
    }
}
