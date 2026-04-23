        if (string.length() == 0) {
            return "";
        }

        int beginning_of_suffix = 0;

        while (!isPalindrome(string.substring(beginning_of_suffix))) {
            beginning_of_suffix++;
        }

        return string + new StringBuffer(string.substring(0, beginning_of_suffix)).reverse().toString();
    }
}