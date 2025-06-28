```Java
towers(int n) {
	int sol = 0;
	List l = new ArrayList();
	l.add(0)
	valid = true;
	while(!l.isEmpty()) {
		valid = true;
		for(int i = l.get(l.size-1), i<n, i++) {
			if(!thread(l,i,l.size)) {
				break;
			}
			if(i = n-1){
				valid = fasle; 
			}	
		}
		
		if(l.size == 8) {
			sol++;
			print(l);
			l.remove(l.size-1); // Backtracking
		};
		if(!valid){
			l.remove(l.size-1);
		} else{
			l.add(0) // add next tower
		}
	}
}
thread(List l, int x, int y){
	for(int i = 0, i < l.size, i++){
		if(i==x || l.get(i) == y){
			return false;
		}
	}
	return true;
}
```

