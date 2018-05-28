/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jenkins.x.client.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 */
public abstract class TreeNode<K, T extends TreeNode> extends BaseNode<K, T> {
    private final TreeItem parent;
    private final String label;
    private Map<K, T> children = new TreeMap<>();

    public TreeNode(TreeItem parent, String label) {
        this.parent = parent;
        this.label = label;
    }

    @Override
    public TreeItem getParent() {
        return parent;
    }

    @Override
    public String getLabel() {
        return label;
    }

    protected T getChild(K key) {
        return children.get(key);
    }

    protected T putChild(K key, T value) {
        return children.put(key, value);
    }

    protected void addChild(K key, T value) {
        children.put(key, value);
    }

    protected T removeChild(K key) {
        return children.remove(key);
    }

    public List<T> getChildren() {
        return new ArrayList<T>(children.values());
    }
}