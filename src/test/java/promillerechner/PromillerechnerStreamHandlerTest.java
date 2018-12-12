package promillerechner;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PromillerechnerStreamHandlerTest {
    @Test
    public void isDynamoDbTableValid() {
        assertEquals("promillerechner", Constants.USER_TABLE);
    }
}
