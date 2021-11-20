public class Converter {
    private Boolean isRoman = false;

    public Integer[] stringToInteger(String firstValue, String secondValue) {
        Integer[] values = new Integer[2];
        if (isRomanNumber(firstValue) && isRomanNumber(secondValue)) {
            isRoman = true;
            values[0] = romanToInt(firstValue);
            values[1] = romanToInt(secondValue);
        } else {
            try {
                values[0] = Integer.valueOf(firstValue);
                values[1] = Integer.valueOf(secondValue);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Нельзя производить арифметические действия римских и арабских цифр вместе");
            }
        }
        return values;
    }

    public String integerToString(Integer value) {
        if (isRoman) {
            if (value <= 0) {
                throw new RuntimeException("Римские не могут быть равными нулю или отрицательными");
            }
            return intToRoman(value);
        }
        return String.valueOf(value);
    }

    private Boolean isRomanNumber(String value) {
        return (value.contains("I") || value.contains("V") || value.contains("X"));
    }

    private Integer romanToInt(String value) {
        int ans = 0, num = 0;
        for (int i = value.length() - 1; i >= 0; i--) {
            switch (value.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }

        return ans;
    }

    private String intToRoman(Integer value) {
        int[] romValues = {1, 4, 5, 9, 10, 40, 50, 90, 100};
        String[] rom = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

        StringBuilder sb = new StringBuilder();

        for (int i = romValues.length - 1; i >= 0 && value > 0; i--) {
            while (value >= romValues[i]) {
                value -= romValues[i];
                sb.append(rom[i]);
            }
        }

        return sb.toString();
    }
}
