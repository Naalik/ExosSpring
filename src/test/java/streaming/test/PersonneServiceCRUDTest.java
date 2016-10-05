/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.entity.Personne;
import streaming.service.PersonneServiceCRUD;
import streaming.spring.SpringConfig;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class PersonneServiceCRUDTest {

    @Autowired
    private PersonneServiceCRUD crud;

    @Before
    public void Config() {
        crud.deleteAll();
        
        Personne p1 = new Personne();
        p1.setNom("X");
        p1.setPrenom("Y");
        crud.save(p1);

        Personne p2 = new Personne();
        p2.setNom("A");
        p2.setPrenom("B");
        crud.save(p2);

    }

    @Test
    public void personneServiceCRUDTestFindOneBy() {
        Assert.assertNotNull(crud.findOneByPrenomAndNom("Y", "X"));
        
    }

}
