```Java
wenigFarben(int[][] a, int n) {
	colors[]= alleFarben;
	int hasColor[n];
	hasColor[0] = colors[0];
	for(int i = 0, i <= n, i++) {
		for(int j = 0, j <= n, j++) {
			potentialColor = colors[0];
			if(i==j) continue;
			if(a[i][j]==0) continue;
			for(int k = 0, k <= n, k++) {
				if(a[j][k]==1 && hasColor[k] == potentialColor){
					potentialColor++;
					k=0;
				}
			}
			hasColor[j] = potentialColor;
		}
		
	}
}
```
