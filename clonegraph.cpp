class Solution {
public:

// MAP to keep track of original node and it's corresponding clone node

    unordered_map<Node*,Node*>mp;
    
    
    // SOLVE USING DFS
    
    void DFS(Node * node,Node * cloneNode){
        for(Node *n: node->neighbors){
            if(mp.find(n)==mp.end()){
                Node * clone =new Node(n->val);
                mp[n]=clone;
                cloneNode->neighbors.push_back(clone);
                DFS(n,clone);
            }
            else{
                cloneNode->neighbors.push_back(mp[n]);
            }
        }
    }
    
    
    Node* cloneGraph(Node* node) {
        
        if(!node)return nullptr;
        
        Node * clone_node = new Node(node->val);
        mp[node]=clone_node;
        // DFS(node,clone_node);
        
        // SOLVE USING BFS
        
        queue<Node*>q;
        q.push(node);
        while(!q.empty()){
            
            Node * node =q.front();
            Node * cloneNode = mp[node];
            q.pop();
            for(Node * n: node->neighbors){
                if(mp.find(n)==mp.end()){
                    Node * clone = new Node(n->val);
                    mp[n]=clone;
                    cloneNode->neighbors.push_back(clone);
                    q.push(n);
                }
                else{
                    cloneNode->neighbors.push_back(mp[n]);
                }
            }
        }
        
        return clone_node;
    }
};
