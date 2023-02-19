package mockinjection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComposerTest {

	@Mock
	Score mockScore;

	//Composer c = new Composer(s);
	@InjectMocks
	Composer injectedC = new Composer();

	@Test
	public void testComposer(){
		Score rawScore = new Score("RE");
		Composer rawComposer = new Composer(rawScore);
		System.out.println(rawComposer.getScore());

		//check
		System.out.println(injectedC.getScore());
		//stubbing
		doReturn("DO-RE-MI").when(mockScore).getStr();

		assertEquals("DO-RE-MI", injectedC.getScore());
	}
}