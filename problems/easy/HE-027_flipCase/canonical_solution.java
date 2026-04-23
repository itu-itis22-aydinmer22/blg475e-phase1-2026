        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLowerCase(string.charAt(i))) {
                sb.append(Character.toUpperCase(string.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(string.charAt(i)));
            }
        }
        return sb.toString();
    }
}