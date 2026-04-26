/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= string.length(); i++) {
            result.add(string.substring(0, i));
        }
        return result;
    }
}