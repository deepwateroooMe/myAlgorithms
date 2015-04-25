int rand5() {
    int x = ~(1<<31); // Max Int
    while (x > 5)
	x = rand7();
    return x;
}

// a > b
int randb() {
    int x = ~(1<<31); // Max Int
    while (x > b)
	x = randa();
    return x;
}

int rand7() {
    int x = ~(1<<31); // Max Int
    while (x > 21)
	x = 5 * (rand5() - 1) + rand5();  // Rand25
    return x % 7 + 1; 
}
