
#include<deque>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

class BSTIterator {
    
public:

    deque<TreeNode*> nodes;

    BSTIterator(TreeNode* root) {
        iterateToNextLeftmostNodeFromCurrentRoot(root);
    }

    int next() {
        if (!hasNext()) {
            throw out_of_range("No Such Element Exception.");
        }

        TreeNode* nextNode = nodes.front();
        nodes.pop_front();
        iterateToNextLeftmostNodeFromCurrentRoot(nextNode->right);
        return nextNode->val;
    }

    bool hasNext() {
        return !nodes.empty();
    }

    void iterateToNextLeftmostNodeFromCurrentRoot(TreeNode* node) {
        while (node != nullptr) {
            nodes.push_front(node);
            node = node->left;
        }
    }
};
