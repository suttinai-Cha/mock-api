package cs.pointscenter.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(SpringExtension.class)
public class TestEx {
	@Test
	@DisplayName("demo test ex")
	public void demo_test_ex() throws Exception {
		assertTrue(true);
	}
}
