package alcortes.expressionsolver;

import java.math.BigDecimal;

public class Expression {

    public static final char OP_ADD = '+';
    public static final char OP_SUBTRACT = '-';
    public static final char OP_MULTIPLY = '*';
    public static final char OP_DIVIDE = '/';
    public static final char OP_NOOP = '#';

    private Node root;

    private class Node {

        BigDecimal constant;
        char operator;
        Node left;
        Node right;

        // avoid using this ctor from the outter class
        Node(BigDecimal constant, char operator, Node left, Node right) {
            // it is going to be a number
            if (constant != null) {
                if (operator != OP_NOOP || left != null || right != null) {
                    throw new IllegalArgumentException();
                }
            } else { // it is going to be an operator
                if (left == null || right == null) {
                    throw new IllegalArgumentException();
                }
                if (operator != OP_ADD &&
                        operator != OP_SUBTRACT &&
                        operator != OP_MULTIPLY &&
                        operator != OP_DIVIDE) {
                    throw new IllegalArgumentException();
                }
            }
            this.constant = constant;
            this.operator = operator;
            this.left = left;
            this.right = right;
        }

        // this ctor is safe to use from the outter class
        Node(BigDecimal constant) {
            this(constant, OP_NOOP, null, null);
        }

        // this ctor is safe to use from the outter class
        Node(Character operator, Node left, Node right) {
            this(null, operator, left, right);
        }

        BigDecimal evaluate() throws ArithmeticException {
            if (constant != null) {
                return constant;
            } else {
                switch (operator) {
                    case OP_ADD:
                        return left.evaluate().add(right.evaluate());
                    case OP_SUBTRACT:
                        return left.evaluate().subtract(right.evaluate());
                    case OP_MULTIPLY:
                        return left.evaluate().multiply(right.evaluate());
                    case OP_DIVIDE:
                        // throws ArithmeticException if the exact
                        // quotient does not have a terminating decimal
                        // expansion
                        return left.evaluate().divide(right.evaluate());
                    default:
                        // should never reach here
                        throw new IllegalStateException();
                }
            }
        }
    }

    public Expression(BigDecimal constant) {
        root = new Node(constant);
    }

    public Expression(Character operator, Expression left, Expression right) {
        if (left == right) {
            throw new IllegalArgumentException();
        }
        if (left == null || right == null) {
            throw new IllegalArgumentException();
        }
        root = new Node(operator, left.root, right.root);
        left.clear();
        right.clear();
    }

    private void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BigDecimal evaluate() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return root.evaluate();
    }
}
