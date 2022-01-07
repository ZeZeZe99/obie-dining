package com.cs311.backend;

import com.cs311.backend.entity.Bar;
import com.cs311.backend.repository.BarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ObieDiningBackendApplicationTests.class})
public class BarTest {
    @Autowired
    private BarRepository barRepository;

    @Test
    public void contextLoads(){
        Bar bar = new Bar();
        bar.setName("Smoke & Fire");
        barRepository.save(bar);
    }
}
