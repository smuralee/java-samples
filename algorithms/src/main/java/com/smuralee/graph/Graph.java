/**
 * Copyright 2025 Suraj Muraleedharan
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smuralee.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

  private final Map<Node, List<Node>> adjList;

  public Graph() {
    this.adjList = new HashMap<>();
  }

  public void addVertex(final Node node) {
    this.adjList.putIfAbsent(node, new ArrayList<>());
  }

  public void addEdge(final Node n1, final Node n2) {
    addVertex(n1);
    addVertex(n2);
    this.adjList.get(n1).add(n2);
    this.adjList.get(n2).add(n1);
  }

  public Set<Node> getVertices() {
    return this.adjList.keySet();
  }

  public List<Node> getEdges(Node node) {
    return this.adjList.getOrDefault(node, new ArrayList<>());
  }

  public void dfs(Node start, Set<Node> visited) {
    visited.add(start);
    for (Node neighbour : adjList.get(start)) {
      if (!visited.contains(neighbour)) {
        dfs(neighbour, visited);
      }
    }
  }

  public void bfs(Node start, Set<Node> visited) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(start);
    visited.add(start);

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      for (Node neighbour : adjList.get(current)) {
        if (!visited.contains(neighbour)) {
          visited.add(neighbour);
          queue.offer(neighbour);
        }
      }
    }
  }
}
