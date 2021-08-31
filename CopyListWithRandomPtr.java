/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node dup(Node head,Node root){
        if(head == null) return null;
        root = new Node(head.val);
        Node runner2 = root;
        Node runner1 = head.next;
        while(runner1 != null){
            runner2.next = new Node(runner1.val);
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        return root;
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node,Node> details = new HashMap<>();
        details.put(null,null);
        Node root = null;
        root = dup(head,root);
        Node runner1 = head;
        Node runner2 = root;
        while(runner1 != null){
            details.put(runner1,runner2);
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        for(Node node : details.keySet()){
            if(node == null) continue;
            details.get(node).random = details.get(node.random);
        }
        return root;
        
        
        
        
    }
}
