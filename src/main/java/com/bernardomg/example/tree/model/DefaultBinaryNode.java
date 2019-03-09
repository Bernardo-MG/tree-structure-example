/**
 * Copyright 2019 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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
