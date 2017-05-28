/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.TUmkTPredmet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Александр
 */
@Stateless
public class TUmkTPredmetFacade extends AbstractFacade<TUmkTPredmet> {

    @PersistenceContext(unitName = "myProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<TUmkTPredmet> findAllByNumNapravl(String numNapravl) 
    {
        List<TUmkTPredmet> newList = new ArrayList<>();
        List<TUmkTPredmet> list = super.findAll();
        
        // Ищем элементы по numNapravl 
        for(TUmkTPredmet o: list)
        {
            if(o.getNumNapravl().getShifrNapravl().equals(numNapravl))
                newList.add(o);
        }
                
        // Сортируем по NumUchCikl и NumPorjadok
        Collections.sort(newList, (TUmkTPredmet o1, TUmkTPredmet o2) -> {
            int c1 = o1.getNumUchCikl().getNumUchCikl().compareTo(o2.getNumUchCikl().getNumUchCikl());
            if(c1 == 0)
            {
                if(o1.getNumPorjadok().length() < 1) return -1;
                if(o1.getNumPorjadok().length() < 1) return 1;
                try
                {
                    float f1 = Float.parseFloat(o1.getNumPorjadok());
                    float f2 = Float.parseFloat(o2.getNumPorjadok());
                    return Float.compare(f1, f2);
                }
                catch(java.lang.NumberFormatException e)
                {
                    //ignored
                }   
            }
            return c1;
        });
        
        return newList;
    }

    public TUmkTPredmetFacade() {
        super(TUmkTPredmet.class);
    }
    
}
