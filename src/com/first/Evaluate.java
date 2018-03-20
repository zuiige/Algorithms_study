package com.first;

import java.util.Stack;

/**
 * Dijkstra的双栈算术表达式求值算法
 * 
 * @author shengong
 *
 */
public class Evaluate {

	public static void main(String[] args) {
		// 运算符栈
		Stack<String> ops = new Stack<String>();
		// 操作数栈
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
				// 如果字符为），弹出运算符和操作符，计算结果并压入栈
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
			} else {// 如果字符既不是运算符也不是括号，就将他作为double值压入栈
				vals.push(Double.parseDouble(s1));
			}
		}
		System.out.println(vals.pop());
	}

}
