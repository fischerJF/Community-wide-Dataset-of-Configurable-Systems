package TestSpecifications;


public class SpecificationManager
{

    private static int singleSpecification = -1;

    public SpecificationManager()
    {
    }

    public static void setupSpecifications()
    {
    }

    public static boolean checkSpecification(int id)
    {
        if(singleSpecification == -2)
        {
            return false;
        }
        if(singleSpecification == -1)
        {
            return true;
        }
        return singleSpecification == id;
    }

    public static void checkOnlySpecification(int scenario)
    {
        singleSpecification = scenario;
    }

}
