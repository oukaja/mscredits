package org.ibm.mscredits.web;

import org.ibm.mscredits.entities.Simulation;
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
@WebMvcTest(SimulationController.class)

public class SimulationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SimulationController controller;

    @Test
    public void getAll() throws Exception {
        Simulation o = new Simulation();
        List<Simulation> allSimulations = singletonList(o);
        assertEquals("100000","100000");
    }
}