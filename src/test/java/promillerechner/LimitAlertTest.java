package promillerechner;

import com.amazon.ask.attributes.AttributesManager;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import promillerechner.calculations.LimitAlert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class LimitAlertTest {

    @Before
    public void initialize() {
        AttributesManager attributesManager = Mockito.mock(AttributesManager.class);
        Map<String, Object> persistentMap = new HashMap<>();
    }

    @Test
    public void testGetLimitAlertEnable() {
        AttributesManager attributesManager = Mockito.mock(AttributesManager.class);
        Map<String, Object> persistentMap = new HashMap<>();
        Map<String, Object> currentUserMap = new HashMap<>();
        currentUserMap.put("name", "max");
        currentUserMap.put("age", new BigDecimal(15));
        currentUserMap.put("sex", "männlich");
        currentUserMap.put("mass", 45);
        persistentMap.put(Constants.CURRENTUSER, currentUserMap);
        persistentMap.put(Constants.LIMIT_ALERT, true);
        when(attributesManager.getPersistentAttributes()).thenReturn(persistentMap);

        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(attributesManager).setPersistentAttributes(arg.capture());
        doNothing().when(attributesManager).savePersistentAttributes();



        assertEquals("Egal wie alt du bist, du solltest jetzt aufhören Alkohol zu trinken!" ,LimitAlert.getAlertMessageDependentByAge(attributesManager, 2.1f));
    }
}
