package TestSpecifications;


public class SpecificationException extends RuntimeException
{

    private static final long serialVersionUID = 0xa466d287c4dfc458L;
    private String specificationName;

    public SpecificationException(String testCaseName, String message)
    {
        super(message);
        specificationName = testCaseName;
    }

    public String getSpecificationName()
    {
        return specificationName;
    }
}
