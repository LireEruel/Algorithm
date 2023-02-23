// leetCode Merge Two Sorted Lists

var mergeTwoLists = function(list1, list2) {
    

    if(list1 === null && list2 === null)
      {
        return list1;
      }
    else if(list1 === null)
      return list2;
    else if(list2 === null)
      return list1;
    
    let preNode = new ListNode(-1);
    let prev = preNode;
    while(list1 !== null || list2 !== null )
      {
        if(list1 == null)
          {
            prev.next = list2;
            break;
          }
        if(list2 == null)
          {
            prev.next = list1;
            break;
          }
        if(list1.val < list2.val)
          {
            prev.next = list1;
            list1 = list1.next;
          }
        else 
          {
            prev.next = list2;
            list2 = list2.next
          }
        prev = prev.next
      }
   
    return preNode.next;
    
  };