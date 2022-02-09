
function TreeNode(val, left, right) {
    this.val = (val === undefined ? 0 : val);
    this.left = (left === undefined ? null : left);
    this.right = (right === undefined ? null : right);
}

/**
 * @param {TreeNode} root
 */
var BSTIterator = function (root) {
    this.nodes = [];
    this.iterateToNextLeftmostNodeFromCurrentRoot(root);
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function () {
    if (!this.hasNext()) {
        throw "No Such Element Exception.";
    }

    let nextNode = this.nodes.pop();
    this.iterateToNextLeftmostNodeFromCurrentRoot(nextNode.right);
    return nextNode.val;
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function () {
    return this.nodes.length > 0;
};

/**
 * @param {TreeNode} node
 */
BSTIterator.prototype.iterateToNextLeftmostNodeFromCurrentRoot = function (node) {
    while (node !== null) {
        this.nodes.push(node);
        node = node.left;
    }
};
