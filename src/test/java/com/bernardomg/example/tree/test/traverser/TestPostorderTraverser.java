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

package com.bernardomg.example.tree.test.traverser;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.example.tree.model.BinaryNode;
import com.bernardomg.example.tree.model.DefaultBinaryNode;
import com.bernardomg.example.tree.model.DefaultNode;
import com.bernardomg.example.tree.model.Node;
import com.bernardomg.example.tree.traverser.PostorderTraverser;
import com.google.common.collect.Iterables;

/**
 * Unit tests for {@link PostorderTraverser}, verifying that it transforms a
 * tree correctly.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestPostorderTraverser {

    /**
     * Default constructor.
     */
    public TestPostorderTraverser() {
        super();
    }

    /**
     * Verifies that the value is generated correctly.
     */
    @Test
    public final void testList() {
        final Node addition;
        final Node subtraction;
        final Node left;
        final Node right;
        final Node rightSecond;
        final Iterable<Node> result;
        final Iterator<Node> exps;
        Node exp;

        left = new DefaultNode("1");
        right = new DefaultNode("2");

        // 1 + 2
        addition = new DefaultBinaryNode(left, right, "+");

        rightSecond = new DefaultNode("3");

        // (1 + 2) - 3
        subtraction = new DefaultBinaryNode(addition, rightSecond, "-");

        // 1 2 + 3 -
        result = new PostorderTraverser().traverse(subtraction);

        Assertions.assertEquals(5, Iterables.size(result));

        exps = result.iterator();

        exp = exps.next();
        Assertions.assertTrue(exp instanceof Node);
        Assertions.assertEquals("1", exp.getText());

        exp = exps.next();
        Assertions.assertTrue(exp instanceof Node);
        Assertions.assertEquals("2", exp.getText());

        exp = exps.next();
        Assertions.assertTrue(exp instanceof BinaryNode);
        Assertions.assertEquals("+", exp.getText());

        exp = exps.next();
        Assertions.assertTrue(exp instanceof Node);
        Assertions.assertEquals("3", exp.getText());

        exp = exps.next();
        Assertions.assertTrue(exp instanceof BinaryNode);
        Assertions.assertEquals("-", exp.getText());
    }

}
