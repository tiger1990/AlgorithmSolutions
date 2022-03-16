package array.algo_company.Trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest
{
    private BinaryTree bst;

    @Before
    public void setUp() throws Exception
    {
        bst = new BinaryTree();
    }

    @Test
    public void insert() throws Exception
    {
        bst.insert(5,"a");
        bst.insert(3,"b");
        bst.insert(2,"c");
        bst.insert(4,"d");
        bst.insert(7,"e");
        bst.insert(6,"f");
        bst.insert(8,"g");

        Assert.assertEquals("a",bst.find(5));
        Assert.assertEquals(null,bst.find(55));

     //   bst.prinInorder();
     //  bst.printPreorder();
       bst.prinPostorder();
    }

    @Test
    public void minKey() throws Exception
    {
        bst.insert(5,"a");
        bst.insert(3,"b");
        bst.insert(2,"c");

        Assert.assertEquals(2,bst.finMinKey());
    }

    @Test
    public void delete() throws Exception
    {
        bst.insert(5,"a");
        bst.insert(3,"b");
        bst.insert(2,"c");
        bst.insert(4,"d");
        bst.insert(7,"e");
        bst.insert(6,"f");
        bst.insert(8,"g");

        bst.delete(7);
        Assert.assertNull(bst.find(7));
    }
}
