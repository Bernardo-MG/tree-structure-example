
package com.bernardomg.example.tree.model;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultBinaryNode implements BinaryNode {

    private final Node   left;

    private final Node   right;

    private final String text;

    public DefaultBinaryNode(final Node l, final Node r, final String t) {
        super();

        left = checkNotNull(l, "Received a null pointer as left node");
        right = checkNotNull(r, "Received a null pointer as right node");
        text = checkNotNull(t, "Received a null pointer as text");
    }

    @Override
    public final Node getLeft() {
        return left;
    }

    @Override
    public final Node getRight() {
        return right;
    }

    @Override
    public final String getText() {
        return text;
    }

}
