package pl.edu.pw.ee;

import org.junit.Test;
import pl.edu.pw.ee.services.MapInterface;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class RbtMapTest {
    @Test
    public void setValue() {
        MapInterface<String, String> map = new RbtMap<>();
        map.setValue("username", "User");
        try {
            Field tree = RbtMap.class.getDeclaredField("tree");
            tree.setAccessible(true);
            RedBlackTree<String, String> redBlackTree = (RedBlackTree<String, String>) tree.get(map);
            String valueByKey = redBlackTree.get("username");
            assertNotNull(valueByKey);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void getValue() {
        MapInterface<String, String> map =  new RbtMap<>();
        map.setValue("12345678", "UserOnePassword");
        String value = map.getValue("12345678");
        String incorrectValue = map.getValue("1234567");
        assertEquals("UserOnePassword", value);
        assertNull(incorrectValue);
    }
}
