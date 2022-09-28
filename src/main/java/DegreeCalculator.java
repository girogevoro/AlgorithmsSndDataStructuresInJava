
public class DegreeCalculator {

    public int degree(int x, int n) {
        // TODO: 26.09.2022 Возвести число x в степень n.
        if(n <= 1){
            return x;
        }
        return  x * degree(x, --n);
    }

}
