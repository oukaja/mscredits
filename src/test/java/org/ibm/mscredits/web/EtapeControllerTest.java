package org.ibm.mscredits.web;

import org.ibm.mscredits.entities.Etape;
import org.ibm.mscredits.web.EtapeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EtapeController.class)

public class EtapeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EtapeController controller;

    @Test
    public void getAll() throws Exception {
        Etape o = new Etape();
        o.setValidateur("système");
        List<Etape> allEtapes = singletonList(o);
        assertEquals("système",o.getValidateur());
    }
}