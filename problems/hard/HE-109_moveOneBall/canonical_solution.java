/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

        if (arr.size() == 0) {
            return true;
        }
        List<Integer> sorted_arr = new ArrayList<>(arr);
        Collections.sort(sorted_arr);

        int min_value = Collections.min(arr);
        int min_index = arr.indexOf(min_value);
        List<Integer> my_arr = new ArrayList<>(arr.subList(min_index, arr.size()));
        my_arr.addAll(arr.subList(0, min_index));
        for (int i = 0; i < arr.size(); i++) {
            if (my_arr.get(i) != sorted_arr.get(i)) {
                return false;
            }
        }
        return true;
    }
}