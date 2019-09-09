package com.hao.leetcode;

import com.hao.common.ListNode;

/**
 * **[两数相加]**
 * 
 * 给出两个 非空 的链表用来表示两个非负的整数。 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 输入：(2 -> 4 ->
 * 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * @author hao
 *
 */
public class LC0002 {

	public static void main(String[] args) {
		System.out.println("****功能测试***");
		test1();
		System.out.println("****边界测试****");
		test2();
		System.out.println("****边界测试****");
		test3();
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return Solution1(l1, l2);
	}

	/**
	 * 方法一： 思路：设置头结点，设置两个指针分别指向两个链表的头，
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static ListNode Solution1(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		int overbit = 0;// 进位
		ListNode p = l1, q = l2;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = x + y + overbit;
			overbit = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (overbit > 0) {
			curr.next = new ListNode(overbit);
		}
		return head.next;
	}

	/**
	 * 方法二:
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static ListNode Solution2(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);// 构造一个头结点
		ListNode curr = head; // 表示当前节点
		int carry = 0;// 进位
		int ans;// 用于存储相加进位之后 当前位结果
		while (l1 != null || l2 != null) {
			ans = carry;
			if (l1 != null) {
				ans += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				ans += l2.val;
				l2 = l2.next;
			}
			if (ans > 9) {
				carry = 1;
				ans -= 10;
			} else {
				carry = 0;
			}
			curr.next = new ListNode(ans);
			curr = curr.next;
		}
		if (carry != 0) {
			curr.next = new ListNode(1);
		}
		return head.next;
	}

	/**
	 * 功能测试
	 * 
	 * l1=[0,1]，l2=[0,1,2]
	 * 
	 */
	private static void test1() {
		ListNode l10 = new ListNode(0);
		ListNode l11 = new ListNode(1);
		l10.next = l11;
		System.out.println("链表l1");
		ListNode.printListNode(l10);
		
		ListNode l20 = new ListNode(0);
		ListNode l21 = new ListNode(1);
		ListNode l22 = new ListNode(2);
		l20.next = l21;
		l21.next = l22;
		System.out.println("链表l2");
		ListNode.printListNode(l20);
		
		ListNode sum = addTwoNumbers(l10, l20);
		System.out.println("两数相加结果：");
		ListNode.printListNodeWithHead(sum);
	}
	
	
	/**
	 * 边界测试
	 * l1=[9,9]，l2=[1]
	 */
	private static void test2() {
		ListNode l10 = new ListNode(9);
		ListNode l11 = new ListNode(9);
		l10.next = l11;
		System.out.println("链表l1");
		ListNode.printListNode(l10);
		
		ListNode l20 = new ListNode(1);
		
		System.out.println("链表l2");
		ListNode.printListNode(l20);
		
		ListNode sum = addTwoNumbers(l10, l20);
		System.out.println("两数相加结果：");
		ListNode.printListNode(sum);
	}
	
	
	/**
	 * 边界测试
	 * l1=[9,9]，l2=[1]
	 */
	private static void test3() {
		ListNode l10 = null;
		System.out.println("链表l1");
		ListNode.printListNode(l10);
		
		ListNode l20 = new ListNode(0);
		ListNode l21 = new ListNode(1);
		l20.next  = l21;
		System.out.println("链表l2");
		ListNode.printListNode(l20);
		
		ListNode sum = addTwoNumbers(l10, l20);
		System.out.println("两数相加结果：");
		ListNode.printListNode(sum);
	}
}
