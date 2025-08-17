# Graphs and Trees

## Graph (General)
• Can have cycles
• Nodes can have any number of connections
• Can be disconnected
• Can be directed or undirected
• Can have multiple paths between nodes

## Tree (Special Graph)
• **No cycles** (acyclic)
• **Connected** (all nodes reachable)
• **N nodes, N-1 edges** (minimum edges to stay connected)
• **Exactly one path** between any two nodes
• Usually has a designated root node

> Trees are graphs, but not all graphs are trees.

### Binary Tree
- A binary tree has each node made up of two children

```
                 9
               / | \
              5  7  11
             / \     \
            3   2    21
```

- A binary search tree is a binary tree in which every node fits into a specific ordering - `all left nodes < all right nodes`
- For a balanced tree, ensure `O(log n)` times for insert and find. 
- Two common types of balanced trees are `red-black` and `AVL` trees
- Complete binary tree has every level of the tree fully filled, last level is filled *left to right*