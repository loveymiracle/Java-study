public boolean isPrime(int n) {
		if (n == 1 || n == 0)
			return false;
		for (int i = 2; i < (n / 2) + 1; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
