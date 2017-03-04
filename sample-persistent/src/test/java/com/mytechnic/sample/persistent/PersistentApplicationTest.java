package com.mytechnic.sample.persistent;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {PersistentApplication.class})
public abstract class PersistentApplicationTest {
}