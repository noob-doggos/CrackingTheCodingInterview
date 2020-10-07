import java.util.Arrays;
import java.util.Stack;

public class CTCI_1_Braces
{
    public static boolean isValid(String toCheck)
    {
        if (toCheck == null || toCheck.length() <= 1)
        {
            return false;
        }

        Stack<Character> charStack = new Stack<Character>();

        for (int i = 0; i < toCheck.length(); i++)
        {
            Character cur = toCheck.charAt(i);
            if (cur == ' ')
            {
                continue;
            }
            
            if (charStack.isEmpty())
            {
                charStack.push(cur);
                continue;
            }
            
            char prev = charStack.peek();
            boolean passed = false;

            switch (cur)
            {
                case '}':
                    passed = prev == '{';
                    charStack.pop();
                    break;

                case ')':
                    passed = prev == '(';
                    charStack.pop();
                    break;

                case ']':
                    passed = prev == '[';
                    charStack.pop();
                    break;

                default:
                    charStack.push(cur);
                    continue;
            }
            
            if (!passed)
            {
                return false;
            }
        }

        return charStack.isEmpty();
    }

    public static String[] braces(String[] values)
    {
        if (values.length == 0)
        {
            return null;
        }
        
        String[] result = new String[values.length];

        for (int i = 0; i < values.length; i++)
        {
            result[i] = isValid(values[i]) ? "YES" : "NO";
        }

        return result;
    }
    
    public static void main(String[] args)
    {
        boolean a = isValid("[[(]])");
        System.out.println(a);
        boolean b = isValid("[[({})]]");
        System.out.println(b);
        String[] toCheck = new String[2];
        toCheck[0] = "[[(]])";
        toCheck[1] = "[[({})]]";
        System.out.println(Arrays.toString(braces(toCheck)));
        
    }
}
