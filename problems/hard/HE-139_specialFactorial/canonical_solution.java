/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

        long fact_i = 1, special_fact = 1;
        for (int i = 1; i <= n; i++) {
            fact_i *= i;
            special_fact *= fact_i;
        }
        return special_fact;
    }
}