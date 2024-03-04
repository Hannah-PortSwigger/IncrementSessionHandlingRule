import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.http.sessions.ActionResult;
import burp.api.montoya.http.sessions.SessionHandlingAction;
import burp.api.montoya.http.sessions.SessionHandlingActionData;
import org.json.JSONObject;

import static burp.api.montoya.http.sessions.ActionResult.actionResult;

public class MySessionHandlingAction implements SessionHandlingAction
{
    private final String extensionName;
    private int counter;

    public MySessionHandlingAction(String EXTENSION_NAME)
    {
        extensionName = EXTENSION_NAME;
        counter = 1;
    }

    @Override
    public String name()
    {
        return extensionName;
    }

    @Override
    public ActionResult performAction(SessionHandlingActionData sessionHandlingActionData)
    {
        JSONObject jsonContent = new JSONObject(sessionHandlingActionData.request().bodyToString());

        JSONObject updatedJsonContent = jsonContent.put("orderNumber", "test" + counter);
        counter++;

        HttpRequest newRequest = sessionHandlingActionData.request().withBody(updatedJsonContent.toString());

        return actionResult(newRequest);
    }
}
