package array.algo_company.DataStructure.testing;

import array.algo_company.DataStructure.linklist.BaseLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkListTest
{

    private BaseLinkedList linkedList;

    @Before
    public void setup()
    {
        linkedList = new BaseLinkedList();
    }

    @Test
    public void addToFront()
    {
        linkedList.addToFront("1");
        linkedList.addToFront("2");
        linkedList.addToFront("3");

        try
        {
            Assert.assertEquals("3",linkedList.getFirst());
            Assert.assertEquals("1",linkedList.getLast());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void size()
    {
        Assert.assertEquals(0,linkedList.size());
        linkedList.addToBack("1");
        Assert.assertEquals(1,linkedList.size());
        linkedList.addToFront("2");
        Assert.assertEquals(2,linkedList.size());

        try {
            Assert.assertEquals("1",linkedList.getLast());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete()
    {
        linkedList.addToBack("1");
        linkedList.addToBack("2");
        linkedList.addToBack("3");
        linkedList.addToBack("4");
        linkedList.delete("2");
        Assert.assertEquals(3,linkedList.size());
    }
}
