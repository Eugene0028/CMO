import java.util.*;

public class LeetCode
{

    static class Entity
    {
        public int value;
        public int index;

        public Entity(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }
//    public static int[] twoSum(int[] arr, int target)
//    {
//        var map = new HashMap<Integer, Integer>();
//
//        for(int i = 0; i < arr.length; i++){
//            int tmp = target - arr[i];
//            if (map.containsKey(tmp)){
//                return new int[]{tmp , i};
//            }
//            map.put(arr[i], i);
//        }
//        return new int[]{};
//    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=1;i<nums.length;i++){
            for(int j=0;j+i<nums.length;j++){
                if(nums[j]+nums[i+j]==target){
                    return new int[] {j,i+j};
                }
            }
        }
        return null;
    }


    public static int mySqrt(int x)
    {
        if (x == 0)return 0;
        if (x == 1)return 1;
        int start = 1;
        int end = x;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if ((long)mid * mid > x) end = mid - 1;
            else if ((long)mid * mid < x) start = mid + 1;
            else return mid;
        }
        return end;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int i = m - 1, j =  n - 1, k = (n + m) - 1;

        while(i >= 0 && j >= 0){
            if (nums1[i] < nums2[j]){
                nums1[k--] = nums2[j--];
            }
            else {
                nums1[k--] = nums1[i--];
            }
        }
        while(j >= 0)nums1[k--] = nums2[j--];
        for(var z : nums1) System.out.print(z + " ");

    }




  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public static ListNode deleteDuplicates(ListNode head)
    {
        ListNode tmp = head;
        while (head != null)
        {
            if (head.next == null) break;
            var curr = head;
            while (curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            head = head.next = curr.next;
        }
        return tmp;
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 0; i < 10; i++) {
            if (i < 5) head = head.next = new ListNode(1);
            else head = head.next = new ListNode(2);
        }
        head = tmp;
        printNodes(head);
        System.out.println();
        deleteDuplicates(head);
        printNodes(head);

    }

    public static void printNodes(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }



//    public static int[] twoSum(int[] arr, int target)
//    {
//        Entity[] tmp = new Entity[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            tmp[i] = new Entity(arr[i], i);
//            System.out.print(tmp[i] + " ");
//        }
//        System.out.println();
//        Arrays.sort(tmp, Comparator.comparingInt(x->x.value));
//        Arrays.stream(tmp).forEach(x-> System.out.print(x + " "));
//
//        int left = 0, right = arr.length - 1;
//
//        while (left < right)
//        {
//            int sum = tmp[left].value + tmp[right].value;
//            if (sum == target) return new int[]{tmp[left].index, tmp[right].index};
//            else if (sum > target)right--;
//            else left++;
//        }
//        return new int[]{};
//    }


}