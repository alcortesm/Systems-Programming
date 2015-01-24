class CelsiusToFahrenheit {
    public static void main(String args[]) {
        for (float c=0f; c<=50f; c=c+10f) {
            float f = celsiusToFahrenheit(c);
            System.out.println(c + " " + f);
        }
    }

    static float celsiusToFahrenheit(float x) {
        float y = x * (9f/5f) + 32f;
        return y;
    }
}
