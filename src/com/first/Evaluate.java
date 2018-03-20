package com.first;

import java.util.Stack;

/**
 * Dijkstra��˫ջ�������ʽ��ֵ�㷨
 * 
 * @author shengong
 *
 */
public class Evaluate {

	public static void main(String[] args) {
		// �����ջ
		Stack<String> ops = new Stack<String>();
		// ������ջ
		Stack<Double> vals = new Stack<Double>();
		String s = "(1+((2+3)*(4*5)))";
		for (int i = 0; i < s.length(); i++) {
			// System.out.println(s.charAt(i) + "");
			String s1 = s.charAt(i) + "";
			if ("(".equals(s1))
				;
			else if ("+".equals(s1)) {
				ops.push(s1);
			} else if ("-".equals(s1)) {
				ops.push(s1);
			} else if ("*".equals(s1)) {
				ops.push(s1);
			} else if ("/".equals(s1)) {
				ops.push(s1);
			} else if ("sqrt".equals(s1)) {
				ops.push(s1);
			} else if (")".equals(s1)) {
				// ����ַ�Ϊ��������������Ͳ���������������ѹ��ջ
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) {
					v = vals.pop() + v;
				} else if (op.equals("-")) {
					v = vals.pop() - v;
				} else if (op.equals("*")) {
					v = vals.pop() * v;
				} else if (op.equals("/")) {
					v = vals.pop() / v;
				} else if (op.equals("sqrt")) {
					v = Math.sqrt(v);
				}
				vals.push(v);
			} else {// ����ַ��Ȳ��������Ҳ�������ţ��ͽ�����Ϊdoubleֵѹ��ջ
				vals.push(Double.parseDouble(s1));
			}
		}
		System.out.println(vals.pop());
	}

}
