/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.add(root);
        
        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();
            if(curr!=null)
            {
                sb.append(curr.val);
                queue.add(curr.left);
                queue.add(curr.right);
            }
            else
            {
                sb.append('#');
            }
            sb.append(",");
        }
        System.out.println(sb.toString());
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String [] str = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int i =1;
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.add(root);
        while(!queue.isEmpty() && i<str.length)
        {
            TreeNode curr = queue.poll();
            if(!str[i].equals("#"))
            {
                curr.left = new TreeNode(Integer.parseInt(str[i]));
                queue.add(curr.left);
            }
            i++;
            if(!str[i].equals("#"))
            {
                curr.right = new TreeNode(Integer.parseInt(str[i]));
                queue.add(curr.right);
            }
            i++;

        }
        

        return root;

        


        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));