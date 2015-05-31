package ie.aidan.adf;

import ie.aidan.adf.service.ServiceImplementation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
@Transactional
public class IntegrationTest {
	@Autowired
	ServiceImplementation tested;

	@Test
	public void testInsertQuestion() {
		tested.insertQuestion("test question text", 1, "test answer", "test 2", "test 3", "test 4", 1);
		boolean checkFromDB = tested.CheckIfQuestionExists("test question text");
		Assert.assertTrue(checkFromDB);
	}

}