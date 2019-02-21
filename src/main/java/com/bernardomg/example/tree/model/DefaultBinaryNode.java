
package com.bernardomg.example.tree.model;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultBinaryNode implements BinaryNode {

    private final Node left;

    private final Node right;

    public DefaultBinaryNode(final Node l, final Node r) {
        super();

        left = checkNotNull(l, "Received a null pointer as left node");
        right = checkNotNull(r, "Received a null pointer as right node");
    }

    @Override
    public final Node getLeft() {
        return left;
    }

    @Override
    public final Node getRight() {
        return right;
    }

}
