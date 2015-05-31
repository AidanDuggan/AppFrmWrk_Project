package ie.aidan.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import ie.aidan.dao.QuestionRepository;
import ie.aidan.domain.Question;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.omg.CosNaming.IstringHelper;

public class QuestionControllerTest {

	private QuestionRepository testQuestionRepositoryMock;
	private QuestionController testQuestionControllerMock;

	@Before
	public void setupMockVariables() {
		testQuestionRepositoryMock = mock(QuestionRepository.class);
		testQuestionControllerMock = new QuestionController(testQuestionRepositoryMock);
	}

	// Using Stubs
	@Test
	public void testGetAllQuestionsStubs() {
		final boolean[] methodInvoked = new boolean[1]; // Workaround to have
														// access within
		final Question[] questions = new Question[1];
		QuestionRepository repoStub = new QuestionRepository() {

			public void setAllToUnSelected() {
			}

			public void select(Question question) {
			}

			public void insert(Question newquestion) {
				questions[0] = newquestion;
			}

			public List<Question> getSelectedQuestions() {
				return null;
			}

			public List<Question> getAllQuestions() {
				methodInvoked[0] = true;
				return new ArrayList<Question>();
			}

			public Question findByQuestionId(Integer question_id) {
				// TODO Auto-generated method stub
				return null;
			}

			public void delete(Integer question_id) {
				// TODO Auto-generated method stub

			}

			public boolean CheckIfQuestionExists(String question_text) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		QuestionController testedStub = new QuestionController(repoStub);
		;
		List<Question> allQuestions = testedStub.getAllQuestions();

		assertThat(methodInvoked[0], equalTo(true));
		assertThat(allQuestions, notNullValue());
	}

	// Testing Using Mocks
	@Test
	public void testGetAllQuestionsMock() {
		List<Question> allQuestions = testQuestionControllerMock
				.getAllQuestions();
		assertThat(allQuestions, notNullValue());
		Mockito.verify(testQuestionRepositoryMock).getAllQuestions();
	}

	@Test
	public void testCreate() {
		testQuestionControllerMock.InsertQuestion("questiontext", 1, "answer1", "A2",
				"A3", "A4", 2);
		Mockito.verify(testQuestionRepositoryMock).insert(
				Mockito.argThat(new ArgumentMatcher<Question>() {

					@Override
					public boolean matches(Object argument) {
						return ((Question) argument).getQuestiontext().equals(
								"questiontext");
					}

					@Override
					public void describeTo(Description description) {
						description.appendText("expected: questiontext");
					}
				}));

	}
}
