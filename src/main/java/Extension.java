import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

public class Extension implements BurpExtension
{
    @Override
    public void initialize(MontoyaApi montoyaApi)
    {
        String EXTENSION_NAME = "Increment session handling rule";

        montoyaApi.extension().setName(EXTENSION_NAME);
        montoyaApi.http().registerSessionHandlingAction(new MySessionHandlingAction(EXTENSION_NAME));
    }
}
