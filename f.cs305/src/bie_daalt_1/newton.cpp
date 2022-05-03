int main() {
	float a, x, result;
	int i;
	a = 4.0;
	x = 1.0;
	while (x*x > a+0.0001 || x*x < a-0.0001 )
		x = (x + a/x)/2.0;
	
	if(x != 1.0)
		result = x;
	for(i = 0; i < 10 ; i = i+1;){
		a = a + 1;
	}
}
