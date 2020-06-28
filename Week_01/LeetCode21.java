class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;
        ListNode pointer = new ListNode();
        result = pointer;
        while (l1!=null && l2!=null){
            if(l1.val <= l2.val){
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if(l1!=null){
            pointer.next = l1;
        } else {
            pointer.next = l2;
        }
        return result.next;
    }
}