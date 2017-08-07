package com.kebodev.session;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kebodev.entity.BtrCustomer;

/**
 * Session Bean implementation class EventHandlerEJB
 */
@Stateless
@LocalBean
public class EventHandlerEJB implements EventHandlerEJBRemote {

    /**
     * Default constructor. 
     */
    public EventHandlerEJB() {
        // TODO Auto-generated constructor stub
    }
    
	
	@PersistenceContext(unitName="BatorBack")
	private EntityManager em;
    
    @Override
    public void sayHelloEJB() {
    	
    	Date date = new Date();
    	
    	System.out.println("EJB CALLED...");
		BtrCustomer newCust = new BtrCustomer();
		newCust.setCustFamilyName("teszt");
		newCust.setCutyId(BigDecimal.valueOf(-1));
		newCust.setMtId(BigDecimal.valueOf(Math.random()));
		newCust.setCustomerno("12345");
		newCust.setCustFamilyName("dummyName");
		newCust.setCrDate(date);
		newCust.setCrUserId(BigDecimal.valueOf(1));
		newCust.setModDate(date);
		newCust.setModUserId(BigDecimal.valueOf(1));
		em.persist(newCust);
    	
    }
    

}
