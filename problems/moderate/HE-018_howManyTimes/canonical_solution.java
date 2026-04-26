/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

        int times = 0;

        for (int i = 0; i < string.length() - substring.length() + 1; i++) {
            if (string.substring(i, i + substring.length()).equals(substring)) {
                times += 1;
            }
        }

        return times;
    }
}