/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

        for (int i = n - 1; i > 0; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }
}