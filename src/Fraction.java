import java.util.Objects;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Fraction(" + numerator + ", 0)");
        }
        int gcd = gcd(numerator, denominator);
        if (denominator < 0) {
            gcd = -gcd;
        }
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Fraction(int i)
    {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction add(Fraction other) {
        if (other == null) {
            return null;
        }
        return new Fraction(
                this.numerator * other.denominator + other.numerator * this.denominator,
                this.denominator * other.denominator
        );
    }

    public Fraction subtract(Fraction other) {
        if (other == null) {
            return null;
        }
        return new Fraction(
                this.numerator * other.denominator - other.numerator * this.denominator,
                this.denominator * other.denominator
        );
    }

    public Fraction multiply(Fraction other) {
        if (other == null) {
            return null;
        }
        return new Fraction(
                this.numerator * other.numerator,
                this.denominator * other.denominator
        );
    }

    public Fraction divide(Fraction other) {
        if (other == null || other.numerator == 0) {
            throw new ArithmeticException("Fraction division by zero");
        }
        return new Fraction(
                this.numerator * other.denominator,
                this.denominator * other.numerator
        );
    }

    public boolean lessThan(Fraction other) {
        if (other == null) {
            return false;
        }
        return this.numerator * other.denominator < other.numerator * this.denominator;
    }

    public boolean lessThanOrEqual(Fraction other) {
        if (other == null) {
            return false;
        }
        return this.numerator * other.denominator <= other.numerator * this.denominator;
    }

    public boolean equal(Fraction other) {
        if (other == null) {
            return false;
        }
        return this.numerator * other.denominator == other.numerator * this.denominator;
    }

    public boolean notEqual(Fraction other) {
        if (other == null) {
            return true;
        }
        return this.numerator * other.denominator != other.numerator * this.denominator;
    }

    public boolean greaterThan(Fraction other) {
        if (other == null) {
            return false;
        }
        return this.numerator * other.denominator > other.numerator * this.denominator;
    }

    public boolean greaterThanOrEqual(Fraction other) {
        if (other == null) {
            return false;
        }
        return this.numerator * other.denominator >= other.numerator * this.denominator;
    }

    public Fraction getAbs()
    {
        return new Fraction(Math.abs(this.numerator), Math.abs(this.denominator));
    }

    @Override
    public String toString() {
        if (this.denominator == 1) {
            return String.valueOf(this.numerator);
        } else {
            return this.numerator + "/" + this.denominator;
        }
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }
}

