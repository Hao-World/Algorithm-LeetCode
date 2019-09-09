package com.hao.common;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		this.val = x;
	}
	
	
	
	/**
	 * 打印链表 有头节点
	 * 
	 * @param pHead
	 */
	public static void printListNodeWithHead(ListNode pHead) {
		ListNode p = pHead.next;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	
	/**
	 * 打印链表 此题目没有头结点
	 * 
	 * @param pHead
	 */
	public  static void printListNode(ListNode pHead) {
		ListNode p = pHead;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
	
}
