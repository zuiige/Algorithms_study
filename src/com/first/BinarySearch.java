package com.first;

import java.util.Arrays;

/**
 * 二分查找
 * @author shengong
 *
 */
public class BinarySearch {
	// 使用二分查找算法数组必须是有序
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			// 要查找的值要么不存在，要么存在于a[lo,hi]之间
			int mid = lo + 1 / 2 * (hi - lo);
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	/*
	 * 使用递归实现二分法
	 * 编写递归代码是最重要的有一下三点：
	 * 1.递归总有一个最简单的情况-方法的第一条语句总是有return的条件语句
	 * 2.递归调用总是去尝试解决一个规模更小的子问题，这样递归才能收敛到最简单的情况
	 * 3.递归调用的父问题和尝试解决的子问题之间不应该有交集。
	 */
	public static int rankByRecursion(int key, int[] a) {
		return rankByRecursion(key, a, 0, a.length - 1);
	}

	private static int rankByRecursion(int key, int[] a, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) {
			return rankByRecursion(key, a, lo, mid - 1);
		} else if (key > a[mid]) {
			return rankByRecursion(key, a, mid + 1, hi);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		int[] list = { 4, 5, 89, 1, 996, 4, 29, 1, 4, 8 };
		Arrays.sort(list);
		System.out.print("list数组:");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		System.out.println();
		// 要寻找的值
		int key = 5;
		// 如果key值不在list中输出key
		// if (rank(key, list) < 0) {
		if (rankByRecursion(key, list) < 0) {
			System.out.println(key);
			System.out.println(key + "不在list中");
		} else {
			System.out.println(key + "在list中");
		}
	}
}
