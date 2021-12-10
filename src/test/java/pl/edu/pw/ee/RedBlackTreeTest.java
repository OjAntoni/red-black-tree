package pl.edu.pw.ee;

import org.junit.Test;

import static org.junit.Assert.*;

public class RedBlackTreeTest {

    @Test
    public void put() {
        RedBlackTree<String, Integer> rbt = new RedBlackTree<>();
        rbt.put("Apples", 12);
        rbt.put("Potatoes", 100);

        Integer apples = rbt.get("Apples");
        assertEquals(12, apples.intValue());

        Integer potatoes = rbt.get("Potatoes");
        assertEquals(100, potatoes.intValue());

        rbt.put("Apples", 222);
        Integer newApples = rbt.get("Apples");
        assertEquals(222, newApples.intValue());
    }


    @Test
    public void getPreOrder() {
        RedBlackTree<String, String> rbt = getFilledRbt(15);
        System.out.println("Pre-order");
        System.out.println(rbt.getPreOrder()+"\n");
    }

    @Test
    public void getInOrder() {
        RedBlackTree<String, String> rbt = getFilledRbt(15);
        System.out.println("In-order");
        System.out.println(rbt.getInOrder()+"\n");
    }

    @Test
    public void getPostOrder() {
        RedBlackTree<String, String> rbt = getFilledRbt(15);
        System.out.println("Post-order");
        System.out.println(rbt.getPostOrder()+"\n");
    }

    @Test
    public void deleteMax() {
        RedBlackTree<String, String> rbt = getFilledRbt(10);
        for(int i = 0; i<10; i++){
            System.out.println(rbt.getInOrder());

            String[] elems = rbt.getInOrder().split(":");
            String[] str = elems[elems.length - 2].split(" ");
            String maxKey = str[str.length > 1 ? 1 : 0].strip();

            rbt.deleteMax();
            String s = rbt.get(maxKey);

            assertNull(s);
        }
        System.out.println("\n");
    }

    private RedBlackTree<String, String> getFilledRbt(int size){
        RedBlackTree<String, String> rbt = new RedBlackTree<>();
        for(int i = 0; i < (size <=0 ? 10 : size); i++){
            rbt.put("key_"+(i+1), "value_"+(i+1));
        }
        return rbt;
    }
}