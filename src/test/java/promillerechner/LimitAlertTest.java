package promillerechner;

import com.amazon.ask.attributes.AttributesManager;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import promillerechner.calculations.LimitAlert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class LimitAlertTest {

    @Test
    public void testGetLimitAlertTwoPromille() {
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

        Assert.assertEquals(Constants.TWO_PROMILLE ,LimitAlert.getAlertMessageDependentByAge(attributesManager, 2.1f));
    }

    @Test
    public void testGetLimitAlertUnder16() {
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

        Assert.assertEquals(Constants.AGE_SIXTEEN_1 + 0.2 + Constants.AGE_SIXTEEN_2 ,LimitAlert.getAlertMessageDependentByAge(attributesManager, 0.2f));
    }

    @Test
    public void testGetLimitAlertUnder18() {
        AttributesManager attributesManager = Mockito.mock(AttributesManager.class);
        Map<String, Object> persistentMap = new HashMap<>();
        Map<String, Object> currentUserMap = new HashMap<>();
        currentUserMap.put("name", "max");
        currentUserMap.put("age", new BigDecimal(16));
        currentUserMap.put("sex", "männlich");
        currentUserMap.put("mass", 45);
        persistentMap.put(Constants.CURRENTUSER, currentUserMap);
        persistentMap.put(Constants.LIMIT_ALERT, true);
        when(attributesManager.getPersistentAttributes()).thenReturn(persistentMap);

        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(attributesManager).setPersistentAttributes(arg.capture());
        doNothing().when(attributesManager).savePersistentAttributes();

        Assert.assertEquals(0.6f + Constants.AGE_EIGHTTEEN ,LimitAlert.getAlertMessageDependentByAge(attributesManager, 0.6f));
    }

    @Test
    public void testGetLimitAlertUnder21() {
        AttributesManager attributesManager = Mockito.mock(AttributesManager.class);
        Map<String, Object> persistentMap = new HashMap<>();
        Map<String, Object> currentUserMap = new HashMap<>();
        currentUserMap.put("name", "max");
        currentUserMap.put("age", new BigDecimal(18));
        currentUserMap.put("sex", "männlich");
        currentUserMap.put("mass", 45);
        persistentMap.put(Constants.CURRENTUSER, currentUserMap);
        persistentMap.put(Constants.LIMIT_ALERT, true);
        when(attributesManager.getPersistentAttributes()).thenReturn(persistentMap);

        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(attributesManager).setPersistentAttributes(arg.capture());
        doNothing().when(attributesManager).savePersistentAttributes();

        Assert.assertEquals(1.6f + Constants.AGE_TWENTYONE ,LimitAlert.getAlertMessageDependentByAge(attributesManager, 1.6f));
    }

    @Test
    public void testGetLimitAlertOlder() {
        AttributesManager attributesManager = Mockito.mock(AttributesManager.class);
        Map<String, Object> persistentMap = new HashMap<>();
        Map<String, Object> currentUserMap = new HashMap<>();
        currentUserMap.put("name", "max");
        currentUserMap.put("age", new BigDecimal(21));
        currentUserMap.put("sex", "männlich");
        currentUserMap.put("mass", 45);
        persistentMap.put(Constants.CURRENTUSER, currentUserMap);
        persistentMap.put(Constants.LIMIT_ALERT, true);
        when(attributesManager.getPersistentAttributes()).thenReturn(persistentMap);

        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(attributesManager).setPersistentAttributes(arg.capture());
        doNothing().when(attributesManager).savePersistentAttributes();

        Assert.assertEquals(1.6f + Constants.ONE_POINT_FIVE_PROMILLE ,LimitAlert.getAlertMessageDependentByAge(attributesManager, 1.6f));
    }
}
