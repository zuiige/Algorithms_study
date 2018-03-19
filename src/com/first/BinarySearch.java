package com.first;

import java.util.Arrays;

/**
 * ���ֲ���
 * @author shengong
 *
 */
public class BinarySearch {
	// ʹ�ö��ֲ����㷨�������������
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			// Ҫ���ҵ�ֵҪô�����ڣ�Ҫô������a[lo,hi]֮��
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
	 * ʹ�õݹ�ʵ�ֶ��ַ�
	 * ��д�ݹ����������Ҫ����һ�����㣺
	 * 1.�ݹ�����һ����򵥵����-�����ĵ�һ�����������return���������
	 * 2.�ݹ��������ȥ���Խ��һ����ģ��С�������⣬�����ݹ������������򵥵����
	 * 3.�ݹ���õĸ�����ͳ��Խ����������֮�䲻Ӧ���н�����
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
		System.out.print("list����:");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ",");
		}
		System.out.println();
		// ҪѰ�ҵ�ֵ
		int key = 5;
		// ���keyֵ����list�����key
		// if (rank(key, list) < 0) {
		if (rankByRecursion(key, list) < 0) {
			System.out.println(key);
			System.out.println(key + "����list��");
		} else {
			System.out.println(key + "��list��");
		}
	}
}
