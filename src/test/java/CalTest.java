import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class CalTest {

	@Mock
	ArrayList<String> mockArrOutLevel;
	@Spy
	ArrayList<String> spyArrOutLevel;

	@Test
	public void getSum() {
		Cal cal = new Cal();

		int ret = cal.getSum(20, 500);

		assertEquals(520, ret);
	}

	@Test
	public void testWithMockClass() {
		ArrayList<String> mockList = mock(ArrayList.class);

		mockList.add("first");

		verify(mockList).add("first");
		System.out.println(mockList.get(0));
	}

	@Test
	public void testOutLevelMock() {
		mockArrOutLevel.add("outer added");
		mockArrOutLevel.add("outer added");
		mockArrOutLevel.add("outer added");
		mockArrOutLevel.add("outer added");

		//verify(mockArrOutLevel).add("outer added?");
		//verify(mockArrOutLevel).add("outer added");
		verify(mockArrOutLevel, atLeast(2)).add(anyString()); // times, alLeast, atMost
	}

	@Test
	public void stubbingDoReturnOutLevelMock() {
		mockArrOutLevel.add("stub added");
		//check
		System.out.println("check before doReturn phrase: " + mockArrOutLevel.get(0));

		//stubbing
		doReturn("this is a stubbed answer.").when(mockArrOutLevel).get(0); // infact, it doesn't call get(0)

		System.out.println(mockArrOutLevel.get(0));
		System.out.println(mockArrOutLevel.get(1));
	}

	@Test
	public void stubbingThenReturnOutLevelMock() {
		mockArrOutLevel.add("stub added");
		//check
		System.out.println("check before when/then phrase: " + mockArrOutLevel.get(1));

		//stubbing
		when(mockArrOutLevel.get(1)).thenReturn("then return"); // it really calls get method.

		System.out.println(mockArrOutLevel.get(0));
		System.out.println(mockArrOutLevel.get(1));
	}

	@Test
	public void stubbingSizeOfOutLevelMock() {
		mockArrOutLevel.add("stub added");
		//check
		System.out.println("check before when/then phrase: " + mockArrOutLevel.size());

		//stubbing
		when(mockArrOutLevel.size()).thenReturn(Integer.MAX_VALUE); // it really calls size() method.

		assertEquals(Integer.MAX_VALUE, mockArrOutLevel.size());
	}


	@Test
	public void spyingSizeOfOutLevelMock() {
		mockArrOutLevel.add("stub added");
		spyArrOutLevel.add("added to spy");
		//check
		System.out.println("check before when/then phrase [MOCK]: " + mockArrOutLevel.size());
		System.out.println("check before when/then phrase [SPY]: " + spyArrOutLevel.size());

		//stubbing
		when(mockArrOutLevel.size()).thenReturn(Integer.MAX_VALUE); // it really calls size() method.
		when(spyArrOutLevel.size()).thenReturn(Integer.MAX_VALUE); // it really calls size() method.

		assertEquals(Integer.MAX_VALUE, mockArrOutLevel.size());
		assertEquals(Integer.MAX_VALUE, spyArrOutLevel.size());
	}

	@Test
	public void inOrderOutLevelMock(){
		mockArrOutLevel.add("DO");
		mockArrOutLevel.add("DO");
		mockArrOutLevel.remove(1);
		mockArrOutLevel.add("RE");
		mockArrOutLevel.add("MI");
		mockArrOutLevel.add("FA");
		mockArrOutLevel.add("SOL");
		mockArrOutLevel.add("RA");
		mockArrOutLevel.add("SI");
		mockArrOutLevel.remove("SI");
		mockArrOutLevel.add("TI");
		mockArrOutLevel.add("DO");

		InOrder order = inOrder(mockArrOutLevel);
		order.verify(mockArrOutLevel, times(2)).add("DO");
		order.verify(mockArrOutLevel).remove(1);
		order.verify(mockArrOutLevel).add("RE");
		order.verify(mockArrOutLevel).add("MI");
		order.verify(mockArrOutLevel).add("FA");
		order.verify(mockArrOutLevel).add("SOL");
		order.verify(mockArrOutLevel).add("RA");
		order.verify(mockArrOutLevel).add("SI");
		order.verify(mockArrOutLevel).remove("SI");
		order.verify(mockArrOutLevel).add("TI");
	}

	@Test(expected = IllegalStateException.class)
	public void testThrow(){
		doThrow(IllegalStateException.class).when(mockArrOutLevel).add("PA");
		mockArrOutLevel.add("DO");
		mockArrOutLevel.add("RE");
		System.out.println("adding actions are completed well,");
		System.out.println(mockArrOutLevel.add("PA"));
		System.out.println("thrown exception successfully.");
	}

	@Test(expected = IllegalStateException.class)
	public void thenReturnsOutLevelMock(){
		when(mockArrOutLevel.add("SI")).thenReturn(false)
				.thenReturn(false)
				.thenThrow(IllegalStateException.class);

		mockArrOutLevel.add("SI");
		mockArrOutLevel.add("SI");
		mockArrOutLevel.add("SI");
	}

}