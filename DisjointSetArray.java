private class UnionFind{
        int count;
        int[] parent;
        int[] rank;
                
        public UnionFind(int N){
            count = 0;
            parent = new int[N];
            rank = new int[N];
            
            for(int i=0;i<N;i++){
                parent[i]=-1;
                rank[i]=0;
            }
        }
        
        public int count(){
            return count;
        }
        
        public void activate(int i){
            parent[i] = i;
            count++;
        }
        
        public boolean isActivated(int i){
            return parent[i]>=0;
        }
        
        public void union(int i, int j){
            int pi = find(i);
            int pj = find(j);
            
            if(pi!=pj){
                if(rank[pi]>rank[pj]){
                    parent[pj]=parent[pi];
                }else if (rank[pj]>rank[pi]){
                    parent[pi] = parent[pj];
                }else{
                    parent[pj]=parent[pi];
                    rank[pi]++;
                }
                count--;
            }                        
        }
        
        public int find(int i){
            if(parent[i]!=i){
                parent[i]=find(parent[i]);
            }
            return parent[i];
        }
        
    }
