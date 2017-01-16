package util.test;

import org.junit.Test;

import com.jackzeng.util.SequenceNoGenerator;

public class SequenceNoGeneratorTest {
	@Test
	public void test(){
		System.out.println(SequenceNoGenerator.getSequenceNo());
		System.out.println(SequenceNoGenerator.getSequenceNo());
		System.out.println(SequenceNoGenerator.getSequenceNo());
	}
}
