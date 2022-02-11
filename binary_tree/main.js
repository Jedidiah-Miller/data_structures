class Node {

    constructor(data, left=null, right=null) {
        this.data = data
        this.left = left
        this.right = right
    }
}

class BinarySearchTree {

    constructor() {
        this.root = null
    }

    insert(data) {
        // creating a new node and initializing with data
        var newNode = new Node(data)
        // root is null then node will
        // be added to the tree and made root
        if (this.root === null)
            this.root = newNode
        else
        // find the correct position in the tree and add the node
            this.insertNode(this.root, newNode)
    }
    // Method to insert a node in a tree 
    // it moves over the tree to find the location 
    // to insert a node with a given data  
    insertNode(node, newNode) {
        // if the data is less than the node 
        // data move left of the tree  
        if(newNode.data < node.data) { 
            // if left is null insert node here 
            if(node.left === null) 
                node.left = newNode; 
            else
                // if left is not null recurr until  
                // null is found 
                this.insertNode(node.left, newNode);  
        } 
        // if the data is more than the node 
        // data move right of the tree  
        else { 
            // if right is null insert node here 
            if(node.right === null) 
                node.right = newNode; 
            else
                // if right is not null recurr until  
                // null is found 
                this.insertNode(node.right,newNode); 
        }
    }

    // helper method that calls the  
    // removeNode with a given data 
    remove(data) {
        // root is re-initialized with 
        // root of a modified tree. 
        this.root = this.removeNode(this.root, data);
    }
    // Method to remove node with a  
    // given data 
    // it recurrs over the tree to find the 
    // data and removes it 
    removeNode(node, key) {
        // if the root is null then tree is  
        // empty 
        if(node === null) return null; 
        // if data to be delete is less than  
        // roots data then move to left subtree 
        else if(key < node.data) {
            node.left = this.removeNode(node.left, key); 
            return node; 
        }
        // if data to be delete is greater than  
        // roots data then move to right subtree 
        else if(key > node.data) {
            node.right = this.removeNode(node.right, key);
            return node; 
        }
        // if data is similar to the root's data  
        // then delete this node 
        else {
                // deleting node with no children 
            if(node.left === null && node.right === null) { 
                node = null; 
                return node; 
            }
            // deleting node with one children 
            if(node.left === null) { 
                node = node.right; 
                return node; 
            }
                
            else if(node.right === null) { 
                node = node.left; 
                return node; 
            }
            // Deleting node with two children 
            // minumum node of the rigt subtree 
            // is stored in aux 
            var aux = this.findMinNode(node.right); 
            node.data = aux.data; 
            node.right = this.removeNode(node.right, aux.data); 
            return node; 
        }
    }

    inorder(node) {
        if(node !== null) {
            this.inorder(node.left)
            console.log(node.data)
            this.inorder(node.right)
        }
    }

    preorder(node) {
        if(node !== null) {
            console.log(node.data)
            this.preorder(node.left)
            this.preorder(node.right)
        }
    }
// performs postorder traversal of a tree
    postorder(node) {
        if(node != nul) {
            this.postorder(node.left)
            this.postorder(node.right)
            console.log(node.data)
        }
    }
// display the tree as a tree
    display(node=this.root, prefix="", isTail=true) {

        console.log(prefix + (isTail ? '└──' : '├──') + node.data)
        if (node.left) this.display(node.left, "", false)
        if (node.right) this.display(node.right, "", false)
        // if(!(node.left && node.right))
    }
// returns root of the tree
    getRootNode() {
        return this.root
    }
    // search for a with given data
    search(node, data) {
     // if trees is empt return null
        if(node === null) return null
        // if data less than node.data
        // move left
        else if(data < node.data)
            return this.search(node.left, data)
        // if data is equal to then node data
        // return onde
        else return node
    }
}

var BST = new BinarySearchTree()

BST.insert(1)
BST.insert(2)
BST.insert(3)
BST.insert(4)
BST.insert(5)
BST.insert(6)
BST.insert(7)
BST.insert(8)
BST.insert(9)
BST.insert(10)
BST.insert(11)

BST.display()