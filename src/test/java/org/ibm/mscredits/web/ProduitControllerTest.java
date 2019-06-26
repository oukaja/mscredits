package org.ibm.mscredits.web;

import org.ibm.mscredits.entities.Produit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(ProduitController.class)

public class ProduitControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProduitController controller;

    @Test
    public void getAll() throws Exception {
        Produit o = new Produit();
        o.setNom("crédit personnel");
        List<Produit> allProduits = singletonList(o);
        assertEquals("crédit personnel",o.getNom());
    }
}