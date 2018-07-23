import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        generateBracketExpressions("", 8).forEach(System.out::println);
    }
    static HashSet<String> generateBracketExpressions(String exp, int n){
        var bracketExpressions = new HashSet<String>();
        if(exp.length()==n){
            bracketExpressions.add(exp);
            return bracketExpressions;
        }

        var result = generateBracketExpressions('('+exp+')', n);
        bracketExpressions.addAll(result);

        generateBracketExpressions('('+exp+')', n).forEach(bracketExpressions::add);

        generateBracketExpressions("()"+exp, n).forEach(bracketExpressions::add);

        generateBracketExpressions(exp+"()", n).forEach(bracketExpressions::add);

        return bracketExpressions;
    }
}
