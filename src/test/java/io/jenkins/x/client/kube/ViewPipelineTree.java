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
package io.jenkins.x.client.kube;

import io.jenkins.x.client.PipelineClient;
import io.jenkins.x.client.tree.PipelineTreeModel;
import io.jenkins.x.client.tree.TreeItem;

import java.util.List;

/**
 */
public class ViewPipelineTree {
    public static void main(String[] args) throws Exception {
        PipelineClient pipelineClient = PipelineClient.newInstance();

        System.out.println("Looking in namespace: " + pipelineClient.getNamespace());
        PipelineTreeModel model = PipelineTreeModel.newStaticInstance();

        viewTree(model, "");

        System.out.println("Done");
        pipelineClient.close();
    }

    public static void viewTree(TreeItem node, String indent) {
        System.out.println(indent + node.getLabel());
        List<TreeItem> children = node.getChildrenItems();
        indent += "  ";
        for (TreeItem child : children) {
            viewTree(child, indent);
        }
    }
}
