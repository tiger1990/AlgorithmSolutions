package array.algo_company.Trees;

public class BinaryTree
{

    private static class Node
   {
       int key;
       String value;
       Node left,right;

       public Node(int key, String value)
       {
           this.key   = key;
           this.value = value;
       }

       public Node min()
       {
          if(left == null)
          {
              return this;
          }
          else
          {
              return left.min();
          }
       }
   }

   private Node root;

   public void insert(int key, String value)
   {
       root = insertItem(root, key, value);
   }

    private Node insertItem(Node node, int key, String value)
    {
        Node newNode = new Node(key,value);

        if(node == null)
        {
           node = newNode;
           return  node;
        }

        if(key < node.key)
        {
           node.left = insertItem(node.left,key,value);
        }
        else if(key > node.key)
        {
          node.right = insertItem(node.right,key,value);
        }

       return node;
    }

    public String find(int key)
    {
       Node node = find(root,key);
       return node == null? null : node.value;
    }

    public Node find(Node node , int key)
    {
        if(node == null || node.key == key)
        {
            return node;
        }
        if(key < node.key)
        {
            return find(node.left,key);
        }
        else if(key > node.key)
        {
            return find(node.right,key);
        }
        return node;
    }

    public int finMinKey()
    {
        return root.min().key;
    }

    public void delete(int key)
    {
      root = delete(root,key);
    }

    public Node finMin(Node node)
    {
        return node.min();
    }

    private Node delete(Node node, int key)
    {
        if(node == null) return null;

        if(key < node.key)
        {
            node.left = delete(node.left,key);

        }else if(key > node.key)
        {
            node.right = delete(node.right,key);
        }
        else  //key equals match found to delete
        {
            //case 1  NO CHILDRENS
            if(node.left == null && node.right == null)
            {
                node = null;
            }

            //case 2  ONE CHILDREN
            else if(node.left ==  null)
            {
                node =  node.right;
            }
            else if(node.right ==  null)
            {
               node = node.left;
            }

            //case 3 Two Childrens
            else
            {
                //find right minimum child and duplicate values
                Node rightMin = finMin(node.right);

                node.key = rightMin.key;
                node.value = rightMin.value;

                //Now go ahead right and delete the node we just duplicated
                node.right = delete(node.right, key);
            }
        }

        return node;
    }

    //left root right
    public void prinInorder() {
        prinInorder(root);
    }

    private void prinInorder(Node node) {
       if(node != null) {
           prinInorder(node.left);
           System.out.println(node.key);
           prinInorder(node.right);
       }

    }

    //Root left right
    public void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(Node node) {
        if(node != null) {
            System.out.println(node.key);
            printPreorder(node.left);
            printPreorder(node.right);
        }
    }

    //left right root
    public void prinPostorder() {
        prinPostorder(root);
    }

    private void prinPostorder(Node node) {
        if(node != null) {
            prinPostorder(node.left);
            prinPostorder(node.right);
            System.out.println(node.key);
        }
    }

}
