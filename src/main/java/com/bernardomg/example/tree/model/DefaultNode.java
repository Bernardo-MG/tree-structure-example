
package com.bernardomg.example.tree.model;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultNode implements Node {

    private final String text;

    public DefaultNode(final String t) {
        super();

        text = checkNotNull(t, "Received a null pointer as text");
    }

    @Override
    public final String getText() {
        return text;
    }

}
